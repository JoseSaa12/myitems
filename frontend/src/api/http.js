// frontend/src/api/http.js
import axios from "axios";

const baseURL =
  (import.meta.env.VITE_API_URL && import.meta.env.VITE_API_URL.replace(/\/+$/, "")) ||
  "http://localhost:8080";

export const api = axios.create({
  baseURL,
  headers: { "Content-Type": "application/json" },
  timeout: 10000,
});

// Logs de error opcionales
api.interceptors.response.use(
  (r) => r,
  (err) => {
    console.error("[HTTP ERROR]", err?.response?.status, err?.message);
    throw err;
  }
);
