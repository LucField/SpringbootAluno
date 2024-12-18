-- V1__aluno.sql
CREATE TABLE aluno (
    matricula SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    data_nascimento VARCHAR(10),
    email VARCHAR(100),
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    curso VARCHAR(100),
    cpf VARCHAR(14)                       
);
