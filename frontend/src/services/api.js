import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Auth API
export const authAPI = {
  login: (credentials) => api.post('/Login', credentials),
  checkServer: (number) => api.post('/checkServer', number),
};

// Sales API
export const salesAPI = {
  getBestSales: (data) => api.post('/bestSalesPrds', data),
  getLineVentes: (data) => api.post('/getLineVentes', data),
  getPrdsVendus: (data) => api.post('/getPrdsVendus', data),
  getDimsPrdVendus: (data) => api.post('/getDimsPrdVendus', data),
};

// Store API
export const storeAPI = {
  getMagasins: () => api.post('/getMagasins'),
  getMagasinsInfoByDate: (data) => api.post('/getMagasinsInfoByDate', data),
  getComparePeriode: (data) => api.post('/getComparePeriode', data),
  getInfosByDate: (data) => api.post('/getInfosByDate', data),
  getInfosDay: (data) => api.post('/getInfosDay', data),
};

// Inventory API
export const inventoryAPI = {
  getStockByProduct: (data) => api.post('/StockByProduct', data),
  getGlobalStock: (data) => api.post('/GlobalStock', data),
  getDims: (data) => api.post('/getDims', data),
};

// Parameters API
export const parametersAPI = {
  getParam: () => api.post('/getParam'),
};

export default api;