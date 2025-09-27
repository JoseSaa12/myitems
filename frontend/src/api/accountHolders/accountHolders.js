// frontend/src/api/accountHolders/accountHolders.js
import { api } from "../http";

// Todos los endpoints del recurso
const API_URL = "/api/account-holders";

/**
 * Obtiene la página del backend tal cual (para componentes que esperan res.data)
 * Devuelve el objeto de backend (ej. { data: [...], total, ... })
 */
export async function getPaged(page = 0, size = 5, sortBy = "id", direction = "ASC") {
  try {
    const resp = await api.get(
      `${API_URL}?page=${page}&size=${size}&sort=${sortBy},${direction}`
    );
    // resp.data es el objeto que viene del backend (AccountHolderResponse)
    return resp.data;
  } catch (error) {
    console.error("Error al obtener AccountHolders:", error);
    // Para no romper el front que hace res.data, devolvemos shape compatible
    return { data: [] };
  }
}

/**
 * Devuelve directamente el array de items (azucar para el hook)
 */
export async function listPaged({ page = 0, size = 100, sortBy = "id", direction = "ASC" } = {}) {
  const res = await getPaged(page, size, sortBy, direction);
  // si el backend responde { data: [...] } devolvemos ese array; si no, [].
  return Array.isArray(res?.data) ? res.data : [];
}

/**
 * Crea un item (NO altera nada del backend más allá de llamar al POST).
 * data: { name, description, ... }
 */
export async function createOne(data) {
  const resp = await api.post(API_URL, data);
  return resp.data;
}

/**
 * Actualiza un item por id.
 */
export async function updateOne(id, data) {
  const resp = await api.put(`${API_URL}/${id}`, data);
  return resp.data;
}

/**
 * Elimina un item por id.
 */
export async function removeOne(id) {
  const resp = await api.delete(`${API_URL}/${id}`);
  return resp.data;
}
