drop database if exists spring08;
create database spring08;
use spring08;
set sql_safe_updates = 0; -- mysql workbench : safeMode 해제(끄기 0 / 켜기 1)

create table mvc(
   var1 varchar(30)
);

insert into mvc values("유재석"),("강호동"),("신동엽");