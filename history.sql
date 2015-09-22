-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 21, 2012 at 08:16 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `onlineexam`
--

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE IF NOT EXISTS `history` (
  `UserId` int(10) NOT NULL,
  `Percentage` int(3) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`UserId`, `Percentage`) VALUES
(10012334, 0),
(10012344, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
