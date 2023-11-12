# Transaction API

_Read this in other languages_:
[Português](README.md)

## Overview

## Key Features

### Transaction Creation:

- Allows users to create new transactions by providing details such as sender, recipient, and amount.

### Transaction Listing:
- Presents a comprehensive view of all completed transactions.
- Enables filtering by sender, recipient, and other criteria.

### Real-time Notifications:
- Sends automatic notifications to users involved in a successful transaction through an external service.

### Transaction Authorization:
- Incorporates an external authorization service (Mocky) to validate transactions before completion.

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

By default, the application will open on port 8080.
