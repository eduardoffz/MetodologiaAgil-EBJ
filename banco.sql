-- ============================================================
-- SCRIPT SQL - Sistema de Patrimônio SENAI
-- Execute este script no MySQL antes de rodar o projeto.
-- ============================================================

-- 1. Criar e selecionar o banco
CREATE DATABASE IF NOT EXISTS patrimonio_senai;
USE patrimonio_senai;

-- 2. Tabela de Departamentos
CREATE TABLE IF NOT EXISTS departamento (
    id    INT PRIMARY KEY AUTO_INCREMENT,
    nome  VARCHAR(100) NOT NULL,
    andar INT NOT NULL
);

-- 3. Tabela de Equipamentos (com FK para departamento)
CREATE TABLE IF NOT EXISTS equipamento (
    id                 INT PRIMARY KEY AUTO_INCREMENT,
    codigo_patrimonio  VARCHAR(50) NOT NULL UNIQUE,
    tipo               VARCHAR(50) NOT NULL,
    marca              VARCHAR(50) NOT NULL,
    id_departamento    INT NOT NULL,
    FOREIGN KEY (id_departamento) REFERENCES departamento(id)
);

-- ============================================================
-- 4. Dados de exemplo para testes
-- ============================================================
INSERT INTO departamento (nome, andar) VALUES
    ('Tecnologia da Informação', 3),
    ('Financeiro', 2),
    ('Marketing', 1),
    ('Recursos Humanos', 2);

INSERT INTO equipamento (codigo_patrimonio, tipo, marca, id_departamento) VALUES
    ('PAT-1001', 'Notebook',  'Dell',    1),
    ('PAT-1002', 'Monitor',   'LG',      1),
    ('PAT-1003', 'Notebook',  'Lenovo',  1),
    ('PAT-2001', 'Impressora','HP',      2),
    ('PAT-2002', 'Notebook',  'Dell',    2),
    ('PAT-3001', 'Desktop',   'Positivo',3),
    ('PAT-3002', 'Monitor',   'Samsung', 3),
    ('PAT-3003', 'Notebook',  'Asus',    3),
    ('PAT-3004', 'Tablet',    'iPad',    3),
    ('PAT-4001', 'Notebook',  'Dell',    4);
-- ============================================================
