# Patient Management Server

Patient Management Server is a Java-based, microservices-ready backend designed to manage patient data and related healthcare workflows. It leverages gRPC for high-performance service-to-service communication, Kafka for event-driven messaging, and PostgreSQL for reliable data persistence. The service is containerized with Docker for consistent deployments.

## Tech Stack

- **Server:** Java, Spring Boot, gRPC
- **Messaging:** Apache Kafka
- **Database:** PostgreSQL
- **CI/CD & Containerization:** Docker

## Features

- **Patient Data Management:** Create, read, update, and delete patient records via gRPC endpoints.  
- **Event-Driven Architecture:** Publishes and consumes domain events (e.g., patient created/updated) through Kafka.  
- **Reliable Persistence:** Stores application data in PostgreSQL.  
- **Microservices-Friendly:** Designed for service-to-service communication with gRPC and scalable messaging via Kafka.  

## Quick Start

> Follow these steps to set up the project locally on your machine.

Clone the repository

```bash
git clone https://github.com/tom474/patient_management_server.git
```

Navigate to the project directory

```bash
cd patient_management_server
```

Configure environment (example: export variables or place them in your container runtime)

```
# PostgreSQL connection
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/patientdb
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres

# Kafka broker(s)
SPRING_KAFKA_BOOTSTRAP_SERVERS=localhost:9092

# gRPC server port
GRPC_SERVER_PORT=9090
```

You can also configure the above via Spring Boot `application.properties`/`application.yml` using their corresponding property names.

### Run with Docker

Build the image

```bash
docker build -t patient-management-server .
```

Run the container

```bash
docker run --rm \
  -e SPRING_DATASOURCE_URL="$SPRING_DATASOURCE_URL" \
  -e SPRING_DATASOURCE_USERNAME="$SPRING_DATASOURCE_USERNAME" \
  -e SPRING_DATASOURCE_PASSWORD="$SPRING_DATASOURCE_PASSWORD" \
  -e SPRING_KAFKA_BOOTSTRAP_SERVERS="$SPRING_KAFKA_BOOTSTRAP_SERVERS" \
  -e GRPC_SERVER_PORT="$GRPC_SERVER_PORT" \
  -p 9090:9090 \
  patient-management-server
```

### Run Locally (without Docker)

Prerequisites
- Java 17+ installed
- PostgreSQL and Kafka running locally or accessible via network
- Maven Wrapper (`mvnw`) or Gradle Wrapper (`gradlew`) available in the repo

Install dependencies and start the server (choose one)

```bash
# Using Maven
./mvnw spring-boot:run
```

```bash
# Using Gradle
./gradlew bootRun
```

Alternatively, build a jar and run it

```bash
# Maven
./mvnw -DskipTests package
java -jar target/*.jar
```

```bash
# Gradle
./gradlew build -x test
java -jar build/libs/*.jar
```
