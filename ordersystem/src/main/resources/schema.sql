create table if not exists order_item (
  id integer identity primary key,
  user_id varchar(255),
  first_name varchar(255),
  last_name varchar(255),
  street varchar(255),
  zip varchar(255),
  city varchar(255),
  country varchar(255),
  created_date datetime
);

create table if not exists product_item (
  id integer identity primary key,
  sku varchar(100),
  title varchar(255),
  description varchar(255),
  price float(2),
  order_item integer
);