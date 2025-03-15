# Bank Account Management System (BAMS)

## 📌 Introduction

BAMS (Bank Account Management System) is a Spring Boot-based web application that provides banking functionalities such as account creation, deposits, withdrawals, and account management. It uses **Spring Boot**, **Spring Data JPA**, and **MySQL** for database management.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **MySQL 8+**
- **Hibernate ORM**
- **Maven**
- **REST API**

---

## ⚙️ Database Configuration

To connect the application with MySQL, update the **`application.properties`** file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_spring
spring.datasource.username=root
spring.datasource.password=Root@123#

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 🏦 MySQL Setup

1. Open MySQL and create the database manually (if not already created):
   ```sql
   CREATE DATABASE banking_spring;
   ```
2. Make sure your MySQL server is **running** on port **3306**.
3. Update `spring.datasource.username` and `spring.datasource.password` according to your MySQL credentials.

---

## 🚀 Running the Project

### Prerequisites

- Install **Java 17+**
- Install **Maven**
- Install **MySQL 8+**

### Steps to Run

1. Clone the repository:
   ```bash
   https://github.com/VirtUHope/BAMS.git
   cd BAMS
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## 📌 API Endpoints

### 🏦 Account Management

| Method | Endpoint                      | Description                    |
| ------ | ----------------------------- | ------------------------------ |
| POST   | `/api/accounts`               | Create a new account           |
| GET    | `/api/accounts/{id}`          | Get account details by ID      |
| PUT    | `/api/accounts/deposit/{id}`  | Deposit money into an account  |
| PUT    | `/api/accounts/withdraw/{id}` | Withdraw money from an account |
| GET    | `/api/accounts/all`           | Get all accounts               |
| DELETE | `/api/accounts/delete/{id}`   | Delete an account              |

---

---

## 💬 Contact

For any queries, feel free to reach out!

- **Email:** [sameergupta122898@gmail.com](mailto\:sameergupta122898@gmail.com)

