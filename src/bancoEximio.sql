create database Eximio;
use Eximio;

select * from pessoa;
describe pessoa;
select * from arquivos;
create table arquivos(
	id int primary key auto_increment,
	descricao varchar(30) not null,
    arquivo mediumblob not null,
    user_arquivo varchar(50),
    constraint user_arquivo foreign key (user_arquivo) references pessoa(email)
);

drop table arquivos;

