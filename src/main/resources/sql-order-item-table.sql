-- CREATE VIEW chungus
-- as
-- select p.`orditeId`, i.`itemId`, i.`title`, i.`price`
-- from `ims`.`items` i
-- join `ims`.`orderItems` p on i.`itemId` = p.`fk_itemId`;

-- select * from chungus;

-- select o.`orderId`, p.`orditeId`, `itemId`, `title`, `price` from chungus c
-- join `ims`.`orders` o on o.`orderId` = p.`fk_orderId` ;
use `ims`;
SELECT p.`fk_itemId`, i.`title`, i.`price`, p.`quantity`, (p.`quantity` * i.`price`) as `totalPrice` from `items` i
	join `orderItems` p
		join `orders` o 
        on o.`orderId` = p.`fk_orderId`
	on i.`itemId` = p.`fk_itemId` where o.`orderId`;
    
Select o.`orderId`, o.`fk_customerId`, p.`fk_itemId`, i.`title`, i.`price`, p.`quantity`, (p.`quantity` * i.`price`) as `totalPrice` from `items` i
	join `orderItems` p
		join `orders` o
        on o.`orderId` = p.`fk_orderId`
	on i.`itemId` = p.`fk_itemId` order by o.`orderId`;
	

    select * from `orderItems`;
