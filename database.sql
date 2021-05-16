/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.27-community-nt : Database - smsportal
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smsportal` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `smsportal`;

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `id` int(11) NOT NULL,
  `branchName` varchar(255) default NULL,
  `branchDescription` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `branch` */

insert  into `branch`(`id`,`branchName`,`branchDescription`) values (1,'CE','Computer Engineering'),(2,'ME','Mechanical Engineering'),(3,'EE','Electrical Engineering'),(4,'Civil','Civil Engineering'),(5,'EC','Electronics & Communication Engineering'),(6,'Principal','Principal\r\n');

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `id` int(11) NOT NULL,
  `className` varchar(255) default NULL,
  `classDescription` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `class` */

insert  into `class`(`id`,`className`,`classDescription`) values (1,'16CE1','Computer Engineering ,  2016 batch , Class - 1'),(2,'16CES','Computer Engineering ,  2016 batch , Second Shift class '),(3,'17CE1','Computer Engineering ,  2017 batch , Class - 1'),(4,'17CE2','Computer Engineering ,  2017 batch , Class - 2'),(5,'16ME1','Mechanical Engineering ,  2016 batch , Class - 1'),(6,'16ME2','Mechanical Engineering ,  2016 batch , Class - 2'),(7,'16CE2','Computer Engineering ,  2016 batch , Class - 2\r\n'),(8,'18EE2','Electrical Engineering ,  2018 batch , Class - 1');

/*Table structure for table `complain` */

DROP TABLE IF EXISTS `complain`;

CREATE TABLE `complain` (
  `id` int(11) NOT NULL,
  `complainSubject` varchar(255) default NULL,
  `complainDescription` varchar(255) default NULL,
  `complainDate` varchar(255) default NULL,
  `complainReply` varchar(255) default NULL,
  `complainReplyDate` varchar(255) default NULL,
  `complainStatus` varchar(255) default NULL,
  `loginId` int(11) default NULL,
  `complainFileName` varchar(255) default NULL,
  `complainFilePath` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKDC4520E91A0477D1` (`loginId`),
  CONSTRAINT `FKDC4520E91A0477D1` FOREIGN KEY (`loginId`) REFERENCES `login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `complain` */

insert  into `complain`(`id`,`complainSubject`,`complainDescription`,`complainDate`,`complainReply`,`complainReplyDate`,`complainStatus`,`loginId`,`complainFileName`,`complainFilePath`) values (14,'Quick SMS','It takes time in loading.','22/03/2019 07:55:25','Solved.','22/03/2019 07:55:42','RESOLVED',6,'','E:\\Yash\\Workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\smsportal\\doc\\complain\\'),(15,'Dynamic SMS','Can you tell me which file should I upload while sending dynamic SMS.','23/03/2019 02:36:00','Use \'.csv\' File.','24/03/2019 12:46:16','RESOLVED',6,'blanck logo.png','E:\\Yash\\Workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\smsportal\\doc\\complain\\'),(17,'Personal','Please change my email to xyz@gmail.com.','25/03/2019 02:02:06','','','PENDING',5,'',NULL),(18,'sende id','i want ... sender id','25/03/2019 10:58:25','okay','25/03/2019 10:58:48','RESOLVED',5,'','');

/*Table structure for table `designation` */

DROP TABLE IF EXISTS `designation`;

CREATE TABLE `designation` (
  `id` int(11) NOT NULL,
  `designationName` varchar(255) default NULL,
  `designationDescription` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `designation` */

insert  into `designation`(`id`,`designationName`,`designationDescription`) values (1,'Lecturer','Lecturer'),(2,'HOD','Head of the Department'),(4,'Principal','Principal');

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `feedbackId` int(11) NOT NULL,
  `feedbackSubject` varchar(255) default NULL,
  `feedbackDescription` varchar(255) default NULL,
  `starRating` int(11) default NULL,
  `loginId` int(11) default NULL,
  PRIMARY KEY  (`feedbackId`),
  KEY `FKF495EB851A0477D1` (`loginId`),
  CONSTRAINT `FKF495EB851A0477D1` FOREIGN KEY (`loginId`) REFERENCES `login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `feedback` */

insert  into `feedback`(`feedbackId`,`feedbackSubject`,`feedbackDescription`,`starRating`,`loginId`) values (1,'Dynamic SMS','Great Logic',5,19),(2,'Group SMS','Nice.',4,6),(3,'Dashboard','Nice work on Statistics',4,5),(4,'Test','Test',3,6),(5,'Test','Test',3,19),(6,'nnn','nnn',3,19),(11,'Dynamic SMS ','The Logic is amazing.',5,5);

/*Table structure for table `futuresms` */

DROP TABLE IF EXISTS `futuresms`;

CREATE TABLE `futuresms` (
  `futureSmsId` int(11) NOT NULL,
  `mobile` varchar(255) default NULL,
  `message` varchar(255) default NULL,
  `senderId` varchar(255) default NULL,
  `timestamp` bigint(20) default NULL,
  `isSent` varchar(255) default NULL,
  `loginId` int(11) default NULL,
  PRIMARY KEY  (`futureSmsId`),
  KEY `FK539D3C961A0477D1` (`loginId`),
  CONSTRAINT `FK539D3C961A0477D1` FOREIGN KEY (`loginId`) REFERENCES `login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `futuresms` */

insert  into `futuresms`(`futureSmsId`,`mobile`,`message`,`senderId`,`timestamp`,`isSent`,`loginId`) values (4,'9016770303','happy birthday','VPMPIN',1552489980000,'yes',5),(6,'8460674501','happy birthday','VPMPPT',1552567680000,'yes',5),(8,'8460674501','happy birthday','VPMPPT',1552714860000,'yes',5),(9,'8460674501','happy birthday','VPMPIN',1552533900000,'yes',5),(10,'8460674501','kkkkkkkkkk','VPMPCE',1552910520000,'yes',5),(11,'8460674501','hello','kushal',1552911300000,'yes',5),(12,'8460674501','hey','VPMPPT',1553027460000,'yes',12),(13,'9638872404','happy birthday','VPMPCE',1553054220000,'yes',5),(14,'9426622485','hey','VPMPCE',1553067660000,'yes',13),(15,'8460674501','happy birthday','VPMPPT',1553068320000,'yes',13),(16,'9016770303','hello','kushal',1553203680000,'yes',5),(17,'8460674501','test test test ','VPMPCE',1553243460000,'yes',5),(18,'8460674501','hey','VPMPPT',1553344440000,'yes',5),(19,'8460674501','hello bro','VPMPPT',1553326080000,'yes',5),(20,'8460674501','hey uthi ja','VPMPIN',1553370360000,'yes',5),(21,'9016770303','hello, how are you?','VPMPPT',1553370600000,'yes',5),(22,'9016770303','happy birthday','VPMPCE',1553371620000,'yes',5),(23,'8460674501','happy birthday','VPMPCE',1553371620000,'yes',5),(24,'9016770303','test test test ','VPMPME',1553415720000,'yes',5),(25,'8460674501','test test test ','VPMPME',1553415720000,'yes',5),(26,'9016770303','Tomorrow is test of AJAVA unit - 5.','VPMPPT',1553374320000,'yes',5),(27,'8460674501','Tomorrow is test of AJAVA unit - 5.','VPMPPT',1553374320000,'yes',5),(28,'9228455528','test test test ','VPMPCE',1553491980000,'yes',5);

/*Table structure for table `groupmembers` */

DROP TABLE IF EXISTS `groupmembers`;

CREATE TABLE `groupmembers` (
  `groupMemberId` int(11) NOT NULL,
  `groupNameId` int(11) default NULL,
  `studentId` int(11) default NULL,
  PRIMARY KEY  (`groupMemberId`),
  KEY `FK23BAED9A8C7E05B5` (`studentId`),
  KEY `FK23BAED9AEBBA25DC` (`groupNameId`),
  CONSTRAINT `FK23BAED9A8C7E05B5` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`),
  CONSTRAINT `FK23BAED9AEBBA25DC` FOREIGN KEY (`groupNameId`) REFERENCES `groupnames` (`groupNameId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `groupmembers` */

insert  into `groupmembers`(`groupMemberId`,`groupNameId`,`studentId`) values (4,2,2),(5,2,3),(7,3,6),(8,3,10),(9,3,11),(10,3,12),(15,7,28),(16,7,29),(17,7,30),(18,7,31),(19,8,2),(20,8,3),(21,8,11),(22,8,12),(23,8,52),(24,8,54),(25,9,2),(26,9,3),(27,9,6),(28,9,10);

/*Table structure for table `groupnames` */

DROP TABLE IF EXISTS `groupnames`;

CREATE TABLE `groupnames` (
  `groupNameId` int(11) NOT NULL,
  `groupName` varchar(255) default NULL,
  `loginId` int(11) default NULL,
  PRIMARY KEY  (`groupNameId`),
  KEY `FK4B7928091A0477D1` (`loginId`),
  CONSTRAINT `FK4B7928091A0477D1` FOREIGN KEY (`loginId`) REFERENCES `login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `groupnames` */

insert  into `groupnames`(`groupNameId`,`groupName`,`loginId`) values (2,'b2 batch',5),(3,'b3 batch',5),(7,'b3 batch',13),(8,'b4 batch',5),(9,'b4 batch',5);

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `email` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `userRoll` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`id`,`email`,`password`,`userRoll`) values (1,'admin@admin.com','admin123','admin'),(2,'staff1@staff.com','staff123','staff'),(4,'staff3@staff.com','staff123','staff'),(5,'staff@staff.com','staff123','staff'),(6,'49yash@gmail.com','yash123','staff'),(9,'rupa@gmail.com','rupa123','staff'),(12,'yash9xm@gmail.com','yash9xm','staff'),(13,'vkmehta224@gmail.com','vkm123','staff'),(18,'49yash@gmail.com','yash','staff'),(19,'kushal@gmail.com','kushal123','staff'),(20,'staff@staff.com','staff','staff'),(21,'staff1@staff.com','staff','staff'),(22,'staff2@staff.com','staff123','staff'),(23,'staff3@staff.com','staff','staff'),(24,'patelanandpec@yahoo.co.in','003425','staff');

/*Table structure for table `semester` */

DROP TABLE IF EXISTS `semester`;

CREATE TABLE `semester` (
  `id` int(11) NOT NULL,
  `semesterNumber` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `semester` */

insert  into `semester`(`id`,`semesterNumber`) values (1,1),(2,2),(3,3),(4,4),(5,5),(6,6);

/*Table structure for table `senderid` */

DROP TABLE IF EXISTS `senderid`;

CREATE TABLE `senderid` (
  `id` int(11) NOT NULL,
  `senderIdName` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `senderid` */

insert  into `senderid`(`id`,`senderIdName`) values (1,'VPMPIN'),(2,'VPMPPT'),(4,'VPMPCE'),(5,'VPMPME'),(6,'VPMPEC'),(7,'VPMPEE'),(8,'VPMPCI');

/*Table structure for table `smshistory` */

DROP TABLE IF EXISTS `smshistory`;

CREATE TABLE `smshistory` (
  `smsHistoryId` int(11) NOT NULL,
  `mobileNo` longtext,
  `message` varchar(255) default NULL,
  `senderId` varchar(255) default NULL,
  `loginId` int(11) default NULL,
  `date` varchar(255) default NULL,
  PRIMARY KEY  (`smsHistoryId`),
  KEY `FK22C0B8FB1A0477D1` (`loginId`),
  CONSTRAINT `FK22C0B8FB1A0477D1` FOREIGN KEY (`loginId`) REFERENCES `login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `smshistory` */

insert  into `smshistory`(`smsHistoryId`,`mobileNo`,`message`,`senderId`,`loginId`,`date`) values (57,'8460674501','marks = 80 , result = fail ','VPMPPT',2,'19/03/2019 04:48:36 PM'),(58,'8460398440','marks = 70 , result = pass ','VPMPPT',2,'19/03/2019 04:48:37 PM'),(59,'8460674501','hey','VPMPPT',12,'20/03/2019 03:59:29 AM'),(60,'8460674501','hi yash , your result is = fail ','VPMPIN',6,'20/03/2019 09:00:52 AM'),(61,'9408226076','hi vatsa , your result is = pass ','VPMPIN',6,'20/03/2019 09:00:53 AM'),(62,'8000726709','test test test ','VPMPPT',6,'20/03/2019 09:22:40 AM'),(63,'9638872404','happy birthday','VPMPCE',6,'20/03/2019 09:27:56 AM'),(64,'8460674501','hello , marks = 90 , absent = yes ','VPMPIN',6,'20/03/2019 09:35:46 AM'),(65,'9408226076','hello , marks = 75 , absent = yes ','VPMPIN',6,'20/03/2019 09:35:47 AM'),(66,'9638872404','hello , marks = 85 , absent = no ','VPMPIN',6,'20/03/2019 09:35:48 AM'),(67,'8460674501,','hello','kushal',6,'20/03/2019 12:58:32 PM'),(70,'9016770303','hello','kushal',6,'22/03/2019 03:12:32 AM'),(71,'8460674501,','aaaaaaaaaaaaabbbbbbb','VPMPPT',6,'22/03/2019 04:26:43 PM'),(72,'8460674501','test test test ','VPMPCE',6,'22/03/2019 04:28:02 PM'),(73,'8460674501,8460674501,8460674501,','happy birthday','VPMPPT',6,'22/03/2019 04:39:55 PM'),(74,'846067450111','hey','VPMPIN',6,'22/03/2019 07:23:44 PM'),(75,'8460674501','sadas','ssssss',6,'23/03/2019 06:46:03 PM'),(76,'8460674501,','test test test ','Select Sender Id',6,'23/03/2019 06:59:27 PM'),(77,'8460674501,','test test test ','kushal',6,'23/03/2019 07:00:17 PM'),(78,'9016770303,8460674501,9228719900,9879171941,','fdf','selectSenderId',6,'23/03/2019 07:23:04 PM'),(79,'9016770303,8460674501,9228719900,9879171941,','lll','VPMPIN',6,'23/03/2019 07:24:19 PM'),(80,'8460674501','hey','VPMPPT',6,'23/03/2019 08:14:58 PM'),(81,'8460674501','hello bro','VPMPPT',6,'23/03/2019 08:19:58 PM'),(82,'','jj','VPMPPT',5,'23/03/2019 08:30:59 PM'),(83,'8460674501,9228719900,','hello','VPMPPT',5,'23/03/2019 08:40:41 PM'),(84,'9016770303','hello value 1   value 1   value 1 ','selectSenderId',5,'23/03/2019 09:26:43 PM'),(85,'9879171941','hello value N   value N   value N ','selectSenderId',5,'23/03/2019 09:26:44 PM'),(86,'9016770303','hello     value 1 value 1 value 1 ','VPMPPT',5,'23/03/2019 09:28:14 PM'),(87,'9879171941','hello     value N value N value N ','VPMPPT',5,'23/03/2019 09:28:15 PM'),(88,'8460674501','happy birthday','VPMPCE',5,'24/03/2019 01:09:13 AM'),(89,'9016770303,8460674501,','test test test ','VPMPCE',5,'24/03/2019 01:09:45 AM'),(90,'9016770303,8460674501,9228719900,9879171941,','good night','VPMPCE',5,'24/03/2019 01:10:32 AM'),(91,'8460674501','hey uthi ja','VPMPIN',5,'24/03/2019 01:16:22 AM'),(92,'9016770303','sui jao','VPMPPT',5,'24/03/2019 01:22:22 AM'),(93,'9016770303,8460674501,','test test test ','VPMPCE',5,'24/03/2019 01:25:46 AM'),(94,'9016770303','testing che aa to ok. :D','VPMPCE',5,'24/03/2019 01:37:02 AM'),(95,'8460674501','testing che aa to ok. :D','VPMPCE',5,'24/03/2019 01:37:03 AM'),(96,'8460674555,9016777894,','aje nathi ayo aa student :D','VPMPCE',5,'24/03/2019 01:40:41 AM'),(97,'9016770303','Dear kush , hello. ','VPMPIN',5,'24/03/2019 01:45:21 AM'),(98,'8460674501','Dear yash , hello. ','VPMPIN',5,'24/03/2019 01:45:22 AM'),(99,'9016770303','wqd','VPMPPT',5,'24/03/2019 02:22:02 AM'),(100,'8460674501','wqd','VPMPPT',5,'24/03/2019 02:22:03 AM'),(101,'8460674501','hello','VPMPPT',5,'24/03/2019 03:12:05 AM'),(102,'9016770303','test test test ','VPMPME',5,'24/03/2019 01:52:54 PM'),(103,'8460674501','test test test ','VPMPME',5,'24/03/2019 01:52:56 PM'),(104,'8460674501','&#2724;&#2734;&#2759; &#2709;&#2759;&#2734; &#2715;&#2763;','VPMPPT',5,'24/03/2019 08:31:27 PM'),(105,'8460674501','&#2724;&#2734;&#2759; &#2709;&#2759;&#2734; &#2715;&#2763;','VPMPCE',5,'24/03/2019 08:34:57 PM'),(106,'8460674501','&#2734;&#2750;&#2736;&#2755;  &#2728;&#2750;&#2734; &#2735;&#2742; &#2715;&#2759;.','VPMPPT',5,'24/03/2019 08:36:36 PM'),(107,'8460674501','test test test ','VPMPPT',5,'24/03/2019 08:49:06 PM'),(108,'8460674501,','happy birthday','16CE01',5,'25/03/2019 12:57:58 AM'),(109,'8460674501','Tomorrow is test of AJAVA unit - 5.','VPMPPT',5,'25/03/2019 01:48:42 AM'),(110,'9016770303','Tomorrow is test of AJAVA unit - 5.','VPMPPT',5,'25/03/2019 01:49:43 AM'),(111,'8460674501','Tomorrow is test of AJAVA unit - 5.','VPMPPT',5,'25/03/2019 01:49:43 AM'),(112,'7048453974','Hello , How are you?','VPMPCE',5,'25/03/2019 10:23:20 AM'),(113,'8460674501,8460674501,8460674501,8460674501,8460674501,9408226076,9408226076,9408226076,9408226076,9408226076,','hello ','VPMPPT',5,'25/03/2019 11:03:08 AM'),(114,'9228455528','test test test ','VPMPCE',5,'25/03/2019 11:03:41 AM'),(115,'8460674501','hello yash , your marks are 90 . ','VPMPPT',5,'25/03/2019 11:05:04 AM'),(116,'9408226076','hello vatsa , your marks are 75 . ','VPMPPT',5,'25/03/2019 11:05:05 AM'),(117,'8460674501','hello yash , marks = 90 , result= fail ','VPMPIN',5,'25/03/2019 11:43:03 AM'),(118,'9426679682','hello sp , marks = 100 , result= pass ','VPMPIN',5,'25/03/2019 11:43:05 AM');

/*Table structure for table `smstemplate` */

DROP TABLE IF EXISTS `smstemplate`;

CREATE TABLE `smstemplate` (
  `smsTemplateId` int(11) NOT NULL,
  `smsTemplateName` varchar(255) default NULL,
  `smsTemplateText` varchar(255) default NULL,
  `loginId` int(11) default NULL,
  PRIMARY KEY  (`smsTemplateId`),
  KEY `FK35D484F31A0477D1` (`loginId`),
  CONSTRAINT `FK35D484F31A0477D1` FOREIGN KEY (`loginId`) REFERENCES `login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `smstemplate` */

insert  into `smstemplate`(`smsTemplateId`,`smsTemplateName`,`smsTemplateText`,`loginId`) values (1,'hello','hhh',6),(2,'yyykk','kkkyyy',4),(4,'hhh111','111hhh',4),(5,'ppp','ppp',4),(6,'bday','happy birthday',5),(8,'test','test test test ',5),(9,'abc','abc abc abc',5),(11,'hbay','happy birthday',13),(12,'hello','Hello , How are you?',5);

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `staffId` int(11) NOT NULL,
  `staffFirstName` varchar(255) default NULL,
  `staffLastName` varchar(255) default NULL,
  `staffMobile` varchar(255) default NULL,
  `loginId` int(11) default NULL,
  `staffGender` varchar(255) default NULL,
  `staffDesignation` varchar(255) default NULL,
  `staffBranch` varchar(255) default NULL,
  `staffAddress` varchar(255) default NULL,
  PRIMARY KEY  (`staffId`),
  KEY `FK68AC2E01A0477D1` (`loginId`),
  CONSTRAINT `FK68AC2E01A0477D1` FOREIGN KEY (`loginId`) REFERENCES `login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `staff` */

insert  into `staff`(`staffId`,`staffFirstName`,`staffLastName`,`staffMobile`,`loginId`,`staffGender`,`staffDesignation`,`staffBranch`,`staffAddress`) values (6,'Rupa','Shah','9228719900',9,'female','Lecturer','CE','address'),(9,'Yash','Shah','8460674501',5,'male','Lecturer','CE','T/46 Manmohan Apartment, near subhash-bridge, Ahmedabad - 380027'),(10,'Kushal','Shah','9016770123',19,'male','HOD','ME','address'),(11,'Staff','Staff','1234567890',6,'male','HOD','CE','address'),(12,'Staff1','Staff1','9874563210',2,'female','Lecturer','civil','address'),(13,'Staff2','Staff2','7894568795',22,'male','Lecturer','EE','address'),(14,'Staff3','Staff3','6547898558',4,'male','HOD','EE','address'),(15,'Dr. Anand','Patel','9228455528',24,'male','Principal','Principal','Address.');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentId` int(11) NOT NULL,
  `studentFirstName` varchar(255) default NULL,
  `studentLastName` varchar(255) default NULL,
  `studentMobile` varchar(255) default NULL,
  `studentEmail` varchar(255) default NULL,
  `studentGender` varchar(255) default NULL,
  `studentEnrollmentNumber` varchar(255) default NULL,
  `studentShift` varchar(255) default NULL,
  `branchId` int(11) default NULL,
  `semesterId` int(11) default NULL,
  `classId` int(11) default NULL,
  `loginId` int(11) default NULL,
  PRIMARY KEY  (`studentId`),
  KEY `FK8FFE823B326169CD` (`branchId`),
  KEY `FK8FFE823BBF5B0CB9` (`semesterId`),
  KEY `FK8FFE823B56F75C6F` (`classId`),
  KEY `FK8FFE823B1A0477D1` (`loginId`),
  CONSTRAINT `FK8FFE823B1A0477D1` FOREIGN KEY (`loginId`) REFERENCES `login` (`id`),
  CONSTRAINT `FK8FFE823B326169CD` FOREIGN KEY (`branchId`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK8FFE823B56F75C6F` FOREIGN KEY (`classId`) REFERENCES `class` (`id`),
  CONSTRAINT `FK8FFE823BBF5B0CB9` FOREIGN KEY (`semesterId`) REFERENCES `semester` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`studentId`,`studentFirstName`,`studentLastName`,`studentMobile`,`studentEmail`,`studentGender`,`studentEnrollmentNumber`,`studentShift`,`branchId`,`semesterId`,`classId`,`loginId`) values (2,'dev','thakkar','9638872404','dev@gmail.com','female','166540307112','2',5,2,2,5),(3,'tirth','vora','1875454501','tirth@gmail.com','male','16654030122','2',1,4,4,5),(5,'Yash','Shah','8465432199','yash@gmail.com','male','166540301000','1',1,2,5,6),(6,'kushal','shah','9016770303','hhh@gmail.com','male','166540307123','2',1,1,3,5),(10,'Yash','Shah','8460674501','yash@gmail.com','male','166540307100','2',1,2,4,5),(11,'rupa','shah','9228719900','rupa@gmail.com','female','166540307112','2',1,2,4,5),(12,'vaishal','shah','9879171941','vaishal@gmail.com','male','166540307112','2',1,2,4,5),(13,'t','v','2555555555','t@g.com','male','16654030122','1',2,6,3,6),(14,'tirth','vora','5555555555','hhh@gmail.com','male','166540307123','2',3,4,3,5),(15,'harsh','vyas','5555555555','t@g.com','male','166540307100','1',3,5,2,5),(16,'harsh','vyas','8888888888','kkk@g.com','female','166540307100','2',4,4,3,5),(17,'tirth','vyas','6666666666','h@g.com','male','16654030122','1',2,4,4,5),(19,'rupa','shah','9228719900','rupa@gmail.com','female','166540307112','1',3,3,3,4),(21,'kushal','shah','9016770303','kushal@gmail.com','male','166540307101','1',3,3,3,4),(22,'Yash','Shah','8460674501','yash@gmail.com','male','166540307100','1',2,3,4,2),(23,'rupa','shah','9228719900','rupa@gmail.com','female','166540307112','1',2,3,4,2),(24,'vaishal','shah','9879171941','vaishal@gmail.com','male','166540307112','1',2,3,4,2),(25,'kushal','shah','9016770303','kushal@gmail.com','male','166540307101','1',2,3,4,2),(26,'yash','vyas','5555555555','h@g.com','male','16654030122','2',2,2,6,12),(27,'yash','shah','8888888888','t@g.com','male','166540307112','1',5,3,4,5),(28,'Yash','Shah','8460674501','yash@gmail.com','male','166540307100','1',1,6,2,13),(29,'rupa','shah','9228719900','rupa@gmail.com','female','166540307112','1',1,6,2,13),(30,'vaishal','shah','9879171941','vaishal@gmail.com','male','166540307112','1',1,6,2,13),(31,'kushal','shah','9016770303','kushal@gmail.com','male','166540307101','1',1,6,2,13),(32,'Yash','Shah','8460674501','yash@gmail.com','male','166540307100','1',1,4,3,13),(33,'rupa','shah','9228719900','rupa@gmail.com','female','166540307112','1',1,4,3,13),(34,'vaishal','shah','9879171941','vaishal@gmail.com','male','166540307112','1',1,4,3,13),(35,'kushal','shah','9016770303','kushal@gmail.com','male','166540307101','1',1,4,3,13),(36,'Yash','Shah','8460674501','yash@gmail.com','male','166540307100','1',1,4,3,13),(37,'rupa','shah','9228719900','rupa@gmail.com','female','166540307112','1',1,4,3,13),(38,'vaishal','shah','9879171941','vaishal@gmail.com','male','166540307112','1',1,4,3,13),(39,'kushal','shah','9016770303','kushal@gmail.com','male','166540307101','1',1,4,3,13),(40,'Yash','Shah','8460674501','yash@gmail.com','male','166540307100','1',1,4,3,13),(41,'rupa','shah','9228719900','rupa@gmail.com','female','166540307112','1',1,4,3,13),(42,'vaishal','shah','9879171941','vaishal@gmail.com','male','166540307112','1',1,4,3,13),(43,'kushal','shah','9016770303','kushal@gmail.com','male','166540307101','1',1,4,3,13),(44,'Yash','Shah','8460674501','yash@gmail.com','male','166540307100','1',1,4,3,13),(45,'rupa','shah','9228719900','rupa@gmail.com','female','166540307112','1',1,4,3,13),(46,'vaishal','shah','9879171941','vaishal@gmail.com','male','166540307112','1',1,4,3,13),(47,'kushal','shah','9016770303','kushal@gmail.com','male','166540307101','1',1,4,3,13),(48,'Yash','Shah','8460674501','yash@gmail.com','male','166540307100','1',1,4,3,13),(49,'Yash','Shah','8460674501','yash@gmail.com','male','166540307100','1',4,4,3,5),(50,'rupa','shah','9228719900','rupa@gmail.com','female','166540307200','1',4,4,3,5),(51,'vaishal','shah','9879171941','vaishal@gmail.com','male','166540307300','1',4,4,3,5),(52,'kushal','shah','9016770303','kushal@gmail.com','male','166540307400','1',4,4,3,5),(53,'ccc','ccc','555','kushal@gmail.com','male','55555555','2',4,4,3,5),(54,'Yash','Shah','9876543210','yash@gmail.com','male','166540307100','2',3,3,3,5),(55,'Dev','Thakkar','9876543210','dev@gmail.com','female','166540307102','2',3,3,3,5),(56,'Tirth','Vora','9876543210','tirth@gmail.co','male','166540307103','2',3,3,3,5),(57,'kushal','shah','9876543210','kushal@gmail.com','male','166540307104','2',3,3,3,5),(58,'Yash','Shah','9876543210','yash@gmail.com','male','166540307100','2',3,3,3,5),(59,'Dev','Thakkar','9876543210','dev@gmail.com','female','166540307102','2',3,3,3,5),(60,'Tirth','Vora','9876543210','tirth@gmail.co','male','166540307103','2',3,3,3,5),(61,'kushal','shah','9876543210','kushal@gmail.com','male','166540307104','2',3,3,3,5),(62,'Yash','Shah','9876543210','yash@gmail.com','male','166540307100','1',5,1,8,5),(63,'Dev','Thakkar','9876543210','dev@gmail.com','female','166540307102','1',5,1,8,5),(64,'Tirth','Vora','9876543210','tirth@gmail.co','male','166540307103','1',5,1,8,5),(65,'kushal','shah','9876543210','kushal@gmail.com','male','166540307104','1',5,1,8,5),(66,'Yash','Shah','9876543210','yash@gmail.com','male','166540307100','1',1,4,3,5),(67,'Dev','Thakkar','9876543210','dev@gmail.com','female','166540307102','1',1,4,3,5),(68,'Tirth','Vora','9876543210','tirth@gmail.co','male','166540307103','1',1,4,3,5),(69,'kushal','shah','9876543210','kushal@gmail.com','male','166540307104','1',1,4,3,5);

/* Trigger structure for table `groupnames` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `deleteGroupMembers` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `deleteGroupMembers` BEFORE DELETE ON `groupnames` FOR EACH ROW BEGIN
	DELETE FROM `smsportal`.`groupmembers` WHERE `groupNameId`= OLD.groupNameId;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
