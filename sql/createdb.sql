CREATE DATABASE IF NOT EXISTS writedb;
USE writedb;
CREATE TABLE IF NOT EXISTS user_write_model
(
    id                 varchar(100) PRIMARY KEY,
    first_name         varchar(100),
    last_name          varchar(100),
    credit_card_number varchar(100)
);

CREATE DATABASE IF NOT EXISTS readdb;

USE readdb;
CREATE TABLE IF NOT EXISTS user_read_model
(
    id         varchar(100) PRIMARY KEY,
    first_name varchar(100),
    last_name  varchar(100)
);