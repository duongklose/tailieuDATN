CREATE TABLE `users` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`username` varchar(200) UNIQUE,
	`password` varchar(500),
	`name` varchar(255) NOT NULL,
	`phone` varchar(15) NOT NULL UNIQUE,
	`email` varchar(255) UNIQUE,
	`role` INT(5) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `coaches` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`num_of_seats` INT(20) NOT NULL,
	`license_plate` varchar(100) NOT NULL UNIQUE,
	`description` varchar(500),
	`type` INT(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `coach_type` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tickets` (
	`user_id` INT(20) NOT NULL,
	`coach_id` INT(20) NOT NULL,
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`book_date` DATETIME NOT NULL,
	`state` varchar(255) NOT NULL DEFAULT 'BOOKED',
	`start_location` INT(20) NOT NULL,
	`end_location` INT(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `seats` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(5) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `coach_seat` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`coach_id` INT(20) NOT NULL,
	`seat_id` INT(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `locations` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	`address` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `payment` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`ticket_id` INT(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `cash_payment` (
	`id` BINARY NOT NULL AUTO_INCREMENT,
	`ticket_id` BINARY NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `internet_banking` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`user_id` INT(20) NOT NULL,
	`account` varchar(255) NOT NULL UNIQUE,
	`bank` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `internet_banking_payment` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`internet_banking_id` INT(20) NOT NULL,
	`payment_id` INT(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `seat_ticket` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`ticket_id` INT(20) NOT NULL,
	`seat_id` INT(20) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `coaches` ADD CONSTRAINT `coaches_fk0` FOREIGN KEY (`type`) REFERENCES `coach_type`(`id`);

ALTER TABLE `tickets` ADD CONSTRAINT `tickets_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `tickets` ADD CONSTRAINT `tickets_fk1` FOREIGN KEY (`coach_id`) REFERENCES `coaches`(`id`);

ALTER TABLE `tickets` ADD CONSTRAINT `tickets_fk2` FOREIGN KEY (`start_location`) REFERENCES `locations`(`id`);

ALTER TABLE `tickets` ADD CONSTRAINT `tickets_fk3` FOREIGN KEY (`end_location`) REFERENCES `locations`(`id`);

ALTER TABLE `coach_seat` ADD CONSTRAINT `coach_seat_fk0` FOREIGN KEY (`coach_id`) REFERENCES `coaches`(`id`);

ALTER TABLE `coach_seat` ADD CONSTRAINT `coach_seat_fk1` FOREIGN KEY (`seat_id`) REFERENCES `seats`(`id`);

ALTER TABLE `payment` ADD CONSTRAINT `payment_fk0` FOREIGN KEY (`ticket_id`) REFERENCES `tickets`(`id`);

ALTER TABLE `cash_payment` ADD CONSTRAINT `cash_payment_fk0` FOREIGN KEY (`ticket_id`) REFERENCES `tickets`(`id`);

ALTER TABLE `internet_banking` ADD CONSTRAINT `internet_banking_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `internet_banking_payment` ADD CONSTRAINT `internet_banking_payment_fk0` FOREIGN KEY (`internet_banking_id`) REFERENCES `internet_banking`(`id`);

ALTER TABLE `internet_banking_payment` ADD CONSTRAINT `internet_banking_payment_fk1` FOREIGN KEY (`payment_id`) REFERENCES `payment`(`id`);

ALTER TABLE `seat_ticket` ADD CONSTRAINT `seat_ticket_fk0` FOREIGN KEY (`ticket_id`) REFERENCES `tickets`(`id`);

ALTER TABLE `seat_ticket` ADD CONSTRAINT `seat_ticket_fk1` FOREIGN KEY (`seat_id`) REFERENCES `seats`(`id`);

