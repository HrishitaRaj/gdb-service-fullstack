# Docker Build Instructions

## Eureka Server
mvn -f eureka-server/pom.xml clean package -DskipTests
docker build -t eureka-server:1.0 -f eureka-server/Dockerfile eureka-server

## Gateway Service
mvn -f gateway-service/pom.xml clean package -DskipTests
docker build -t gateway-service:1.0 -f gateway-service/Dockerfile gateway-service

## Account Service
mvn -f account-service/pom.xml clean package -DskipTests
docker build -t account-service:1.0 -f account-service/Dockerfile account-service

## Auth Service
mvn -f auth-service/pom.xml clean package -DskipTests
docker build -t auth-service:1.0 -f auth-service/Dockerfile auth-service

## Users Service
mvn -f users-service/pom.xml clean package -DskipTests
docker build -t users-service:1.0 -f users-service/Dockerfile users-service
## Transactions Service
mvn -f transactions-service/pom.xml clean package -DskipTests
docker build -t transactions-service:1.0 -f transactions-service/Dockerfile transactions-service

## Aadhar Service
mvn -f aadhar-service/pom.xml clean package -DskipTests
docker build -t aadhar-service:1.0 -f aadhar-service/Dockerfile aadhar-service

## Company Service
mvn -f company-service/pom.xml clean package -DskipTests
docker build -t company-service:1.0 -f company-service/Dockerfile company-service

## Payment Gateway Service
mvn -f payment-gateway-service/pom.xml clean package -DskipTests
docker build -t payment-gateway-service:1.0 -f payment-gateway-service/Dockerfile payment-gateway-service