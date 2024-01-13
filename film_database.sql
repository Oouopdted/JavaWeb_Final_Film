drop database films;
create database if not exists films;
use films;
create table film(
	id int auto_increment primary key,
	name char(100),
	maker char(16),
	actor char(16),
	type char(16),
	region char(16),
	gene char(20)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
delete from film;
set names utf8;
insert into film values(1000,'肖申克的救赎','Frank Darabont','Liam Neeson','剧情片','美国','友谊');
insert into film values(null,'辛德勒的名单','Steven Spielberg','Tim Robbins','历史片','美国','历史');
insert into film values(null,'霸王别姬','陈凯歌','张国荣','艺术片','中国','艺术');
insert into film values(null,'阿甘正传','Robert Zemeckis','Tom Hanks','传记片','美国','喜剧');
insert into film values(null,'千与千寻','宫崎骏','荻原秀树','动画片','日本','奇幻');
insert into film values(null,'海上钢琴师','Giuseppe Tornatore','Tim Roth','剧情片','意大利','音乐');
insert into film values(null,'东邪西毒','王家卫','张国荣','武侠片','中国','爱情');
insert into film values(null,'醉拳','成龙','成龙','动作片','中国','喜剧');
insert into film values(null,'大话西游','刘镇伟','周星驰','喜剧片','中国','爱情');
insert into film values(null,'龙猫','宫崎骏','日高法子','动画片','日本','奇幻');
select * from film;

create table user(
	id int auto_increment primary key,
	name char(100),
	password char(100),
	member boolean
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
delete from user;
set names utf8;
insert into user values(2000,'admin','admin',1);
insert into user values(null,'tom','tom',0);
insert into user values(null,'jack','jack',1);
insert into user values(null,'viper','viper',0);
select * from user;

create table rank(
	id int auto_increment primary key,
	name char(100),
	temperature int,
	week int,
	month int,
	favor int
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
delete from rank;
set names utf8;
insert into rank values(1000,'肖申克的救赎',62,3120,13890,341);
insert into rank values(null,'辛德勒的名单',66,3324,12320,312);
insert into rank values(null,'霸王别姬',84,4298,17932,981);
insert into rank values(null,'阿甘正传',70,3510,15821,311);
insert into rank values(null,'千与千寻',87,4311,18311,408);
insert into rank values(null,'海上钢琴师',60,3047,12211,302);
insert into rank values(null,'东邪西毒',90,4520,17322,728);
insert into rank values(null,'醉拳',116,5831,21022,531);
insert into rank values(null,'大话西游',134,6701,25727,831);
insert into rank values(null,'龙猫',68,3433,13479,344);
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
select * from rank;
	