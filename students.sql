-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2024 at 09:59 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `RegNo` varchar(25) NOT NULL,
  `Math` int(50) NOT NULL,
  `Java` int(30) NOT NULL,
  `Php` int(24) NOT NULL,
  `Average` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `Name`, `RegNo`, `Math`, `Java`, `Php`, `Average`) VALUES
(1, 'ddd', 'sss', 0, 0, 0, 0),
(2, 'iiii', 'kl', 0, 0, 0, 0),
(3, 'Innocent', '22RP02338', 40, 24, 22, 0),
(4, 'Devcent', '22rp02338', 34, 56, 32, 41),
(5, 'Innocent', '22RP02338', 18, 54, 89, 54),
(6, 'Me', '44', 44444444, 89, 76, 14814870),
(7, 'me', '22RP02338', 45, 79, 90, 71),
(8, 'Amie', '22rp0324', 23, 45, 67, 45),
(9, 'manzi', '22rp08209', 50, 90, 100, 80),
(10, 'Devcentt', '22rp02338', 36, 34, 77, 49);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
