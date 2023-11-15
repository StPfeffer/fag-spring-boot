# Transaction API

_Read this in other languages_:
[Português](README.md)

## Overview

This project is an API for transactions between users, built using the principles of clean architecture to ensure modularity, flexibility, and scalability. By adopting this approach, the code is organized into independent layers, promoting the separation of concerns and facilitating maintenance.

The chosen technologies for implementation are:


- **Java**: The robust and versatile programming language, chosen for its widespread adoption in the development community and its ability to provide performance and reliability.


- **Spring Boot**: A framework that simplifies the development of Java applications, providing a comprehensive set of tools and conventions for the rapid creation of services and RESTful APIs. Spring Boot also easily integrates with other technologies and libraries, speeding up the development cycle.


- **Jakarta Persistence API (JPA)**: A standard data persistence API for Java, which facilitates interaction with relational databases. By adopting JPA, the project gains in portability and flexibility, allowing for a more seamless switch between database vendors.


- **H2**: An in-memory database that offers a lightweight and efficient solution for development and testing. The choice of H2 streamlines the development process, allowing developers to test and validate API functionality without the need to set up a more robust database during the initial stages of the project.

## Key Features

### Transaction Creation:

- Allows users to create new transactions by providing details such as sender, recipient, and amount.

### Transaction Listing:
- Presents a comprehensive view of all completed transactions.
- Enables filtering by sender, recipient, and other criteria.

### Real-time Notifications:
- Sends automatic notifications to users involved in a successful transaction through an external service.

### Transaction Authorization:
- Incorporates an external authorization service to validate transactions before completion.

## Project Structure

![img.png](assets/img.png)

## How to Use

### Java and Maven

Firstly, ensure you have [Java](https://www.oracle.com/java/technologies/downloads/) and [Maven](https://maven.apache.org/download.cgi) installed.

### Install Dependencies

- Spring Boot
- H2 Database
- Jakarta Persistence API

```
mvn clean install
```

### Database

Configure the database properties in the src/main/resources/application.properties file.

*Note*: By default, an in-memory H2 database is configured.

### Postman

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/25630504-041b878b-1a1b-48ca-b1db-ec3e63343d71?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D25630504-041b878b-1a1b-48ca-b1db-ec3e63343d71%26entityType%3Dcollection%26workspaceId%3Dcfd8052d-40cd-44c6-b0f0-a2325f1f5430)

In the project directories, there is a folder named postman, containing a collection with all API endpoints.

To use it, copy the content of the postman/collections/Transaction API.json file and paste it into Postman:

![img1.png](assets/img1.png)

If you use IntelliJ, you can make HTTP requests directly from the IDE:

![img2.png](assets/img2.png)

### Run the Application:

To start the application, use the command:

```
mvn spring-boot:run
```

By default, the application will start on port 8080.
