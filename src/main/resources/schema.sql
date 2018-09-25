create table inventory_item (
	product_code int primary key,
	size enum('S', 'M', 'L', 'XL', 'XXL') not null,	
	description varchar not null,
	count bigint not null
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