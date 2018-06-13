# Credit card application

## Create database schema

```
create database credit_card_application;
create user 'creditcarduser'@'localhost' identified by 'creditcardpassword';
grant all on credit_card_application.* to 'creditcarduser'@'localhost';

SELECT * FROM credit_card_application.credit_cards;CREATE TABLE `credit_cards` (
  `id` bigint(20) NOT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `ccv` int(11) NOT NULL,
  `expiry_date` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
```

## Insert some credit cards

```
use credit_card_application;

insert into credit_cards(id, amount, ccv, expiry_date, first_name, last_name, number) 
values(1, 1000.0, 123, '2018/12/31', 'Adam', 'Nowak', '123456789');

insert into credit_cards(id, amount, ccv, expiry_date, first_name, last_name, number)
values(2, 1000.0, 123, '2018/12/31', 'Piotr', 'Kowalski', '987654321');

insert into credit_cards(id, amount, ccv, expiry_date, first_name, last_name, number)
values(3, 1000.0, 123, '2018/12/31', 'Adam', 'Kowalski', '111222333');

insert into credit_cards(id, amount, ccv, expiry_date, first_name, last_name, number)
values(4, 1000.0, 123, '2018/12/31', 'Piotr', 'Nowak', '444555666');
```

## Run application

```
mvnw spring-boot:run
```

Application should start using port 9090

## Test `/creditCards` endpoints

```
http://localhost:9090/creditCards
http://localhost:9090/creditCards/123456789
```

Note that exposing full credit card data is not secure ;-)

## Test `/chargeRequests` endpoint

```
POST http://localhost:9090/chargeRequests
Content-Type: application/json

{
  "creditCard": {
    "number": "123456789",
    "owner": "owner",
    "expiryDate": "1/2/3",
    "ccv": 200
  },
  "amount": "200"
}
```