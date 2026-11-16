# E commerce backend Spring Boot

A REST API built with Spring Boot around 4 JPA entities, using PostgreSQL.

## Tech stack

- Java 16, built with Maven
- Spring Boot 2.5.5
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Spring Data REST
- Spring Boot Actuator
- Lombok
- PostgreSQL driver
- Database: PostgreSQL (`ecommercedb` in `application.properties`)

## Data model

| Entity | Fields |
|---|---|
| `Product` | id, label, price, endConsumeDate, fabricationDate, description, quantity, photo, customers, productProvider |
| `Customer` | id, firstName, lastName, type, products, customerAddress |
| `Provider` | id, name, email, telephone, siteUrl, products |
| `Address` | id, number, street, province, postalCode, customer |

## REST endpoints

Found in the controllers (`productController`, `customerController`):

| Method | Path |
|---|---|
| GET | `/products/all` |
| GET | `/products/get-product/{id}` |
| POST | `/products/add-product` |
| DELETE | `/products/remove-product/{id}` |
| PUT | `/products/update-product/{id}` |

## Project structure

- `tn.esb.bis.ecommercebackend`: ECommerceBackendApplication
- `tn.esb.bis.ecommercebackend.Controllers`: addressController, commandController, customerController, deliveryController, productController, providrContoller
- `tn.esb.bis.ecommercebackend.Domains`: Address, Command, Customer, Delivery, Product, Provider
- `tn.esb.bis.ecommercebackend.Enumerations`: CustomerType
- `tn.esb.bis.ecommercebackend.Repositories`: DeliveryRepository, addressRepository, commandRepository, customerRepository, productRepository, providerRepository
- `tn.esb.bis.ecommercebackend.Services`: CustomerService, ProductService
- Tests: 1 test class

## How to run

Requirements: a JDK 16+ and Maven (or the included Maven wrapper).
Create the `ecommercedb` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:8080`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
