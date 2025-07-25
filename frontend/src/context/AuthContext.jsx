import React, { createContext, useContext, useState, useEffect } from 'react';
import { authAPI } from '../services/api';

const AuthContext = createContext();

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
};

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [stores, setStores] = useState([]);
  const [selectedStore, setSelectedStore] = useState(null);

  useEffect(() => {
    const savedUser = localStorage.getItem('user');
    const savedStores = localStorage.getItem('stores');
    const savedSelectedStore = localStorage.getItem('selectedStore');
    
    if (savedUser) {
      setUser(JSON.parse(savedUser));
    }
    if (savedStores) {
      setStores(JSON.parse(savedStores));
    }
    if (savedSelectedStore) {
      setSelectedStore(JSON.parse(savedSelectedStore));
    }
    setLoading(false);
  }, []);

  const login = async (credentials) => {
    try {
      const response = await authAPI.login(credentials);
      if (response.data.success) {
        const data = JSON.parse(response.data.data);
        setUser(data.user);
        setStores(data.mags);
        
        localStorage.setItem('user', JSON.stringify(data.user));
        localStorage.setItem('stores', JSON.stringify(data.mags));
        
        // Set default store
        if (data.mags.length > 0) {
          setSelectedStore(data.mags[0]);
          localStorage.setItem('selectedStore', JSON.stringify(data.mags[0]));
        }
        
        return { success: true };
      } else {
        return { success: false, message: response.data.message };
      }
    } catch (error) {
      return { success: false, message: 'Connection error' };
    }
  };

  const logout = () => {
    setUser(null);
    setStores([]);
    setSelectedStore(null);
    localStorage.removeItem('user');
    localStorage.removeItem('stores');
    localStorage.removeItem('selectedStore');
  };

  const selectStore = (store) => {
    setSelectedStore(store);
    localStorage.setItem('selectedStore', JSON.stringify(store));
  };

  const value = {
    user,
    stores,
    selectedStore,
    loading,
    login,
    logout,
    selectStore,
  };

  return (
    <AuthContext.Provider value={value}>
      {children}
    </AuthContext.Provider>
  );
};