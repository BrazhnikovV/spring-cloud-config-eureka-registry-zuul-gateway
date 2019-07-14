create table account (id bigint not null auto_increment, created_at datetime(6), updated_at datetime(6), account_number varchar(13) not null, primary key (id)) engine=InnoDB;
create table account_addresses (account_id bigint not null, addresses_id bigint not null, primary key (account_id, addresses_id)) engine=InnoDB;
create table account_credit_cards (account_id bigint not null, credit_cards_id bigint not null, primary key (account_id, credit_cards_id)) engine=InnoDB;
create table address (id bigint not null auto_increment, created_at datetime(6), updated_at datetime(6), city varchar(64) not null, country varchar(64) not null, district varchar(64) not null, street1 varchar(64) not null, street2 varchar(64), zip_code varchar(8) not null, primary key (id)) engine=InnoDB;
create table credit_card (id bigint not null auto_increment, created_at datetime(6), updated_at datetime(6), number varchar(19) not null, type varchar(32) not null, primary key (id)) engine=InnoDB;
create table customer (id bigint not null auto_increment, created_at datetime(6), updated_at datetime(6), email varchar(64) not null, first_name varchar(64) not null, last_name varchar(64) not null, password varchar(64) not null, role varchar(32) not null, token varchar(64) not null, username varchar(64) not null, account_id bigint, primary key (id)) engine=InnoDB;

alter table account_addresses add constraint UK_r2ahplt2rqwvx1pnd5bbo7o70 unique (addresses_id);
alter table account_credit_cards add constraint UK_b0tk2gq9bk6cggk5c4d33g3y4 unique (credit_cards_id);
alter table account_addresses add constraint FK2lksxt4h2eauvgp1duv9gkh4u foreign key (addresses_id) references address (id);
alter table account_addresses add constraint FKk29q8n02ecu2edpjd40ge1xdy foreign key (account_id) references account (id);
alter table account_credit_cards add constraint FK9j2d59tomf2r8c7jee0xf73rx foreign key (credit_cards_id) references credit_card (id);
alter table account_credit_cards add constraint FKn1m8mpxful5qke3mggw7gt35v foreign key (account_id) references account (id);
alter table customer add constraint FKn9x2k8svpxj3r328iy1rpur83 foreign key (account_id) references account (id);
