-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2019 at 09:04 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `parkir`
--

-- --------------------------------------------------------

--
-- Table structure for table `parkir`
--

CREATE TABLE IF NOT EXISTS `parkir` (
`no_tiket` int(11) NOT NULL,
  `jam_masuk` text,
  `jam_keluar` text,
  `id_petugas` varchar(10) NOT NULL DEFAULT '',
  `kode_harga` varchar(5) NOT NULL DEFAULT ''
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Dumping data for table `parkir`
--

INSERT INTO `parkir` (`no_tiket`, `jam_masuk`, `jam_keluar`, `id_petugas`, `kode_harga`) VALUES
(1, '19/04/2019 - 11:52:48', '20/04/2019 - 15:04:38', '', 'H2019'),
(2, '19/04/2019 - 16:24:26', '20/04/2019 - 15:05:16', '', 'H2020'),
(3, '19/04/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(7, '19/04/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(8, '19/04/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(9, '19/04/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(10, '19/04/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(11, '19/04/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(12, '19/04/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(13, '19/04/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(14, '19/04/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(15, '19/05/2019 - 16:26:45', '20/04/2019 - 15:05:59', '', 'H2020'),
(17, '20/04/2019 - 16:23:55', '20/04/2019 - 17:39:03', '11111', 'H2020'),
(18, '20/04/2019 - 16:23:55', '20/04/2019 - 17:39:03', '11111', 'H2020'),
(19, '20/04/2019 - 16:25:19', '20/04/2019 - 17:39:03', '11111', 'H2020'),
(20, '20/04/2019 - 16:26:12', '20/04/2019 - 17:39:03', '11111', 'H2020'),
(21, '20/04/2019 - 17:17:41', '20/04/2019 - 17:39:03', '', 'H2020'),
(22, '20/04/2019 - 17:17:41', '20/04/2019 - 17:39:03', '', 'H2020'),
(23, '20/04/2019 - 17:19:09', '20/04/2019 - 17:39:03', '', 'H2020'),
(24, '20/04/2019 - 17:20:30', '20/04/2019 - 17:39:03', '', 'H2020'),
(25, '20/04/2019 - 17:21:02', '20/04/2019 - 17:39:03', '', 'H2020'),
(26, '20/04/2019 - 17:28:01', '20/04/2019 - 17:39:03', '', 'H2020'),
(27, '20/04/2019 - 17:33:12', '20/04/2019 - 17:39:03', '', 'H2020'),
(28, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(29, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(30, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(31, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(32, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(33, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(34, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(35, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(36, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(37, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(38, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(39, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(40, '21/04/2019 - 13:39:41', '', '', 'H2020'),
(41, '21/04/2019 - 13:44:36', '', '', 'H2020'),
(42, '21/04/2019 - 13:50:12', '', '', 'H2020'),
(43, '21/04/2019 - 13:52:25', '', '', 'H2020');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `parkir`
--
ALTER TABLE `parkir`
 ADD PRIMARY KEY (`no_tiket`,`id_petugas`,`kode_harga`), ADD KEY `id_petugas` (`id_petugas`), ADD KEY `kode_harga` (`kode_harga`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `parkir`
--
ALTER TABLE `parkir`
MODIFY `no_tiket` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=44;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `parkir`
--
ALTER TABLE `parkir`
ADD CONSTRAINT `parkir_ibfk_2` FOREIGN KEY (`kode_harga`) REFERENCES `harga` (`kode_harga`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
