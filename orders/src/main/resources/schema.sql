create table if not exists order_item (
  id integer identity primary key,
  order_id integer,
  user_id varchar(255),
  order_date datetime,
  total_price float(2),
  status varchar(255)
);