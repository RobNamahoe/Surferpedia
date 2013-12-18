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

create table page_view (
  id                        bigint not null,
  surfer_id                 bigint,
  user_id                   bigint,
  constraint pk_page_view primary key (id))
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

create table updates (
  id                        bigint not null,
  user_id                   bigint,
  date                      varchar(255),
  action                    varchar(255),
  name                      varchar(255),
  slug                      varchar(255),
  constraint pk_updates primary key (id))
;

create table user_info (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  date_joined               varchar(255),
  admin                     boolean,
  constraint pk_user_info primary key (id))
;

create sequence country_seq;

create sequence gender_seq;

create sequence page_view_seq;

create sequence surfer_seq;

create sequence updates_seq;

create sequence user_info_seq;

alter table page_view add constraint fk_page_view_surfer_1 foreign key (surfer_id) references surfer (id) on delete restrict on update restrict;
create index ix_page_view_surfer_1 on page_view (surfer_id);
alter table page_view add constraint fk_page_view_user_2 foreign key (user_id) references user_info (id) on delete restrict on update restrict;
create index ix_page_view_user_2 on page_view (user_id);
alter table surfer add constraint fk_surfer_country_3 foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_surfer_country_3 on surfer (country_id);
alter table surfer add constraint fk_surfer_gender_4 foreign key (gender_id) references gender (id) on delete restrict on update restrict;
create index ix_surfer_gender_4 on surfer (gender_id);
alter table updates add constraint fk_updates_user_5 foreign key (user_id) references user_info (id) on delete restrict on update restrict;
create index ix_updates_user_5 on updates (user_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists country;

drop table if exists gender;

drop table if exists page_view;

drop table if exists surfer;

drop table if exists updates;

drop table if exists user_info;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists country_seq;

drop sequence if exists gender_seq;

drop sequence if exists page_view_seq;

drop sequence if exists surfer_seq;

drop sequence if exists updates_seq;

drop sequence if exists user_info_seq;

