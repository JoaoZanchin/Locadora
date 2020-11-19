CREATE DATABASE locadora;
USE locadora;


CREATE TABLE filme (
	idFilme int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	titulo varchar(50),
	tempo int,
	imagem3d tinyint,
	dublado tinyint,
	sinopse varchar(500),
	categoria varchar(20)
);

CREATE TABLE cliente (
	idCliente int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome varchar(50),
	endereco varchar(500),
	sexo tinyint,
	idade int,
) ;
