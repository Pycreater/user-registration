# User Registration and Fetch API

This project provides a RESTful API for user registration and fetching user details using Spring Boot and MySQL.

## Setup Instructions

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/Pycreater/user-registration.git
    cd user-registration
    ```

2. **Database Setup**:
    - Ensure you have MySQL installed and running on your machine.
    - Create a database named `users`:
        ```sql
        CREATE DATABASE users;
        ```

3. **Configure Database Credentials**:
    - Update the `src/main/resources/application.properties` file with your MySQL credentials:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/users
        spring.datasource.username=root
        spring.datasource.password=yourpassword
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
        ```

4. **Install Lombok Plugin**:
    - Lombok is used to reduce boilerplate code. Ensure you have the Lombok plugin installed in your IDE:
        - **IntelliJ IDEA**:
            1. Go to `File > Settings > Plugins`.
            2. Search for `Lombok` and install it.
            3. Enable annotation processing: `File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors` and check `Enable annotation processing`.
        - **Eclipse**:
            1. Go to `Help > Eclipse Marketplace`.
            2. Search for `Lombok` and install it.
            3. Restart Eclipse.
            4. Enable annotation processing: `Project > Properties > Java Compiler > Annotation Processing` and check `Enable annotation processing`.

5. **Build and Run the Application**:
    - Build the application using Maven:
        ```bash
        mvn clean install
        ```
    - Run the application:
        ```bash
        mvn spring-boot:run
        ```

## API Endpoints

1. **Register User**
    - **Endpoint**: `/api/user/register`
    - **Method**: `POST`
    - **Description**: Registers a new user.
    - **Request Body**: JSON object containing user details (username, email, password).
    - **Response**: Returns the registered user object on success, or an error message on failure.

    **Example Request**:
    ```json
    {
        "username": "testuser",
        "email": "testuser@example.com",
        "password": "password"
    }
    ```

    **Example cURL**:
    ```bash
    curl -X POST http://localhost:8080/api/user/register \
    -H "Content-Type: application/json" \
    -d '{"username":"testuser","email":"testuser@example.com","password":"password"}'
    ```

2. **Fetch User**
    - **Endpoint**: `/api/user/fetch`
    - **Method**: `GET`
    - **Description**: Fetches user details by username.
    - **Query Parameter**: `username` (String) - The username of the user to fetch.
    - **Response**: Returns the user object on success, or an error message if the user is not found.

    **Example Request**:
    ```
    GET /api/user/fetch?username=testuser
    ```

    **Example cURL**:
    ```bash
    curl -X GET "http://localhost:8080/api/user/fetch?username=testuser"
    ```

## Error Handling

The API uses basic error handling to return appropriate HTTP status codes and messages:

- **Registration Errors**: If there is an error during registration, the API will return a `500 Internal Server Error` with a message detailing the issue.
- **Fetch Errors**: If the user is not found, the API will return a `404 Not Found` with the message "User not found".

## Example Responses

1. **Register User - Success**:
    ```json
    {
        "id": 1,
        "username": "testuser",
        "email": "testuser@example.com",
        "password": "password"
    }
    ```

2. **Register User - Failure**:
    ```json
    {
        "message": "Error registering user: {error details}"
    }
    ```

3. **Fetch User - Success**:
    ```json
    {
        "id": 1,
        "username": "testuser",
        "email": "testuser@example.com",
        "password": "password"
    }
    ```

4. **Fetch User - Failure**:
    ```json
    {
        "message": "User not found"
    }
    ```

## PostMan API Testing
![Screenshot (102)](https://github.com/Pycreater/user-registration/assets/114671066/a4757b73-7f96-4c22-a432-c56b693f0761)
![Screenshot (103)](https://github.com/Pycreater/user-registration/assets/114671066/c8c23957-c2cd-451b-9097-7f1297f9f591)

