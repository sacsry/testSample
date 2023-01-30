CREATE DATABASE `sampledb` /*!40100 DEFAULT CHARACTER SET euckr */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `teamrecord` (
  `팀이름` varchar(45) DEFAULT NULL,
  `팀승수` int DEFAULT NULL,
  `팀패배` int DEFAULT NULL,
  `세트승` int DEFAULT NULL,
  `세트패` int DEFAULT NULL,
  `득실차` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
