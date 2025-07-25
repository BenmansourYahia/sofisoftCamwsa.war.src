import React, { useState } from 'react';
import { useAuth } from '../../context/AuthContext';
import { 
  UserIcon, 
  ChevronDownIcon, 
  ArrowRightOnRectangleIcon,
  BuildingStorefrontIcon 
} from '@heroicons/react/24/outline';

const Navbar = () => {
  const { user, logout, stores, selectedStore, selectStore } = useAuth();
  const [showUserMenu, setShowUserMenu] = useState(false);
  const [showStoreMenu, setShowStoreMenu] = useState(false);

  return (
    <nav className="bg-white shadow-sm border-b border-gray-200">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between h-16">
          <div className="flex items-center">
            <div className="flex-shrink-0">
              <h1 className="text-xl font-bold text-gray-900">CAM2020</h1>
            </div>
          </div>

          <div className="flex items-center space-x-4">
            {/* Store Selector */}
            <div className="relative">
              <button
                onClick={() => setShowStoreMenu(!showStoreMenu)}
                className="flex items-center space-x-2 px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"
              >
                <BuildingStorefrontIcon className="h-5 w-5" />
                <span>{selectedStore?.nomMagasin || 'Select Store'}</span>
                <ChevronDownIcon className="h-4 w-4" />
              </button>

              {showStoreMenu && (
                <div className="absolute right-0 mt-2 w-56 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5 z-50">
                  <div className="py-1">
                    {stores.map((store) => (
                      <button
                        key={store.numMagasin}
                        onClick={() => {
                          selectStore(store);
                          setShowStoreMenu(false);
                        }}
                        className={`block w-full text-left px-4 py-2 text-sm ${
                          selectedStore?.numMagasin === store.numMagasin
                            ? 'bg-blue-50 text-blue-700'
                            : 'text-gray-700 hover:bg-gray-50'
                        }`}
                      >
                        <div>
                          <div className="font-medium">{store.nomMagasin}</div>
                          <div className="text-xs text-gray-500">{store.codeMagasin}</div>
                        </div>
                      </button>
                    ))}
                  </div>
                </div>
              )}
            </div>

            {/* User Menu */}
            <div className="relative">
              <button
                onClick={() => setShowUserMenu(!showUserMenu)}
                className="flex items-center space-x-2 px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"
              >
                <UserIcon className="h-5 w-5" />
                <span>{user?.nom}</span>
                <ChevronDownIcon className="h-4 w-4" />
              </button>

              {showUserMenu && (
                <div className="absolute right-0 mt-2 w-48 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5 z-50">
                  <div className="py-1">
                    <button
                      onClick={logout}
                      className="flex items-center w-full px-4 py-2 text-sm text-gray-700 hover:bg-gray-50"
                    >
                      <ArrowRightOnRectangleIcon className="h-4 w-4 mr-2" />
                      Logout
                    </button>
                  </div>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;