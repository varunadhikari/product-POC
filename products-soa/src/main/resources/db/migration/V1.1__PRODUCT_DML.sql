INSERT INTO USER VALUES
('admin', 'admin', 'ADMIN'),
('abhishek', 'abhishek', 'DISTRIBUTOR'),
('ekansh', 'ekansh', 'DISTRIBUTOR');

INSERT INTO User_Detail VALUES
(991,'admin', 'Varun','Adhikari', null,null,null,null,null,null,'vadhikari@test.com'),
(992,'abhishek', 'Abhishek','Dhasmana', null,null,null,null,null,null,'adhasmana@test.com'),
(993,'ekansh', 'Ekansh','Jain', null,null,null,null,null,null,'ejain@test.com');

INSERT INTO PRODUCT VALUES
(991, 'Okacet', 'Citrizine 10MG', 'CIPLA', 18.0, 450),
(992, 'Crocin', 'Crocin Paracetamol 500MG', 'GSK', 20, 600),
(993, 'Pudin Hara', 'Pudin hara', 'Dabur', 22, 550),
(994, 'Betadine', 'Beyadine - POVIDONE IODINE-10%W/V', 'WIN-MEDICARE', 104.5, 500),
(995, 'Digene', 'Digene', 'CIPLA', 87.5, 200);

INSERT INTO ORDERS VALUES
(991, 'abhishek', TIMESTAMP '2021-08-29 18:26:23.518', 'ORDERED', 2546.0, 5.0),
(992, 'ekansh', TIMESTAMP '2021-08-29 18:26:23.518', 'ORDERED', 2023.5, 5.0);

INSERT INTO ORDER_DETAIL VALUES
(991, 991, 991, 50 ,900.0),
(992, 991, 992, 35 ,700.0),
(993, 991, 993, 10 ,220.0),
(994, 991, 994, 05 ,522.5),
(995, 992, 991, 50 ,900.0),
(996, 992, 992, 35 ,700.0),
(997, 992, 993, 10 ,220.0);