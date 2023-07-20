``` Run docker compose
docker-compose up
```

``` Verify the Local Kafka Environment
docker ps
```

``` Postman producer

POST: http://localhost:8082/v1/coffee_orders
Header: Content-Type - application/json
Body: Raw 
{
  "id": "a27d9492-1402-48d6-9bf7-2c59c76e8a34",
  "name": "Ivo Vošahlík",
  "nickName": "",
  "store": {
    "storeId": 123,
    "address": {
      "addressLine1": "1234 street",
      "city": "1234 city",
      "state": "1234 state",
      "country": "1234 country",
      "zip": "1234 zip"
    }
  },
  "orderLineItems": [
    {
      "name": "Latte",
      "size": "MEDIUM",
      "quantity": 1,
      "cost": 3.99
    }
  ],
  "pickUp": "IN_STORE",
  "orderedTime": "2023-08-24T04:46:28",
  "status": "NEW"
}

PUT: http://localhost:8082/v1/coffee_orders
Header: Content-Type - application/json
Body: Raw 
{
  "id": 358,
  "status": "READY_FOR_PICK_UP"
}