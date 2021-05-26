CREATE DATABASE IF NOT EXISTS credit_service;
GRANT ALL ON 'credit_service'.* TO 'user'@'%';
GRANT ALL PRIVILEGES ON credit_service.* TO 'credit_service_user'@'%' IDENTIFIED BY 'credit_service_pwd';
GRANT ALL PRIVILEGES ON credit_service.* TO 'credit_service_user'@'localhost' IDENTIFIED BY 'credit_service_pwd';
USE credit_service;

CREATE DATABASE customer_service;
GRANT ALL PRIVILEGES ON customer_service.* TO 'customer_service_user'@'%' IDENTIFIED BY 'customer_service_pwd';
GRANT ALL PRIVILEGES ON customer_service.* TO 'customer_service_user'@'localhost' IDENTIFIED BY 'customer_service_pwd';
USE customer_service;

CREATE DATABASE product_service;
GRANT ALL PRIVILEGES ON product_service.* TO 'product_service_user'@'%' IDENTIFIED BY 'product_service_pwd';
GRANT ALL PRIVILEGES ON product_service.* TO 'product_service_user'@'localhost' IDENTIFIED BY 'product_service_pwd';
USE product_service;