# 🎬 NetflixAPI

A RESTful backend service built with Java and Spring Boot to manage Netflix series data with full CRUD operations.

This project follows a layered architecture and focuses on building scalable and maintainable backend systems.

---

## 🚀 Features

* RESTful API design
* CRUD operations
* Layered architecture (Controller, Service, Repository)
* DTO-based request/response handling
* Global exception handling
* PostgreSQL database integration
* JPA/Hibernate ORM
* Swagger UI for API documentation
* Input validation

---

## 🛠 Tech Stack

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Validation
* PostgreSQL
* Hibernate
* Lombok
* Swagger / OpenAPI
* Maven

---

## 📁 Project Structure

```
src
 └── main
     ├── controller
     ├── service
     ├── repository
     ├── dto
     ├── model
     └── resources
```
---

## 🧠 Architecture

* **Controller** → Handles HTTP requests
* **Service** → Business logic
* **Repository** → Database operations
* **DTO** → API data transfer
* **Model** → Database entities

---

## ⚙️ Setup & Installation

### Requirements

* Java 17
* Maven
* PostgreSQL

---

### 1. Clone the repository

git clone https://github.com/hakancebe/NetflixAPI.git
cd NetflixAPI

---

### 2. Create database

CREATE DATABASE netflix_db;

---

### 3. Configure application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/netflix_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

springdoc.swagger-ui.path=/swagger

---

### 4. Run the application

./mvnw spring-boot:run

Windows:
mvnw.cmd spring-boot:run

---

## 📖 API Documentation

http://localhost:8080/swagger

---

## ⚡ Performance Optimization

* Optimized bulk operations using hashing
* Reduced time complexity from **O(n²)** to **O(n)**

---

## 🔮 Future Improvements

* JWT Authentication
* Pagination & filtering
* Docker support
* Microservice architecture

---

## 👤 Author

Hakan Cebe
GitHub: https://github.com/hakancebe
LinkedIn: https://www.linkedin.com/in/hakancebe

---

## ⚠️ Note

Do not expose database credentials in production.
Use environment variables for security.
