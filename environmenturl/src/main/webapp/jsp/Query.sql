--Original Tomcat Data Table
CREATE TABLE `environmenturl_db`.`tomcat_data` (
  `tomcat_id` INT(5) NOT NULL AUTO_INCREMENT,
  `tomcat_name` VARCHAR(45) NOT NULL,
  `tomcat_port` VARCHAR(5) NOT NULL,
  `environment_name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`tomcat_id`));
  
-- Back Up table for Tomcat Data
CREATE TABLE `environmenturl_db`.`tomcat_data_bkp` (
  `tomcat_id` INT(5) NOT NULL AUTO_INCREMENT,
  `tomcat_name` VARCHAR(45) NOT NULL,
  `tomcat_port` VARCHAR(5) NOT NULL,
  `environment_name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`tomcat_id`));

-- Stored Procedure
DELIMITER $$
CREATE PROCEDURE `fetchAllTomcats` (in portNumber INT(5))
BEGIN
	select * from tomcat_data where tomcat_port = portNumber;
END

-- Trigger to insert record in back up Tomcat Table
USE `environmenturl_db`;
DELIMITER $$
DROP TRIGGER IF EXISTS environmenturl_db.tomcat_data_AINS$$
USE `environmenturl_db`$$
CREATE TRIGGER `tomcat_data_AINS` AFTER INSERT ON `tomcat_data` FOR EACH ROW
INSERT INTO tomcat_data_bkp SELECT * FROM tomcat_data WHERE tomcat_id=(select max(tomcat_id) from tomcat_data);$$
DELIMITER ;

--Original URL Table
CREATE TABLE `environmenturl_db`.`url_data` (
  `url_id` INT(5) NOT NULL AUTO_INCREMENT,
  `environment_name` VARCHAR(45) NOT NULL,
  `project_name` VARCHAR(45) NOT NULL,
  `module_name` VARCHAR(45) NOT NULL,
  `module_link` VARCHAR(130) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`url_id`));
  
-- Back Up table for URL Data
CREATE TABLE `environmenturl_db`.`url_data_bkp` (
  `url_id` INT(5) NOT NULL AUTO_INCREMENT,
  `environment_name` VARCHAR(45) NOT NULL,
  `project_name` VARCHAR(45) NOT NULL,
  `module_name` VARCHAR(45) NOT NULL,
  `module_link` VARCHAR(130) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`url_id`));

 
-- Trigger to insert record in back up URL Table
USE `environmenturl_db`;
DELIMITER $$
DROP TRIGGER IF EXISTS environmenturl_db.url_data_AINS$$
USE `environmenturl_db`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `url_data_AINS` AFTER INSERT ON `url_data` FOR EACH ROW
INSERT INTO url_data_bkp SELECT * FROM url_data WHERE url_id=(select max(url_id) from url_data)$$
DELIMITER ;

--Original DB Credential Table
CREATE TABLE `environmenturl_db`.`database_credentials` (
  `database_id` INT(11) NOT NULL AUTO_INCREMENT,
  `database_name` VARCHAR(45) NOT NULL,
  `database_ip` VARCHAR(45) NOT NULL,
  `database_username` VARCHAR(45) NOT NULL,
  `database_password` VARCHAR(45) NOT NULL,
  `application_name` VARCHAR(45) NULL,
  PRIMARY KEY (`database_id`));
  
-- Database Credential Table
CREATE TABLE `environmenturl_db`.`database_credentials_bkp` (
  `database_id` INT(11) NOT NULL AUTO_INCREMENT,
  `database_name` VARCHAR(45) NOT NULL,
  `database_ip` VARCHAR(45) NOT NULL,
  `database_username` VARCHAR(45) NOT NULL,
  `database_password` VARCHAR(45) NOT NULL,
  `application_name` VARCHAR(45) NULL,
  PRIMARY KEY (`database_id`));


-- Trigger for back up of Database Credential Table
USE `environmenturl_db`;
DELIMITER $$
DROP TRIGGER IF EXISTS environmenturl_db.database_credentials_AINS$$
USE `environmenturl_db`$$
CREATE TRIGGER `database_credentials_AINS` AFTER INSERT ON `database_credentials` FOR EACH ROW
INSERT INTO database_credentials_bkp SELECT * FROM database_credentials WHERE database_id=(select max(database_id) from database_credentials)$$
DELIMITER ;

-- Static Data Maintenance
CREATE TABLE `environmenturl_db`.`config_data` (
  `data_id` INT(11) NOT NULL AUTO_INCREMENT,
  `data_type` VARCHAR(45) NOT NULL,
  `data_value` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`data_id`));

-- Static Data Maintenance
CREATE TABLE `environmenturl_db`.`config_data_bkp` (
  `data_id` INT(11) NOT NULL AUTO_INCREMENT,
  `data_type` VARCHAR(45) NOT NULL,
  `data_value` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`data_id`));

-- trigger for Config Data
USE `environmenturl_db`;
DELIMITER $$
DROP TRIGGER IF EXISTS environmenturl_db.config_data_AINS$$
USE `environmenturl_db`$$
CREATE TRIGGER `config_data_AINS` AFTER INSERT ON `config_data` FOR EACH ROW
INSERT INTO config_data_bkp SELECT * FROM config_data WHERE data_id=(select max(data_id) from config_data)$$
DELIMITER ;