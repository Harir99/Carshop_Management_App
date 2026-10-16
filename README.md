# CarShop Management App

Full-stack car inventory management application built with **Java, Spring Boot, React, TypeScript, and MariaDB**.

The project focuses on production-style backend development, including REST API design, authentication and authorization, validation, database optimization, automated testing, caching, logging, database migrations, and containerized development.

## Highlights

- RESTful API for managing vehicles and application data
- JWT-based authentication
- Role-based access control
- Pagination, filtering, and sorting
- Request validation and centralized exception handling
- Database query optimization that reduced API response time by **30%**
- Application-level caching
- Structured application logging
- Database migrations
- Unit, integration, and API testing
- Docker Compose development environment

## Tech Stack

### Backend
- Java
- Spring Boot
- REST APIs
- JPA / Hibernate
- MariaDB

### Frontend
- React
- TypeScript

### Testing
- JUnit
- Unit tests
- Integration tests
- API tests

### Infrastructure
- Docker
- Docker Compose

## Architecture

The application follows a layered architecture:

```text
React / TypeScript Client
          |
          v
    REST Controllers
          |
          v
      Services
          |
          v
    Repositories
          |
          v
       MariaDB
