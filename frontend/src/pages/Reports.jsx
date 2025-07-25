import React, { useState, useEffect } from 'react';
import { useAuth } from '../context/AuthContext';
import { storeAPI } from '../services/api';
import { format, subDays } from 'date-fns';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const Reports = () => {
  const { selectedStore, stores } = useAuth();
  const [reportData, setReportData] = useState(null);
  const [compareData, setCompareData] = useState([]);
  const [loading, setLoading] = useState(false);
  const [reportType, setReportType] = useState('daily');
  const [compareStores, setCompareStores] = useState({
    store1: '',
    store2: '',
    dateDebut_1: format(subDays(new Date(), 14), 'dd-MM-yyyy HH:mm:ss'),
    dateFin_1: format(subDays(new Date(), 7), 'dd-MM-yyyy HH:mm:ss'),
    dateDebut_2: format(subDays(new Date(), 7), 'dd-MM-yyyy HH:mm:ss'),
    dateFin_2: format(new Date(), 'dd-MM-yyyy HH:mm:ss'),
  });

  const fetchDailyReport = async () => {
    if (!selectedStore) return;
    
    try {
      setLoading(true);
      const response = await storeAPI.getInfosDay({
        debut: format(new Date(), 'dd-MM-yyyy 00:00:00'),
        fin: format(new Date(), 'dd-MM-yyyy 23:59:59'),
      });
      
      if (response.data.success) {
        const data = JSON.parse(response.data.data);
        setReportData(data);
      }
    } catch (error) {
      console.error('Error fetching daily report:', error);
    } finally {
      setLoading(false);
    }
  };

  const fetchCompareReport = async () => {
    if (!compareStores.store1) return;
    
    try {
      setLoading(true);
      const response = await storeAPI.getComparePeriode({
        codeMagasin: compareStores.store1,
        dateDebut_1: compareStores.dateDebut_1,
        dateFin_1: compareStores.dateFin_1,
        dateDebut_2: compareStores.dateDebut_2,
        dateFin_2: compareStores.dateFin_2,
      });
      
      if (response.data.success) {
        const data = JSON.parse(response.data.data);
        setCompareData(data);
      }
    } catch (error) {
      console.error('Error fetching compare report:', error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    if (reportType === 'daily') {
      fetchDailyReport();
    }
  }, [selectedStore, reportType]);

  useEffect(() => {
    if (reportType === 'compare' && compareStores.store1) {
      fetchCompareReport();
    }
  }, [compareStores, reportType]);

  // Prepare chart data for daily report
  const dailyChartData = reportData?.data ? 
    JSON.parse(reportData.data).map(item => ({
      time: format(new Date(item.dateMvt), 'HH:mm'),
      sales: item.montantTtc || 0,
      hour: item.hour || 0,
    })) : [];

  // Prepare comparison chart data
  const comparisonChartData = compareData.length >= 2 ? [
    {
      name: 'Period 1',
      sales: compareData[0]?.montantTTC || 0,
      transactions: compareData[0]?.nombreTickets || 0,
      items: compareData[0]?.quantite || 0,
    },
    {
      name: 'Period 2',
      sales: compareData[1]?.montantTTC || 0,
      transactions: compareData[1]?.nombreTickets || 0,
      items: compareData[1]?.quantite || 0,
    }
  ] : [];

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-2xl font-bold text-gray-900">Reports & Analytics</h1>
        <p className="mt-1 text-sm text-gray-500">
          Generate detailed reports and compare performance
        </p>
      </div>

      {/* Report Type Selector */}
      <div className="mb-6 bg-white p-4 rounded-lg shadow">
        <div className="flex space-x-4">
          <button
            onClick={() => setReportType('daily')}
            className={`px-4 py-2 rounded-md text-sm font-medium ${
              reportType === 'daily'
                ? 'bg-indigo-600 text-white'
                : 'bg-gray-200 text-gray-700 hover:bg-gray-300'
            }`}
          >
            Daily Report
          </button>
          <button
            onClick={() => setReportType('compare')}
            className={`px-4 py-2 rounded-md text-sm font-medium ${
              reportType === 'compare'
                ? 'bg-indigo-600 text-white'
                : 'bg-gray-200 text-gray-700 hover:bg-gray-300'
            }`}
          >
            Period Comparison
          </button>
        </div>
      </div>

      {reportType === 'daily' && (
        <div>
          {/* Daily Report */}
          <div className="grid grid-cols-1 lg:grid-cols-2 gap-6 mb-8">
            {/* Hourly Sales Chart */}
            <div className="bg-white p-6 rounded-lg shadow">
              <h3 className="text-lg font-medium text-gray-900 mb-4">Hourly Sales Today</h3>
              <ResponsiveContainer width="100%" height={300}>
                <LineChart data={dailyChartData}>
                  <CartesianGrid strokeDasharray="3 3" />
                  <XAxis dataKey="time" />
                  <YAxis />
                  <Tooltip />
                  <Legend />
                  <Line type="monotone" dataKey="sales" stroke="#3B82F6" strokeWidth={2} />
                </LineChart>
              </ResponsiveContainer>
            </div>

            {/* Daily Summary */}
            <div className="bg-white p-6 rounded-lg shadow">
              <h3 className="text-lg font-medium text-gray-900 mb-4">Today's Summary</h3>
              {reportData?.objCompare && (
                <div className="space-y-4">
                  {(() => {
                    const todayData = JSON.parse(reportData.objCompare);
                    return (
                      <>
                        <div className="flex justify-between items-center p-3 bg-blue-50 rounded-lg">
                          <span className="text-sm font-medium text-gray-700">Total Sales</span>
                          <span className="text-lg font-bold text-blue-600">
                            ${(todayData.montantTTC || 0).toLocaleString()}
                          </span>
                        </div>
                        <div className="flex justify-between items-center p-3 bg-green-50 rounded-lg">
                          <span className="text-sm font-medium text-gray-700">Transactions</span>
                          <span className="text-lg font-bold text-green-600">
                            {todayData.nombreTickets || 0}
                          </span>
                        </div>
                        <div className="flex justify-between items-center p-3 bg-yellow-50 rounded-lg">
                          <span className="text-sm font-medium text-gray-700">Items Sold</span>
                          <span className="text-lg font-bold text-yellow-600">
                            {todayData.quantite || 0}
                          </span>
                        </div>
                      </>
                    );
                  })()}
                </div>
              )}
            </div>
          </div>
        </div>
      )}

      {reportType === 'compare' && (
        <div>
          {/* Comparison Settings */}
          <div className="mb-6 bg-white p-4 rounded-lg shadow">
            <h3 className="text-lg font-medium text-gray-900 mb-4">Comparison Settings</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              {/* Store Selection */}
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">
                  Select Store
                </label>
                <select
                  value={compareStores.store1}
                  onChange={(e) => setCompareStores({...compareStores, store1: e.target.value})}
                  className="w-full border border-gray-300 rounded-md px-3 py-2 text-sm"
                >
                  <option value="">Select a store</option>
                  {stores.map(store => (
                    <option key={store.numMagasin} value={store.codeMagasin}>
                      {store.nomMagasin}
                    </option>
                  ))}
                </select>
              </div>

              <div></div>

              {/* Period 1 */}
              <div>
                <h4 className="font-medium text-gray-900 mb-2">Period 1</h4>
                <div className="space-y-2">
                  <input
                    type="datetime-local"
                    value={format(new Date(compareStores.dateDebut_1.split(' ')[0].split('-').reverse().join('-') + 'T' + compareStores.dateDebut_1.split(' ')[1]), 'yyyy-MM-dd\'T\'HH:mm')}
                    onChange={(e) => {
                      const date = new Date(e.target.value);
                      setCompareStores({
                        ...compareStores,
                        dateDebut_1: format(date, 'dd-MM-yyyy HH:mm:ss')
                      });
                    }}
                    className="w-full border border-gray-300 rounded-md px-3 py-2 text-sm"
                  />
                  <input
                    type="datetime-local"
                    value={format(new Date(compareStores.dateFin_1.split(' ')[0].split('-').reverse().join('-') + 'T' + compareStores.dateFin_1.split(' ')[1]), 'yyyy-MM-dd\'T\'HH:mm')}
                    onChange={(e) => {
                      const date = new Date(e.target.value);
                      setCompareStores({
                        ...compareStores,
                        dateFin_1: format(date, 'dd-MM-yyyy HH:mm:ss')
                      });
                    }}
                    className="w-full border border-gray-300 rounded-md px-3 py-2 text-sm"
                  />
                </div>
              </div>

              {/* Period 2 */}
              <div>
                <h4 className="font-medium text-gray-900 mb-2">Period 2</h4>
                <div className="space-y-2">
                  <input
                    type="datetime-local"
                    value={format(new Date(compareStores.dateDebut_2.split(' ')[0].split('-').reverse().join('-') + 'T' + compareStores.dateDebut_2.split(' ')[1]), 'yyyy-MM-dd\'T\'HH:mm')}
                    onChange={(e) => {
                      const date = new Date(e.target.value);
                      setCompareStores({
                        ...compareStores,
                        dateDebut_2: format(date, 'dd-MM-yyyy HH:mm:ss')
                      });
                    }}
                    className="w-full border border-gray-300 rounded-md px-3 py-2 text-sm"
                  />
                  <input
                    type="datetime-local"
                    value={format(new Date(compareStores.dateFin_2.split(' ')[0].split('-').reverse().join('-') + 'T' + compareStores.dateFin_2.split(' ')[1]), 'yyyy-MM-dd\'T\'HH:mm')}
                    onChange={(e) => {
                      const date = new Date(e.target.value);
                      setCompareStores({
                        ...compareStores,
                        dateFin_2: format(date, 'dd-MM-yyyy HH:mm:ss')
                      });
                    }}
                    className="w-full border border-gray-300 rounded-md px-3 py-2 text-sm"
                  />
                </div>
              </div>
            </div>
          </div>

          {/* Comparison Results */}
          {compareData.length >= 2 && (
            <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
              {/* Comparison Chart */}
              <div className="bg-white p-6 rounded-lg shadow">
                <h3 className="text-lg font-medium text-gray-900 mb-4">Period Comparison</h3>
                <ResponsiveContainer width="100%" height={300}>
                  <LineChart data={comparisonChartData}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="name" />
                    <YAxis />
                    <Tooltip />
                    <Legend />
                    <Line type="monotone" dataKey="sales" stroke="#3B82F6" strokeWidth={2} />
                    <Line type="monotone" dataKey="transactions" stroke="#10B981" strokeWidth={2} />
                  </LineChart>
                </ResponsiveContainer>
              </div>

              {/* Comparison Table */}
              <div className="bg-white p-6 rounded-lg shadow">
                <h3 className="text-lg font-medium text-gray-900 mb-4">Detailed Comparison</h3>
                <div className="overflow-x-auto">
                  <table className="min-w-full divide-y divide-gray-200">
                    <thead className="bg-gray-50">
                      <tr>
                        <th className="px-4 py-2 text-left text-xs font-medium text-gray-500 uppercase">
                          Metric
                        </th>
                        <th className="px-4 py-2 text-left text-xs font-medium text-gray-500 uppercase">
                          Period 1
                        </th>
                        <th className="px-4 py-2 text-left text-xs font-medium text-gray-500 uppercase">
                          Period 2
                        </th>
                        <th className="px-4 py-2 text-left text-xs font-medium text-gray-500 uppercase">
                          Change
                        </th>
                      </tr>
                    </thead>
                    <tbody className="bg-white divide-y divide-gray-200">
                      <tr>
                        <td className="px-4 py-2 text-sm font-medium text-gray-900">Sales</td>
                        <td className="px-4 py-2 text-sm text-gray-500">
                          ${(compareData[0]?.montantTTC || 0).toLocaleString()}
                        </td>
                        <td className="px-4 py-2 text-sm text-gray-500">
                          ${(compareData[1]?.montantTTC || 0).toLocaleString()}
                        </td>
                        <td className="px-4 py-2 text-sm text-gray-500">
                          {(() => {
                            const change = ((compareData[1]?.montantTTC || 0) - (compareData[0]?.montantTTC || 0)) / (compareData[0]?.montantTTC || 1) * 100;
                            return (
                              <span className={change >= 0 ? 'text-green-600' : 'text-red-600'}>
                                {change >= 0 ? '+' : ''}{change.toFixed(1)}%
                              </span>
                            );
                          })()}
                        </td>
                      </tr>
                      <tr>
                        <td className="px-4 py-2 text-sm font-medium text-gray-900">Transactions</td>
                        <td className="px-4 py-2 text-sm text-gray-500">
                          {compareData[0]?.nombreTickets || 0}
                        </td>
                        <td className="px-4 py-2 text-sm text-gray-500">
                          {compareData[1]?.nombreTickets || 0}
                        </td>
                        <td className="px-4 py-2 text-sm text-gray-500">
                          {(() => {
                            const change = ((compareData[1]?.nombreTickets || 0) - (compareData[0]?.nombreTickets || 0)) / (compareData[0]?.nombreTickets || 1) * 100;
                            return (
                              <span className={change >= 0 ? 'text-green-600' : 'text-red-600'}>
                                {change >= 0 ? '+' : ''}{change.toFixed(1)}%
                              </span>
                            );
                          })()}
                        </td>
                      </tr>
                      <tr>
                        <td className="px-4 py-2 text-sm font-medium text-gray-900">Items</td>
                        <td className="px-4 py-2 text-sm text-gray-500">
                          {compareData[0]?.quantite || 0}
                        </td>
                        <td className="px-4 py-2 text-sm text-gray-500">
                          {compareData[1]?.quantite || 0}
                        </td>
                        <td className="px-4 py-2 text-sm text-gray-500">
                          {(() => {
                            const change = ((compareData[1]?.quantite || 0) - (compareData[0]?.quantite || 0)) / (compareData[0]?.quantite || 1) * 100;
                            return (
                              <span className={change >= 0 ? 'text-green-600' : 'text-red-600'}>
                                {change >= 0 ? '+' : ''}{change.toFixed(1)}%
                              </span>
                            );
                          })()}
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          )}
        </div>
      )}

      {loading && (
        <div className="flex items-center justify-center h-32">
          <div className="animate-spin rounded-full h-8 w-8 border-b-2 border-indigo-500"></div>
        </div>
      )}
    </div>
  );
};

export default Reports;