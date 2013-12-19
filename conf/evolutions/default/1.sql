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

create table page_view (
  id                        bigint auto_increment not null,
  surfer_id                 bigint,
  user_id                   bigint,
  constraint pk_page_view primary key (id))
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

create table surfer_update (
  id                        bigint auto_increment not null,
  user_id                   bigint,
  date                      varchar(255),
  action                    varchar(255),
  name                      varchar(255),
  slug                      varchar(255),
  constraint pk_surfer_update primary key (id))
;

create table user_info (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  date_joined               varchar(255),
  admin                     tinyint(1) default 0,
  constraint pk_user_info primary key (id))
;

alter table page_view add constraint fk_page_view_surfer_1 foreign key (surfer_id) references surfer (id) on delete restrict on update restrict;
create index ix_page_view_surfer_1 on page_view (surfer_id);
alter table page_view add constraint fk_page_view_user_2 foreign key (user_id) references user_info (id) on delete restrict on update restrict;
create index ix_page_view_user_2 on page_view (user_id);
alter table surfer add constraint fk_surfer_country_3 foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_surfer_country_3 on surfer (country_id);
alter table surfer add constraint fk_surfer_gender_4 foreign key (gender_id) references gender (id) on delete restrict on update restrict;
create index ix_surfer_gender_4 on surfer (gender_id);
alter table surfer_update add constraint fk_surfer_update_user_5 foreign key (user_id) references user_info (id) on delete restrict on update restrict;
create index ix_surfer_update_user_5 on surfer_update (user_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table country;

drop table gender;

drop table page_view;

drop table surfer;

drop table surfer_update;

drop table user_info;

SET FOREIGN_KEY_CHECKS=1;

