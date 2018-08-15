/*
SQLyog Ultimate v8.32 
MySQL - 8.0.12 : Database - childishgarden_test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`childishgarden_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `childishgarden_test`;

/*Table structure for table `book_category` */

DROP TABLE IF EXISTS `book_category`;

CREATE TABLE `book_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) NOT NULL,
  `category_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '分类状态, 默认为0正常,1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `book_category` */

insert  into `book_category`(`category_id`,`category_name`,`category_status`,`create_time`,`update_time`) values (1,'枕草子',0,'2018-08-13 17:02:53','2018-08-13 17:02:53');

/*Table structure for table `book_info` */

DROP TABLE IF EXISTS `book_info`;

CREATE TABLE `book_info` (
  `book_id` varchar(32) NOT NULL,
  `category_id` int(11) NOT NULL,
  `book_name` varchar(32) NOT NULL,
  `book_pic` varchar(500) DEFAULT NULL,
  `book_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '书籍状态, 默认为0正常,1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `book_info` */

/*Table structure for table `child_info` */

DROP TABLE IF EXISTS `child_info`;

CREATE TABLE `child_info` (
  `child_id` varchar(32) NOT NULL,
  `child_name` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL COMMENT '负责老师id',
  `user_name` varchar(32) NOT NULL,
  `child_gender` tinyint(3) NOT NULL COMMENT '0男孩,1女孩',
  `camp_id` varchar(32) NOT NULL COMMENT '校区id',
  `child_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0为在读,1为不在读,默认在读',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`child_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `child_info` */

/*Table structure for table `class_info` */

DROP TABLE IF EXISTS `class_info`;

CREATE TABLE `class_info` (
  `class_id` varchar(32) NOT NULL,
  `class_name` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL COMMENT '班级负责人',
  `user_name` varchar(32) NOT NULL,
  `class_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0为在读,1为不在读,默认在读',
  `camp_id` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `class_info` */

/*Table structure for table `course_selection` */

DROP TABLE IF EXISTS `course_selection`;

CREATE TABLE `course_selection` (
  `detail_id` varchar(32) NOT NULL,
  `curriculum_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL COMMENT '创建人id',
  `user_name` varchar(32) NOT NULL COMMENT '创建人姓名',
  `class_id` varchar(32) NOT NULL,
  `class_name` varchar(32) NOT NULL COMMENT '上课班级,为null时是私课',
  `child_id` varchar(32) NOT NULL COMMENT '上私课的孩子',
  `classroom` varchar(32) NOT NULL COMMENT '上课教室',
  `course_day` date NOT NULL COMMENT '上课日期',
  `course_num` tinyint(3) NOT NULL COMMENT '第几节课,上课的时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_class_id` (`class_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `course_selection` */

/*Table structure for table `curriculum_category` */

DROP TABLE IF EXISTS `curriculum_category`;

CREATE TABLE `curriculum_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `is_parent` tinyint(1) DEFAULT NULL COMMENT '该父类是否为父类目,1为true,0为false',
  `sort_order` int(4) DEFAULT NULL COMMENT '排列序号,表示同级类目的展现次序,如果数值相等则按名称次序排列.取值范围:大于零的整数',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类Id=0时,代表的一级类目,父类目ID=0时,代表的是一级的类目',
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_status` tinyint(3) DEFAULT '0' COMMENT '分类是否使用,1为删除,0为正在使用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`),
  KEY `idx_parent_id` (`parent_id`,`category_status`) USING BTREE,
  KEY `idx_sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `curriculum_category` */

insert  into `curriculum_category`(`category_id`,`is_parent`,`sort_order`,`parent_id`,`category_name`,`category_status`,`create_time`,`update_time`) values (1,1,1,0,'个人和社会发展',0,'2018-08-13 15:45:50','2018-08-14 16:40:26'),(2,1,1,1,'建立关系',0,'2018-08-14 16:01:16','2018-08-14 16:01:16'),(3,0,1,2,'和朋友交往',0,'2018-08-14 18:22:22','2018-08-14 18:22:22');

/*Table structure for table `curriculum_detail` */

DROP TABLE IF EXISTS `curriculum_detail`;

CREATE TABLE `curriculum_detail` (
  `detail_id` varchar(32) NOT NULL,
  `curriculum_id` varchar(32) NOT NULL,
  `music_id` varchar(32) NOT NULL,
  `music_name` varchar(32) NOT NULL,
  `material_id` varchar(32) NOT NULL,
  `material_name` varchar(32) NOT NULL,
  `book_id` varchar(32) NOT NULL,
  `book_name` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `curriculum_detail` */

/*Table structure for table `curriculum_info` */

DROP TABLE IF EXISTS `curriculum_info`;

CREATE TABLE `curriculum_info` (
  `curriculum_id` varchar(32) NOT NULL,
  `curriculum_name` varchar(64) NOT NULL COMMENT '课程名称',
  `curriculum_property` tinyint(3) DEFAULT '0' COMMENT '室内课为0,室外课为1',
  `user_id` varchar(32) NOT NULL COMMENT '创建老师id',
  `user_name` varchar(32) NOT NULL COMMENT '创建老师姓名',
  `curriculum_difficulty` tinyint(3) NOT NULL COMMENT '课程难度选择',
  `curriculum_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '课程状态,0正常,1删除',
  `category_id` int(11) NOT NULL COMMENT '课程分类编号',
  `curriculum_plan` text COMMENT '主题计划内容',
  `curriculum_description` text COMMENT '课程描述内容',
  `curriculum_prepare` text COMMENT '课程准备内容',
  `activity_step` text COMMENT '活动步骤备内容',
  `activity_target` text COMMENT '活动目标1',
  `activity_target2` text COMMENT '活动目标2',
  `curriculum_target` text COMMENT '课程目标',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `curriculum_age` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程适合的年龄',
  PRIMARY KEY (`curriculum_id`),
  KEY `idx_curriculum_id` (`curriculum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `curriculum_info` */

insert  into `curriculum_info`(`curriculum_id`,`curriculum_name`,`curriculum_property`,`user_id`,`user_name`,`curriculum_difficulty`,`curriculum_status`,`category_id`,`curriculum_plan`,`curriculum_description`,`curriculum_prepare`,`activity_step`,`activity_target`,`activity_target2`,`curriculum_target`,`create_time`,`update_time`,`curriculum_age`) values ('01','狗年交友指南',0,'01','小白老师',9,0,3,'啊','啊','啊','啊','啊','啊','啊','2018-08-14 17:15:30','2018-08-14 17:31:30','12'),('02','一拳一个怪',0,'02','大海老师',8,0,3,'啊','啊','啊','啊','啊','啊','啊','2018-08-14 17:15:30','2018-08-14 17:31:30','12');

/*Table structure for table `materials_category` */

DROP TABLE IF EXISTS `materials_category`;

CREATE TABLE `materials_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) NOT NULL,
  `category_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '分类状态, 默认为0正常,1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `materials_category` */

/*Table structure for table `materials_info` */

DROP TABLE IF EXISTS `materials_info`;

CREATE TABLE `materials_info` (
  `material_id` varchar(32) NOT NULL,
  `material_name` varchar(32) NOT NULL,
  `category_id` int(11) NOT NULL,
  `material_pic` varchar(500) NOT NULL,
  `material_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '材料状态, 默认为0正常,1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `materials_info` */

/*Table structure for table `music_category` */

DROP TABLE IF EXISTS `music_category`;

CREATE TABLE `music_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) NOT NULL,
  `category_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '分类状态, 默认为0正常,1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `music_category` */

/*Table structure for table `music_info` */

DROP TABLE IF EXISTS `music_info`;

CREATE TABLE `music_info` (
  `music_id` varchar(32) NOT NULL,
  `music_name` varchar(32) NOT NULL,
  `category_id` int(11) NOT NULL,
  `music_pic` varchar(500) DEFAULT NULL,
  `music_url` varchar(500) DEFAULT NULL,
  `music_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '材料状态, 默认为0正常,1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`music_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `music_info` */

/*Table structure for table `parent_child_relate` */

DROP TABLE IF EXISTS `parent_child_relate`;

CREATE TABLE `parent_child_relate` (
  `relate_id` varchar(32) NOT NULL,
  `parent_id` varchar(32) NOT NULL,
  `parent_name` varchar(32) NOT NULL,
  `child_id` varchar(32) NOT NULL,
  `child_name` varchar(32) NOT NULL,
  `relationship` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`relate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `parent_child_relate` */

/*Table structure for table `parent_info` */

DROP TABLE IF EXISTS `parent_info`;

CREATE TABLE `parent_info` (
  `parent_id` varchar(32) NOT NULL,
  `parent_name` varchar(32) NOT NULL,
  `class_id` varchar(32) NOT NULL,
  `class_name` varchar(32) NOT NULL,
  `camp_id` varchar(32) NOT NULL,
  `parent_phone` varchar(32) NOT NULL,
  `parent_wechat` varchar(32) NOT NULL,
  `parent_address` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `parent_info` */

/*Table structure for table `school_camp_info` */

DROP TABLE IF EXISTS `school_camp_info`;

CREATE TABLE `school_camp_info` (
  `camp_id` int(20) NOT NULL AUTO_INCREMENT,
  `camp_name` varchar(32) NOT NULL,
  `camp_adress` varchar(128) NOT NULL,
  `user_id` varchar(32) NOT NULL COMMENT '负责人id',
  `user_name` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`camp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `school_camp_info` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` varchar(32) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `user_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0为在职,1为不在职,默认在职',
  `camp_id` varchar(32) NOT NULL,
  `camp_name` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
