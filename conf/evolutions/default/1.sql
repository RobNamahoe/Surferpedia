# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table country (
  id                        bigint not null,
  country                   varchar(255),
  constraint pk_country primary key (id))
;

create table gender (
  id                        bigint not null,
  gender                    varchar(255),
  constraint pk_gender primary key (id))
;

create table surfer (
  id                        bigint not null,
  country_id                bigint,
  gender_id                 bigint,
  bio                       clob,
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

create sequence country_seq;

create sequence gender_seq;

create sequence surfer_seq;

alter table surfer add constraint fk_surfer_country_1 foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_surfer_country_1 on surfer (country_id);
alter table surfer add constraint fk_surfer_gender_2 foreign key (gender_id) references gender (id) on delete restrict on update restrict;
create index ix_surfer_gender_2 on surfer (gender_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists country;

drop table if exists gender;

drop table if exists surfer;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists country_seq;

drop sequence if exists gender_seq;

drop sequence if exists surfer_seq;

