# Microservices API for Authentication and User Management

This project is an implementation of a microservices-based backend system using Java Spring Boot. The system consists of two separate services that run independently but share the same data persistence.

### 🏗️ Architecture

This project uses a microservices architecture with a shared database (H2 file-based) pattern for data persistence between services.

1. **User Service (Port 8081):** Handles user registration, profile retrieval, and user data updates.
2. **Auth Service (Port 8082):** Handles the login process and JWT (JSON Web Token) token generation.

### 🛠️ Technologies Used

- Java 17
- Spring Boot 3
- Spring Security & JWT (jjwt)
- Spring Data JPA
- H2 Database (Server Mode/File Persistence)
- Lombok

---

## How to Run the Application

Since this is Microservices, it is necessary to run both projects simultaneously.

**Prerequisites:**
Make sure Java JDK 17+ and Maven are installed.

### Step 1: Run User Service

1. Open a terminal/CMD and navigate to the `userservice` folder.
2. Run the command:

   **For Windows (CMD):**

   ```cmd
   mvnw spring-boot:run
   ```

   **For Mac/Linux (Bash):**

   ```bash
   ./mvnw spring-boot:run
   ```

   (Or run UserserviceApplication.java through the IDE).

3. Ensure the service is running on Port 8081.

### Step 2: Run Auth Service

1. Open a new terminal (don't close the old one), navigate to the authservice folder.
2. Run the command:

   **For Windows (CMD):**

   ```cmd
   mvnw spring-boot:run
   ```

   **For Mac/Linux (Bash):**

   ```bash
   ./mvnw spring-boot:run
   ```

   (Or run AuthserviceApplication.java through the IDE).

3. Make sure the service is running on Port 8082.

Note: The H2 database will be automatically created in the computer's user home folder (~/myDatabase.mv.db) when the application is first run.

## How to Test API (API Documentation)

Use Postman or a similar tool to test the endpoints. Follow these steps to ensure a smooth test flow.

1. New User Registration (User Service)
   Create a new user to save in the database.

- URL: http://localhost:8081/users/register
- Method: POST
- Body (JSON):
  {
  "username": "assignment",
  "password": "password123",
  "email": "test@company.com",
  "fullName": "John Doe",
  "phone": "08123456789"
  }

- Expectation: Status 200 OK and return the created user data.

2. Login & Get Token (Auth Service)
   Log in using the newly created account to get a JWT token.

- URL: http://localhost:8082/auth/login
- Method: POST
- Body (JSON):
  {
  "username": "assignment",
  "password": "password123"
  }

- Expectation: Status 200 OK and response containing the token:
  {
  "token": "eyJhbGciOiJIUzI1NiJ9..."
  }
- Note: Copy the token (without the quotes) for the next step.

3. View User Profile (Protected Route - User Service)
   Accessing sensitive data requires a valid token.

- URL: http://localhost:8081/users/1 (Replace 1 with your user ID)
- Method: GET
- Authorization:
- Select Type: Bearer Token
- Paste your token in the Token field.
- Expectation: Status 200 OK and user profile data appears. (If no token, it will return 403 Forbidden).

4. Update User Profile (Protected Route - User Service)
   Change user data (e.g., add age and location).

- URL: http://localhost:8081/users/1
- Method: PUT
- Authorization: Select Bearer Token (Paste the token obtained from logging in).
- Body (JSON):
  {
  "name": "John Doe Updated",
  "age": 25,
  "location": "Jakarta, Indonesia"
  }

Expectation: Status 200 OK and user data updated.

## Project Structure

/AssignmentSubmittion-John Davincent
│
├── README.md <-- Guide File
│
├── /userservice <-- Project A (Port 8081)
│ ├── src/main/java...
│ ├── pom.xml
│ └── application.properties (User DB Config)
│
└── /authservice <-- Project B (Port 8082)
├── src/main/java...
├── pom.xml
└── application.properties (Auth DB Config)
