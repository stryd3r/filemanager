-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema stomato
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema stomato
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stomato` DEFAULT CHARACTER SET utf8 ;
USE `stomato` ;

-- -----------------------------------------------------
-- Table `stomato`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`doctor` (
  `doctorId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `surname` VARCHAR(100) NOT NULL,
  `color` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`doctorId`),
  UNIQUE INDEX `color_UNIQUE` (`color` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`pacient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`pacient` (
  `pacientId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `surname` VARCHAR(20) NOT NULL,
  `doctorId` INT(11) NOT NULL,
  PRIMARY KEY (`pacientId`),
  INDEX `fk_pacienti_doctori1_idx` (`doctorId` ASC),
  CONSTRAINT `fk_pacienti_doctori1`
    FOREIGN KEY (`doctorId`)
    REFERENCES `stomato`.`doctor` (`doctorId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`consultation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`consultation` (
  `consultationId` INT(11) NOT NULL AUTO_INCREMENT,
  `pacientId` INT(11) NOT NULL,
  `doctorId` INT(11) NOT NULL,
  `diagnostic` VARCHAR(300) NULL DEFAULT NULL,
  `observation` VARCHAR(500) NULL,
  `price` VARCHAR(100) NULL DEFAULT NULL,
  `consultationTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`consultationId`),
  INDEX `Vizite_clienti` (`pacientId` ASC),
  INDEX `doctori_Vizite` (`doctorId` ASC),
  CONSTRAINT `Vizite_clienti`
    FOREIGN KEY (`pacientId`)
    REFERENCES `stomato`.`pacient` (`pacientId`),
  CONSTRAINT `doctori_Vizite`
    FOREIGN KEY (`doctorId`)
    REFERENCES `stomato`.`doctor` (`doctorId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`event` (
  `eventId` INT(11) NOT NULL AUTO_INCREMENT,
  `doctorId` INT(11) NOT NULL,
  `observation` VARCHAR(300) NULL DEFAULT NULL,
  `startDate` TIMESTAMP NULL DEFAULT NULL,
  `endDate` TIMESTAMP NULL DEFAULT NULL,
  `allDay` TINYINT(1) NOT NULL DEFAULT '0',
  `color` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`eventId`),
  INDEX `fk_event_doctor1_idx` (`doctorId` ASC),
  CONSTRAINT `fk_event_doctor1`
    FOREIGN KEY (`doctorId`)
    REFERENCES `stomato`.`doctor` (`doctorId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`pacientDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`pacientDetail` (
  `pacientId` INT(11) NOT NULL,
  `address` VARCHAR(300) NULL,
  `zipCode` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `birthdate` TIMESTAMP NULL,
  `sex` VARCHAR(1) NULL,
  `cnp` VARCHAR(13) NULL,
  INDEX `fk_detalii_pacient_pacienti1_idx` (`pacientId` ASC),
  UNIQUE INDEX `pacientId_UNIQUE` (`pacientId` ASC),
  CONSTRAINT `fk_detalii_pacient_pacienti1`
    FOREIGN KEY (`pacientId`)
    REFERENCES `stomato`.`pacient` (`pacientId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`questionnaire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`questionnaire` (
  `questionnaireId` INT(11) NOT NULL,
  `questionId` INT(11) NOT NULL,
  `question` VARCHAR(301) NOT NULL,
  PRIMARY KEY (`questionnaireId`, `questionId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`questionnaireAnswer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`questionnaireAnswer` (
  `pacientId` INT(11) NOT NULL,
  `questionnaireId` INT(11) NOT NULL,
  `questionId` INT(11) NOT NULL,
  `answer` VARCHAR(500) NULL,
  INDEX `raspuns_chestionar_chestionare` (`questionnaireId` ASC, `questionId` ASC),
  INDEX `raspuns_chestionar_clienti` (`pacientId` ASC),
  CONSTRAINT `raspuns_chestionar_chestionare`
    FOREIGN KEY (`questionnaireId` , `questionId`)
    REFERENCES `stomato`.`questionnaire` (`questionnaireId` , `questionId`),
  CONSTRAINT `raspuns_chestionar_clienti`
    FOREIGN KEY (`pacientId`)
    REFERENCES `stomato`.`pacient` (`pacientId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
