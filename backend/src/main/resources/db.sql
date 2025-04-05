CREATE SCHEMA CONTROLL;

CREATE TABLE IF NOT EXISTS CONTROLL.users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    status CHAR(1) NOT NULL DEFAULT 'A'
);

INSERT INTO CONTROLL.users (name, email, status) VALUES
('Leo Kenzley', 'leokenzley@gmail.com', 'A'),
('Liz Kenzley', 'lizkenzley@gmail.com', 'A');

CREATE TABLE IF NOT EXISTS CONTROLL.artists (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telephone VARCHAR(11) NOT NULL UNIQUE,
    status CHAR(1) NOT NULL DEFAULT 'A',
    imagelink VARCHAR,
    incorporate VARCHAR
);

INSERT INTO CONTROLL.artists (name, email, telephone, status) VALUES
('Chicote de Luxo', 'xicluxo@gmail.com', '61998554712', 'A'),
('Caneta Azul', 'caneazul@gmail.com', '78995412568','A');

CREATE TABLE IF NOT EXISTS CONTROLL.agenda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_commitment VARCHAR(50) NOT NULL,
    organizer_responsible VARCHAR(100) NOT NULL UNIQUE,
    telephone VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    status CHAR(1) NOT NULL DEFAULT 'A',
    artists_id BIGINT NOT NULL,
    FOREIGN KEY (artists_id) REFERENCES CONTROLL.artists(id)
);