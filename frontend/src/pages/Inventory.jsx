import React, { useState, useEffect } from 'react';
import { inventoryAPI } from '../services/api';
import { MagnifyingGlassIcon } from '@heroicons/react/24/outline';

const Inventory = () => {
  const [stockData, setStockData] = useState([]);
  const [loading, setLoading] = useState(false);
  const [searchTerm, setSearchTerm] = useState('');
  const [stockFilter, setStockFilter] = useState(2); // TAG_STOCK_AVEC_ZERO
  const [pagination, setPagination] = useState({ from: 1, to: 50 });

  useEffect(() => {
    fetchGlobalStock();
  }, [stockFilter, pagination]);

  const fetchGlobalStock = async () => {
    try {
      setLoading(true);
      const response = await inventoryAPI.getGlobalStock({
        from: pagination.from,
        to: pagination.to,
        stockBy: stockFilter,
      });
      if (response.data.success) {
        const data = JSON.parse(response.data.data);
        setStockData(data);
      }
    } catch (error) {
      console.error('Error fetching stock data:', error);
    } finally {
      setLoading(false);
    }
  };

  const searchProduct = async () => {
    if (!searchTerm.trim()) return;

    try {
      setLoading(true);
      const response = await inventoryAPI.getStockByProduct({
        codeProduit: searchTerm,
        isByBarcode: false,
      });
      if (response.data.success) {
        const data = JSON.parse(response.data.data);
        setStockData(JSON.parse(data.data));
      }
    } catch (error) {
      console.error('Error searching product:', error);
    } finally {
      setLoading(false);
    }
  };

  const stockFilterOptions = [
    { value: 1, label: 'Non-Zero Stock' },
    { value: 2, label: 'All Stock' },
    { value: 3, label: 'Zero Stock' },
    { value: 4, label: 'Negative Stock' },
    { value: 5, label: 'Positive Stock' },
  ];

  const filteredData = stockData.filter(item =>
    item.designation?.toLowerCase().includes(searchTerm.toLowerCase()) ||
    item.codeProduit?.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-2xl font-bold text-gray-900">Inventory Management</h1>
        <p className="mt-1 text-sm text-gray-500">
          Monitor stock levels and search for products
        </p>
      </div>

      {/* Search and Filters */}
      <div className="mb-6 bg-white p-4 rounded-lg shadow">
        <div className="flex flex-wrap gap-4 items-end">
          <div className="flex-1 min-w-64">
            <label className="block text-sm font-medium text-gray-700 mb-1">
              Search Products
            </label>
            <div className="relative">
              <input
                type="text"
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                placeholder="Search by product name or code..."
                className="w-full border border-gray-300 rounded-md px-3 py-2 pl-10 text-sm"
                onKeyPress={(e) => e.key === 'Enter' && searchProduct()}
              />
              <MagnifyingGlassIcon className="h-5 w-5 text-gray-400 absolute left-3 top-2.5" />
            </div>
          </div>
          
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              Stock Filter
            </label>
            <select
              value={stockFilter}
              onChange={(e) => setStockFilter(parseInt(e.target.value))}
              className="border border-gray-300 rounded-md px-3 py-2 text-sm"
            >
              {stockFilterOptions.map(option => (
                <option key={option.value} value={option.value}>
                  {option.label}
                </option>
              ))}
            </select>
          </div>

          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              From
            </label>
            <input
              type="number"
              value={pagination.from}
              onChange={(e) => setPagination({...pagination, from: parseInt(e.target.value)})}
              className="border border-gray-300 rounded-md px-3 py-2 text-sm w-20"
            />
          </div>

          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              To
            </label>
            <input
              type="number"
              value={pagination.to}
              onChange={(e) => setPagination({...pagination, to: parseInt(e.target.value)})}
              className="border border-gray-300 rounded-md px-3 py-2 text-sm w-20"
            />
          </div>

          <button
            onClick={searchProduct}
            className="bg-indigo-600 text-white px-4 py-2 rounded-md text-sm hover:bg-indigo-700"
          >
            Search
          </button>
        </div>
      </div>

      {/* Stock Table */}
      <div className="bg-white shadow rounded-lg">
        <div className="px-4 py-5 sm:p-6">
          <h3 className="text-lg leading-6 font-medium text-gray-900 mb-4">
            Stock Levels
          </h3>
          
          {loading ? (
            <div className="flex items-center justify-center h-32">
              <div className="animate-spin rounded-full h-8 w-8 border-b-2 border-indigo-500"></div>
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="min-w-full divide-y divide-gray-200">
                <thead className="bg-gray-50">
                  <tr>
                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                      Product Code
                    </th>
                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                      Description
                    </th>
                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                      Quantity
                    </th>
                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                      Store
                    </th>
                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                      Dimensions
                    </th>
                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                      Status
                    </th>
                  </tr>
                </thead>
                <tbody className="bg-white divide-y divide-gray-200">
                  {filteredData.map((item, index) => (
                    <tr key={index} className="hover:bg-gray-50">
                      <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">
                        {item.codeProduit || 'N/A'}
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        {item.designation || item.nomProduit || 'N/A'}
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        <span className={`inline-flex px-2 py-1 text-xs font-semibold rounded-full ${
                          (item.quantite || 0) > 0 
                            ? 'bg-green-100 text-green-800'
                            : (item.quantite || 0) === 0
                            ? 'bg-yellow-100 text-yellow-800'
                            : 'bg-red-100 text-red-800'
                        }`}>
                          {item.quantite || 0}
                        </span>
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        {item.designation || 'Main Store'}
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        {item.dims1 && item.dims2 
                          ? `${item.dims1} / ${item.dims2}`
                          : item.dims1 || item.dims2 || 'N/A'
                        }
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        <span className={`inline-flex px-2 py-1 text-xs font-semibold rounded-full ${
                          (item.quantite || 0) > 10 
                            ? 'bg-green-100 text-green-800'
                            : (item.quantite || 0) > 0
                            ? 'bg-yellow-100 text-yellow-800'
                            : 'bg-red-100 text-red-800'
                        }`}>
                          {(item.quantite || 0) > 10 ? 'In Stock' : 
                           (item.quantite || 0) > 0 ? 'Low Stock' : 'Out of Stock'}
                        </span>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
              
              {filteredData.length === 0 && (
                <div className="text-center py-8 text-gray-500">
                  No products found matching your criteria.
                </div>
              )}
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default Inventory;