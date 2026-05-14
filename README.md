📱 Social-Net - Backend API
Social-Net is a robust API developed with Java and Spring Boot, designed to simulate the core operations of a social media platform. The project focuses on demonstrating mastery in scalable architectures, data security, and complex entity relationships.

---

🎯 Key Features
1. User & Profile Management
Authentication: Secure login system using Spring Security (JWT recommended).

Profiles: Create, update, and view profiles with support for biographies and profile pictures.

Social Graph: Implementation of self-referencing relationships (users following other users).

2. Posts & Interactions
News Feed: Timeline of posts generated based on the user's connections.

Content Creation: Text and media support for posts.

Reactions & Comments: Real-time interaction system for user publications.

3. Architecture & Persistence
ORM: Leveraging Spring Data JPA for data layer abstraction.

Relationships: Implementation of complex cardinalities (ManyToMany for followers/friends and OneToMany for posts/comments).

Validations: Usage of Bean Validation (Hibernate Validator) to ensure input data integrity.

---

📐 Data Modeling
The system utilizes PostgreSQL to ensure data consistency through the following relational schema:

Snippet de código
erDiagram
    USER ||--o{ POST : writes
    USER ||--o{ COMMENT : composes
    USER ||--o{ USER : follows
    POST ||--o{ COMMENT : contains
    POST ||--o{ LIKE : receives

---

🛠️ Technology Stack
Language: Java 17+

Framework: Spring Boot 3.x

Security: Spring Security

Database: PostgreSQL / H2 (for testing)

Documentation: Swagger/OpenAPI

Build Tool: Maven

---

🚀 Getting Started
1. Clone the Repository
Bash
git clone https://github.com/LucasSilva1717/Social-Net.git
cd Social-Net
2. Database Configuration
Adjust the credentials in the src/main/resources/application.properties file:

---

Properties
spring.datasource.url=jdbc:postgresql://localhost:5432/social_net_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
3. Run the Application
Bash
mvn spring-boot:run

---

🤝 Roadmap (Future Updates)
[ ] Implementation of WebSockets for real-time notifications.

[ ] Integration with Amazon S3 for profile image storage.

[ ] Full test coverage using JUnit 5 and Mockito.

[ ] Automated deployment via Docker and GitHub Actions.

Developed with ☕ by Lucas Silva
