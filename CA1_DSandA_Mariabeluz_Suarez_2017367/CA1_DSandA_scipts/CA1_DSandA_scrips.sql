-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema vlid
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema vlid
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vlid` DEFAULT CHARACTER SET utf8 ;
USE `vlid` ;

-- -----------------------------------------------------
-- Table `vlid`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vlid`.`Users` (
  `idUsers` INT NOT NULL AUTO_INCREMENT,
  `firstName` CHAR(100) NULL,
  `LastName` CHAR(100) NULL,
  `Date_Arrival` DATE NULL,
  `Passport` CHAR(20) NULL,
  `Priority_Level` CHAR(10) NULL,
  `Possition` INT NULL,
  `PreviousNode` INT NULL,
  `NextNode` INT NULL,
  PRIMARY KEY (`idUsers`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;





INSERT INTO `vlid`.`users` (`idUsers`, `firstName`, `LastName`, `Date_Arrival`, `Passport`, `Priority_Level`, `Possition`) VALUES ('1', 'Beluz', 'Suarez', '2015-06-19', 'G89765432', 'High', '1');
