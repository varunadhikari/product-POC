INSERT INTO USER VALUES
('varun', 'adhikari92', 'ADMIN');

INSERT INTO PRODUCT VALUES
(1, 'Okacet', 'Citrizine 10MG', 'CIPLA', 18.0, 500);

INSERT INTO ORDERS VALUES
(2, 'varun', TIMESTAMP '2021-08-29 18:26:23.518', 'ORDERED', 1890.0, 5.0);

INSERT INTO ORDER_DETAIL VALUES
(3, 2, 1, 100 ,1800.0);