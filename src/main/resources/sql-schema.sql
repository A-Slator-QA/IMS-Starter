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
`price` double NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`customer_id` int(11) NOT NULL,
`item_id_1` int(11) NOT NULL,
`total_cost` double NOT NULL,
PRIMARY KEY (`id`),
Foreign key (`customer_id`) references `ims`.`customers`(`id`)
);