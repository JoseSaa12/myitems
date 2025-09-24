# MyItems – Backend (Spring Boot) · AccountHolder API

API REST para gestionar **titulares (AccountHolder)**.  
Proyecto construido con **Spring Boot 3**, **Java 21**, **JPA (Hibernate)**, **H2** y **Swagger/OpenAPI**.

---

## 📚 Tabla de contenido
- [Stack](#-stack)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Cómo ejecutar](#-cómo-ejecutar)
- [Base de datos H2 & Seeds](#-base-de-datos-h2--seeds)
- [Swagger / OpenAPI](#-swagger--openapi)
- [Endpoints](#-endpoints)
- [Paginación](#-paginación)
- [Validaciones](#-validaciones)
- [Manejo de errores](#-manejo-de-errores)
- [Decisiones de diseño](#-decisiones-de-diseño)
- [Pruebas (plan mínimo)](#-pruebas-plan-mínimo)
- [Comandos Git rápidos](#-comandos-git-rápidos)

---

## 🧰 Stack
- **Java** 21
- **Spring Boot** 3.3.x
- **Spring Web**, **Spring Data JPA**, **Validation**
- **H2** (en memoria)
- **springdoc-openapi** (Swagger UI)

---

## 🗂 Estructura del proyecto
backend/

├─ src/main/java/com/josesaa12/myitems/backend
│ ├─ controller
│ │ ├─ AccountHolderController.java # CRUD + paginación + manejo de errores (local)
│ │ └─ HealthController.java # /api/health (ping)
│ ├─ dto
│ │ ├─ AccountHolderRequest.java # name, description, tags (validado)
│ │ ├─ AccountHolderResponse.java # id, name, description, tags, createdAt, updatedAt
│ │ └─ PagedResponse.java # data[], meta{page,size,totalElements,totalPages}
│ ├─ model
│ │ └─ AccountHolder.java # Entidad JPA
│ ├─ repository
│ │ └─ AccountHolderRepository.java # JpaRepository
│ ├─ service
│ │ └─ AccountHolderService.java # Lógica de negocio
│ ├─ config
│ │ └─ SwaggerConfig.java # Info de OpenAPI (título, links)
│ └─ BackendApplication.java
│
├─ src/main/resources
│ ├─ application.properties # H2, puerto, etc.
│ ├─ schema.sql (si aplica)
│ └─ data.sql (si aplica)
└─ pom.xml