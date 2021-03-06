DROP TABLE IF EXISTS `animal` CASCADE;

CREATE TABLE `animal` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL, 
	`age` INTEGER, 
	`colour` VARCHAR(255) NOT NULL, 
	`is_cute` BOOLEAN,
	`image_url` VARCHAR(10000) NOT NULL
);