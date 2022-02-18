-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
use mydb;
-- -----------------------------------------------------
-- Table `mydb`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Items` (
  `id` INT NOT NULL,
  `item_name` VARCHAR(45) NOT NULL,
  `count` INT NOT NULL,
  `exp_date` DATE NULL,
  `department_id` INT NOT NULL,
  `vegan` TINYINT NULL,
  `age_restricted` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`managers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`managers` (
  `manager_id` INT NOT NULL,
  `employee_id` INT NOT NULL,
  PRIMARY KEY (`manager_id`),
  UNIQUE INDEX `manager_id_UNIQUE` (`manager_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Dairy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Dairy` (
  `id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  `employee_count` INT NOT NULL,
  `last_inspection` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `manager_id_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `manager_id_fk`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Frozen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Frozen` (
  `id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  `employee_count` INT NOT NULL,
  `last_inspection` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `manager_id_fk_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `manager_id_fk_Frozen`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Meat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Meat` (
  `id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  `employee_count` INT NOT NULL,
  `last_inspection` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `manager_id_fk_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `manager_id_fk_meat`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Seafood`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Seafood` (
  `id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  `employee_count` INT NOT NULL,
  `last_inspection` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `manager_id_fk_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `manager_id_fk_seafood`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Deli`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Deli` (
  `id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  `employee_count` INT NOT NULL,
  `last_inspection` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `manger_id_fk_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `manger_id_fk_deli`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produce`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produce` (
  `id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  `employee_count` INT NOT NULL,
  `last_inspection` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `manager_id_fk_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `manager_id_fk_produce`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Liquor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Liquor` (
  `id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  `employee_count` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `manager_id_fk_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `manager_id_fk_liquor`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Grocery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Grocery` (
  `id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  `employee_count` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `manager_id_fk_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `manager_id_fk_grocery`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vendors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vendors` (
  `vendor_id` INT NOT NULL,
  `company_name` VARCHAR(55) NOT NULL,
  `department_id` INT NOT NULL,
  `vendor_name` VARCHAR(45) NOT NULL,
  `vendor_phone` INT NULL,
  PRIMARY KEY (`vendor_id`),
  UNIQUE INDEX `id_UNIQUE` (`vendor_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Recepits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Receipts` (
  `receipt_id` INT NOT NULL,
  `department_id` INT NOT NULL,
  `department_manager_id` INT NOT NULL,
  `amount` DOUBLE NOT NULL,
  `purchase_date` DATE NOT NULL,
  `delivery_date` DATE NOT NULL,
  `item_count` INT NOT NULL,
  `vendor_id` INT NOT NULL,
  PRIMARY KEY (`receipt_id`),
  UNIQUE INDEX `receipt_id_UNIQUE` (`receipt_id` ASC) VISIBLE,
  INDEX `manager_id_fk_idx` (`department_manager_id` ASC) VISIBLE,
  INDEX `vendor_id_fk_idx` (`vendor_id` ASC) VISIBLE,
  CONSTRAINT `manager_id_fk_receipts`
    FOREIGN KEY (`department_manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `vendor_id_fk`
    FOREIGN KEY (`vendor_id`)
    REFERENCES `mydb`.`Vendors` (`vendor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Employees` (
  `employee_id` INT NOT NULL,
  `employee_name` VARCHAR(45) NOT NULL,
  `employee_phone` INT NOT NULL,
  `employee_startdate` DATE NOT NULL,
  `employee_enddate` DATE NULL,
  `employee_title` VARCHAR(45) NOT NULL,
  `department_id` INT NOT NULL,
  `employee_DOB` DATE NOT NULL,
  `manager_id` INT,
  PRIMARY KEY (`employee_id`),
  UNIQUE INDEX `employee_id_UNIQUE` (`employee_id` ASC) VISIBLE,
  INDEX `manager_id_fk_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `manager_id_fk_employees`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`managers` (`manager_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;