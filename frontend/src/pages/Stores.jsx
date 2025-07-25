import React, { useState, useEffect } from 'react';
import { storeAPI } from '../services/api';
import { format, subDays } from 'date-fns';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const Stores = () => {
  const [storesData, setStoresData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [dateRange, setDateRange] = useState({
    debut: format(subDays(new Date(), 7), 'dd-MM-yyyy HH:mm:ss'),
    fin: format(new Date(), 'dd-MM-yyyy HH:mm:ss'),
    withDate: true,
  });

  useEffect(() => {
    fetchStoresData();
  }, [dateRange]);

  const fetchStoresData = async () => {
    try {
      setLoading(true);
      const response = await storeAPI.getMagasinsInfoByDate(dateRange);
      if (response.data.success) {
        const data = JSON.parse(response.data.data);
        setStoresData(data);
      }
    } catch (error) {
      console.error('Error fetching stores data:', error);
    } finally {
      setLoading(false);
    }
  };

  // Prepare chart data
  const chartData = storesData.map(store => ({
    name: store.nomMagasin?.substring(0, 10) + '...' || 'Unknown',
    sales: store.montantTTC || 0,
    transactions: store.nombreTickets || 0,
    items: store.quantite || 0,
  }));

  if (loading) {
    return (
      <div className="flex items-center justify-center h-64">
        <div className="animate-spin rounded-full h-32 w-32 border-b-2 border-indigo-500"></div>
      </div>
    );
  }

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-2xl font-bold text-gray-900">Store Performance</h1>
        <p className="mt-1 text-sm text-gray-500">
          Compare performance across all stores
        </p>
      </div>

      {/* Date Range Selector */}
      <div className="mb-6 bg-white p-4 rounded-lg shadow">
        <div className="flex flex-wrap gap-4 items-center">
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              Start Date
            </label>
            <input
              type="datetime-local"
              value={format(new Date(dateRange.debut.split(' ')[0].split('-').reverse().join('-') + 'T' + dateRange.debut.split(' ')[1]), 'yyyy-MM-dd\'T\'HH:mm')}
              onChange={(e) => {
                const date = new Date(e.target.value);
                setDateRange({
                  ...dateRange,
                  debut: format(date, 'dd-MM-yyyy HH:mm:ss')
                });
              }}
              className="border border-gray-300 rounded-md px-3 py-2 text-sm"
            />
          </div>
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              End Date
            </label>
            <input
              type="datetime-local"
              value={format(new Date(dateRange.fin.split(' ')[0].split('-').reverse().join('-') + 'T' + dateRange.fin.split(' ')[1]), 'yyyy-MM-dd\'T\'HH:mm')}
              onChange={(e) => {
                const date = new Date(e.target.value);
                setDateRange({
                  ...dateRange,
                  fin: format(date, 'dd-MM-yyyy HH:mm:ss')
                });
              }}
              className="border border-gray-300 rounded-md px-3 py-2 text-sm"
            />
          </div>
          <div className="flex items-center">
            <input
              type="checkbox"
              id="withDate"
              checked={dateRange.withDate}
              onChange={(e) => setDateRange({...dateRange, withDate: e.target.checked})}
              className="mr-2"
            />
            <label htmlFor="withDate" className="text-sm text-gray-700">
              Filter by date range
            </label>
          </div>
        </div>
      </div>

      {/* Charts */}
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6 mb-8">
        {/* Sales Chart */}
        <div className="bg-white p-6 rounded-lg shadow">
          <h3 className="text-lg font-medium text-gray-900 mb-4">Sales by Store</h3>
          <ResponsiveContainer width="100%" height={300}>
            <BarChart data={chartData}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Bar dataKey="sales" fill="#3B82F6" />
            </BarChart>
          </ResponsiveContainer>
        </div>

        {/* Transactions Chart */}
        <div className="bg-white p-6 rounded-lg shadow">
          <h3 className="text-lg font-medium text-gray-900 mb-4">Transactions by Store</h3>
          <ResponsiveContainer width="100%" height={300}>
            <BarChart data={chartData}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Bar dataKey="transactions" fill="#10B981" />
            </BarChart>
          </ResponsiveContainer>
        </div>
      </div>

      {/* Stores Table */}
      <div className="bg-white shadow rounded-lg">
        <div className="px-4 py-5 sm:p-6">
          <h3 className="text-lg leading-6 font-medium text-gray-900 mb-4">
            Store Performance Details
          </h3>
          <div className="overflow-x-auto">
            <table className="min-w-full divide-y divide-gray-200">
              <thead className="bg-gray-50">
                <tr>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Store
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Code
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Total Sales
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Transactions
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Items Sold
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Avg. Order
                  </th>
                  <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Performance
                  </th>
                </tr>
              </thead>
              <tbody className="bg-white divide-y divide-gray-200">
                {storesData.map((store, index) => {
                  const avgOrder = (store.nombreTickets || 0) > 0 ? 
                    (store.montantTTC || 0) / (store.nombreTickets || 1) : 0;
                  
                  return (
                    <tr key={index} className="hover:bg-gray-50">
                      <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">
                        {store.nomMagasin || 'Unknown Store'}
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        {store.codeMagasin || 'N/A'}
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        <span className="font-medium">
                          ${(store.montantTTC || 0).toLocaleString()}
                        </span>
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        {store.nombreTickets || 0}
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        {store.quantite || 0}
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        ${avgOrder.toFixed(2)}
                      </td>
                      <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        <span className={`inline-flex px-2 py-1 text-xs font-semibold rounded-full ${
                          (store.montantTTC || 0) > 10000 
                            ? 'bg-green-100 text-green-800'
                            : (store.montantTTC || 0) > 5000
                            ? 'bg-yellow-100 text-yellow-800'
                            : 'bg-red-100 text-red-800'
                        }`}>
                          {(store.montantTTC || 0) > 10000 ? 'Excellent' : 
                           (store.montantTTC || 0) > 5000 ? 'Good' : 'Needs Improvement'}
                        </span>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Stores;