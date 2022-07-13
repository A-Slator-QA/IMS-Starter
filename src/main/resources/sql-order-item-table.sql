-- CREATE VIEW chungus
-- as
-- select p.`orditeId`, i.`itemId`, i.`title`, i.`price`
-- from `ims`.`items` i
-- join `ims`.`orderItems` p on i.`itemId` = p.`fk_itemId`;

-- select * from chungus;

-- select o.`orderId`, p.`orditeId`, `itemId`, `title`, `price` from chungus c
-- join `ims`.`orders` o on o.`orderId` = p.`fk_orderId` ;

SELECT o.`orderId`, p.`orditeId`, i.`itemId`, i.`title`, i.`price`, (p.`quantity` * i.`price`) as `totalPrice` from `ims`.`items` i
	join `ims`.`orderItems` p
		join `ims`.orders o 
        on o.`orderId` = p.`fk_orderId`
	on i.`itemId` = p.`fk_itemId`;
