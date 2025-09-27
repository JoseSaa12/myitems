# 🏋️ MyItems Monorepo

Este proyecto contiene **frontend** y **backend** organizados en un monorepo.  
Es un CRUD simple para la gestión de miembros de un gimnasio.

---

## 📂 Estructura del proyecto

myitems/
│── backend/ # Proyecto Spring Boot (Java)
│── frontend/ # Proyecto React + Vite
│── README.md # Este archivo


---

## ⚙️ Tecnologías usadas

- **Backend**
  - Java 21
  - Spring Boot 3.3.5
  - Spring Data JPA
  - H2 Database (en memoria)
  - Maven

- **Frontend**
  - React 18
  - Vite
  - Axios
  - TailwindCSS

---

## ▶️ Cómo ejecutar el proyecto

### 🔹 Backend (Spring Boot)

1. Abrir una terminal en la carpeta:
   ```bash
   cd backend/backend


--- 

Ejecutar con Marven:

mvn spring-boot:run

---
Frontend (React)

cd frontend

---

Instalar dependencias:

npm install

--

Ejecutar en modo desarrollo:

npm run dev 

---
El frontend estará disponible en:
(http://localhost:5173)

---
test

backend/backend/src/test/java/com/josesaa12/myitems/backend/

mvn test

---

📊 Estado del proyecto

✔️ Estructura backend + frontend lista
✔️ CRUD de miembros implementado en backend
✔️ Frontend con componentes principales (listado, modal, stats)
⚠️ Problema pendiente con CORS entre frontend y backend
⚠️ Falta pulir integración completa y validaciones

📖 Notas finales

Este proyecto fue desarrollado como parte del Proyecto Final del Módulo 3.
El foco principal es la práctica de:

Monorepo con Java + React

CRUD completo

Buenas prácticas con Spring Boot y React

   
