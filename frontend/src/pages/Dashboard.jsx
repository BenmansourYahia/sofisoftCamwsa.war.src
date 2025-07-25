import React, { useState, useEffect } from 'react';
import { useAuth } from '../context/AuthContext';
import { storeAPI } from '../services/api';
import { format, subDays } from 'date-fns';
import {
  CurrencyDollarIcon,
  ShoppingCartIcon,
  UserGroupIcon,
  TrendingUpIcon,
} from '@heroicons/react/24/outline';

const Dashboard = () => {
  const { selectedStore } = useAuth();
  const [dashboardData, setDashboardData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [dateRange, setDateRange] = useState({
    debut: format(subDays(new Date(), 7), 'dd-MM-yyyy HH:mm:ss'),
    fin: format(new Date(), 'dd-MM-yyyy HH:mm:ss'),
  });

  useEffect(() => {
    if (selectedStore) {
      fetchDashboardData();
    }
  }, [selectedStore, dateRange]);

  const fetchDashboardData = async () => {
    try {
      setLoading(true);
      const response = await storeAPI.getInfosByDate(dateRange);
      if (response.data.success) {
        const data = JSON.parse(response.data.data);
        setDashboardData(data);
      }
    } catch (error) {
      console.error('Error fetching dashboard data:', error);
    } finally {
      setLoading(false);
    }
  };

  const stats = [
    {
      name: 'Total Sales',
      value: dashboardData?.data ? 
        JSON.parse(dashboardData.data).reduce((sum, item) => sum + (item.montantTTC || 0), 0).toLocaleString('en-US', {
          style: 'currency',
          currency: 'USD'
        }) : '$0',
      icon: CurrencyDollarIcon,
      change: '+4.75%',
      changeType: 'increase',
    },
    {
      name: 'Total Transactions',
      value: dashboardData?.data ? 
        JSON.parse(dashboardData.data).reduce((sum, item) => sum + (item.nombreTickets || 0), 0) : 0,
      icon: ShoppingCartIcon,
      change: '+54.02%',
      changeType: 'increase',
    },
    {
      name: 'Items Sold',
      value: dashboardData?.data ? 
        JSON.parse(dashboardData.data).reduce((sum, item) => sum + (item.quantite || 0), 0) : 0,
      icon: UserGroupIcon,
      change: '-1.39%',
      changeType: 'decrease',
    },
    {
      name: 'Average Order',
      value: dashboardData?.data ? 
        (() => {
          const data = JSON.parse(dashboardData.data);
          const totalSales = data.reduce((sum, item) => sum + (item.montantTTC || 0), 0);
          const totalTransactions = data.reduce((sum, item) => sum + (item.nombreTickets || 0), 0);
          return totalTransactions > 0 ? 
            (totalSales / totalTransactions).toLocaleString('en-US', {
              style: 'currency',
              currency: 'USD'
            }) : '$0';
        })() : '$0',
      icon: TrendingUpIcon,
      change: '+10.18%',
      changeType: 'increase',
    },
  ];

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
        <h1 className="text-2xl font-bold text-gray-900">Dashboard</h1>
        <p className="mt-1 text-sm text-gray-500">
          Welcome back! Here's what's happening at {selectedStore?.nomMagasin}.
        </p>
      </div>

      {/* Date Range Selector */}
      <div className="mb-6 bg-white p-4 rounded-lg shadow">
        <div className="flex flex-wrap gap-4">
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
        </div>
      </div>

      {/* Stats Grid */}
      <div className="grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-4 mb-8">
        {stats.map((item) => (
          <div
            key={item.name}
            className="relative bg-white pt-5 px-4 pb-12 sm:pt-6 sm:px-6 shadow rounded-lg overflow-hidden"
          >
            <dt>
              <div className="absolute bg-indigo-500 rounded-md p-3">
                <item.icon className="h-6 w-6 text-white" aria-hidden="true" />
              </div>
              <p className="ml-16 text-sm font-medium text-gray-500 truncate">
                {item.name}
              </p>
            </dt>
            <dd className="ml-16 pb-6 flex items-baseline sm:pb-7">
              <p className="text-2xl font-semibold text-gray-900">{item.value}</p>
              <p
                className={`ml-2 flex items-baseline text-sm font-semibold ${
                  item.changeType === 'increase'
                    ? 'text-green-600'
                    : 'text-red-600'
                }`}
              >
                {item.change}
              </p>
            </dd>
          </div>
        ))}
      </div>

      {/* Recent Activity */}
      <div className="bg-white shadow rounded-lg">
        <div className="px-4 py-5 sm:p-6">
          <h3 className="text-lg leading-6 font-medium text-gray-900 mb-4">
            Recent Activity
          </h3>
          <div className="text-sm text-gray-500">
            {dashboardData?.data ? (
              <div className="space-y-2">
                {JSON.parse(dashboardData.data).slice(0, 5).map((item, index) => (
                  <div key={index} className="flex justify-between items-center py-2 border-b border-gray-100">
                    <div>
                      <span className="font-medium">
                        {format(new Date(item.jourVente), 'MMM dd, yyyy')}
                      </span>
                    </div>
                    <div className="text-right">
                      <div className="font-medium">
                        {(item.montantTTC || 0).toLocaleString('en-US', {
                          style: 'currency',
                          currency: 'USD'
                        })}
                      </div>
                      <div className="text-xs text-gray-400">
                        {item.nombreTickets || 0} transactions
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            ) : (
              <p>No recent activity data available.</p>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;