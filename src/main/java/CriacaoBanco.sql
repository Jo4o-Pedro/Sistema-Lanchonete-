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
nome            varchar(20) not null,
descricao	varchar(50) not null,
categoria	varchar(20) not null ,
preco           numeric (6,2) not null,
informacao	varchar(50),
constraint pk_produto Primary key (id_produto) );

create table pedido(
id		serial,
id_usuario	integer,
dta_pedido	varchar(11),
status          varchar(1),
constraint pk_id_pedido	PRIMARY KEY (id),
constraint fk_id_cliente FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario));

create table carrinho(
id		serial,
id_pedido	integer,
id_produto	integer,
nome_prod       varchar(50),
qntd		integer,
constraint pk_id_carrinho PRIMARY KEY (id),
constraint fk_id_pedido FOREIGN KEY (id_pedido) REFERENCES pedido(id),
constraint fk_id_produto Foreign key (id_produto) references produto(id_produto));