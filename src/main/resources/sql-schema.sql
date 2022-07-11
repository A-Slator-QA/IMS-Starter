CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`title` varchar (20) NOT NULL,
`price` float NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`customer-id` int(11) NOT NULL,
`product-id-1` int(11) NOT NULL,
`total-cost` float NOT NULL,
PRIMARY KEY (`id`),
Foreign key (`customer-id`) references `ims`.`customers`(`id`)
);