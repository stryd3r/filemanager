-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 20, 2016 at 09:28 AM
-- Server version: 5.7.10-log
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `stomato`
--

-- --------------------------------------------------------

--
-- Table structure for table `calendar`
--

CREATE TABLE IF NOT EXISTS `calendar` (
  `id` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Calendar_utilizatori` (`id_doctor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `chestionare`
--

CREATE TABLE IF NOT EXISTS `chestionare` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_intrebare` int(11) NOT NULL,
  `intrebare` varchar(301) NOT NULL,
  PRIMARY KEY (`id`,`id_intrebare`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `consultatii`
--

CREATE TABLE IF NOT EXISTS `consultatii` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pacient` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `diagnostic` varchar(300) DEFAULT NULL,
  `observatii` varchar(500) DEFAULT NULL,
  `pret` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_pacient`,`id_doctor`),
  KEY `Vizite_clienti` (`id_pacient`),
  KEY `doctori_Vizite` (`id_doctor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `detalii_pacient`
--

CREATE TABLE IF NOT EXISTS `detalii_pacient` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `adresa` varchar(300) NOT NULL,
  `id_pacient` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_detalii_pacient_pacienti1_idx` (`id_pacient`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `detalii_pacient`
--

INSERT INTO `detalii_pacient` (`id`, `adresa`, `id_pacient`) VALUES
(1, 'lalelelor', 1),
(5, 'lalelelor', 2);

-- --------------------------------------------------------

--
-- Table structure for table `doctori`
--

CREATE TABLE IF NOT EXISTS `doctori` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(100) NOT NULL,
  `prenume` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `doctori`
--

INSERT INTO `doctori` (`id`, `nume`, `prenume`) VALUES
(1, 'doc1n', 'doc1p');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_calendar` int(11) NOT NULL,
  `culoare` varchar(50) DEFAULT NULL,
  `observatie` varchar(300) DEFAULT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `end_date` timestamp NULL DEFAULT NULL,
  `all_day` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `Events_Calendar` (`id_calendar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pacienti`
--

CREATE TABLE IF NOT EXISTS `pacienti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(20) NOT NULL,
  `prenume` varchar(20) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pacienti_doctori1_idx` (`id_doctor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `pacienti`
--

INSERT INTO `pacienti` (`id`, `nume`, `prenume`, `id_doctor`) VALUES
(1, 'barna', 'adrian', 1),
(2, 'barna2', 'adrian2', 1);

-- --------------------------------------------------------

--
-- Table structure for table `raspuns_chestionar`
--

CREATE TABLE IF NOT EXISTS `raspuns_chestionar` (
  `id_pacient` int(11) NOT NULL,
  `id_chestionar` int(11) NOT NULL,
  `id_intrebare` int(11) NOT NULL,
  `raspuns` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_pacient`,`id_chestionar`,`id_intrebare`),
  KEY `raspuns_chestionar_chestionare` (`id_chestionar`,`id_intrebare`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `calendar`
--
ALTER TABLE `calendar`
  ADD CONSTRAINT `Calendar_utilizatori` FOREIGN KEY (`id_doctor`) REFERENCES `doctori` (`id`);

--
-- Constraints for table `consultatii`
--
ALTER TABLE `consultatii`
  ADD CONSTRAINT `Vizite_clienti` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id`),
  ADD CONSTRAINT `doctori_Vizite` FOREIGN KEY (`id_doctor`) REFERENCES `doctori` (`id`);

--
-- Constraints for table `detalii_pacient`
--
ALTER TABLE `detalii_pacient`
  ADD CONSTRAINT `fk_detalii_pacient_pacienti1` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `Events_Calendar` FOREIGN KEY (`id_calendar`) REFERENCES `calendar` (`id`);

--
-- Constraints for table `pacienti`
--
ALTER TABLE `pacienti`
  ADD CONSTRAINT `fk_pacienti_doctori1` FOREIGN KEY (`id_doctor`) REFERENCES `doctori` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `raspuns_chestionar`
--
ALTER TABLE `raspuns_chestionar`
  ADD CONSTRAINT `raspuns_chestionar_chestionare` FOREIGN KEY (`id_chestionar`, `id_intrebare`) REFERENCES `chestionare` (`id`, `id_intrebare`),
  ADD CONSTRAINT `raspuns_chestionar_clienti` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
