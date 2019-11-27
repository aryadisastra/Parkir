-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2019 at 01:36 PM
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
-- Table structure for table `harga`
--

CREATE TABLE IF NOT EXISTS `harga` (
  `kode_harga` varchar(5) NOT NULL DEFAULT '',
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harga`
--

INSERT INTO `harga` (`kode_harga`, `harga`) VALUES
('H2019', 2000),
('H2020', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `level`
--

CREATE TABLE IF NOT EXISTS `level` (
  `kode_level` varchar(10) NOT NULL DEFAULT '',
  `level` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `level`
--

INSERT INTO `level` (`kode_level`, `level`) VALUES
('ADM002', 'Petugas'),
('KRY003', 'Karyawan'),
('MNJ001', 'Manager');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

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
(27, '20/04/2019 - 17:33:12', '20/04/2019 - 17:39:03', '', 'H2020');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE IF NOT EXISTS `petugas` (
  `id_petugas` varchar(10) NOT NULL DEFAULT '',
  `nama` varchar(40) DEFAULT NULL,
  `kode_level` varchar(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `ttl` text,
  `no_hp` varchar(12) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `alamat` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama`, `kode_level`, `gender`, `ttl`, `no_hp`, `email`, `alamat`) VALUES
('11111', 'Arya Disastra', 'MNJ001', 'Laki-Laki', '2002-09-09', '089697457066', 'aryadisastra63', 'kp.lapang'),
('22222', 'Bintang Permana Putra', 'ADM002', 'Laki-Laki', '2002-10-01', '', 'bintangpe919@gmail.com', 'Sariwangi'),
('33333', 'Bima Sakti Ramdani', 'KRY003', 'Laki-Laki', '2001-10-02', '', 'Bimaaveiro@gmail.com', 'Batujajar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `harga`
--
ALTER TABLE `harga`
 ADD PRIMARY KEY (`kode_harga`);

--
-- Indexes for table `level`
--
ALTER TABLE `level`
 ADD PRIMARY KEY (`kode_level`);

--
-- Indexes for table `parkir`
--
ALTER TABLE `parkir`
 ADD PRIMARY KEY (`no_tiket`,`id_petugas`,`kode_harga`), ADD KEY `id_petugas` (`id_petugas`), ADD KEY `kode_harga` (`kode_harga`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
 ADD PRIMARY KEY (`id_petugas`), ADD KEY `kode_level` (`kode_level`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `parkir`
--
ALTER TABLE `parkir`
MODIFY `no_tiket` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `parkir`
--
ALTER TABLE `parkir`
ADD CONSTRAINT `parkir_ibfk_2` FOREIGN KEY (`kode_harga`) REFERENCES `harga` (`kode_harga`);

--
-- Constraints for table `petugas`
--
ALTER TABLE `petugas`
ADD CONSTRAINT `petugas_ibfk_1` FOREIGN KEY (`kode_level`) REFERENCES `level` (`kode_level`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
