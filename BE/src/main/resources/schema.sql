create table if not exists menu
(
    id int not null auto_increment,
    primary key (id)
);

create table if not exists category (
    id int not null auto_increment,
    name varchar(100),
    primary key (id)
);

create table if not exists item  (
    id int not null auto_increment primary key ,
    image varchar(1000),
    title varchar(500),
    n_price int,
    menu int references menu(id),
    category int references category(id)
);

create table if not exists detail (
    id int not null auto_increment primary key,
    top_image varchar (100),
    product_description varchar (100),
    point varchar (100),
    delivery_info varchar (100),
    delivery_fee varchar (100),
    prices varchar (100)
);

create table if not exists thumb_image (
    id int not null auto_increment primary key,
    url varchar (100),
    detail int references detail(id)
);

create table if not exists detail_section (
    id int not null auto_increment primary key,
    url varchar (100),
    detail int references detail(id)
);
