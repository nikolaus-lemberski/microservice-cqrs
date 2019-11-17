# Microservice CQRS

Simple microservice project to demonstrate CQRS pattern with Spring Boot, Spring Data and RabbitMQ.

Needs SQL Database and RabbitMQ. On Cloud Foundry:

`cf create-service p.rabbitmq single-node-3.7 rabbitmq-service
cf create-service p.mysql db-small ordersystem-db
cf create-service p.mysql db-small orders-db`

## Create order

## Get orders