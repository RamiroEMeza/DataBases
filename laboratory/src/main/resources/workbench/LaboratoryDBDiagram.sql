-- MySQL Script generated by MySQL Workbench
-- Thu Jan 19 00:37:18 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema LaboratoryDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `LaboratoryDB` ;

-- -----------------------------------------------------
-- Schema LaboratoryDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LaboratoryDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci ;
USE `LaboratoryDB` ;

-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Scientists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Scientists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `nationality` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Assistants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Assistants` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `nationality` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `Scientists_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Assistants_Scientists1`
    FOREIGN KEY (`Scientists_id`)
    REFERENCES `LaboratoryDB`.`Scientists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Resources_Stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Resources_Stock` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `unit` VARCHAR(45) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Resource_Petition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Resource_Petition` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Scientists_id` INT NOT NULL,
  `Resources_id` INT NOT NULL,
  `unit` VARCHAR(45) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ResourceOrder_Scientists1`
    FOREIGN KEY (`Scientists_id`)
    REFERENCES `LaboratoryDB`.`Scientists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ResourceOrder_Resources1`
    FOREIGN KEY (`Resources_id`)
    REFERENCES `LaboratoryDB`.`Resources_Stock` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Equipment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `working` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Labs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Labs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `capacity` INT NOT NULL,
  `complexity` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Researchs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Researchs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `start` DATE NOT NULL,
  `budget` INT NOT NULL,
  `complete` TINYINT NULL,
  `Labs_id` INT NOT NULL,
  `Scientists_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Labs_id_UNIQUE` (`Labs_id` ASC) VISIBLE,
  UNIQUE INDEX `Scientists_id_UNIQUE` (`Scientists_id` ASC) VISIBLE,
  CONSTRAINT `fk_Researchs_Labs1`
    FOREIGN KEY (`Labs_id`)
    REFERENCES `LaboratoryDB`.`Labs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Researchs_Scientists1`
    FOREIGN KEY (`Scientists_id`)
    REFERENCES `LaboratoryDB`.`Scientists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Equipment_Asigned`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Equipment_Asigned` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Equipment_id` INT NOT NULL,
  `expires` DATE NOT NULL,
  `Researchs_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Equipment_id_UNIQUE` (`Equipment_id` ASC) VISIBLE,
  CONSTRAINT `fk_EquipmentAsigned_Equipment1`
    FOREIGN KEY (`Equipment_id`)
    REFERENCES `LaboratoryDB`.`Equipment` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipment_Asigned_Researchs1`
    FOREIGN KEY (`Researchs_id`)
    REFERENCES `LaboratoryDB`.`Researchs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Administratives`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Administratives` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `Resources_Stock_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Resources_Stock_id_UNIQUE` (`Resources_Stock_id` ASC) VISIBLE,
  CONSTRAINT `fk_Administratives_Resources_Stock1`
    FOREIGN KEY (`Resources_Stock_id`)
    REFERENCES `LaboratoryDB`.`Resources_Stock` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Technical_Support`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Technical_Support` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Equipment_Suport_History`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Equipment_Suport_History` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Equipment_id` INT NOT NULL,
  `TechnicalSupport_id` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `start` DATE NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_EquipmentSuport_Equipment1`
    FOREIGN KEY (`Equipment_id`)
    REFERENCES `LaboratoryDB`.`Equipment` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EquipmentSuport_TechnicalSupport1`
    FOREIGN KEY (`TechnicalSupport_id`)
    REFERENCES `LaboratoryDB`.`Technical_Support` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LaboratoryDB`.`Test_Subjects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LaboratoryDB`.`Test_Subjects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `species` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `sex` TINYINT NOT NULL,
  `weight` DOUBLE NOT NULL,
  `Researchs_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Test_Subjects_Researchs1`
    FOREIGN KEY (`Researchs_id`)
    REFERENCES `LaboratoryDB`.`Researchs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO Labs (capacity, complexity) VALUES (6, 2);
INSERT INTO Labs (capacity, complexity) VALUES (6, 2);
INSERT INTO Labs (capacity, complexity) VALUES (6, 2);
INSERT INTO Labs (capacity, complexity) VALUES (6, 2);
INSERT INTO Labs (capacity, complexity) VALUES (6, 2);

INSERT INTO technical_support (name, lastname) VALUES ("Many", "King");
INSERT INTO technical_support (name, lastname) VALUES ("Manuel", "Herrera");
INSERT INTO technical_support (name, lastname) VALUES ("Miguel", "Hernandez");

INSERT INTO equipment (name, working) VALUES ("Laser", 1);
INSERT INTO equipment (name, working) VALUES ("Laser", 1);
INSERT INTO equipment (name, working) VALUES ("Laser", 1);

INSERT INTO equipment_suport_history (Equipment_id, TechnicalSupport_id, status, start) VALUES (2, 2, "inProgress", "2023-01-12");

INSERT INTO resources_stock (name, unit, quantity) VALUES ("Distilled Water", "liters", 400);
INSERT INTO resources_stock (name, unit, quantity) VALUES ("Gold", "grams", 300);
INSERT INTO resources_stock (name, unit, quantity) VALUES ("Copper", "grams", 900);
INSERT INTO resources_stock (name, unit, quantity) VALUES ("Alcohol", "liters", 400);
INSERT INTO resources_stock (name, unit, quantity) VALUES ("Benzene", "liters", 400);

INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Adam", "King", 1);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Adam", "Philips", 2);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Alexander", "Romanov", 3);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Augustus", "Maximus", 4);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Anne", "Sheeran", 5);

INSERT INTO Scientists (name, lastname, nationality, age) VALUES ("Steve", "Moore", "canadian", 31);
INSERT INTO Scientists (name, lastname, nationality, age) VALUES ("Andres", "Rivas", "spainish", 30);
INSERT INTO Scientists (name, lastname, nationality, age) VALUES ("Mario", "Ferrari", "italian", 42);
INSERT INTO Scientists (name, lastname, nationality, age) VALUES ("Steve", "Moore", "canadian", 31);

INSERT INTO researchs (name, start, budget, complete, Labs_id, Scientists_id) VALUES ("Heavy Water", "2022-12-01", 7000, 0, 4, 1);
INSERT INTO researchs (name, start, budget, complete, Labs_id, Scientists_id) VALUES ("Radioactivity", "2022-11-01", 7000, 0, 2, 2);
INSERT INTO researchs (name, start, budget, complete, Labs_id, Scientists_id) VALUES ("Ultra Violet", "2022-6-01", 7000, 0, 3, 4);
INSERT INTO researchs (name, start, budget, complete, Labs_id, Scientists_id) VALUES ("Infra Red", "2022-6-01", 7000, 0, 5, 3);

INSERT INTO Assistants (name, lastname, nationality, age, Scientists_id) VALUES ("Brok", "Lee", "canadian", 24, 1);
INSERT INTO Assistants (name, lastname, nationality, age, Scientists_id) VALUES ("Chi", "Lee", "korean", 24, 1);
INSERT INTO Assistants (name, lastname, nationality, age, Scientists_id) VALUES ("Kim", "Lee", "korean", 24, 3);

INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 3, 1, 28, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 2, 0, 24, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 2, 0, 22, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 4, 0, 26, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 4, 1, 34, 2);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 3, 1, 35, 3);
