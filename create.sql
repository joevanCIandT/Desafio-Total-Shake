create table item_pedido (id bigint not null auto_increment, descricao varchar(255), quantidade integer, pedido_id bigint, primary key (id)) engine=InnoDB;
create table pedido (id bigint not null, data_hora datetime(6), status varchar(255), primary key (id)) engine=InnoDB;
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id);
create table item_pedido (id bigint not null auto_increment, descricao varchar(255), quantidade integer, pedido_id bigint, primary key (id)) engine=InnoDB;
create table pedido (id bigint not null, data_hora datetime(6), status varchar(255), primary key (id)) engine=InnoDB;
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido (id);
