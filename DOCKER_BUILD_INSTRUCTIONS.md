# Docker Build Instructions

## Eureka Server
mvn clean package -DskipTests
docker build -t eureka-server:1.0 .

## Gateway Service
mvn clean package -DskipTests
docker build -t gateway-service:1.0 .

## Account Service
mvn clean package -DskipTests
docker build -t account-service:1.0 .

## Auth Service
mvn clean package -DskipTests
docker build -t auth-service:1.0 .

## Users Service
mvn clean package -DskipTests
docker build -t users-service:1.0 .

## Transactions Service
mvn clean package -DskipTests
docker build -t transactions-service:1.0 .

## Aadhar Service
mvn clean package -DskipTests
docker build -t aadhar-service:1.0 .

## Company Service
mvn clean package -DskipTests
docker build -t company-service:1.0 .

## Payment Gateway Service
mvn clean package -DskipTests
docker build -t payment-gateway-service:1.0 .