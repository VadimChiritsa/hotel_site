-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bookinghotel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bookinghotel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookinghotel` DEFAULT CHARACTER SET utf8 ;
USE `bookinghotel` ;

-- -----------------------------------------------------
-- Table `bookinghotel`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookinghotel`.`user` (
  `login` VARCHAR(15) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`login`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bookinghotel`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookinghotel`.`admin` (
  `id_admin` INT(11) NOT NULL,
  `surname` VARCHAR(15) NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  `position` VARCHAR(15) NOT NULL,
  `login` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE INDEX `id_admin_UNIQUE` (`id_admin` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  CONSTRAINT `login`
    FOREIGN KEY (`login`)
    REFERENCES `bookinghotel`.`user` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bookinghotel`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookinghotel`.`client` (
  `id_client` INT(11) NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  `phone` INT(11) NOT NULL,
  `passport_number` VARCHAR(15) NOT NULL,
  `discount` INT(15) NULL DEFAULT NULL,
  `login` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE INDEX `id_client_UNIQUE` (`id_client` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  CONSTRAINT `loginClient`
    FOREIGN KEY (`login`)
    REFERENCES `bookinghotel`.`user` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bookinghotel`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookinghotel`.`order` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `number_of_seats` INT(11) NOT NULL,
  `type_of_apartment` VARCHAR(20) NOT NULL,
  `time_of_stay` INT(11) NOT NULL,
  `data_of_arrival` DATE NOT NULL,
  `id_client` INT(11) NOT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE INDEX `id_order_UNIQUE` (`id_order` ASC),
  INDEX `id_client_idx` (`id_client` ASC),
  CONSTRAINT `id_client`
    FOREIGN KEY (`id_client`)
    REFERENCES `bookinghotel`.`client` (`id_client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bookinghotel`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookinghotel`.`room` (
  `number` INT(11) NOT NULL,
  `type_of_apartment` VARCHAR(20) NOT NULL,
  `number_of_seats` INT(11) NOT NULL,
  `cost` INT(11) NOT NULL,
  `employment` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`number`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bookinghotel`.`residents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookinghotel`.`residents` (
  `id_resident` INT(15) NOT NULL AUTO_INCREMENT,
  `id_order` INT(15) NOT NULL,
  `number_of_room` INT(15) NOT NULL,
  `cost` INT(15) NOT NULL,
  PRIMARY KEY (`id_resident`),
  UNIQUE INDEX `id_resident_UNIQUE` (`id_resident` ASC),
  INDEX `id_order_idx` (`id_order` ASC),
  INDEX `number_of_room_idx` (`number_of_room` ASC),
  CONSTRAINT `id_order`
    FOREIGN KEY (`id_order`)
    REFERENCES `bookinghotel`.`order` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `number_of_room`
    FOREIGN KEY (`number_of_room`)
    REFERENCES `bookinghotel`.`room` (`number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
