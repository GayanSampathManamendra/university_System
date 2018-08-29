-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2018 at 07:08 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nsbm`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignmentmarks`
--

CREATE TABLE `assignmentmarks` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL,
  `assName` varchar(200) NOT NULL,
  `marks` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assignmentmarks`
--

INSERT INTO `assignmentmarks` (`regNo`, `subCode`, `assName`, `marks`) VALUES
('scs61', 'scs1000', 'ass1', 45),
('scs61', 'scs1000', 'ass2', 75),
('scs61', 'scs1000', 'assingment 1', 45),
('scs61', 'scs1002', 'assgnment4', 12);

-- --------------------------------------------------------

--
-- Table structure for table `assignmentsmarks`
--

CREATE TABLE `assignmentsmarks` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL,
  `assName` varchar(200) DEFAULT NULL,
  `marks` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `regNo` varchar(10) NOT NULL,
  `subject` varchar(10) NOT NULL,
  `marks` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`regNo`, `subject`, `marks`) VALUES
('scs60', 'scs1002', 53),
('scs61', 'scs1000', 85),
('scs61', 'scs1002', 56),
('scs61', 'scs1003', 45),
('scs61', 'scs1003', 80),
('scs61', 'scs1004', 47);

-- --------------------------------------------------------

--
-- Table structure for table `examresults`
--

CREATE TABLE `examresults` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL,
  `marks` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `examresults`
--

INSERT INTO `examresults` (`regNo`, `subCode`, `marks`) VALUES
('scs61', 'scs1000', 18),
('scs61', 'scs1001', 39),
('scs61', 'scs1002', 53),
('scs77', 'scs1012', 48),
('scs77', 'scs1013', 59),
('scs77', 'scs1014', 72),
('scs78', 'scs1010', 90),
('scs78', 'scs1011', 86),
('scs78', 'scs1012', 80),
('scs78', 'scs1013', 92),
('scs80', 'scs1015', 72),
('scs80', 'scs1016', 71),
('scs80', 'scs1017', 80),
('scs80', 'scs1018', 64),
('scs81', 'scs1015', 36),
('scs81', 'scs1016', 45),
('scs81', 'scs1017', 33),
('scs81', 'scs1019', 44),
('scs83', 'scs1015', 60),
('scs83', 'scs1016', 62),
('scs83', 'scs1017', 55),
('scs83', 'scs1018', 52),
('scs85', 'scs 1021', 45),
('scs85', 'scs 1022', 49),
('scs85', 'scs 1023', 56),
('scs85', 'scs 1024', 60),
('scs86', 'scs 1020', 72),
('scs86', 'scs 1022', 70),
('scs86', 'scs 1023', 66),
('scs86', 'scs 1024', 69),
('scs87', 'scs 1020', 50),
('scs87', 'scs 1021', 47),
('scs87', 'scs 1022', 78),
('scs87', 'scs 1023', 53),
('scs90', 'scs 1025', 71),
('scs90', 'scs 1026', 70),
('scs90', 'scs 1027', 60),
('scs90', 'scs 1028', 65),
('scs91', 'scs 1026', 56),
('scs91', 'scs 1027', 58),
('scs91', 'scs 1028', 68),
('scs91', 'scs 1029', 71),
('scs92', 'scs 1025', 82),
('scs92', 'scs 1026', 80),
('scs92', 'scs 1027', 88),
('scs92', 'scs 1029', 78);

-- --------------------------------------------------------

--
-- Table structure for table `facandyear`
--

CREATE TABLE `facandyear` (
  `regNo` varchar(10) NOT NULL,
  `faculty` varchar(200) NOT NULL,
  `acadumicYear` int(2) NOT NULL,
  `semester` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facandyear`
--

INSERT INTO `facandyear` (`regNo`, `faculty`, `acadumicYear`, `semester`) VALUES
('2018cs56', 'COM', 1, 1),
('ENG53', 'ENG', 2, 1),
('scs175', 'COM', 1, 1),
('scs200', 'COM', 1, 1),
('scs201', 'COM', 4, 1),
('scs550', 'COM', 1, 1),
('scs555', 'COM', 4, 1),
('scs60', 'COM', 1, 1),
('scs61', 'COM', 1, 1),
('scs62', 'COM', 1, 1),
('scs63', 'COM', 1, 1),
('scs64', 'COM', 1, 1),
('scs70', 'COM', 1, 2),
('scs71', 'COM', 1, 2),
('scs72', 'COM', 1, 2),
('scs73', 'COM', 1, 2),
('scs74', 'COM', 1, 2),
('scs75', 'COM', 2, 1),
('scs76', 'COM', 2, 1),
('scs77', 'COM', 2, 1),
('scs78', 'COM', 2, 1),
('scs79', 'COM', 2, 1),
('scs80', 'COM', 2, 2),
('scs81', 'COM', 2, 2),
('scs82', 'COM', 2, 2),
('scs83', 'COM', 2, 2),
('scs84', 'COM', 2, 2),
('scs85', 'COM', 3, 1),
('scs86', 'COM', 3, 1),
('scs87', 'COM', 3, 1),
('scs88', 'COM', 3, 1),
('scs89', 'COM', 3, 1),
('scs90', 'COM', 3, 2),
('scs91', 'COM', 3, 2),
('scs92', 'COM', 3, 2),
('scs999', 'COM', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `finalgrade`
--

CREATE TABLE `finalgrade` (
  `regNo` varchar(10) NOT NULL,
  `subject` varchar(10) NOT NULL,
  `marks` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `finalresult`
--

CREATE TABLE `finalresult` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL,
  `finalMark` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hallinfo`
--

CREATE TABLE `hallinfo` (
  `hallId` varchar(10) NOT NULL,
  `capacity` int(10) DEFAULT NULL,
  `discription` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `instrucappoinment`
--

CREATE TABLE `instrucappoinment` (
  `insId` varchar(20) NOT NULL,
  `date_` date DEFAULT NULL,
  `time_Duration` time DEFAULT NULL,
  `avilable` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `instrucinfo`
--

CREATE TABLE `instrucinfo` (
  `insId` varchar(20) NOT NULL,
  `insName` varchar(255) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `room` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instrucinfo`
--

INSERT INTO `instrucinfo` (`insId`, `insName`, `DOB`, `age`, `gender`, `email`, `tel`, `fax`, `room`) VALUES
('ins5', 'nimal', '1996-08-09', 23, 'male', 'nimal@gmail.com', '1253458', '11145862', 'W009');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `subCode` varchar(20) NOT NULL,
  `insId` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`subCode`, `insId`) VALUES
('scs 1022', 'ins5'),
('scs 1028', 'ins5'),
('scs1001', 'ins5');

-- --------------------------------------------------------

--
-- Table structure for table `lecappoinment`
--

CREATE TABLE `lecappoinment` (
  `lecId` varchar(20) NOT NULL,
  `date_` date DEFAULT NULL,
  `time_Duration` time DEFAULT NULL,
  `available` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lecinfo`
--

CREATE TABLE `lecinfo` (
  `lecId` varchar(20) NOT NULL,
  `lecName` varchar(255) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `fax` varchar(30) DEFAULT NULL,
  `room` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecinfo`
--

INSERT INTO `lecinfo` (`lecId`, `lecName`, `DOB`, `age`, `gender`, `email`, `tel`, `fax`, `room`) VALUES
('com5', 'dr.nalin', '1966-08-09', 56, 'male', 'nlain@gmail.com', '65132', '9865', 'Woos2'),
('eng5', 'lkjhg', '3215-07-05', 65, 'female', ';lkjhg', '897653', '89654132', 'yttgjh'),
('hjkl', 'hgjkl', '1568-08-07', 53, 'male', 'gfhjkl', '895623', '8965326', 'gfhj'),
('iugsajoo;', 'oijpkgas[', '1524-08-05', 65, 'female', 'bdl', '6845312', '985', 'jakbsl');

-- --------------------------------------------------------

--
-- Table structure for table `lectues`
--

CREATE TABLE `lectues` (
  `subCode` varchar(10) NOT NULL,
  `lecId` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lecture`
--

CREATE TABLE `lecture` (
  `subCode` varchar(20) NOT NULL,
  `lecId` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecture`
--

INSERT INTO `lecture` (`subCode`, `lecId`) VALUES
('scs 1022', 'eng5'),
('scs 1023', 'eng5'),
('scs 1029', 'eng5'),
('scs 1020', 'hjkl'),
('scs 1028', 'hjkl'),
('scs1004', 'hjkl');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `subCode` varchar(20) NOT NULL,
  `hallId` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userName` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userName`, `pass`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `overallessmarks`
--

CREATE TABLE `overallessmarks` (
  `regNo` varchar(10) NOT NULL,
  `subject` varchar(10) NOT NULL,
  `marks` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `overallmarks`
--

CREATE TABLE `overallmarks` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL,
  `overallEssMarks` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`regNo`, `subCode`) VALUES
('scs175', 'scs1001'),
('scs175', 'scs1002'),
('scs175', 'scs1003'),
('scs200', 'scs1001'),
('scs200', 'scs1002'),
('scs200', 'scs1003'),
('scs550', 'scs1000'),
('scs550', 'scs1002'),
('scs550', 'scs1003'),
('scs550', 'scs1004'),
('scs555', 'scs 1021'),
('scs555', 'scs1000'),
('scs555', 'scs1001'),
('scs61', 'scs1000'),
('scs61', 'scs1001'),
('scs61', 'scs1002'),
('scs61', 'scs1003'),
('scs62', 'scs1000'),
('scs62', 'scs1001'),
('scs62', 'scs1002'),
('scs62', 'scs1004'),
('scs63', 'scs1000'),
('scs63', 'scs1001'),
('scs63', 'scs1002'),
('scs63', 'scs1004'),
('scs64', 'scs1001'),
('scs64', 'scs1002'),
('scs64', 'scs1003'),
('scs64', 'scs1004'),
('scs70', 'scs1005'),
('scs70', 'scs1006'),
('scs70', 'scs1007'),
('scs70', 'scs1008'),
('scs71', 'scs1005'),
('scs71', 'scs1007'),
('scs71', 'scs1008'),
('scs71', 'scs1009'),
('scs72', 'scs1005'),
('scs72', 'scs1006'),
('scs72', 'scs1008'),
('scs72', 'scs1009'),
('scs73', 'scs1005'),
('scs73', 'scs1006'),
('scs73', 'scs1007'),
('scs73', 'scs1009'),
('scs74', 'scs1005'),
('scs74', 'scs1007'),
('scs74', 'scs1008'),
('scs74', 'scs1009'),
('scs75', 'scs1010'),
('scs75', 'scs1011'),
('scs75', 'scs1012'),
('scs75', 'scs1014'),
('scs76', 'scs1010'),
('scs76', 'scs1011'),
('scs76', 'scs1013'),
('scs76', 'scs1014'),
('scs77', 'scs1011'),
('scs77', 'scs1012'),
('scs77', 'scs1013'),
('scs77', 'scs1014'),
('scs78', 'scs1010'),
('scs78', 'scs1011'),
('scs78', 'scs1012'),
('scs78', 'scs1013'),
('scs79', 'scs1010'),
('scs79', 'scs1012'),
('scs79', 'scs1013'),
('scs79', 'scs1014'),
('scs80', 'scs1015'),
('scs80', 'scs1016'),
('scs80', 'scs1017'),
('scs80', 'scs1018'),
('scs81', 'scs1015'),
('scs81', 'scs1016'),
('scs81', 'scs1017'),
('scs81', 'scs1019'),
('scs82', 'scs1015'),
('scs82', 'scs1016'),
('scs82', 'scs1017'),
('scs82', 'scs1018'),
('scs84', 'scs1016'),
('scs84', 'scs1017'),
('scs84', 'scs1018'),
('scs84', 'scs1019'),
('scs85', 'scs 1021'),
('scs85', 'scs 1022'),
('scs85', 'scs 1023'),
('scs85', 'scs 1024'),
('scs86', 'scs 1020'),
('scs86', 'scs 1022'),
('scs86', 'scs 1023'),
('scs86', 'scs 1024'),
('scs87', 'scs 1020'),
('scs87', 'scs 1021'),
('scs87', 'scs 1022'),
('scs87', 'scs 1023'),
('scs88', 'scs 1020'),
('scs88', 'scs 1021'),
('scs88', 'scs 1023'),
('scs88', 'scs 1024'),
('scs89', 'scs 1020'),
('scs89', 'scs 1021'),
('scs89', 'scs 1022'),
('scs89', 'scs 1024'),
('scs90', 'scs 1025'),
('scs90', 'scs 1026'),
('scs90', 'scs 1027'),
('scs90', 'scs 1028'),
('scs91', 'scs 1026'),
('scs91', 'scs 1027'),
('scs91', 'scs 1028'),
('scs91', 'scs 1029'),
('scs92', 'scs 1025'),
('scs92', 'scs 1026'),
('scs92', 'scs 1027'),
('scs92', 'scs 1029');

-- --------------------------------------------------------

--
-- Table structure for table `postgraduate`
--

CREATE TABLE `postgraduate` (
  `regNo` varchar(10) NOT NULL,
  `qulificationType` varchar(255) NOT NULL,
  `institute` varchar(255) NOT NULL,
  `curGPA` double(5,4) NOT NULL,
  `outYear` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `postgraduate`
--

INSERT INTO `postgraduate` (`regNo`, `qulificationType`, `institute`, `curGPA`, `outYear`) VALUES
('scs201', 'Bsc', 'slit', 2.3650, 2018),
('scs555', 'bsc', 'slit', 2.1540, 2015);

-- --------------------------------------------------------

--
-- Table structure for table `practicalmarks`
--

CREATE TABLE `practicalmarks` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL,
  `practicalName` varchar(200) DEFAULT NULL,
  `marks` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `practicals`
--

CREATE TABLE `practicals` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL,
  `practicalName` varchar(200) NOT NULL,
  `marks` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `practicals`
--

INSERT INTO `practicals` (`regNo`, `subCode`, `practicalName`, `marks`) VALUES
('scs61', 'scs1000', 'parctical 1', 95),
('scs61', 'scs1000', 'practical 1', 75),
('scs61', 'scs1000', 'practical 2', 98),
('scs61', 'scs1002', 'practical 3', 54);

-- --------------------------------------------------------

--
-- Table structure for table `qulified`
--

CREATE TABLE `qulified` (
  `regNo` varchar(10) NOT NULL,
  `qulifyOrNot` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ranking`
--

CREATE TABLE `ranking` (
  `regNo` varchar(10) NOT NULL,
  `GPA` double(5,4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reportmarks`
--

CREATE TABLE `reportmarks` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL,
  `reportName` varchar(200) NOT NULL,
  `marks` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reportmarks`
--

INSERT INTO `reportmarks` (`regNo`, `subCode`, `reportName`, `marks`) VALUES
('scs61', 'scs1000', 'report 1', 78),
('scs61', 'scs1000', 'report 2', 87),
('scs61', 'scs1000', 'report1', 84),
('scs61', 'scs1002', 'report 4', 89);

-- --------------------------------------------------------

--
-- Table structure for table `reportsmarks`
--

CREATE TABLE `reportsmarks` (
  `regNo` varchar(10) NOT NULL,
  `subCode` varchar(10) NOT NULL,
  `reportName` varchar(200) DEFAULT NULL,
  `marks` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `regNo` varchar(10) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nic` varchar(20) DEFAULT NULL,
  `DOB` varchar(40) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `addres` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` int(15) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `curYear` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`regNo`, `name`, `nic`, `DOB`, `age`, `addres`, `gender`, `email`, `tel`, `district`, `curYear`) VALUES
('2018cs56', '1995/2/1', '950320486V', 'gayan samapath', 15, 'kandy', 'male', 'gayansampathmanamendra@gmail.com', 1782546321, 'colombo', 2016),
('ENG53', 'mr.kumar', '950320496V', '1998/5/8', 55, 'moratuwa', 'male', 'kumar@gmail.com', 11457821, 'colobmo', 2014),
('scs175', 'sjith', '95321560', '1996/8/7', 23, 'peradeniya', 'male', 'sujit@gmail.com', 1245782, 'Kandy', 2015),
('scs200', 'kamal', '895323232', '1254/8/7', 12, 'ghjkl', 'male', 'klgjaljg@gamil.com', 8976451, 'matara', 2016),
('scs201', 'kmal', '654312', '1205/9/8', 45, 'hsgakjl', 'male', 'fsdhhgiuoaj', 6512023, 'jngeidgo', 2016),
('scs550', 'amara', '789465', '1245/8/7', 45, 'peradeniya', 'male', 'amara@gmail.com', 11458204, 'kandy', 2015),
('scs555', 'sujith', '4653', '1245/8/8', 45, 'sgjakhiusgha', 'female', 'oawibja', 654123, 'iuaghsu', 1245),
('scs60', '14521', '956241v', 'gayan', 23, 'peradeniya', 'male', 'gayan@gmail.com', 81234562, 'kandy', 2015),
('scs61', '1995/2/1', '3215421v', 'sampath', 20, 'kagalle', 'male', 'sampath@gmail.com', 12045782, 'jafna', 2014),
('scs62', '1992/4/5', '213542v', 'kamal', 24, 'pilimathalawa', 'male', 'kamal@gmail.com', 4125321, 'mathale', 2013),
('scs63', '199/6/2', '875421V', 'rani', 25, 'mawanalle', 'female', 'rani@gmailcom', 1245215, 'nuwara Elliya', 2014),
('scs64', '1994/8/5', '245183v', 'nimal', 23, 'galle', 'male', 'nimal@123', 1245321, 'galle', 2015),
('scs70', '1996/8/7', '952461v', 'saman', 21, 'mathara', 'Male', 'saman@gamil.com', 1542782, 'mathara', 2015),
('scs71', '1995/8/7', '21546v', 'nimali', 20, 'rathnapura', 'female', 'nimali@gmail.com', 1145421, 'Rathnapura', 2015),
('scs72', '1992/5/3', '854218v', 'thilini', 17, 'kadugannawa', 'female', 'thilini@gmail.com', 145237, 'kandy', 2014),
('scs73', '1999/2/1', '954621v', 'ruwan', 22, 'badulla', 'male', 'ruwan@gmail.com', 2145782, 'badulle', 2013),
('scs74', '1996/2/5', '985421v', 'thusitha', 18, 'anuradapura', 'male', 'thusith@gmail.com', 124583, 'anuradapura', 2014),
('scs75', '1997/8/7', '9532145v', 'anushka', 25, 'mathale', 'male', 'anush@gmail.com', 2154785, 'mathale', 2014),
('scs76', '1993/8/7', '9521451v', 'sandun', 20, 'kurunagala', 'male', 'sandun@gamil.com', 21457215, 'kurunagla', 2014),
('scs77', '1998/7/8', '9785421v', 'sameera', 23, 'polonnaruwa', 'male', 'sameera@gmail.com', 154875, 'polonnaruwa', 2015),
('scs78', '1996/3/2', '954218v', 'ramith', 26, 'hambanthota', 'male', 'ramith@gmail.com', 1245078, 'hambanthota', 2013),
('scs79', '1996/9/8', '2458621v', 'ajantha', 23, 'kandy', 'male', 'ajantha@gmail.com', 231457, 'kandy', 2013),
('scs80', '1999/8/9', '9562431v', 'danushka', 20, 'colombo', 'male', 'danushka@gmail.com', 2015483, 'colombo', 2015),
('scs81', '1998/6/3', '879521v', 'kasun', 26, 'kalaniya', 'male', 'kasun@gmail.com', 2451371, 'colombo', 2014),
('scs82', '1999/6/8', '874512v', 'pubudu', 24, 'warakapola', 'male', 'pubudu@gmail.com', 214578, 'kagalla', 2013),
('scs83', '1996/3/8', '9857621v', 'saduni', 23, 'ampara', 'female', 'saduni@gmail.com', 124563, 'ampara', 2014),
('scs84', '1998/3/5', '321454v', 'smith', 20, 'kandy', 'male', 'smith@gmail.com', 7201452, 'kandy', 2015),
('scs85', '1996/8/5', '85246321v', 'Amir', 23, 'mathale', 'male', 'amir@gmail.com', 12365478, 'mathale', 2013),
('scs86', '1995/6/2', '485621v', 'meena', 24, 'mawanalla', 'female', 'meena@gmail.com', 231546, 'kagalle', 2015),
('scs87', '1993/5/5', '2458321v', 'kumara', 26, 'kurunagala', 'male', 'kumara@gmail.com', 4521368, 'kurunagala', 2014),
('scs88', '1993/9/6', '51515v', 'raveen', 23, 'maharagama', 'male', 'raveen@gmail.com', 12548763, 'colmbo', 2015),
('scs89', '1996/7/7', '86541v', 'sachini', 22, 'trinco', 'female', 'sachini@gmail.com', 123456987, 'Trinco', 2014),
('scs90', '1993/8/7', '8946512v', 'nuwan', 22, 'badulla', 'male', 'nuwan@gmailcom', 12326545, 'badulla', 2013),
('scs91', '1993/3/3', '123265v', 'ranga', 23, 'mathara', 'male', 'ranga@gmail.com', 12354, 'mathara', 2015),
('scs92', '1995/2/1', '87951546v', 'ramani', 25, 'kadawatha', 'female', 'ramani@gmailcom', 13654578, 'colombo', 2014),
('scs999', 'saman', '98652', '1546/8/7', 54, 'iuadshgoihas', 'male', 'bgukdfsi', 4897851, 'kandjar', 2015);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subCode` varchar(10) NOT NULL,
  `subjectName` varchar(100) DEFAULT NULL,
  `faculty` varchar(100) DEFAULT NULL,
  `acadumicYear` int(2) DEFAULT NULL,
  `semester` int(1) DEFAULT NULL,
  `numOfCredit` int(2) DEFAULT NULL,
  `amount` int(10) NOT NULL,
  `compalsary` int(2) NOT NULL,
  `presantage` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subCode`, `subjectName`, `faculty`, `acadumicYear`, `semester`, `numOfCredit`, `amount`, `compalsary`, `presantage`) VALUES
('Eng 5693', 'micanical engineering', 'ENG', 2, 1, 2, 5632, 1, 45),
('MGT55', 'management', 'MGT', 2, 1, 3, 26500, 1, 0),
('scs 1020', 'subject N', 'COM', 3, 1, 2, 4500, 0, 0),
('scs 1021', 'subject NM', 'COM', 4, 1, 3, 4500, 1, 0),
('scs 1022', 'subject MM', 'COM', 3, 1, 2, 4000, 1, 0),
('scs 1023', 'subject MN', 'COM', 3, 1, 2, 4000, 0, 0),
('scs 1024', 'subject NMN', 'COM', 3, 1, 2, 4500, 1, 0),
('scs 1025', 'subject GH', 'COM', 3, 2, 2, 4000, 1, 0),
('scs 1026', 'subject GG', 'COM', 3, 2, 3, 4500, 1, 0),
('scs 1027', 'subject HH', 'COM', 3, 2, 2, 4500, 0, 0),
('scs 1028', 'subject HG', 'COM', 3, 2, 3, 4500, 0, 0),
('scs 1029', 'subject HHG', 'COM', 3, 2, 2, 4000, 1, 0),
('scs1000', 'subject A', 'COM', 4, 1, 2, 4000, 1, 40),
('scs1001', 'subject B', 'COM', 4, 1, 3, 4000, 0, 20),
('scs1002', 'subject C', 'COM', 1, 1, 2, 4000, 0, 0),
('scs1003', 'subject D', 'COM', 1, 1, 3, 4500, 0, 0),
('scs1004', 'subject E', 'COM', 1, 1, 2, 4000, 1, 0),
('scs1005', 'subject AB', 'COM', 1, 2, 2, 4000, 1, 0),
('scs1006', 'subject AC', 'COM', 4, 2, 3, 4500, 0, 0),
('scs1007', 'subject AD', 'COM', 1, 2, 3, 4500, 1, 0),
('scs1008', 'subject AE', 'COM', 1, 2, 2, 4000, 0, 0),
('scs1009', 'subject BC', 'COM', 1, 2, 2, 4000, 0, 0),
('scs1010', 'subject AAA', 'COM', 2, 1, 2, 4000, 1, 0),
('scs1011', 'subject AAB', 'COM', 2, 1, 2, 4000, 0, 0),
('scs1012', 'subject AAC', 'COM', 2, 1, 3, 4500, 1, 0),
('scs1013', 'subject ABB', 'COM', 2, 1, 2, 4000, 1, 0),
('scs1014', 'subject ACC', 'COM', 2, 1, 3, 4500, 0, 0),
('scs1015', 'subject AX', 'COM', 2, 2, 2, 4000, 0, 0),
('scs1016', 'subject AY', 'COM', 2, 2, 3, 4500, 0, 0),
('scs1017', 'subject QP', 'COM', 2, 2, 3, 4500, 0, 0),
('scs1018', 'subject BS', 'COM', 2, 2, 2, 4500, 0, 0),
('scs1019', 'subject AF', 'COM', 2, 2, 2, 4000, 0, 0),
('scs1105', 'computer networking', 'COM', 2, 1, 2, 4500, 1, 0),
('scs2563', 'computer system', 'COM', 2, 1, 2, 5600, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `timetable`
--

CREATE TABLE `timetable` (
  `time` varchar(200) NOT NULL,
  `day` varchar(100) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `lecture` varchar(100) DEFAULT NULL,
  `instructor` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `timetable`
--

INSERT INTO `timetable` (`time`, `day`, `subject`, `lecture`, `instructor`, `location`) VALUES
('1-3', 'Wednesday', 'scs1003', 'com5', 'scs54Ins', '109E'),
('10-12', 'Tuesday', 'scs1003', 'eng5', 'scs54Ins', 'S205'),
('4-5', 'Monday', 'scs1002', 'com5', 'ins5', 'bjkj'),
('8-10', 'Monday', 'scs1002', 'com5', 'scs54Ins', 'E404');

-- --------------------------------------------------------

--
-- Table structure for table `undergraduate`
--

CREATE TABLE `undergraduate` (
  `regNo` varchar(10) NOT NULL,
  `rank` int(5) DEFAULT NULL,
  `zcore` double(6,5) DEFAULT NULL,
  `ALresult` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `undergraduate`
--

INSERT INTO `undergraduate` (`regNo`, `rank`, `zcore`, `ALresult`) VALUES
('2018cs56', 125, 1.61900, 'BBB'),
('ENG53', 125, 1.85200, 'AAA'),
('scs175', 114, 1.56200, 'AAA'),
('scs200', 123, 2.25000, 'AAA'),
('scs550', 215, 1.24000, 'AAB'),
('scs60', 132, 1.23400, 'AAB'),
('scs61', 152, 1.23400, 'BBB'),
('scs62', 145, 1.24500, 'CCC'),
('scs63', 148, 1.23400, 'ABC'),
('scs64', 231, 1.23000, 'SSS'),
('scs70', 321, 1.24500, 'AAB'),
('scs71', 122, 2.21400, 'AAA'),
('scs72', 150, 0.95400, 'SSS'),
('scs73', 124, 1.32000, 'SAS'),
('scs74', 145, 1.23400, 'AAA'),
('scs75', 111, 1.23400, 'ABC'),
('scs76', 125, 2.32100, 'BBB'),
('scs77', 124, 1.23400, 'BSA'),
('scs78', 163, 2.36500, 'ABB'),
('scs79', 104, 1.23400, 'AAB'),
('scs80', 136, 1.23000, 'BBB'),
('scs81', 104, 1.36000, 'CAA'),
('scs82', 126, 1.32400, 'AAC'),
('scs83', 123, 1.32000, 'ABC'),
('scs84', 105, 1.32000, 'SSB'),
('scs85', 132, 1.32500, 'AAC'),
('scs86', 175, 1.65000, 'BBB'),
('scs87', 101, 1.36500, 'AAB'),
('scs88', 132, 1.45000, 'ABC'),
('scs89', 144, 1.54000, 'BBB'),
('scs90', 154, 1.32000, 'ABB'),
('scs91', 122, 1.35600, 'AAC'),
('scs92', 135, 1.63000, 'AAC');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignmentmarks`
--
ALTER TABLE `assignmentmarks`
  ADD PRIMARY KEY (`regNo`,`subCode`,`assName`),
  ADD KEY `subCode` (`subCode`);

--
-- Indexes for table `assignmentsmarks`
--
ALTER TABLE `assignmentsmarks`
  ADD PRIMARY KEY (`regNo`,`subCode`),
  ADD KEY `subCode` (`subCode`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`regNo`,`subject`,`marks`),
  ADD KEY `subject` (`subject`);

--
-- Indexes for table `examresults`
--
ALTER TABLE `examresults`
  ADD PRIMARY KEY (`regNo`,`subCode`),
  ADD KEY `subCode` (`subCode`);

--
-- Indexes for table `facandyear`
--
ALTER TABLE `facandyear`
  ADD PRIMARY KEY (`regNo`);

--
-- Indexes for table `finalgrade`
--
ALTER TABLE `finalgrade`
  ADD PRIMARY KEY (`regNo`,`subject`,`marks`),
  ADD KEY `subject` (`subject`);

--
-- Indexes for table `finalresult`
--
ALTER TABLE `finalresult`
  ADD PRIMARY KEY (`regNo`,`subCode`),
  ADD KEY `subCode` (`subCode`);

--
-- Indexes for table `hallinfo`
--
ALTER TABLE `hallinfo`
  ADD PRIMARY KEY (`hallId`);

--
-- Indexes for table `instrucappoinment`
--
ALTER TABLE `instrucappoinment`
  ADD PRIMARY KEY (`insId`);

--
-- Indexes for table `instrucinfo`
--
ALTER TABLE `instrucinfo`
  ADD PRIMARY KEY (`insId`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`subCode`),
  ADD KEY `insId` (`insId`);

--
-- Indexes for table `lecappoinment`
--
ALTER TABLE `lecappoinment`
  ADD PRIMARY KEY (`lecId`);

--
-- Indexes for table `lecinfo`
--
ALTER TABLE `lecinfo`
  ADD PRIMARY KEY (`lecId`);

--
-- Indexes for table `lectues`
--
ALTER TABLE `lectues`
  ADD PRIMARY KEY (`subCode`,`lecId`),
  ADD KEY `lecId` (`lecId`);

--
-- Indexes for table `lecture`
--
ALTER TABLE `lecture`
  ADD PRIMARY KEY (`subCode`),
  ADD KEY `lecId` (`lecId`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`subCode`),
  ADD KEY `hallId` (`hallId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userName`,`pass`);

--
-- Indexes for table `overallessmarks`
--
ALTER TABLE `overallessmarks`
  ADD PRIMARY KEY (`regNo`,`subject`,`marks`),
  ADD KEY `subject` (`subject`);

--
-- Indexes for table `overallmarks`
--
ALTER TABLE `overallmarks`
  ADD PRIMARY KEY (`regNo`,`subCode`),
  ADD KEY `subCode` (`subCode`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`regNo`,`subCode`),
  ADD KEY `payments_ibfk_1` (`subCode`);

--
-- Indexes for table `postgraduate`
--
ALTER TABLE `postgraduate`
  ADD PRIMARY KEY (`regNo`);

--
-- Indexes for table `practicalmarks`
--
ALTER TABLE `practicalmarks`
  ADD PRIMARY KEY (`regNo`,`subCode`),
  ADD KEY `subCode` (`subCode`);

--
-- Indexes for table `practicals`
--
ALTER TABLE `practicals`
  ADD PRIMARY KEY (`regNo`,`subCode`,`practicalName`),
  ADD KEY `subCode` (`subCode`);

--
-- Indexes for table `qulified`
--
ALTER TABLE `qulified`
  ADD PRIMARY KEY (`regNo`);

--
-- Indexes for table `ranking`
--
ALTER TABLE `ranking`
  ADD PRIMARY KEY (`regNo`);

--
-- Indexes for table `reportmarks`
--
ALTER TABLE `reportmarks`
  ADD PRIMARY KEY (`regNo`,`subCode`,`reportName`),
  ADD KEY `subCode` (`subCode`);

--
-- Indexes for table `reportsmarks`
--
ALTER TABLE `reportsmarks`
  ADD PRIMARY KEY (`regNo`,`subCode`),
  ADD KEY `subCode` (`subCode`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`regNo`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subCode`);

--
-- Indexes for table `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`time`);

--
-- Indexes for table `undergraduate`
--
ALTER TABLE `undergraduate`
  ADD PRIMARY KEY (`regNo`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignmentmarks`
--
ALTER TABLE `assignmentmarks`
  ADD CONSTRAINT `assignmentmarks_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `assignmentmarks_ibfk_2` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `assignmentsmarks`
--
ALTER TABLE `assignmentsmarks`
  ADD CONSTRAINT `assignmentsmarks_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `assignmentsmarks_ibfk_2` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `exam_ibfk_2` FOREIGN KEY (`subject`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `examresults`
--
ALTER TABLE `examresults`
  ADD CONSTRAINT `examresults_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examresults_ibfk_2` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `facandyear`
--
ALTER TABLE `facandyear`
  ADD CONSTRAINT `facandyear_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `finalgrade`
--
ALTER TABLE `finalgrade`
  ADD CONSTRAINT `finalgrade_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `finalgrade_ibfk_2` FOREIGN KEY (`subject`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `finalresult`
--
ALTER TABLE `finalresult`
  ADD CONSTRAINT `finalresult_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `finalresult_ibfk_2` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `instrucappoinment`
--
ALTER TABLE `instrucappoinment`
  ADD CONSTRAINT `instrucappoinment_ibfk_1` FOREIGN KEY (`insId`) REFERENCES `instrucinfo` (`insId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `instructor`
--
ALTER TABLE `instructor`
  ADD CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `instructor_ibfk_2` FOREIGN KEY (`insId`) REFERENCES `instrucinfo` (`insId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lecappoinment`
--
ALTER TABLE `lecappoinment`
  ADD CONSTRAINT `lecappoinment_ibfk_1` FOREIGN KEY (`lecId`) REFERENCES `lecinfo` (`lecId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lectues`
--
ALTER TABLE `lectues`
  ADD CONSTRAINT `lectues_ibfk_1` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `lectues_ibfk_2` FOREIGN KEY (`lecId`) REFERENCES `lecinfo` (`lecId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lecture`
--
ALTER TABLE `lecture`
  ADD CONSTRAINT `lecture_ibfk_1` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `lecture_ibfk_2` FOREIGN KEY (`lecId`) REFERENCES `lecinfo` (`lecId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `location_ibfk_2` FOREIGN KEY (`hallId`) REFERENCES `hallinfo` (`hallId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `overallessmarks`
--
ALTER TABLE `overallessmarks`
  ADD CONSTRAINT `overallessmarks_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `overallessmarks_ibfk_2` FOREIGN KEY (`subject`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `overallmarks`
--
ALTER TABLE `overallmarks`
  ADD CONSTRAINT `overallmarks_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `overallmarks_ibfk_2` FOREIGN KEY (`subCode`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `payments_ibfk_3` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `postgraduate`
--
ALTER TABLE `postgraduate`
  ADD CONSTRAINT `postgraduate_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `practicalmarks`
--
ALTER TABLE `practicalmarks`
  ADD CONSTRAINT `practicalmarks_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `practicalmarks_ibfk_2` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `practicals`
--
ALTER TABLE `practicals`
  ADD CONSTRAINT `practicals_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `practicals_ibfk_2` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `qulified`
--
ALTER TABLE `qulified`
  ADD CONSTRAINT `qulified_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ranking`
--
ALTER TABLE `ranking`
  ADD CONSTRAINT `ranking_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reportmarks`
--
ALTER TABLE `reportmarks`
  ADD CONSTRAINT `reportmarks_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reportmarks_ibfk_2` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reportsmarks`
--
ALTER TABLE `reportsmarks`
  ADD CONSTRAINT `reportsmarks_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reportsmarks_ibfk_2` FOREIGN KEY (`subCode`) REFERENCES `subject` (`subCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `undergraduate`
--
ALTER TABLE `undergraduate`
  ADD CONSTRAINT `undergraduate_ibfk_1` FOREIGN KEY (`regNo`) REFERENCES `student` (`regNO`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
