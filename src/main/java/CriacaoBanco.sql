create table usuario(
	id_usuario serial,
	nome varchar(40) not null,
	email varchar(30) not null,
	senha varchar(30) not null,
	telefone int,
	constraint id_usuario primary key (id_usuario)
);

create table produto(
id_produto serial not null,
nome	varchar(20) not null,
descricao	varchar(50) not null,
categoria	varchar(20) not null ,
preco	numeric (6,2) not null,
informacao	varchar(50),
constraint pk_produto Primary key (id_produto) );