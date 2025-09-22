# Student REST API

REST API for managing students using Spring Boot and H2 database.

## Setup

1. Install Java 17 and Maven.
2. Clone the repository: `git clone https://github.com/dzarembo/student-rest-api.git`
3. Navigate to the project directory: `cd student-rest-api`
4. Rename `application-example.properties` to `application.properties`

```bash
cd student-rest-api/src/main/resources
mv application-example.properties application.properties
```

5. Add your credentials for database access

```bash
nano application.properties
```

6. Run the application: `mvn spring-boot:run`
7. The API is available at `http://localhost:8080`

## Endpoints

- GET /students - Retrieve all students
- POST /students - Create a student
- GET /student/{id} - Retrieve a student by ID
- PUT /student/{id} - Update a student
- DELETE /student/{id} - Delete a student


## Post Body example

{
"name": "Dima",
"salary": 5000,
"birthday": "1991-07-03"
}

# Security block
## Session-based
### Endpoints

- POST /security/registration - public registration new user (role USER_ROLE)
  
{
  "username": "newuser",
  "password": "securepassword"
  }
- GET /security/user/** - USER and ADMIN zone
- GET /security/user/me - authenticated user info
- GET /security/admin/** - ADMIN only zone
- GET /security/ - authenticated users only 
- /login /logout  - standard forms

### Exists users
admin admin (ADMIN_ROLE)
user user (USER_ROLE)
