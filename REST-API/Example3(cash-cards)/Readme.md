# CashCard RESTful API

This is a simple RESTful API project for managing CashCards using the Java programming language and Spring Boot framework.
The project demonstrates basic CRUD operations for CashCards, such as creating, updating, deleting, and fetching cards.

## Technologies Used

- Java
- Spring Boot
- JPA (Java Persistence API)
- Jackson (for JSON processing)
- PostgreSQL (database)
- Maven (project management tool)
- Postman (for API testing)

## API Endpoints

- `GET /cashcards`: Retrieve all CashCards.
- `GET /cashcards/{id}`: Retrieve a specific CashCard by ID.
- `POST /cashcards/AddCard`: Add a new CashCard.
- `PUT /cashcards/update/{id}`: Update the amount of an existing CashCard by ID.
- `DELETE /cashcards/delete/{id}`: Delete an existing CashCard by ID.
