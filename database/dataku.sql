-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 18, 2024 at 01:17 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dataku`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int NOT NULL,
  `nama` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `alamat` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `nim` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `jurusan` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nama`, `alamat`, `nim`, `jurusan`) VALUES
(1, 'John Doe', 'Jl. Contoh No. 123', '12345', 'Informatika'),
(2, 'Jane Doe', 'Jl. Contoh No. 456', '54321', 'Sistem Informasi');

-- --------------------------------------------------------

--
-- Table structure for table `r_customer`
--

CREATE TABLE `r_customer` (
  `id` varchar(50) NOT NULL,
  `kode` varchar(50) DEFAULT NULL,
  `nama` varchar(200) DEFAULT NULL,
  `jenisid` varchar(50) DEFAULT NULL,
  `cp` varchar(50) DEFAULT NULL,
  `alamat` varchar(200) DEFAULT NULL,
  `telp` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `kota` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `jt` decimal(19,2) DEFAULT '0.00',
  `disc` decimal(19,2) DEFAULT '0.00',
  `AWAL` decimal(19,2) DEFAULT NULL,
  `Piutang` decimal(19,2) DEFAULT NULL,
  `Bayar` decimal(19,2) DEFAULT NULL,
  `Akhir` decimal(19,2) DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `userid` varchar(100) DEFAULT NULL,
  `pwd` varchar(200) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `r_dosen`
--

CREATE TABLE `r_dosen` (
  `id` varchar(60) NOT NULL DEFAULT '',
  `nip` varchar(60) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `tempat` varchar(255) DEFAULT NULL,
  `lahir` datetime DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `agama` varchar(20) DEFAULT NULL,
  `hp` varchar(255) DEFAULT NULL,
  `jabatan` varchar(200) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` varchar(255) DEFAULT NULL,
  `aktif` varchar(2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `r_mhs`
--

CREATE TABLE `r_mhs` (
  `nim` varchar(30) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  `prodi_id` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `pmb` varchar(1) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `tempat` varchar(255) DEFAULT NULL,
  `lahir` datetime DEFAULT NULL,
  `agama` varchar(15) DEFAULT NULL,
  `tahun` double DEFAULT NULL,
  `masuk_thn` int DEFAULT NULL,
  `semester` double DEFAULT NULL,
  `kelas_id` varchar(10) DEFAULT NULL,
  `jenjang_id` varchar(2) DEFAULT NULL,
  `dosen_id` varchar(30) DEFAULT NULL,
  `baru` varchar(1) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `photo_wisuda` varchar(255) DEFAULT NULL,
  `no_reg` varchar(255) DEFAULT NULL,
  `tgl` datetime DEFAULT NULL,
  `alamat_1` mediumtext,
  `telp_1` varchar(255) DEFAULT NULL,
  `sekolah` mediumtext,
  `kota` varchar(255) DEFAULT NULL,
  `prodi_id_1` varchar(20) DEFAULT NULL,
  `prodi_id_2` varchar(20) DEFAULT NULL,
  `bpk` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `alamat_2` mediumtext,
  `telp_2` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `referensi` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nik` varchar(30) NOT NULL,
  `income_id` varchar(2) NOT NULL,
  `sts_reg` varchar(100) DEFAULT NULL,
  `nisn` varchar(100) DEFAULT NULL,
  `kel` mediumtext,
  `kec` mediumtext,
  `kode_pos` varchar(50) DEFAULT NULL,
  `kipk` varchar(2) DEFAULT '0',
  `thn_lulus` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `r_pegawai`
--

CREATE TABLE `r_pegawai` (
  `id` varchar(60) NOT NULL DEFAULT '',
  `nip` varchar(60) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `tempat` varchar(255) DEFAULT NULL,
  `lahir` datetime DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `agama` varchar(20) DEFAULT NULL,
  `hp` varchar(255) DEFAULT NULL,
  `jabatan` varchar(200) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` varchar(255) DEFAULT NULL,
  `aktif` varchar(2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `r_supplier`
--

CREATE TABLE `r_supplier` (
  `id` int NOT NULL,
  `nama` varchar(200) DEFAULT NULL,
  `cp` varchar(200) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `telp` varchar(255) DEFAULT NULL,
  `kota` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `jt` decimal(19,0) DEFAULT '0',
  `disc` decimal(19,2) DEFAULT '0.00',
  `AWAL` decimal(19,4) DEFAULT NULL,
  `Hutang` decimal(19,4) DEFAULT NULL,
  `Bayar` decimal(19,4) DEFAULT NULL,
  `Akhir` decimal(19,4) DEFAULT NULL,
  `tgl` datetime DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `r_supplier`
--

INSERT INTO `r_supplier` (`id`, `nama`, `cp`, `alamat`, `telp`, `kota`, `fax`, `email`, `jt`, `disc`, `AWAL`, `Hutang`, `Bayar`, `Akhir`, `tgl`, `userid`) VALUES
(1, '1', '1', '1', '1', '1', '1', '1', 1, 1.00, 1.0000, 1.0000, 1.0000, 1.0000, '2069-11-05 00:00:00', NULL),
(17, 'Fyodor Edit', '12345', 'Jl. Contoh No. 123', '12345', 'Semarang', '024123', 'fyodor@gmail.com', 1, 0.50, 2.0000, 3.0000, 2.0000, 4.0000, '2024-05-07 00:00:00', NULL),
(39, 'Justin', NULL, 'Parepare', '082250064836', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(40, 'Jeremy', NULL, 'Jambi', '082142008052', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(41, 'Heather', NULL, 'Sukabumi', '089903009844', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(42, 'ANNNNNNN', NULL, 'Denpasar', '082883851523', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(43, 'Benjamin', NULL, 'Yogyakarta', '083714124557', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(44, 'Jason', NULL, 'Tual', '087501225048', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(45, 'Lindsay', NULL, 'Merauke', '089313582400', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(46, 'Anna', NULL, 'Purwokerto', '084792261890', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(47, 'Steven', NULL, 'Denpasar', '081365193880', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(48, 'Sara', NULL, 'Bengkulu', '083512553990', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(49, 'Travis', NULL, 'Ambarawa', '085563880459', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(50, 'Kyle', NULL, 'Kupang', '088055693561', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(51, 'Ashley', NULL, 'Pasuruan', '088881431710', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(52, 'David', NULL, 'Sijunjung', '086229535364', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(54, 'Stephanie', NULL, 'Tomohon', '089116314042', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(55, 'James', NULL, 'Palu', '084656628264', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(56, 'Alic', NULL, 'Tomohon', '081738187162', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(57, 'Katie', NULL, 'Cimahi', '085660178163', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(58, 'Kristen', NULL, 'Muna', '082876162361', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(59, 'Jason', NULL, 'Sorong', '087248274702', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(60, 'James', NULL, 'Pare-pare', '081685069705', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(61, 'Nicholas', NULL, 'Pematangsiantar', '086404040060', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(62, 'Jesse', NULL, 'Tapaktuan', '083528604782', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(63, 'Hannah', NULL, 'Tual', '089674467778', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(64, 'Peter', NULL, 'Pagar Alam', '087480949280', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(65, 'Christine', NULL, 'Lamongan', '085567915806', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(66, 'Kelly', NULL, 'Blitar', '085729104236', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(67, 'Brandon', NULL, 'Serang', '088217848761', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(68, 'Jamie', NULL, 'Jakarta', '083571487926', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(69, 'Stephanie', NULL, 'Padang Sidempuan', '084020475386', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(70, 'Steven', NULL, 'Madiun', '088562118536', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(71, 'Nicholas', NULL, 'Serang', '085945963687', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(72, 'Danielle', NULL, 'Mojokerto', '086545156787', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(73, 'Lauren', NULL, 'Samarinda', '084311996712', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(74, 'Katie', NULL, 'Sukabumi', '088979955817', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(75, 'Travis', NULL, 'Mojokerto', '084909956415', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(76, 'Cassandra', NULL, 'Ende', '087329992630', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(77, 'Benjamin', NULL, 'Pematang Siantar', '082166315789', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(78, 'Lindsay', NULL, 'Mojokerto', '084955155514', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(79, 'Heather', NULL, 'Banda Aceh', '088840266977', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(80, 'Lisa', NULL, 'Tasikmalaya', '087774402712', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(81, 'Ryan', NULL, 'Blitar', '086917570025', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(82, 'Brandi', NULL, 'Parepare', '086969446601', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(83, 'Joshua', NULL, 'Tabanan', '087362943245', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(84, 'Angela', NULL, 'Walawe', '087357304203', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(85, 'Jordan', NULL, 'Jambi', '087089339491', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(86, 'Andrea', NULL, 'Tebing Tinggi', '083235841620', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(87, 'Andrea', NULL, 'Blitar', '088111157199', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(88, 'Jose', NULL, 'Padang', '083142214994', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(89, 'Rebecca', NULL, 'Pontianak', '088319287116', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(90, 'Sara', NULL, 'Palopo', '089591174310', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(91, 'Jessica', NULL, 'Tidore Kepulauan', '087317332929', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(92, 'Katherine', NULL, 'Banjarmasin', '088442480368', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(93, 'Zach', NULL, 'semarang', '085406973710', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(95, 'Jamie', NULL, 'Bengkulu', '084092030957', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(96, 'Cassandra', NULL, 'Bangka', '088221225977', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(97, 'Katherine', NULL, 'Sukabumi', '085529963184', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(98, 'Lindsay', NULL, 'Batu', '082312151709', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(99, 'Heidi', NULL, 'Pekanbaru', '084342710276', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(100, 'Andrea', NULL, 'Tidore', '089798525693', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(101, 'April', NULL, 'Surakarta', '088122229505', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(102, 'Jason', NULL, 'Tarakan', '085167474169', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(103, 'Amanda', NULL, 'Tapaktuan', '084462743462', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(104, 'Emily', NULL, 'Kefamenanu', '085081714268', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(105, 'Kimberly', NULL, 'Tanjungpinang', '084916528888', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(106, 'Michelle', NULL, 'Bima', '083450591187', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(107, 'Brandon', NULL, 'Rote Ndao', '088455958983', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(108, 'Lauren', NULL, 'Bukittinggi', '087724581051', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(109, 'Jesse', NULL, 'Bukittinggi', '086416667601', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(110, 'Julie', NULL, 'Denpasar', '087418571234', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(111, 'Joseph', NULL, 'Palangkaraya', '081737577788', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(112, 'Travis', NULL, 'Pangkalpinang', '083479414388', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(113, 'Lindsay', NULL, 'Lamongan', '087393235810', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(114, 'Cassandra', NULL, 'Denpasar', '088286565132', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(115, 'Jared', NULL, 'Bangka', '082947859861', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(116, 'Anthony', NULL, 'Kendari', '087601088754', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(117, 'Danielle', NULL, 'Malang', '088072634306', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(118, 'Jennifer', NULL, 'Padang', '089888448021', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(119, 'Megan', NULL, 'Takalar', '081246158888', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(120, 'Jason', NULL, 'Sijunjung', '088923508613', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(121, 'Erin', NULL, 'Semarang', '083145547487', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(122, 'Gregory', NULL, 'Tarakan', '085053808180', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(123, 'Christina', NULL, 'Tasikmalaya', '087864954536', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(124, 'Kevin', NULL, 'Sawahlunto', '087773676825', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(125, 'Christopher', NULL, 'Tual', '089275607611', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(126, 'Vanessa', NULL, 'Makassar', '082404143767', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(127, 'Erin', NULL, 'Dumai', '081942755044', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(128, 'Paul', NULL, 'Semarang', '081112375946', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(129, 'Andrea', NULL, 'Palu', '088760873558', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(130, 'William', NULL, 'Bangka', '085528623498', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(131, 'James', NULL, 'Sumbawa Besar', '086251366569', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(132, 'Joseph', NULL, 'Yogyakarta', '083979402899', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(133, 'Kristin', NULL, 'Waingapu', '084881609330', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(134, 'Laura', NULL, 'Tidore Kepulauan', '084493820941', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(135, 'Adam', NULL, 'Palopo', '087382861130', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(136, 'Kelly', NULL, 'Blitar', '083611165682', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(137, 'Andrew', NULL, 'Sukabumi', '088400210509', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(138, 'Nicole', NULL, 'Tual', '087713798155', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(139, 'Justin', NULL, 'Banda Aceh', '084680306528', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(140, 'Andrew', NULL, 'Tomohon', '081246896214', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(141, 'Amber', NULL, 'Tarakan', '087301791611', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(142, 'Vanessa', NULL, 'Sawahlunto', '081325534612', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(143, 'Katherine', NULL, 'Jambi', '082377039035', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(144, 'Bryan', NULL, 'Samarinda', '082460250065', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(245, 'zxcz', NULL, NULL, '123', '123123', NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(146, 'Sean', NULL, 'Palangkaraya', '089194127335', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(147, 'Julie', NULL, 'Rote Ndao', '086617728371', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(148, 'Amanda', NULL, 'Pangkal Pinang', '087026725595', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(149, 'Brittany', NULL, 'Tidore', '089659557359', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(150, 'Heather', NULL, 'Banjarmasin', '085034068034', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(151, 'Kristina', NULL, 'Lhokseumawe', '087972678363', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(152, 'Jason', NULL, 'Padang Sidempuan', '087039913419', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(244, 'testtestes', NULL, 'test', '1234', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(154, 'April', NULL, 'Makassar', '087009250927', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(155, 'Kimberly', NULL, 'Tegal', '086894985514', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(156, 'Michael', NULL, 'Medan', '083455576955', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(157, 'Kyle', NULL, 'Bandar Lampung', '088712233455', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(158, 'Brittany', NULL, 'Palopo', '084042278272', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(159, 'Amber', NULL, 'Pematangsiantar', '081600787888', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(160, 'Travis', NULL, 'Dumai', '089284112382', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(161, 'Mary', NULL, 'Padangpanjang', '081683671471', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(162, 'Kristen', NULL, 'Tegal', '088086751459', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(163, 'Jeremy', NULL, 'Bogor', '084462607659', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(164, 'Thomas', NULL, 'Muna', '083301572277', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(165, 'Kelly', NULL, 'Pontianak', '084811585020', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(166, 'Erica', NULL, 'Ende', '088735451738', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(167, 'Amandajbkjkjhk', NULL, 'Palu', '082089139423', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(168, 'Brandon', NULL, 'Probolinggo', '083503318952', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(169, 'Kristen', NULL, 'Singkawang', '085609410117', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(170, 'Anthony', NULL, 'Samarinda', '086436442594', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(247, 'Fyodor Dostoevsky', '12345', 'Jl. Contoh No. 123', '08123456', 'Semarang', '024123', 'fyodor@gmail.com', 1, 0.50, 2.0000, 3.0000, 2.0000, 4.0000, NULL, NULL),
(172, 'Michelle', NULL, 'Kendari', '085027602326', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(173, 'Patrick', NULL, 'Tidore Kepulauan', '084480480426', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(174, 'Nicholas', NULL, 'Padang', '087578239675', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(175, 'Timothy', NULL, 'Bekasi', '088661700230', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(176, 'Jennifer', NULL, 'Sawahlunto', '085038500675', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(177, 'Vanessa', NULL, 'Banjarmasin', '083120908095', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(178, 'Rebecca', NULL, 'Pematang Siantar', '086508959347', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(179, 'Amy', NULL, 'Malang', '085132777580', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(180, 'Julie', NULL, 'Takalar', '087785294071', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(181, 'Heidi', NULL, 'Tarakan', '088996288798', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(182, 'Katherine', NULL, 'Padang', '082199773911', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(183, 'Brian', NULL, 'Bandar Lampung', '089523901116', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(184, 'Courtney', NULL, 'Palu', '085744288714', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(185, 'Kristina', NULL, 'Banjarmasin', '088680648391', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(186, 'Christine', NULL, 'Bitung', '086699635333', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(187, 'Danielle', NULL, 'Blitar', '089248021755', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(188, 'Jason', NULL, 'Banyuwangi', '083274352740', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(189, 'Adam', NULL, 'Takalar', '084804546556', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(190, 'Matthew', NULL, 'Bengkulu', '089852013920', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(191, 'Jared', NULL, 'Lhokseumawe', '082582328433', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(192, 'Christina', NULL, 'Depok', '082918990889', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(193, 'David', NULL, 'Lamongan', '085680847872', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(194, 'Thomas', NULL, 'Sungai Penuh', '089792978636', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(195, 'Tiffany', NULL, 'Palangkaraya', '088601443050', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(196, 'Brian', NULL, 'Lamongan', '083577124337', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(197, 'Julie', NULL, 'Palopo', '084985216950', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(198, 'Jose', NULL, 'Sungailiat', '088617187685', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(199, 'Lindsey', NULL, 'Tarakan', '083360289025', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(200, 'Jordan', NULL, 'Bontang', '087679885774', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(201, 'Mary', NULL, 'Medan', '087316434776', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(202, 'Brandi', NULL, 'Tanjungbalai', '083250230696', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(203, 'Kenneth', NULL, 'Tanjungbalai', '083960661627', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(204, 'Megan', NULL, 'Tangerang Selatan', '086511419444', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(205, 'Tara', NULL, 'Sawahlunto', '085571876430', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(206, 'Katie', NULL, 'Sungai Penuh', '087741898557', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(207, 'Jeremy', NULL, 'Banda Aceh', '087085194733', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(208, 'Timothy', NULL, 'Dompu', '086363757039', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(246, 'Faizal', NULL, 'Semarang', '09123456', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(210, 'Kristina', NULL, 'Banda Aceh', '085257622188', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(211, 'Erin', NULL, 'Manado', '085263901420', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(212, 'Kelly', NULL, 'Singkawang', '082228703720', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(213, 'Lauren', NULL, 'Manado', '088300325187', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(214, 'Justin', NULL, 'Tangerang', '088806100328', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(243, 'f', NULL, 'f', '1', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(216, 'Michael', NULL, 'Kupang', '087307999745', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(217, 'Emily', NULL, 'Blitar', '086674545033', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(218, 'Ashley', NULL, 'Bukittinggi', '089826406153', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(219, 'Adam', NULL, 'Tarakan', '084553674850', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(220, 'Christina', NULL, 'Malang', '086923059850', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(221, 'Erica', NULL, 'Lhokseumawe', '087375555928', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(223, 'Daniel', NULL, 'Padang', '089307541818', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(224, 'Michael', NULL, 'Jakarta', '088241490451', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(225, 'Lindsey', NULL, 'Sorong', '088925393783', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(226, 'Heidi', NULL, 'Tarakan', '086249094328', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(227, 'Andrea', NULL, 'Palopo', '086494960594', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(228, 'Timothy', NULL, 'Sungailiat', '087708900349', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(229, 'Alicia', NULL, 'Surabaya', '086533241798', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(230, 'Daniel', NULL, 'Tidore', '082655853537', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(231, 'Heather', NULL, 'Tanjungpinang', '087849558518', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(232, 'Kath', NULL, 'Medan', '081267426697', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(233, 'Sean', NULL, 'Manado', '089603280481', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(234, 'Chris', NULL, 'Batam', '083289579275', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(235, 'Robert', NULL, 'Banda Aceh', '086266874580', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(236, 'Lindsey', NULL, 'Batam', '082166039810', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(237, 'Amanda', NULL, 'Padangpanjang', '081741687168', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(238, 'Travis', NULL, 'Banda Aceh', '084512708753', 'z', NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL),
(240, 'Tet', NULL, 'test', '1', NULL, NULL, NULL, 0, 0.00, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `t_pmb`
--

CREATE TABLE `t_pmb` (
  `no_reg` varchar(50) NOT NULL,
  `tgl` date NOT NULL,
  `nama` varchar(200) NOT NULL,
  `tempat` varchar(200) NOT NULL,
  `lahir` date NOT NULL,
  `sex` varchar(20) NOT NULL,
  `agama` varchar(20) NOT NULL,
  `alamat_1` mediumtext NOT NULL,
  `telp_1` varchar(200) NOT NULL,
  `sekolah` mediumtext NOT NULL,
  `kota` varchar(200) NOT NULL,
  `prodi_id_1` varchar(20) NOT NULL,
  `prodi_id_2` varchar(50) NOT NULL,
  `kelas_id` varchar(2) NOT NULL,
  `bpk` varchar(200) NOT NULL,
  `ibu` varchar(200) NOT NULL,
  `alamat_2` mediumtext NOT NULL,
  `telp_2` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `status` varchar(1) NOT NULL,
  `referensi` mediumtext NOT NULL,
  `prodi_id` varchar(20) NOT NULL,
  `pmb` varchar(2) NOT NULL,
  `nik` varchar(30) NOT NULL,
  `income_id` varchar(2) NOT NULL,
  `nisn` varchar(100) DEFAULT NULL,
  `kel` mediumtext,
  `kec` mediumtext,
  `kode_pos` varchar(50) DEFAULT NULL,
  `kipk` varchar(2) DEFAULT '0',
  `thn_lulus` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `r_customer`
--
ALTER TABLE `r_customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `CustomerID` (`id`),
  ADD KEY `UserID` (`userid`);

--
-- Indexes for table `r_dosen`
--
ALTER TABLE `r_dosen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `r_mhs`
--
ALTER TABLE `r_mhs`
  ADD PRIMARY KEY (`nim`),
  ADD KEY `nim` (`nim`);

--
-- Indexes for table `r_pegawai`
--
ALTER TABLE `r_pegawai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `r_supplier`
--
ALTER TABLE `r_supplier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `SupplierID` (`id`),
  ADD KEY `UserID` (`userid`);

--
-- Indexes for table `t_pmb`
--
ALTER TABLE `t_pmb`
  ADD PRIMARY KEY (`no_reg`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `r_supplier`
--
ALTER TABLE `r_supplier`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=248;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
