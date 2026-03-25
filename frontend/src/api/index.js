import axios from 'axios';

const API = axios.create({
baseURL: 'https://road2cs.onrender.com',
headers: { 'Content-Type': 'application/json' }
});

export default API;
