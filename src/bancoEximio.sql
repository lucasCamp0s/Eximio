create database Eximio;
use Eximio;

select * from pessoa;
describe pessoa;

create table arquivos(
	descricao varchar(30) not null,
    arquivo mediumblob not null,
    user_arquivo varchar(50),
    constraint user_arquivo foreign key (user_arquivo) references pessoa(email)
);