
CREATE TABLE IF NOT EXISTS `person` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(80) NOT NULL,
    `surname` varchar(80) NOT NULL,
    `address` varchar(80) NOT NULL,
    `gender` varchar(6) NOT NULL,
    PRIMARY KEY (`id`)
);


