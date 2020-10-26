# Microservice CQRS

Simple microservice project to demonstrate CQRS pattern with Spring Boot, Spring Data and RabbitMQ.

Uses in-memory database and RabbitMQ. On Cloud Foundry:

```
cf dev start -f Documents/pcfdev-v1.2.0-darwin.tgz -s rabbitmq
cf login -a https://api.dev.cfdev.sh --skip-ssl-validation
cf create-service p.rabbitmq single-node-3.7 rabbitmq-service
```

## Create Order

Path: `ordersystem.dev.cf-dev.sh`

Payload:
```json
{
    "userId": "user-1",
    "address": {
        "firstName": "Vorname",
        "lastName": "Nachname",
        "street": "Straße",
        "zip": "12345",
        "city": "Ort",
        "country": "Deutschland"
    },
    "products": [
        {
            "sku": "sku123",
            "title": "Product title",
            "description": "Product description",
            "price": 10.50
        }
    ]
}
```

```
curl -i \
    -H "Content-Type: application/json" \
    -X POST -d '{"userId": "user-1", "address": { "firstName": "Vorname", "lastName": "Nachname", "street": "Straße", "zip": "12345", "city": "Ort", "country": "Deutschland" }, "products": [ { "sku": "sku123", "title": "Product title", "description": "Product description", "price": 10.50 } ] }' \
    https://nlemberski-ordersystem.apps.pcfone.io/

```

## Check Orders

Path: `orders.dev.df-dev.sh/<userId>`

```
curl -i \
    -H "Accept: application/json" \
    -X GET \
    https://nlemberski-orders.apps.pcfone.io/user-1
```

## Monitor RabbitMQ

```
cf create-service-key rabbitmq-service rabbitmq-service-key
cf service-key rabbitmq-service-key rabbitmq-service-key
```