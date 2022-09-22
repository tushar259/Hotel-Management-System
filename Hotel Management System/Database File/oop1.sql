-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 26, 2018 at 04:28 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `oop1`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `UserId` varchar(6) NOT NULL,
  `Password` varchar(8) NOT NULL,
  `AccountNumber` int(10) NOT NULL,
  `AccountHolderName` varchar(10) NOT NULL,
  `Balance` double(8,2) NOT NULL,
  PRIMARY KEY (`AccountNumber`),
  UNIQUE KEY `UserId` (`UserId`),
  UNIQUE KEY `UserId_2` (`UserId`),
  UNIQUE KEY `UserId_3` (`UserId`),
  UNIQUE KEY `UserId_4` (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`UserId`, `Password`, `AccountNumber`, `AccountHolderName`, `Balance`) VALUES
('OOP1 F', 'abcd', 1000000001, 'AIUB', 15000.00),
('OOP1 H', '1234', 1000000002, 'CS', 10000.00),
('niloy', 'niloy', 1000000004, 'Mohaimen', 51000.00);

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `Email` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  UNIQUE KEY `Email` (`Email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Email`, `Password`) VALUES
('manager@gmail.com', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE IF NOT EXISTS `experience` (
  `SL_No` int(2) NOT NULL AUTO_INCREMENT,
  `Good` int(6) NOT NULL,
  `Bad` int(6) NOT NULL,
  PRIMARY KEY (`SL_No`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `experience`
--

INSERT INTO `experience` (`SL_No`, `Good`, `Bad`) VALUES
(1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `price`
--

CREATE TABLE IF NOT EXISTS `price` (
  `No` int(1) NOT NULL,
  `RoomPrice` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `price`
--

INSERT INTO `price` (`No`, `RoomPrice`) VALUES
(1, 500);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
  `RoomNo` int(2) NOT NULL,
  `AvailableRooms` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`RoomNo`, `AvailableRooms`) VALUES
(0, 'Not Available'),
(1, 'Not Available'),
(2, 'Not Available'),
(3, 'Not Available'),
(4, '005');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Mobile` int(14) NOT NULL,
  `DebitCard` double(7,2) DEFAULT NULL,
  `CreditCard` double(7,2) DEFAULT NULL,
  PRIMARY KEY (`Mobile`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Email`, `Password`, `Mobile`, `DebitCard`, `CreditCard`) VALUES
('mark@gmail.com', '12345', 1672560150, 54600.99, NULL);
