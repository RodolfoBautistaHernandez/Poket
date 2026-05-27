# Proyecto Spring Boot - API REST (Evaluación Técnica Banca Mifel)

##  Descripción

Este proyecto consiste en el desarrollo de una API REST utilizando **Spring Boot** que cumple con los requerimientos de una evaluación técnica.

Incluye:

* Autenticación mediante **JWT**
* Persistencia con **H2 + JPA**
* Filtro dinámico de catálogo de items
* Consumo de API externa (**PokeAPI**)
* Servicio de cifrado **AES/CBC/PKCS5Padding**
* Validación de datos con **@Valid**
* Documentación con **Swagger (OpenAPI)**

---

## Tecnologías utilizadas

* Java 21
* Spring Boot 3
* Spring Security
* JWT (jjwt)
* Spring Data JPA
* H2 Database
* Maven
* WebClient (WebFlux)
* Swagger / OpenAPI
* Lombok

---

## ▶️ Cómo ejecutar el proyecto

### 1. Clonar repositorio

```bash
git clone https://github.com/RodolfoBautistaHernandez/Poket.git
cd Poket
```

### 2. Ejecutar aplicación

Desde IntelliJ o terminal:

```bash
mvn spring-boot:run
```

---

### 3. Accesos importantes

* API: http://localhost:8080
* H2 Console: http://localhost:8080/h2-console
* Swagger UI: http://localhost:8080/swagger-ui.html

---

## Credenciales de prueba

```json
{
  "username": "admin",
  "password": "admin123"
}
```

---

## Endpoints principales

### Autenticación

#### POST /auth/login

**Request:**

```json
{
  "username": "admin",
  "password": "admin123"
}
```

**Response:**

```json
{
  "token": "jwt_token"
}
```

---

### Items

#### GET /items

Obtiene todos los items

#### GET /items?nombre=valor

Filtra items por nombre

**Ejemplo:**

```
GET /items?nombre=lap
```

---

### Consumo API externa

#### GET /pokemon

Consume la API pública:

https://pokeapi.co/api/v2/pokemon/ditto

---

### Cifrado

#### POST /crypto/encrypt

**Request:**

```json
{
  "texto": "mensaje secreto"
}
```

**Response:**

```json
{
  "resultado": "texto cifrado"
}
```

---

## Configuración

### application.properties

```properties
spring.datasource.url=jdbc:h2:mem:testdb

crypto.secret.key=mifelSecretKey16
crypto.init.vector=mifelInitVector1
```

---

## Validaciones

Se implementan validaciones con:

* `@NotBlank`
* `@Size`
* `@Valid`

Ejemplo de error:

```json
{
  "errors": [
    "El username es obligatorio",
    "El password debe tener al menos 6 caracteres"
  ],
  "status": 400
}
```

---

##  Manejo de errores

Se implementa un manejador global con:

* `@RestControllerAdvice`

Para garantizar respuestas consistentes en toda la API.

---

## 📈 Buenas prácticas implementadas

* Arquitectura en capas (Controller, Service, Repository)
* Uso de DTOs
* Validación de entrada
* Manejo global de errores
* Variables de entorno
* Logs estructurados
* Documentación con Swagger

---

## Autor

**Rodolfo Bautista Hernández**

---
