create table inventory_item (
    product_code int primary key,
    size enum('S', 'M', 'L', 'XL', 'XXL') not null,    
    description varchar not null,
    count bigint not null
);
create table customer (
    customerId int auto_increment primary key,
    name varchar(20),
    email varchar(20),
    address varchar(20),
    neighborhood varchar(20),
    city varchar(20),
    state_or_province varchar(20),
    postalCode varchar(10),
    country varchar(20),
    company varchar(20),
    title varchar(20),
    phone varchar(15)
);
create table card (
	cardId int auto_increment primary key,
	card varchar(20),
	flag varchar(20),
	dueDate varchar(20)
);


create table tshirt_order (    
    order_id bigint auto_increment primary key,
    product_code int not null,
    size enum('S', 'M', 'L', 'XL', 'XXL') not null,
    email varchar not null,
    name varchar not null,
    address1 varchar not null,
    address2 varchar,
    city varchar not null,
    state_or_province varchar not null,
    postal_code varchar not null,
    country varchar not null,
    status enum ('WAITING_CARRIER', 'IN_TRANSIT', 'DELIVERED') not null
);


create unique index unique_order on tshirt_order (product_code, size, email);