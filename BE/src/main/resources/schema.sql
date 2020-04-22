drop table if exists menu;
drop table if exists item;
drop table if exists thumb_image;
drop table if exists detail_section;
drop table if exists badge;
drop table if exists delivery;

show tables;

create table if not exists menu
(
    id   int not null auto_increment primary key,
    name varchar(45)
);

create table if not exists item
(
    id                  int not null auto_increment primary key,
    image               varchar(1000),
    title               varchar(500),
    n_price             varchar(50),
    s_price             varchar(50),
    alt                 varchar(100),
    description         varchar(1000),
    top_image           varchar(100),
    product_description varchar(100),
    point               varchar(100),
    delivery_info       varchar(100),
    delivery_fee        varchar(100),
    menu                int references menu (id),
    menu_key            int
);

create table if not exists thumb_image
(
    id         int not null auto_increment primary key,
    url        varchar(100),
    item        int references item (id),
    item_key int
);

create table if not exists detail_section
(
    id         int not null auto_increment primary key,
    url        varchar(100),
    item       int references item (id),
    item_key int
);

create table if not exists badge
(
    id       int not null auto_increment primary key,
    name     varchar(45),
    item     int references item (id),
    item_key int
);

create table if not exists delivery
(
    id       int not null auto_increment primary key,
    type     varchar(45),
    item     int references item (id),
    item_key int
);


