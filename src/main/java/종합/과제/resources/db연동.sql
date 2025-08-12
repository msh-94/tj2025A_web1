drop database if exists waiting;
create database waiting;
use waiting;
set SQL_SAFE_UPDATES = 0;

create table Waiting(
	wno int auto_increment,
	phone varchar(13) not null,
    count int not null ,
    addDate datetime default now(),
    constraint primary key(wno)
);

insert into waiting(phone,count) values('010-1111-1111',1);
insert into waiting(phone,count) values('010-2222-2222',2);
insert into waiting(phone,count) values('010-3333-3333',3);
insert into waiting(phone,count) values('010-4444-4444',4);
insert into waiting(phone,count) values('010-5555-5555',5);

select * from waiting;