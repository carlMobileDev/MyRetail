# MyRetail

A Java Spring Boot webservice to help collect pricing data from Target's RedSky API.


### Architecture Stack
This project uses the following technologies:
* Java
* Spring Boot
* Mongo DB


### How it works
There are two ways to interact with the data in this webservice. 
1. Submit a GET request to the following endpoint
`localhost:8080/products/{productId}`
    Where the `productId` is one of a few configured id's.
    These include: 13860428, 54456119, 13264003, 12954218.
2. Submit a PUT request to the following endpoing
`localhost:8080/products/{productId}`
    Where the `productId` is one of a few configured id's.
    These include: 13860428, 54456119, 13264003, 12954218.
    AND including a payload describing the produce with updated pricing information.
    Here is a example of this PUT request using curl:
    `curl -i -X PUT -H 'Content-Type: application/json' -d '{"_id": 12954218, "currentPrice": {"value": 17.29, "currencyCode": "USD"}}' http://localhost:8080/products/12954218`

It is also backed by a local instance of MongoDB.
MongoDB needs to be setup prior in the following ways:

1. Create a "price" collection
2. Create four documents in this collection:
    `{ "_id": 13860428, "value": 4.29, "countryCode": "USD" }`
    `{ "_id": 54456119, "value": 6.29, "countryCode": "USD" }`
    `{ "_id": 13264003, "value": 3.59, "countryCode": "USD" }`
    `{ "_id": 12954218, "value": 5.99, "countryCode": "USD" }`


