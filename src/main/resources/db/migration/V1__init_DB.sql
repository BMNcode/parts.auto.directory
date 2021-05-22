create sequence hibernate_sequence start 1 increment 1;

create table brand (
	id int8 not null, 
	brand_name varchar(255) not null, 
	primary key (id)
);

create table category (
	id int8 not null,
	name varchar(255) not null,
	primary key (id)
);

create table model (
	id int8 not null,
	model_name varchar(255) not null,
	brand_id int8,
	primary key (id)
);

create table part (
	id int8 not null, 
	article varchar(255) not null, 
	part_name varchar(255) not null, 
	category_id int8 not null, 
	model_id int8 not null, 
	primary key (id)
);

alter table if exists model 
	add constraint model_brand_fk
	foreign key (brand_id) references brand;
	
alter table if exists part
	add constraint part_category_fk
	foreign key (category_id) references category;
	
alter table if exists part
	add constraint part_model_fk
	foreign key (model_id) references model;