import axios from "axios";

const API_URL = "http://localhost:8080/accountHolders"; // URL del backend Spring Boot

// Función para obtener los datos con paginación
export async function getPaged(page = 0, sortBy = "id", direction = "ASC") {
  try {
    const response = await axios.get(`${API_URL}?page=${page}&sort=${sortBy},${direction}`);
    return response.data; // Aquí vendrán los AccountHolderResponse
  } catch (error) {
    console.error("Error al obtener AccountHolders:", error);
    return { data: [] }; // Para no romper el frontend si hay error
  }
}