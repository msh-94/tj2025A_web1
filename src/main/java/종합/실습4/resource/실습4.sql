DROP DATABASE IF EXISTS 실습4;
CREATE DATABASE 실습4;
USE 실습4;

create table wait(
	wno int auto_increment primary key,
    phone varchar(13) ,
    count int ,
    wdate date default (current_date())
);

select * from wait;