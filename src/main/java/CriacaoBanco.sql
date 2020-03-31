create table usuario(
	id_usuario serial,
	nome varchar(40) not null,
	email varchar(30) not null,
	senha varchar(30) not null,
	telefone int,
	constraint id_usuario primary key (id_usuario)
);