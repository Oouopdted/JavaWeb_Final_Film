drop database if exists films;
create database films;
use films;
drop table if exists pic;
drop table if exists film;
create table film(
	id int auto_increment primary key,
	name char(100),
	maker char(32),
	actor char(32),
	type char(16),
	region char(16),
	gene char(16),
    thumbnail char(100) COMMENT '缩略图url',
    introduction text COMMENT '简介'
)collate = utf8mb4_general_ci;

create table pic
(
    id      int auto_increment,
    film_id int          not null comment '电影id',
    url     varchar(255) not null,
    constraint pics_pk
        primary key (id),
    constraint pics_film_null_fk
        foreign key (film_id) references film (id)
)collate = utf8mb4_general_ci;

create index pics_film_id_index
    on pic (film_id)
    comment '针对filmid建立索引';


set names utf8;
insert into film values(1000,'肖申克的救赎','Frank Darabont','Liam Neeson','剧情片','美国','友谊','https://img3.doubanio.com/view/photo/l/public/p480747492.webp','一场谋杀案使银行家安迪（蒂姆•罗宾斯 Tim Robbins 饰）蒙冤入狱，谋杀妻子及其情人的指控将囚禁他终生。在肖申克监狱的首次现身就让监狱“大哥”瑞德（摩根•弗里曼 Morgan Freeman 饰）对他另眼相看。瑞德帮助他搞到一把石锤和一幅女明星海报，两人渐成患难 之交。很快，安迪在监狱里大显其才，担当监狱图书管理员，并利用自己的金融知识帮助监狱官避税，引起了典狱长的注意，被招致麾下帮助典狱长洗黑钱。偶然一次，他得知一名新入狱的小偷能够作证帮他洗脱谋杀罪。燃起一丝希望的安迪找到了典狱长，希望他能帮自己翻案。阴险伪善的狱长假装答应安迪，背后却派人杀死小偷，让他唯一能合法出狱的希望泯灭。沮丧的安迪并没有绝望，在一个电闪雷鸣的风雨夜，一场暗藏几十年的越狱计划让他自我救赎，重获自由！老朋友瑞德在他的鼓舞和帮助下，也勇敢地奔向自由。
　　本片获得1995年奥斯卡10项提名，以及金球奖、土星奖等多项提名。');



insert into film values(null,'辛德勒的名单','Steven Spielberg','Tim Robbins','历史片','美国','历史','https://img3.doubanio.com/view/photo/l/public/p492406163.webp','1939年，波兰在纳粹德国的统治下，党卫军对犹太人进行了隔离统治。德国商人奥斯卡·辛德勒（连姆·尼森 Liam Neeson 饰）来到德军统治下的克拉科夫，开设了一间搪瓷厂，生产军需用品。凭着出众的社交能力和大量的金钱，辛德勒和德军建立了良好的关系，他的工厂雇用犹太人工作，大发战争财。
　　1943年，克拉科夫的犹太人遭到了惨绝人寰的大屠杀，辛德勒目睹这一切，受到了极大的震撼，他贿赂军官，让自己的工厂成为集中营的附属劳役营，在那些疯狂屠杀的日子里，他的工厂也成为了犹太人的避难所。
　　1944年，德国战败前夕，屠杀犹太人的行动越发疯狂，辛德勒向德军军官开出了1200人的名单，倾家荡产买下了这些犹太人的生命。在那些暗无天日的岁月里，拯救一个人，就是拯救全世界。');
insert into film values(null,'霸王别姬','陈凯歌','张国荣','艺术片','中国','艺术','https://img3.doubanio.com/view/photo/l/public/p2561716440.webp','1924年，程蝶衣（张国荣 饰）在京剧《霸王别姬》中饰演小旦，搭档同台演出的戏子段小楼（张丰毅 饰）饰演丑角，两人成为一对无法分隔的好朋友。尽管段小楼知道程蝶衣是个男人，但对他的爱慕之情日益加深。国共内战爆发，京城混乱，段小楼和程蝶衣分开逃亡，但两人始终保持联系。文革期间，程蝶衣被下放农村，段小楼也被迫害成为“反革命”，在狱中得知程蝶衣已经结婚生子。出狱后的段小楼在一家剧院当小工，偶然间结识了名叫菊仙（巩俐 饰）的女人，两人结婚后育有一女，小楼过着平静的生活。文革结束后，程蝶衣被平反出狱，但已身心俱疲，只想回家乡过平凡日子。小楼得知消息后，带着菊仙和女儿去看望程蝶衣，程蝶衣见到小楼的妻女，心中郁结终于释然。');
insert into film values(null,'阿甘正传','Robert Zemeckis','Tom Hanks','传记片','美国','喜剧','https://img3.doubanio.com/view/photo/l/public/p1484728154.webp','阿甘（汤姆·汉克斯 Tom Hanks 饰）有着一颗纯真而善良的心灵，他用自己的一生诠释了什么叫做“真正的强者”。阿甘一生都在等待一个女孩，这个女孩就是珍妮（罗宾·怀特 Robin Wright 饰），阿甘的这份痴情感动了上苍，最终在阿甘的人生中安排了珍妮的出现。阿甘的人生就此改变，他和珍妮一起长大，一起奔跑，一起经历了一切。阿甘天生傻气，但他却用自己的真诚打动了无数人，他成为了橄榄球巨星、越战英雄、乒乓球外交使者、亿万富翁，但最终他还是心心念念的珍妮的爱情。');
insert into film values(null,'千与千寻','宫崎骏','荻原秀树','动画片','日本','奇幻','https://img3.doubanio.com/view/photo/l/public/p2557573348.webp','小千（荻原秀树 配音）是一个顽皮淘气的10岁女孩，一次去看望亲戚，她和父母一起来到了乡下的一座废弃的神秘澡堂。父母贪婪地进入了澡堂内，小千却不愿意进去，她在澡堂外面等待，可是父母却怎么也出不来了。小千只好独自进入澡堂，她在里面遇到了一位叫做椿的神秘男孩，椿帮助小千找到了一家名叫“千寻”的餐馆，小千在餐馆里面遇到了一位叫做湫的男人，湫给了小千一块叫做“千寻”的食物，小千吃下食物后，她的身体变得透明，她的父母也变成了猪。原来，这个餐馆是一家专门招待神灵的餐馆，小千的父母贪吃，所以被餐馆的女老板娘变成了猪。小千为了救父母，决定留在餐馆里面工作，她的工作是帮助餐馆的厨师湫工作。');
insert into film values(null,'海上钢琴师','Giuseppe Tornatore','Tim Roth','剧情片','意大利','音乐','https://img3.doubanio.com/view/photo/l/public/p511146807.webp','本片讲述了一个钢琴天才传奇的一生。
　　1900年，Virginian号豪华邮轮上，一个孤儿被遗弃在头等舱，由船上的水手抚养长大，取名1900（蒂姆•罗斯 饰）。1900慢慢长大，显示出了无师自通的非凡钢琴天赋，在船上的乐队表演钢琴，每个听过他演奏的人，都被深深打动。爵士乐鼻祖杰尼听说了1900的高超技艺，专门上船和他比赛，最后自叹弗如，黯然离去。
　　可惜，这一切的事情都发生在海上，1900从来不愿踏上陆地，直到有一天，他爱上了一个女孩，情愫在琴键上流淌。他会不会为了爱情，踏上陆地开始新的生活，用他的琴声惊艳世界？他将怎样谱写自己非凡的人生。');
insert into film values(null,'东邪西毒','王家卫','张国荣','武侠片','中国','爱情','https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1982176012.webp','在恋人（张曼玉）负气嫁给兄长的当晚，欧阳锋（张国荣）黯然离开白陀山，走进沙漠某个小镇，成为一名杀手中介人。他的朋友、风流剑客黄药师（梁家辉）每年都来小镇与他畅饮，酒话里有关白陀山的消息令他忘却往事的念想渐次演变成自欺行为。
　　黄药师只是表面风流。他迷恋好友“盲武士”（梁朝伟）的妻子桃花（刘嘉玲），后者在丈夫死后，永远地离开了他；而对迷恋他的女人慕容嫣（林青霞），他又不愿兑现曾经随口说出的承诺，这使得慕容嫣迷失于自己的身份中。与欧阳锋构成短暂“买凶杀人”关系的洪七（张学友）、村姑（杨采妮）等人，也都有一段只有他们自己才知、不愿回首的痛苦过往。');
insert into film values(null,'醉拳','成龙','成龙','动作片','中国','喜剧','https://img1.doubanio.com/view/photo/s_ratio_poster/public/p1387691770.webp', '广东武术界名人黄麒英自儿子黄飞鸿（成龙）小时候起就严格训练其习武，可惜黄飞鸿少年时代年轻气盛，经常用三脚猫功夫在外惹事生非，武学上一直无大的长进。直到某次较量中被人打得落花流水且受到侮辱，黄飞鸿才发誓要拜苏乞儿（袁小田）为师好好习武。
　　由于苏乞儿懒于收徒，加上对黄飞鸿的人品很不信任，他开出了种种苛刻条件。为表决心，黄飞鸿一一应允并努力将它们全都实现，终以真心将苏乞儿打动，令其将醉拳传授给了他，黄飞鸿渐从一名莽撞的少年成长为一个见义勇为的年轻人。');
insert into film values(null,'大话西游','刘镇伟','周星驰','喜剧片','中国','爱情','https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2455050536.webp','至尊宝（周星驰 饰）被月光宝盒带回到五百年前，遇见紫霞仙子（朱茵 饰），被对方打上烙印成为对方的人，并发觉自己已变成孙悟空。
　　紫霞与青霞（朱茵 饰）本是如来佛祖座前日月神灯的灯芯（白天是紫霞，晚上是青霞），二人虽然同一肉身却仇恨颇深，因此紫霞立下誓言，谁能拔出她手中的紫青宝剑，谁就是她的意中人。紫青宝剑被至尊宝于不经意间拔出，紫霞决定以身相许，却遭一心记挂白晶晶（莫文蔚 饰）的至尊宝拒绝。后牛魔王救下迷失在沙漠中的紫霞，并逼紫霞与他成婚，关键时刻，至尊宝现身。');
insert into film values(null,'龙猫','宫崎骏','日高法子','动画片','日本','奇幻','https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2540924496.webp','小月的母亲生病住院了，父亲带着她与四岁的妹妹小梅到乡间的居住。她们对那里的环境都感到十分新奇，也发现了很多有趣的事情。她们遇到了很多小精灵，她们来到属于她们的环境中，看到了她们世界中很多的奇怪事物，更与一只大大胖胖的龙猫成为了朋友。龙猫与小精灵们利用他们的神奇力量，为小月与妹妹带来了很多神奇的景观，令她们大开眼界。
　　妹妹小梅常常挂念生病中的母亲，嚷着要姐姐带着她去看母亲，但小月拒绝了。小梅竟然自己前往，不料途中迷路了，小月只好寻找她的龙猫及小精灵朋友们帮助。');



drop table if exists user;
create table user(
	id int auto_increment primary key,
	name char(100),
	password char(100),
	member boolean
)collate = utf8mb4_general_ci;

set names utf8;
insert into user values(2000,'admin','admin',1);
insert into user values(null,'tom','tom',0);
insert into user values(null,'jack','jack',1);
insert into user values(null,'viper','viper',0);

drop table if exists film_rank;
create table film_rank(
	id int auto_increment primary key,
	name char(100),
	temperature int,
	week int,
	month int,
	favor int
)collate = utf8mb4_general_ci;


insert into film_rank values(1000,'肖申克的救赎',62,3120,13890,341);
insert into film_rank values(null,'辛德勒的名单',66,3324,12320,312);
insert into film_rank values(null,'霸王别姬',84,4298,17932,981);
insert into film_rank values(null,'阿甘正传',70,3510,15821,311);
insert into film_rank values(null,'千与千寻',87,4311,18311,408);
insert into film_rank values(null,'海上钢琴师',60,3047,12211,302);
insert into film_rank values(null,'东邪西毒',90,4520,17322,728);
insert into film_rank values(null,'醉拳',116,5831,21022,531);
insert into film_rank values(null,'大话西游',134,6701,25727,831);
insert into film_rank values(null,'龙猫',68,3433,13479,344);


	