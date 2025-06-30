create table produtos (
    id varchar(255) not null primary key,
    nome varchar(255) not null,
    descricao varchar(255) not null,
    preco decimal(10,2) not null,
);