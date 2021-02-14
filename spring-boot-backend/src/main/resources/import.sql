INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Achraf', 'Arazzouk', 'achraf@gmail.com', '2017-08-01');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('John', 'Doe', 'john.doe@gmail.com', '2017-08-02');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2017-08-03');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Jane', 'Doe', 'jane.doe@gmail.com', '2017-08-04');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2017-08-05');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2017-08-06');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2017-08-07');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2017-08-08');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2017-08-09');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('James', 'Gosling', 'james.gosling@gmail.com', '2017-08-010');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Bruce', 'Lee', 'bruce.lee@gmail.com', '2017-08-11');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Johnny', 'Doe', 'johnny.doe@gmail.com', '2017-08-12');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('John', 'Roe', 'john.roe@gmail.com', '2017-08-13');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Jane', 'Roe', 'jane.roe@gmail.com', '2017-08-14');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Richard', 'Doe', 'richard.doe@gmail.com', '2017-08-15');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Janie', 'Doe', 'janie.doe@gmail.com', '2017-08-16');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Phillip', 'Webb', 'phillip.webb@gmail.com', '2017-08-17');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Stephane', 'Nicoll', 'stephane.nicoll@gmail.com', '2017-08-18');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Sam', 'Brannen', 'sam.brannen@gmail.com', '2017-08-19');  
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Juergen', 'Hoeller', 'juergen.Hoeller@gmail.com', '2017-08-20'); 
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Janie', 'Roe', 'janie.roe@gmail.com', '2017-08-21');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('John', 'Smith', 'john.smith@gmail.com', '2017-08-22');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Joe', 'Bloggs', 'joe.bloggs@gmail.com', '2017-08-23');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('John', 'Stiles', 'john.stiles@gmail.com', '2017-08-24');
INSERT INTO clientes (nombre, apellido, email, create_at ) VALUES('Richard', 'Roe', 'stiles.roe@gmail.com', '2017-08-25');

/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled, email) VALUES ('achraf','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1,'achraf@gmail.com');
INSERT INTO `users` (username, password, enabled, email) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1,'admin@gmail.com');

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
