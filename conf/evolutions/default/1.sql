# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table country (
  id                        bigint auto_increment not null,
  country                   varchar(255),
  constraint pk_country primary key (id))
;

create table gender (
  id                        bigint auto_increment not null,
  gender                    varchar(255),
  constraint pk_gender primary key (id))
;

create table surfer (
  id                        bigint auto_increment not null,
  country_id                bigint,
  gender_id                 bigint,
  bio                       longtext,
  name                      varchar(255),
  home                      varchar(255),
  awards                    varchar(255),
  carousel_url              varchar(255),
  bio_url                   varchar(255),
  slug                      varchar(255),
  status                    varchar(255),
  foot_style                varchar(255),
  constraint pk_surfer primary key (id))
;

create table updates (
  id                        bigint auto_increment not null,
  date                      varchar(255),
  action                    varchar(255),
  name                      varchar(255),
  constraint pk_updates primary key (id))
;

alter table surfer add constraint fk_surfer_country_1 foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_surfer_country_1 on surfer (country_id);
alter table surfer add constraint fk_surfer_gender_2 foreign key (gender_id) references gender (id) on delete restrict on update restrict;
create index ix_surfer_gender_2 on surfer (gender_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table country;

drop table gender;

drop table surfer;

drop table updates;

SET FOREIGN_KEY_CHECKS=1;

