import axios from 'axios';

const API = axios.create({
  baseURL: import.meta.env.VITE_API_URL || 'https://road2cs.onrender.com',
  headers: { 'Content-Type': 'application/json' }
});

let onBackendDown = null;

export const setBackendDownHandler = (handler) => {
  onBackendDown = handler;
};

API.interceptors.response.use(
  (response) => response,
  (error) => {
    const isNetworkError = !error.response;
    const isServerError = error.response?.status >= 500;

    if (isNetworkError || isServerError) {
      if (onBackendDown) onBackendDown(true);
    }

    return Promise.reject(error);
  }
);

export default API;