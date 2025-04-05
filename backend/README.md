# Artist Management API

This is a artist management API developed with Kotlin and Spring Boot. The API allows you to create, list, update, and delete artist, as well as provide pagination and search by ID.

## Technologies Used

- **Kotlin**: Main programming language.
- **Spring Boot**: Framework for building the application.
- **Gradle**: Build automation tool.
- **SQL**: Relational database.

## How to Run

### Prerequisites

- **Java 11+**: Ensure that Java is installed and configured in your `PATH`.
- **Gradle**: Although the Gradle wrapper is included, you can install Gradle globally.

### Steps to Run

1. **Clone the repository**:
    ```sh
    git clone https://github.com/leokenzley/kotlin-react-google-auth.git
    cd kotlin-react-google-auth/backend
    ```

2. **Configure the database**:
    - Ensure the database is configured and the credentials are correct in the `application.properties` file.

3. **Run the application**:
    ```sh
    ./gradlew bootRun
    ```

4. **Access the API**:
    - The API will be available at `http://localhost:8080`.

## Endpoints

- **POST /artist/users**: Creates a new user.
- **GET /artist/users**: Lists all users.
- **GET /artist/users/{id}**: Retrieves a user by ID.
- **PUT /artist/users/{id}**: Updates an existing user.
- **DELETE /artist/users/{id}**: Deletes a user.
  Converta o texto do seguinte .md para o inglês:

### Issues

**Description:**
This API is currently under development. The following features and improvements are being
- [ ] Complete Unit Test Coverage
- [ ] Endpoint documentation
- [ ] Artist CRUD
- [ ] Agenda CRUD

**Tasks:**
1. Write unit tests for application use cases
2. Add integration tests for application endpoints
3. Implement Artist CRUD functionality.
4. Implement Agenda CRUD functionality.

## Contact

- **Name**: Leo Kenzley
- **Email**: leokenzley@email.com
- **GitHub**: [leokenzley](https://github.com/leokenzley)

Feel free to contact me if you have any questions or suggestions.