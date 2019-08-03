create database quest_in_jeju;
use quest_in_jeju;

create table quest_item (
  id bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(100) NOT NULL,
  quest_id bigint(20) UNSIGNED NOT NULL,
  latitude varchar(20) NOT NULL,
  longitude varchar(20) NOT NULL,
  description TEXT NOT NULL,
  addr varchar(100) NOT NULL
);
create table quest (
    id bigint unsigned auto_increment Primary key ,
    name varchar(24) not null ,
    item_count int not null
);
create table user (
	id bigint unsigned auto_increment primary key,
	email varchar(30) not null,
	name varchar(10) not null,
	password varchar(10) not null
);
create table post (
    id bigint unsigned not null auto_increment primary key,
    like_count int,
	contents text not null,
    date datetime not null,
	user_id bigint unsigned not null
);
create table comment (
    id bigint unsigned not null auto_increment primary key,
    contents varchar(300),
    date datetime not null,
    post_id bigint unsigned not null,
	user_id bigint unsigned not null
);
create table alias(
    id bigint unsigned auto_increment primary key ,
    name  varchar(15) not null
);
create table user_alias_have(
	user_id bigint unsigned NOT NULL,
    alias_id bigint unsigned NOT NULL
);
create table user_quest_play(
	user_id bigint unsigned NOT NULL,
    quest_id bigint unsigned NOT NULL
);

create table user_item_play(
	user_id bigint unsigned NOT NULL,
    item_id bigint unsigned NOT NULL,
    is_completed tinyint NOT NULL
);

create table user_post_like(
	user_id bigint unsigned NOT NULL,
    post_id bigint unsigned NOT NULL
);

create table quest_log(
	user_id bigint unsigned NOT NULL,
    quest_id bigint unsigned NOT NULL,
    item_id bigint unsigned NOT NULL
);

alter table quest_item ADD CONSTRAINT fk_quest_item_quest_num FOREIGN KEY(quest_id) REFERENCES quest(id);
alter table post ADD CONSTRAINT fk_post_user_id FOREIGN KEY(user_id) REFERENCES user(id);

alter table comment ADD CONSTRAINT fk_comment_user_id FOREIGN KEY(user_id) REFERENCES user(id);
alter table comment ADD CONSTRAINT fk_comment_post_id FOREIGN KEY(post_id) REFERENCES post(id);

alter table user_alias_have ADD CONSTRAINT fk_user_alias_have_user_id FOREIGN KEY(user_id) REFERENCES user(id);
alter table user_alias_have ADD CONSTRAINT fk_user_alias_have_alias_id FOREIGN KEY(alias_id) REFERENCES alias(id);
alter table user_alias_have ADD PRIMARY KEY(user_id,alias_id);

alter table user_quest_play ADD CONSTRAINT fk_user_quest_play_user_id FOREIGN KEY(user_id) REFERENCES user(id);
alter table user_quest_play ADD CONSTRAINT fk_user_quest_play_quest_id FOREIGN KEY(quest_id) REFERENCES quest(id);
alter table user_quest_play ADD PRIMARY KEY(user_id,quest_id);

alter table user_item_play ADD CONSTRAINT fk_user_item_play_user_id FOREIGN KEY(user_id) REFERENCES user(id);
alter table user_item_play ADD CONSTRAINT fk_user_item_play_item_id FOREIGN KEY(item_id) REFERENCES quest_item(id);
alter table user_item_play ADD PRIMARY KEY(user_id,item_id);

alter table user_post_like ADD CONSTRAINT fk_user_post_like_user_id FOREIGN KEY(user_id) REFERENCES user(id);
alter table user_post_like ADD CONSTRAINT fk_user_post_like_post_id FOREIGN KEY(post_id) REFERENCES post(id);
alter table user_post_like ADD PRIMARY KEY(user_id,post_id);

alter table quest_log ADD CONSTRAINT fk_quest_log_user_id FOREIGN KEY(user_id) REFERENCES user(id);
alter table quest_log ADD CONSTRAINT fk_quest_log_quest_id FOREIGN KEY(quest_id) REFERENCES quest(id);
alter table quest_log ADD CONSTRAINT fk_quest_log_item_id FOREIGN KEY(item_id) REFERENCES quest_item(id);
alter table quest_log ADD PRIMARY KEY(user_id,quest_id,item_id);