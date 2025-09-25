import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "./index.css"; // asegúrate que este archivo existe (lo crea Vite por defecto)

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
