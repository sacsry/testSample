CREATE DATABASE `sampledb` /*!40100 DEFAULT CHARACTER SET euckr */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `sunsu_data` (
  `순위` int DEFAULT NULL,
  `이름` text,
  `종족` text,
  `팀` text,
  `sum` int DEFAULT NULL,
  `센스` int DEFAULT NULL,
  `컨트롤` int DEFAULT NULL,
  `공격력` int DEFAULT NULL,
  `전략` int DEFAULT NULL,
  `물량` int DEFAULT NULL,
  `수비력` int DEFAULT NULL,
  `등급` text
) ENGINE=InnoDB DEFAULT CHARSET=euckr;

