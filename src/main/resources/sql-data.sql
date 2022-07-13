-- INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
use `ims`;
insert into `orders` (`orderId`, `fk_customerId`) values (1, 1);
insert into `items` (`title`, `price`) values ('Bungus', 7.45);
insert into `orderItems` (`fk_orderId`, `fk_itemId`, `quantity`) values (1, 1, 2);
