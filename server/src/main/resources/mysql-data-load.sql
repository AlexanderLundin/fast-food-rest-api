DROP DATABASE orders_api;
CREATE DATABASE orders_api;
Use orders_api;
DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
    id    INTEGER AUTO_INCREMENT,
    customer_name VARCHAR(20) DEFAULT 'EMPTY',
    created_at     VARCHAR(50) DEFAULT 'EMPTY',
    status          VARCHAR(50) DEFAULT 'EMPTY',
    description       VARCHAR(200),
    note       VARCHAR(200),
    last_updated        VARCHAR(50),
    PRIMARY KEY (id)
);
INSERT INTO orders(customer_name, created_at, status, description, last_updated)
VALUES ('Master Yoda', '2019-11-06T15:15:30', 'PENDING' , 'Burger, double meat, extra pickles, doughnut buns, diet coke',
        '2011-12-03T10:15:30');
INSERT INTO orders(customer_name, created_at, status, description, last_updated)
VALUES ('Master Yoda1', '2019-11-06T15:15:30', 'PENDING' , 'Burger, double meat, extra pickles, doughnut buns, diet coke',
        '2011-12-03T10:15:30');
INSERT INTO orders(customer_name, created_at, status, description, last_updated)
VALUES ('Master Yoda2', '2019-11-06T15:15:30', 'PENDING' , 'Burger, double meat, extra pickles, doughnut buns, diet coke',
        '2011-12-03T10:15:30');
INSERT INTO orders(customer_name, created_at, status, description, last_updated)
VALUES ('Master Yoda3', '2019-11-06T15:15:30', 'PENDING' , 'Burger, double meat, extra pickles, doughnut buns, diet coke',
        '2011-12-03T10:15:30');
select *
from orders;
