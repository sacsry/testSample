CREATE DATABASE `sampledb` /*!40100 DEFAULT CHARACTER SET euckr */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `map` (
  `맵이름` text NOT NULL,
  `Terran` int NOT NULL,
  `Z1` int NOT NULL,
  `Zerg` int NOT NULL,
  `P1` int NOT NULL,
  `Protoss` int NOT NULL,
  `T1` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
CREATE TABLE `recorddata12` (
  `검색선수` varchar(45) DEFAULT NULL,
  `검색선수종족` varchar(45) DEFAULT NULL,
  `상대선수` varchar(45) DEFAULT NULL,
  `상대선수종족` varchar(45) DEFAULT NULL,
  `맵` varchar(45) DEFAULT NULL,
  `결과` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `등급` text,
  `승` int DEFAULT NULL,
  `패` int DEFAULT NULL,
  `vsT승` int DEFAULT NULL,
  `vsT패` int DEFAULT NULL,
  `vsZ승` int DEFAULT NULL,
  `vsZ패` int DEFAULT NULL,
  `vsP승` int DEFAULT NULL,
  `vsP패` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
