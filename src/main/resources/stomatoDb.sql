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
CREATE SCHEMA IF NOT EXISTS `stomato` DEFAULT CHARACTER SET latin1 ;
USE `stomato` ;

-- -----------------------------------------------------
-- Table `stomato`.`doctori`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`doctori` (
  `id_doctor` INT(11) NOT NULL AUTO_INCREMENT,
  `nume` VARCHAR(100) NOT NULL,
  `prenume` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_doctor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`calendar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`calendar` (
  `id_calendar` INT(11) NOT NULL AUTO_INCREMENT,
  `id_doctor` INT(11) NOT NULL,
  PRIMARY KEY (`id_calendar`),
  INDEX `Calendar_utilizatori` (`id_doctor` ASC),
  CONSTRAINT `Calendar_utilizatori`
    FOREIGN KEY (`id_doctor`)
    REFERENCES `stomato`.`doctori` (`id_doctor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`chestionare`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`chestionare` (
  `id_chestionar` INT(11) NOT NULL,
  `id_intrebare` INT(11) NOT NULL,
  `intrebare` VARCHAR(301) NOT NULL,
  PRIMARY KEY (`id_chestionar`, `id_intrebare`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`pacienti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`pacienti` (
  `id_pacient` INT(11) NOT NULL AUTO_INCREMENT,
  `nume` VARCHAR(20) NOT NULL,
  `prenume` VARCHAR(20) NOT NULL,
  `id_doctor` INT(11) NOT NULL,
  PRIMARY KEY (`id_pacient`),
  INDEX `fk_pacienti_doctori1_idx` (`id_doctor` ASC),
  CONSTRAINT `fk_pacienti_doctori1`
    FOREIGN KEY (`id_doctor`)
    REFERENCES `stomato`.`doctori` (`id_doctor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`consultatii`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`consultatii` (
  `id_consultatii` INT(11) NOT NULL AUTO_INCREMENT,
  `id_pacient` INT(11) NOT NULL,
  `id_doctor` INT(11) NOT NULL,
  `diagnostic` VARCHAR(300) NULL DEFAULT NULL,
  `observatii` VARCHAR(500) NULL DEFAULT NULL,
  `pret` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_consultatii`),
  INDEX `Vizite_clienti` (`id_pacient` ASC),
  INDEX `doctori_Vizite` (`id_doctor` ASC),
  CONSTRAINT `Vizite_clienti`
    FOREIGN KEY (`id_pacient`)
    REFERENCES `stomato`.`pacienti` (`id_pacient`),
  CONSTRAINT `doctori_Vizite`
    FOREIGN KEY (`id_doctor`)
    REFERENCES `stomato`.`doctori` (`id_doctor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`detalii_pacient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`detalii_pacient` (
  `id_detalii_pacient` INT NOT NULL AUTO_INCREMENT,
  `adresa` VARCHAR(300) NOT NULL,
  `id_pacient` INT(11) NOT NULL,
  INDEX `fk_detalii_pacient_pacienti1_idx` (`id_pacient` ASC),
  PRIMARY KEY (`id_detalii_pacient`),
  CONSTRAINT `fk_detalii_pacient_pacienti1`
    FOREIGN KEY (`id_pacient`)
    REFERENCES `stomato`.`pacienti` (`id_pacient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`events` (
  `id_events` INT(11) NOT NULL AUTO_INCREMENT,
  `id_calendar` INT(11) NOT NULL,
  `culoare` VARCHAR(50) NULL,
  `observatie` VARCHAR(300) NULL DEFAULT NULL,
  `start_date` TIMESTAMP NULL,
  `end_date` TIMESTAMP NULL,
  `all_day` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_events`),
  INDEX `Events_Calendar` (`id_calendar` ASC),
  CONSTRAINT `Events_Calendar`
    FOREIGN KEY (`id_calendar`)
    REFERENCES `stomato`.`calendar` (`id_calendar`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `stomato`.`raspuns_chestionar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stomato`.`raspuns_chestionar` (
  `id_raspuns_chestionar` INT(3) NOT NULL AUTO_INCREMENT,
  `id_pacient` INT(11) NOT NULL,
  `id_chestionar` INT(11) NOT NULL,
  `id_intrebare` INT(11) NOT NULL,
  `raspuns` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id_raspuns_chestionar`),
  INDEX `raspuns_chestionar_chestionare` (`id_chestionar` ASC, `id_intrebare` ASC),
  CONSTRAINT `raspuns_chestionar_chestionare`
    FOREIGN KEY (`id_chestionar` , `id_intrebare`)
    REFERENCES `stomato`.`chestionare` (`id_chestionar` , `id_intrebare`),
  CONSTRAINT `raspuns_chestionar_clienti`
    FOREIGN KEY (`id_pacient`)
    REFERENCES `stomato`.`pacienti` (`id_pacient`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
