-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 02, 2022 at 12:27 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lab5`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(2, 'newadmin', 'newadmin');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `room` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `room`, `name`) VALUES
(1, 'A100', 'Phòng Cơ sở vật chất'),
(2, 'A101', 'Phòng Công tác Sinh viên'),
(3, 'A102', 'Phòng Đào tạo'),
(4, 'A103', 'Phòng Kế hoạch - Tài chính'),
(5, 'A104', 'Phòng Khảo thí và Đảm bảo chất lượng GD'),
(6, 'A105', 'Phòng Khoa học Công nghệ - Hợp tác quốc tế'),
(7, 'A106', 'Phòng Thanh tra Pháp chế'),
(8, 'A107', 'Phòng Tổ chức - Hành chính'),
(9, 'A108', 'Phòng Nghiên cứu thí nghiệm Khoa học'),
(10, 'A109', 'Phòng Trao thưởng và trao bằng khen');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `departmentId` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `email`, `phone`, `address`, `departmentId`, `image`) VALUES
('NV001', 'Nguyễn Tấn Khôi', 'ntkhoi@dut.udn.vn', '0903511888', 'Đà Nẵng', 1, 'http://dut.udn.vn/Files/k.cntt/images/Gioithieu/NTKhoi.jpg'),
('NV002', 'Đặng Hoài Phương', 'dhphuong@dut.udn.vn', '0935578555', 'Đà Nẵng', 2, 'http://dut.udn.vn/Files/k.cntt/images/Gioithieu/DHPhuong.jpg'),
('NV003', 'Phạm Minh Tuấn', 'pmtuan@dut.udn.vn', '0913230910', 'Đà Nẵng', 3, 'http://dut.udn.vn/Files/k.cntt/images/Gioithieu/PMTuan.jpg'),
('NV004', 'Hoàng Thị Hương', 'huongcnttbk@gmail.com', '0902023000', 'Đà Nẵng', 4, 'http://dut.udn.vn/images/Canbo/131.012.00238.jpg'),
('NV005', 'Nguyễn Văn Hiệu', 'nvhieuqt@dut.udn.vn', '0367997777', 'Đà Nẵng', 5, 'http://dut.udn.vn/Files/k.cntt/images/Gioithieu/NVHieu.jpg'),
('NV006', 'Đỗ Thị Tuyết Hoa', 'dtthoa@dut.udn.vn', '0935678198', 'Đà Nẵng', 6, 'http://dut.udn.vn/images/Canbo/131.012.00240.jpg'),
('NV007', 'Võ Đức Hoàng', 'hoangvd.it@dut.udn.vn', '0906477283', 'Đà Nẵng', 7, 'http://dut.udn.vn/images/Canbo/vo_duc_hoang1.jpg'),
('NV008', 'Ninh Khánh Duy', 'nkduy@dut.udn.vn', '0935043201', 'Đà Nẵng', 8, 'http://dut.udn.vn/Files/k.cntt/images/Gioithieu/NKDuy.png'),
('NV009', 'Lê Trần Đức', 'letranduc@dut.udn.vn', '0931733853', 'Đà Nẵng', 9, 'http://scv.udn.vn/anh/2019/7250-2019m08d08_9_7_36.jpg'),
('NV010', 'Bùi Thị Thanh Thanh', 'bttthanh@dut.udn.vn', '0935825915', 'Đà Nẵng', 10, 'http://dut.udn.vn/images/Canbo/10960.jpg'),
('NV011', 'Mai Văn Hà', 'mvha@dut.udn.vn', '0905161888', 'Đà Nẵng', 8, 'http://dut.udn.vn/images/Canbo/Mai%20Van%20Ha.png'),
('NV012', 'Huỳnh Hữu Hưng', 'hhhung@dut.udn.vn', '0905444669', 'Đà Nẵng', 1, 'http://dut.udn.vn/images/Canbo/huynh_huu_hung.jpg'),
('NV013', 'Trần Hồ Thủy Tiên', 'thttien@dut.udn.vn', '0983461008', 'Đà Nẵng', 6, 'http://dut.udn.vn/images/Canbo/1175-tran_ho_thuy_tien.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_employee_department` (`departmentId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_employee_department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
