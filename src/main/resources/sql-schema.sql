drop schema `ims`;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customerId` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`customerId`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
`itemId` INT(11) NOT NULL AUTO_INCREMENT,
`title` varchar (20) NOT NULL,
`price` double NOT NULL,
PRIMARY KEY (`itemId`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
`orderId` int(11) NOT NULL AUTO_INCREMENT,
`fk_customerId` int(11) NOT NULL,
PRIMARY KEY (`orderId`),
Foreign key (`fk_customerId`) references `ims`.`customers`(`customerId`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orderItems` (
`orditeId` int(11) NOT NULL AUTO_INCREMENT,
`fk_orderId` int(11) NOT NULL,
`fk_itemId` int(11) not null,
`quantity` int(11) not null,
PRIMARY KEY (`orditeId`),
FOREIGN KEY (`fk_orderId`) references `ims`.`orders`(`orderId`),
FOREIGN KEY (`fk_itemId`) references `ims`.`items`(`itemId`)
);


