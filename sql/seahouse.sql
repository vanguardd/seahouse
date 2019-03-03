/*
Navicat MySQL Data Transfer

Source Server         : seahouse
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : seahouse

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-09-21 14:16:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', '__TASK_CLASS_NAME__1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', '__TASK_CLASS_NAME__2', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', '__TASK_CLASS_NAME__1', 'DEFAULT', null, 'com.ruoyi.project.monitor.job.util.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C770800000010000000017400135F5F5441534B5F50524F504552544945535F5F73720028636F6D2E72756F79692E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200084C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720029636F6D2E72756F79692E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E0787074000070707074000E302F3130202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672795461736B74000A72794E6F506172616D7374000074000130740001317800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', '__TASK_CLASS_NAME__2', 'DEFAULT', null, 'com.ruoyi.project.monitor.job.util.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C770800000010000000017400135F5F5441534B5F50524F504552544945535F5F73720028636F6D2E72756F79692E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200084C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720029636F6D2E72756F79692E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E0787074000070707074000E302F3230202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000672795461736B7400087279506172616D73740002727974000130740001317800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RuoyiScheduler', 'vanguard1537504213979', '1537510582465', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', '__TASK_CLASS_NAME__1', 'DEFAULT', '__TASK_CLASS_NAME__1', 'DEFAULT', null, '1537258590000', '-1', '5', 'PAUSED', 'CRON', '1537258585000', '0', null, '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C770800000010000000017400135F5F5441534B5F50524F504552544945535F5F73720028636F6D2E72756F79692E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200084C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720029636F6D2E72756F79692E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E0787074000070707074000E302F3130202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672795461736B74000A72794E6F506172616D7374000074000130740001317800);
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', '__TASK_CLASS_NAME__2', 'DEFAULT', '__TASK_CLASS_NAME__2', 'DEFAULT', null, '1537258600000', '-1', '5', 'PAUSED', 'CRON', '1537258585000', '0', null, '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C770800000010000000017400135F5F5441534B5F50524F504552544945535F5F73720028636F6D2E72756F79692E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200084C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C000C6D6574686F64506172616D7371007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720029636F6D2E72756F79692E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E0787074000070707074000E302F3230202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000672795461736B7400087279506172616D73740002727974000130740001317800);

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(100) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-default', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '默认 skin-default、蓝色 skin-blue、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` int(11) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT '' COMMENT '负责人',
  `phone` varchar(11) DEFAULT '' COMMENT '联系电话',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('100', '0', '0', '若依科技', '0', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('101', '100', '0,100', '深圳总公司', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('102', '100', '0,100', '长沙分公司', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('103', '101', '0,100,101', '研发部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('104', '101', '0,100,101', '市场部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('105', '101', '0,100,101', '测试部门', '3', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('106', '101', '0,100,101', '财务部门', '4', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('107', '101', '0,100,101', '运维部门', '5', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('108', '102', '0,100,102', '市场部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('109', '102', '0,100,102', '财务部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(500) DEFAULT '' COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(500) DEFAULT '' COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1', '1', '男', '1', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 19:28:01', '性别男');
INSERT INTO `sys_dict_data` VALUES ('2', '2', '女', '0', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 19:28:08', '性别女');
INSERT INTO `sys_dict_data` VALUES ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别未知');
INSERT INTO `sys_dict_data` VALUES ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '显示菜单');
INSERT INTO `sys_dict_data` VALUES ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 16:01:53', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 16:02:03', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES ('10', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:53:52', '系统默认是');
INSERT INTO `sys_dict_data` VALUES ('11', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:54:05', '系统默认否');
INSERT INTO `sys_dict_data` VALUES ('12', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知');
INSERT INTO `sys_dict_data` VALUES ('13', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '公告');
INSERT INTO `sys_dict_data` VALUES ('14', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('15', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '关闭状态');
INSERT INTO `sys_dict_data` VALUES ('16', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('17', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('18', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('19', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('20', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('21', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('22', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('23', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES ('24', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES ('25', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 16:01:38', '用户性别列表');
INSERT INTO `sys_dict_type` VALUES ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:54:32', '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:54:37', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES ('4', '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:54:42', '任务状态列表');
INSERT INTO `sys_dict_type` VALUES ('5', '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:54:49', '系统是否列表');
INSERT INTO `sys_dict_type` VALUES ('6', '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:54:54', '通知类型列表');
INSERT INTO `sys_dict_type` VALUES ('7', '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:54:58', '通知状态列表');
INSERT INTO `sys_dict_type` VALUES ('8', '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:55:03', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES ('9', '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:55:09', '登录状态列表');
INSERT INTO `sys_dict_type` VALUES ('10', '用户状态', 'sys_user_status', '0', 'admin', '2018-09-20 12:14:04', '', null, '会员用户的状态');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT '' COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT '' COMMENT '任务方法',
  `method_params` varchar(200) DEFAULT '' COMMENT '方法参数',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '0' COMMENT '计划执行错误策略（0默认 1继续 2等待 3放弃）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('1', 'ryTask', '系统默认（无参）', 'ryNoParams', '', '0/10 * * * * ?', '0', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_job` VALUES ('2', 'ryTask', '系统默认（有参）', 'ryParams', 'ry', '0/20 * * * * ?', '0', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
  `job_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT NULL COMMENT '任务方法',
  `method_params` varchar(200) DEFAULT '' COMMENT '方法参数',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` text COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES ('100', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '1', '密码输入错误1次，admin1234', '2018-09-18 16:17:43');
INSERT INTO `sys_logininfor` VALUES ('101', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '0', '登录成功', '2018-09-18 16:17:56');
INSERT INTO `sys_logininfor` VALUES ('102', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '0', '退出成功', '2018-09-18 16:18:01');
INSERT INTO `sys_logininfor` VALUES ('103', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '1', '验证码错误', '2018-09-18 16:18:07');
INSERT INTO `sys_logininfor` VALUES ('104', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '1', '密码输入错误1次，admin1234', '2018-09-18 16:18:13');
INSERT INTO `sys_logininfor` VALUES ('105', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '1', '密码输入错误2次，admin1234', '2018-09-18 16:18:19');
INSERT INTO `sys_logininfor` VALUES ('106', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '1', '验证码错误', '2018-09-18 16:18:28');
INSERT INTO `sys_logininfor` VALUES ('107', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '1', '密码输入错误3次，admin1234', '2018-09-18 16:18:36');
INSERT INTO `sys_logininfor` VALUES ('108', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '1', '密码输入错误4次，admin1234', '2018-09-18 16:18:53');
INSERT INTO `sys_logininfor` VALUES ('109', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '0', '登录成功', '2018-09-18 16:20:47');
INSERT INTO `sys_logininfor` VALUES ('110', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '0', '退出成功', '2018-09-18 16:21:11');
INSERT INTO `sys_logininfor` VALUES ('111', 'admin', '127.0.0.1', 'XX XX', 'Chrome', 'Windows 10', '0', '登录成功', '2018-09-18 16:21:19');
INSERT INTO `sys_logininfor` VALUES ('112', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '0', '登录成功', '2018-09-19 14:49:14');
INSERT INTO `sys_logininfor` VALUES ('113', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '0', '退出成功', '2018-09-19 16:28:43');
INSERT INTO `sys_logininfor` VALUES ('114', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '1', '验证码错误', '2018-09-19 16:34:35');
INSERT INTO `sys_logininfor` VALUES ('115', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '0', '登录成功', '2018-09-19 16:34:41');
INSERT INTO `sys_logininfor` VALUES ('116', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '0', '登录成功', '2018-09-19 18:10:14');
INSERT INTO `sys_logininfor` VALUES ('117', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '1', '验证码错误', '2018-09-19 18:19:54');
INSERT INTO `sys_logininfor` VALUES ('118', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '1', '验证码错误', '2018-09-19 18:19:59');
INSERT INTO `sys_logininfor` VALUES ('119', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '0', '登录成功', '2018-09-19 18:20:07');
INSERT INTO `sys_logininfor` VALUES ('120', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '0', '退出成功', '2018-09-19 18:38:28');
INSERT INTO `sys_logininfor` VALUES ('121', 'admin', '127.0.0.1', 'XX XX', 'Unknown', 'Unknown', '0', '登录成功', '2018-09-19 18:38:47');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2012 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '6', '#', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-18 18:32:21', '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '7', '#', 'M', '0', '', 'fa fa-video-camera', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-18 18:32:03', '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '系统工具', '0', '8', '#', 'M', '0', '', 'fa fa-bars', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-18 18:31:56', '系统工具目录');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', '/system/user', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', '/system/role', 'C', '0', 'system:role:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', '/system/menu', 'C', '0', 'system:menu:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('103', '部门管理', '1', '4', '/system/dept', 'C', '0', 'system:dept:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `sys_menu` VALUES ('104', '岗位管理', '1', '5', '/system/post', 'C', '0', 'system:post:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', '/system/dict', 'C', '0', 'system:dict:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', '/system/config', 'C', '0', 'system:config:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('107', '通知公告', '1', '8', '/system/notice', 'C', '0', 'system:notice:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `sys_menu` VALUES ('108', '日志管理', '1', '9', '#', 'M', '0', '', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '日志管理菜单');
INSERT INTO `sys_menu` VALUES ('109', '在线用户', '2', '1', '/monitor/online', 'C', '0', 'monitor:online:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu` VALUES ('110', '定时任务', '2', '2', '/monitor/job', 'C', '0', 'monitor:job:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES ('111', '数据监控', '2', '3', '/monitor/data', 'C', '0', 'monitor:data:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `sys_menu` VALUES ('112', '表单构建', '3', '1', '/tool/build', 'C', '0', 'tool:build:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `sys_menu` VALUES ('113', '代码生成', '3', '2', '/tool/gen', 'C', '0', 'tool:gen:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `sys_menu` VALUES ('114', '系统接口', '3', '3', '/tool/swagger', 'C', '0', 'tool:swagger:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `sys_menu` VALUES ('500', '操作日志', '108', '1', '/monitor/operlog', 'C', '0', 'monitor:operlog:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu` VALUES ('501', '登录日志', '108', '2', '/monitor/logininfor', 'C', '0', 'monitor:logininfor:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `sys_menu` VALUES ('1000', '用户查询', '100', '1', '#', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1001', '用户新增', '100', '2', '#', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1002', '用户修改', '100', '3', '#', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1003', '用户删除', '100', '4', '#', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1004', '用户导出', '100', '5', '#', 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1005', '重置密码', '100', '5', '#', 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1006', '角色查询', '101', '1', '#', 'F', '0', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1007', '角色新增', '101', '2', '#', 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1008', '角色修改', '101', '3', '#', 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1009', '角色删除', '101', '4', '#', 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1010', '角色导出', '101', '4', '#', 'F', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1011', '菜单查询', '102', '1', '#', 'F', '0', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1012', '菜单新增', '102', '2', '#', 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1013', '菜单修改', '102', '3', '#', 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1014', '菜单删除', '102', '4', '#', 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1015', '部门查询', '103', '1', '#', 'F', '0', 'system:dept:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1016', '部门新增', '103', '2', '#', 'F', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1017', '部门修改', '103', '3', '#', 'F', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1018', '部门删除', '103', '4', '#', 'F', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1019', '岗位查询', '104', '1', '#', 'F', '0', 'system:post:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1020', '岗位新增', '104', '2', '#', 'F', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1021', '岗位修改', '104', '3', '#', 'F', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1022', '岗位删除', '104', '4', '#', 'F', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1023', '岗位导出', '104', '4', '#', 'F', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1024', '字典查询', '105', '1', '#', 'F', '0', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1025', '字典新增', '105', '2', '#', 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1026', '字典修改', '105', '3', '#', 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1027', '字典删除', '105', '4', '#', 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1028', '字典导出', '105', '4', '#', 'F', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1029', '参数查询', '106', '1', '#', 'F', '0', 'system:config:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1030', '参数新增', '106', '2', '#', 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1031', '参数修改', '106', '3', '#', 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1032', '参数删除', '106', '4', '#', 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1033', '参数导出', '106', '4', '#', 'F', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1034', '公告查询', '107', '1', '#', 'F', '0', 'system:notice:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1035', '公告新增', '107', '2', '#', 'F', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1036', '公告修改', '107', '3', '#', 'F', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1037', '公告删除', '107', '4', '#', 'F', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1038', '操作查询', '500', '1', '#', 'F', '0', 'monitor:operlog:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1039', '操作删除', '500', '2', '#', 'F', '0', 'monitor:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1040', '详细信息', '500', '3', '#', 'F', '0', 'monitor:operlog:detail', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1041', '日志导出', '500', '3', '#', 'F', '0', 'monitor:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1042', '登录查询', '501', '1', '#', 'F', '0', 'monitor:logininfor:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1043', '登录删除', '501', '2', '#', 'F', '0', 'monitor:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1044', '日志导出', '501', '2', '#', 'F', '0', 'monitor:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1045', '在线查询', '109', '1', '#', 'F', '0', 'monitor:online:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1046', '批量强退', '109', '2', '#', 'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1047', '单条强退', '109', '3', '#', 'F', '0', 'monitor:online:forceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1048', '任务查询', '110', '1', '#', 'F', '0', 'monitor:job:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1049', '任务新增', '110', '2', '#', 'F', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1050', '任务修改', '110', '3', '#', 'F', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1051', '任务删除', '110', '4', '#', 'F', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1052', '状态修改', '110', '5', '#', 'F', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1053', '任务导出', '110', '5', '#', 'F', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1054', '生成查询', '113', '1', '#', 'F', '0', 'tool:gen:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('1055', '生成代码', '113', '2', '#', 'F', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('2001', '后端接口', '3', '4', '/tool/swagger/server', 'C', '0', 'tool:swagger:view', '#', 'admin', '2018-09-18 16:35:39', '', null, '');
INSERT INTO `sys_menu` VALUES ('2002', '用户中心', '0', '1', '#', 'M', '0', '', 'fa fa-user-o', 'admin', '2018-09-18 18:30:57', 'admin', '2018-09-18 22:15:07', '');
INSERT INTO `sys_menu` VALUES ('2003', '用户管理', '2002', '1', '/user', 'C', '0', 'user:view', '#', 'admin', '2018-09-18 20:41:01', 'admin', '2018-09-18 20:55:11', '');
INSERT INTO `sys_menu` VALUES ('2004', '查询详情', '2003', '5', '#', 'F', '0', 'user:detail', '#', 'admin', '2018-09-18 20:56:17', 'admin', '2018-09-21 12:52:01', '');
INSERT INTO `sys_menu` VALUES ('2005', '房屋管理', '0', '2', '/house', 'C', '0', 'house:view', 'fa fa-bank', 'admin', '2018-09-18 22:17:04', 'admin', '2018-09-18 22:23:14', '');
INSERT INTO `sys_menu` VALUES ('2006', '订单管理', '0', '3', '/order', 'C', '0', 'order:view', 'fa fa-bar-chart', 'admin', '2018-09-18 22:25:47', 'admin', '2018-09-18 22:26:21', '');
INSERT INTO `sys_menu` VALUES ('2007', '会员查询', '2003', '1', '#', 'F', '0', 'user:list', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2018-09-21 12:52:14', '');
INSERT INTO `sys_menu` VALUES ('2008', '会员新增', '2003', '2', '#', 'F', '0', 'user:add', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2018-09-21 12:52:25', '');
INSERT INTO `sys_menu` VALUES ('2009', '会员修改', '2003', '3', '#', 'F', '0', 'user:edit', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2018-09-21 12:52:36', '');
INSERT INTO `sys_menu` VALUES ('2010', '会员删除', '2003', '4', '#', 'F', '0', 'user:remove', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2018-09-21 12:52:45', '');
INSERT INTO `sys_menu` VALUES ('2011', '会员导出', '2003', '6', '#', 'F', '0', 'user:export', '#', 'admin', '2018-09-21 12:50:31', 'admin', '2018-09-21 12:52:58', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(2) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(500) NOT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('1', '温馨提醒：2018-07-01 若依新版本发布啦', '2', '新版本内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_notice` VALUES ('2', '维护通知：2018-07-01 若依系统凌晨维护', '1', '维护内容', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(30) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(255) DEFAULT '' COMMENT '请求参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES ('100', '重置密码', '2', 'com.ruoyi.project.system.user.controller.ProfileController.resetPwd()', '1', 'admin', '研发部门', '/system/user/profile/resetPwd', '127.0.0.1', 'XX XX', '{\"userId\":[\"1\"],\"loginName\":[\"admin\"],\"oldPassword\":[\"admin123\"],\"password\":[\"admin\"],\"confirm\":[\"admin\"]}', '0', null, '2018-09-18 16:21:07');
INSERT INTO `sys_oper_log` VALUES ('101', '菜单管理', '1', 'com.ruoyi.project.system.menu.controller.MenuController.addSave()', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', 'XX XX', '{\"parentId\":[\"114\"],\"menuType\":[\"C\"],\"menuName\":[\"后端接口\"],\"url\":[\"/tool/swagger\"],\"perms\":[\"\"],\"orderNum\":[\"4\"],\"icon\":[\"\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 16:33:39');
INSERT INTO `sys_oper_log` VALUES ('102', '菜单管理', '3', 'com.ruoyi.project.system.menu.controller.MenuController.remove()', '1', 'admin', '研发部门', '/system/menu/remove/2000', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-18 16:34:58');
INSERT INTO `sys_oper_log` VALUES ('103', '菜单管理', '1', 'com.ruoyi.project.system.menu.controller.MenuController.addSave()', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', 'XX XX', '{\"parentId\":[\"3\"],\"menuType\":[\"C\"],\"menuName\":[\"后端接口\"],\"url\":[\"/tool/swagger/server\"],\"perms\":[\"tool:swagger:view\"],\"orderNum\":[\"4\"],\"icon\":[\"\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 16:35:39');
INSERT INTO `sys_oper_log` VALUES ('104', '个人信息', '2', 'com.ruoyi.project.system.user.controller.ProfileController.updateAvatar()', '1', 'admin', '研发部门', '/system/user/profile/updateAvatar', '127.0.0.1', 'XX XX', '{\"userId\":[\"1\"]}', '0', null, '2018-09-18 18:17:31');
INSERT INTO `sys_oper_log` VALUES ('105', '个人信息', '2', 'com.ruoyi.project.system.user.controller.ProfileController.update()', '1', 'admin', '研发部门', '/system/user/profile/update', '127.0.0.1', 'XX XX', '{\"userId\":[\"1\"],\"loginName\":[\"admin\"],\"dept.deptName\":[\"研发部门\"],\"userName\":[\"vanguardd\"],\"email\":[\"ry@163.com\"],\"phonenumber\":[\"15888888888\"],\"sex\":[\"1\"]}', '0', null, '2018-09-18 18:17:52');
INSERT INTO `sys_oper_log` VALUES ('106', '个人信息', '2', 'com.ruoyi.project.system.user.controller.ProfileController.update()', '1', 'admin', '研发部门', '/system/user/profile/update', '127.0.0.1', 'XX XX', '{\"userId\":[\"1\"],\"loginName\":[\"admin\"],\"dept.deptName\":[\"研发部门\"],\"userName\":[\"vanguardd\"],\"email\":[\"ry@163.com\"],\"phonenumber\":[\"15888888888\"],\"sex\":[\"0\"]}', '0', null, '2018-09-18 18:17:58');
INSERT INTO `sys_oper_log` VALUES ('107', '菜单管理', '1', 'com.ruoyi.project.system.menu.controller.MenuController.addSave()', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', 'XX XX', '{\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"会员管理\"],\"url\":[\"\"],\"perms\":[\"\"],\"orderNum\":[\"4\"],\"icon\":[\"fa fa-user-o\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 18:30:57');
INSERT INTO `sys_oper_log` VALUES ('108', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"3\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"系统工具\"],\"url\":[\"#\"],\"perms\":[\"\"],\"orderNum\":[\"5\"],\"icon\":[\"fa fa-bars\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 18:31:35');
INSERT INTO `sys_oper_log` VALUES ('109', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"3\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"系统工具\"],\"url\":[\"#\"],\"perms\":[\"\"],\"orderNum\":[\"8\"],\"icon\":[\"fa fa-bars\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 18:31:56');
INSERT INTO `sys_oper_log` VALUES ('110', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"系统监控\"],\"url\":[\"#\"],\"perms\":[\"\"],\"orderNum\":[\"7\"],\"icon\":[\"fa fa-video-camera\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 18:32:03');
INSERT INTO `sys_oper_log` VALUES ('111', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"1\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"系统管理\"],\"url\":[\"#\"],\"perms\":[\"\"],\"orderNum\":[\"6\"],\"icon\":[\"fa fa-gear\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 18:32:21');
INSERT INTO `sys_oper_log` VALUES ('112', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2002\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"会员管理\"],\"url\":[\"#\"],\"perms\":[\"\"],\"orderNum\":[\"1\"],\"icon\":[\"fa fa-user-o\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 18:32:28');
INSERT INTO `sys_oper_log` VALUES ('113', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', '1', 'admin', '研发部门', '/tool/gen/batchGenCode', '127.0.0.1', 'XX XX', '{\"tables\":[\"tb_user_info,tb_user\"]}', '0', null, '2018-09-18 18:57:07');
INSERT INTO `sys_oper_log` VALUES ('114', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', '1', 'admin', '研发部门', '/tool/gen/batchGenCode', '127.0.0.1', 'XX XX', '{\"tables\":[\"tb_user_info,tb_user\"]}', '0', null, '2018-09-18 18:57:08');
INSERT INTO `sys_oper_log` VALUES ('115', '菜单管理', '1', 'com.ruoyi.project.system.menu.controller.MenuController.addSave()', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', 'XX XX', '{\"parentId\":[\"2002\"],\"menuType\":[\"C\"],\"menuName\":[\"会员列表\"],\"url\":[\"/user/list\"],\"perms\":[\"\"],\"orderNum\":[\"1\"],\"icon\":[\"\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 20:41:01');
INSERT INTO `sys_oper_log` VALUES ('116', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2003\"],\"parentId\":[\"2002\"],\"menuType\":[\"C\"],\"menuName\":[\"会员列表\"],\"url\":[\"/user/list\"],\"perms\":[\"user:view:list\"],\"orderNum\":[\"1\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 20:51:55');
INSERT INTO `sys_oper_log` VALUES ('117', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2003\"],\"parentId\":[\"2002\"],\"menuType\":[\"C\"],\"menuName\":[\"会员列表\"],\"url\":[\"/user\"],\"perms\":[\"user:view:list\"],\"orderNum\":[\"1\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 20:52:52');
INSERT INTO `sys_oper_log` VALUES ('118', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2003\"],\"parentId\":[\"2002\"],\"menuType\":[\"C\"],\"menuName\":[\"用户管理\"],\"url\":[\"/user\"],\"perms\":[\"user:view\"],\"orderNum\":[\"1\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 20:55:11');
INSERT INTO `sys_oper_log` VALUES ('119', '菜单管理', '1', 'com.ruoyi.project.system.menu.controller.MenuController.addSave()', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', 'XX XX', '{\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"用户查询\"],\"url\":[\"\"],\"perms\":[\"user:view:list\"],\"orderNum\":[\"1\"],\"icon\":[\"\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 20:56:17');
INSERT INTO `sys_oper_log` VALUES ('120', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2002\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"用户中心\"],\"url\":[\"#\"],\"perms\":[\"\"],\"orderNum\":[\"1\"],\"icon\":[\"fa fa-user-o\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:15:07');
INSERT INTO `sys_oper_log` VALUES ('121', '菜单管理', '1', 'com.ruoyi.project.system.menu.controller.MenuController.addSave()', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', 'XX XX', '{\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"房屋管理\"],\"url\":[\"/house\"],\"perms\":[\"\"],\"orderNum\":[\"4\"],\"icon\":[\"\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:17:04');
INSERT INTO `sys_oper_log` VALUES ('122', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2005\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"房屋管理\"],\"url\":[\"/house\"],\"perms\":[\"\"],\"orderNum\":[\"4\"],\"icon\":[\"fa fa-bank\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:17:55');
INSERT INTO `sys_oper_log` VALUES ('123', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2005\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"房屋管理\"],\"url\":[\"\"],\"perms\":[\"\"],\"orderNum\":[\"4\"],\"icon\":[\"fa fa-bank\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:18:17');
INSERT INTO `sys_oper_log` VALUES ('124', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2005\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"房屋管理\"],\"url\":[\"/house\"],\"perms\":[\"\"],\"orderNum\":[\"2\"],\"icon\":[\"fa fa-bank\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:18:49');
INSERT INTO `sys_oper_log` VALUES ('125', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2005\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"房屋管理\"],\"url\":[\"\"],\"perms\":[\"\"],\"orderNum\":[\"2\"],\"icon\":[\"fa fa-bank\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:19:12');
INSERT INTO `sys_oper_log` VALUES ('126', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2005\"],\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"房屋管理\"],\"url\":[\"#\"],\"perms\":[\"\"],\"orderNum\":[\"2\"],\"icon\":[\"fa fa-bank\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:19:25');
INSERT INTO `sys_oper_log` VALUES ('127', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2005\"],\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"房屋管理\"],\"url\":[\"/house\"],\"perms\":[\"\"],\"orderNum\":[\"2\"],\"icon\":[\"fa fa-bank\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:22:49');
INSERT INTO `sys_oper_log` VALUES ('128', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2005\"],\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"房屋管理\"],\"url\":[\"/house\"],\"perms\":[\"house:view\"],\"orderNum\":[\"2\"],\"icon\":[\"fa fa-bank\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:23:14');
INSERT INTO `sys_oper_log` VALUES ('129', '菜单管理', '1', 'com.ruoyi.project.system.menu.controller.MenuController.addSave()', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', 'XX XX', '{\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"订单管理\"],\"url\":[\"/order\"],\"perms\":[\"order:view\"],\"orderNum\":[\"3\"],\"icon\":[\"\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:25:47');
INSERT INTO `sys_oper_log` VALUES ('130', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2006\"],\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"订单管理\"],\"url\":[\"/order\"],\"perms\":[\"order:view\"],\"orderNum\":[\"3\"],\"icon\":[\"fa fa-bar-chart\"],\"visible\":[\"0\"]}', '0', null, '2018-09-18 22:26:21');
INSERT INTO `sys_oper_log` VALUES ('131', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', '1', 'admin', '研发部门', '/tool/gen/batchGenCode', '127.0.0.1', 'XX XX', '{\"tables\":[\"tb_user_info,tb_user\"]}', '0', null, '2018-09-18 22:32:15');
INSERT INTO `sys_oper_log` VALUES ('132', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', '1', 'admin', '研发部门', '/tool/gen/batchGenCode', '127.0.0.1', 'XX XX', '{\"tables\":[\"tb_user_info,tb_user\"]}', '0', null, '2018-09-18 22:32:16');
INSERT INTO `sys_oper_log` VALUES ('133', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', '1', 'admin', '研发部门', '/tool/gen/genCode/tb_user', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-18 22:36:23');
INSERT INTO `sys_oper_log` VALUES ('134', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', '1', 'admin', '研发部门', '/tool/gen/genCode/tb_user', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-18 22:36:23');
INSERT INTO `sys_oper_log` VALUES ('135', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', '1', 'admin', '研发部门', '/tool/gen/genCode/tb_user', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-18 22:52:43');
INSERT INTO `sys_oper_log` VALUES ('136', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', '1', 'admin', '研发部门', '/tool/gen/genCode/tb_user', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-18 22:53:00');
INSERT INTO `sys_oper_log` VALUES ('137', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', '1', 'admin', '研发部门', '/tool/gen/genCode/tb_user', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-18 22:53:00');
INSERT INTO `sys_oper_log` VALUES ('138', '用户管理', '2', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.editSave()', '1', 'admin', '研发部门', '/system/user/edit', '127.0.0.1', 'XX XX', '{\"userId\":[\"1\"],\"deptId\":[\"103\"],\"userName\":[\"vanguardd\"],\"email\":[\"ry@163.com\"],\"phonenumber\":[\"15888888888\"],\"sex\":[\"0\"],\"status\":[\"0\"],\"roleIds\":[\"1\"],\"postIds\":[\"1\"]}', '0', null, '2018-09-19 15:14:03');
INSERT INTO `sys_oper_log` VALUES ('139', '用户管理', '2', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.editSave()', '1', 'admin', '研发部门', '/system/user/edit', '127.0.0.1', 'XX XX', '{\"userId\":[\"1\"],\"deptId\":[\"103\"],\"userName\":[\"vanguardd\"],\"email\":[\"ry@163.com\"],\"phonenumber\":[\"15888888887\"],\"sex\":[\"0\"],\"status\":[\"0\"],\"roleIds\":[\"1\"],\"postIds\":[\"1\"]}', '0', null, '2018-09-19 15:14:13');
INSERT INTO `sys_oper_log` VALUES ('140', '用户管理', '2', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.editSave()', '1', 'admin', '研发部门', '/system/user/edit', '127.0.0.1', 'XX XX', '{\"userId\":[\"2\"],\"deptId\":[\"105\"],\"userName\":[\"若依\"],\"email\":[\"ry@qq.com\"],\"phonenumber\":[\"15666666667\"],\"sex\":[\"1\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"2\"]}', '0', null, '2018-09-19 15:14:26');
INSERT INTO `sys_oper_log` VALUES ('141', '用户管理', '5', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.export()', '1', 'admin', '研发部门', '/system/user/export', '127.0.0.1', 'XX XX', '{\"deptId\":[\"\"],\"parentId\":[\"\"],\"loginName\":[\"\"],\"phonenumber\":[\"\"],\"status\":[\"\"],\"params[beginTime]\":[\"\"],\"params[endTime]\":[\"\"]}', '0', null, '2018-09-19 15:26:42');
INSERT INTO `sys_oper_log` VALUES ('142', '字典数据', '2', 'com.ruoyi.project.system.dict.controller.DictDataController.editSave()', '1', 'admin', '研发部门', '/system/dict/data/edit', '127.0.0.1', 'XX XX', '{\"dictCode\":[\"6\"],\"dictLabel\":[\"正常\"],\"dictValue\":[\"1\"],\"dictType\":[\"sys_normal_disable\"],\"cssClass\":[\"\"],\"dictSort\":[\"1\"],\"listClass\":[\"primary\"],\"isDefault\":[\"Y\"],\"status\":[\"0\"],\"remark\":[\"正常状态\"]}', '0', null, '2018-09-19 15:53:13');
INSERT INTO `sys_oper_log` VALUES ('143', '字典数据', '2', 'com.ruoyi.project.system.dict.controller.DictDataController.editSave()', '1', 'admin', '研发部门', '/system/dict/data/edit', '127.0.0.1', 'XX XX', '{\"dictCode\":[\"7\"],\"dictLabel\":[\"停用\"],\"dictValue\":[\"0\"],\"dictType\":[\"sys_normal_disable\"],\"cssClass\":[\"\"],\"dictSort\":[\"2\"],\"listClass\":[\"danger\"],\"isDefault\":[\"N\"],\"remark\":[\"停用状态\"]}', '0', null, '2018-09-19 15:53:22');
INSERT INTO `sys_oper_log` VALUES ('144', '字典数据', '2', 'com.ruoyi.project.system.dict.controller.DictDataController.editSave()', '1', 'admin', '研发部门', '/system/dict/data/edit', '127.0.0.1', 'XX XX', '{\"dictCode\":[\"10\"],\"dictLabel\":[\"是\"],\"dictValue\":[\"Y\"],\"dictType\":[\"sys_yes_no\"],\"cssClass\":[\"\"],\"dictSort\":[\"1\"],\"listClass\":[\"primary\"],\"isDefault\":[\"Y\"],\"status\":[\"1\"],\"remark\":[\"系统默认是\"]}', '0', null, '2018-09-19 15:53:52');
INSERT INTO `sys_oper_log` VALUES ('145', '字典数据', '2', 'com.ruoyi.project.system.dict.controller.DictDataController.editSave()', '1', 'admin', '研发部门', '/system/dict/data/edit', '127.0.0.1', 'XX XX', '{\"dictCode\":[\"11\"],\"dictLabel\":[\"否\"],\"dictValue\":[\"N\"],\"dictType\":[\"sys_yes_no\"],\"cssClass\":[\"\"],\"dictSort\":[\"2\"],\"listClass\":[\"danger\"],\"isDefault\":[\"N\"],\"status\":[\"1\"],\"remark\":[\"系统默认否\"]}', '0', null, '2018-09-19 15:54:05');
INSERT INTO `sys_oper_log` VALUES ('146', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"1\"],\"dictName\":[\"用户性别\"],\"dictType\":[\"sys_user_sex\"],\"status\":[\"1\"],\"remark\":[\"用户性别列表\"]}', '0', null, '2018-09-19 15:54:20');
INSERT INTO `sys_oper_log` VALUES ('147', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"2\"],\"dictName\":[\"菜单状态\"],\"dictType\":[\"sys_show_hide\"],\"status\":[\"1\"],\"remark\":[\"菜单状态列表\"]}', '0', null, '2018-09-19 15:54:32');
INSERT INTO `sys_oper_log` VALUES ('148', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"3\"],\"dictName\":[\"系统开关\"],\"dictType\":[\"sys_normal_disable\"],\"status\":[\"1\"],\"remark\":[\"系统开关列表\"]}', '0', null, '2018-09-19 15:54:37');
INSERT INTO `sys_oper_log` VALUES ('149', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"4\"],\"dictName\":[\"任务状态\"],\"dictType\":[\"sys_job_status\"],\"status\":[\"1\"],\"remark\":[\"任务状态列表\"]}', '0', null, '2018-09-19 15:54:42');
INSERT INTO `sys_oper_log` VALUES ('150', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"5\"],\"dictName\":[\"系统是否\"],\"dictType\":[\"sys_yes_no\"],\"status\":[\"1\"],\"remark\":[\"系统是否列表\"]}', '0', null, '2018-09-19 15:54:49');
INSERT INTO `sys_oper_log` VALUES ('151', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"6\"],\"dictName\":[\"通知类型\"],\"dictType\":[\"sys_notice_type\"],\"status\":[\"1\"],\"remark\":[\"通知类型列表\"]}', '0', null, '2018-09-19 15:54:54');
INSERT INTO `sys_oper_log` VALUES ('152', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"7\"],\"dictName\":[\"通知状态\"],\"dictType\":[\"sys_notice_status\"],\"status\":[\"1\"],\"remark\":[\"通知状态列表\"]}', '0', null, '2018-09-19 15:54:58');
INSERT INTO `sys_oper_log` VALUES ('153', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"8\"],\"dictName\":[\"操作类型\"],\"dictType\":[\"sys_oper_type\"],\"status\":[\"1\"],\"remark\":[\"操作类型列表\"]}', '0', null, '2018-09-19 15:55:03');
INSERT INTO `sys_oper_log` VALUES ('154', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"9\"],\"dictName\":[\"系统状态\"],\"dictType\":[\"sys_common_status\"],\"status\":[\"1\"],\"remark\":[\"登录状态列表\"]}', '0', null, '2018-09-19 15:55:09');
INSERT INTO `sys_oper_log` VALUES ('155', '用户管理', '2', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.editSave()', '1', 'admin', '研发部门', '/system/user/edit', '127.0.0.1', 'XX XX', '{\"userId\":[\"2\"],\"deptId\":[\"105\"],\"userName\":[\"若依\"],\"email\":[\"ry@qq.com\"],\"phonenumber\":[\"15666666667\"],\"sex\":[\"1\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"2\"]}', '0', null, '2018-09-19 15:55:35');
INSERT INTO `sys_oper_log` VALUES ('156', '用户管理', '2', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.editSave()', '1', 'admin', '研发部门', '/system/user/edit', '127.0.0.1', 'XX XX', '{\"userId\":[\"1\"],\"deptId\":[\"103\"],\"userName\":[\"vanguardd\"],\"email\":[\"ry@163.com\"],\"phonenumber\":[\"15888888888\"],\"sex\":[\"0\"],\"status\":[\"1\"],\"roleIds\":[\"1\"],\"postIds\":[\"1\"]}', '0', null, '2018-09-19 15:55:50');
INSERT INTO `sys_oper_log` VALUES ('157', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"1\"],\"dictName\":[\"用户性别\"],\"dictType\":[\"sys_user_sex\"],\"status\":[\"1\"],\"remark\":[\"用户性别列表\"]}', '0', null, '2018-09-19 16:00:56');
INSERT INTO `sys_oper_log` VALUES ('158', '字典类型', '2', 'com.ruoyi.project.system.dict.controller.DictTypeController.editSave()', '1', 'admin', '研发部门', '/system/dict/edit', '127.0.0.1', 'XX XX', '{\"dictId\":[\"1\"],\"dictName\":[\"用户性别\"],\"dictType\":[\"sys_user_sex\"],\"status\":[\"0\"],\"remark\":[\"用户性别列表\"]}', '0', null, '2018-09-19 16:01:38');
INSERT INTO `sys_oper_log` VALUES ('159', '字典数据', '2', 'com.ruoyi.project.system.dict.controller.DictDataController.editSave()', '1', 'admin', '研发部门', '/system/dict/data/edit', '127.0.0.1', 'XX XX', '{\"dictCode\":[\"6\"],\"dictLabel\":[\"正常\"],\"dictValue\":[\"0\"],\"dictType\":[\"sys_normal_disable\"],\"cssClass\":[\"\"],\"dictSort\":[\"1\"],\"listClass\":[\"primary\"],\"isDefault\":[\"Y\"],\"status\":[\"0\"],\"remark\":[\"正常状态\"]}', '0', null, '2018-09-19 16:01:53');
INSERT INTO `sys_oper_log` VALUES ('160', '字典数据', '2', 'com.ruoyi.project.system.dict.controller.DictDataController.editSave()', '1', 'admin', '研发部门', '/system/dict/data/edit', '127.0.0.1', 'XX XX', '{\"dictCode\":[\"7\"],\"dictLabel\":[\"停用\"],\"dictValue\":[\"1\"],\"dictType\":[\"sys_normal_disable\"],\"cssClass\":[\"\"],\"dictSort\":[\"2\"],\"listClass\":[\"danger\"],\"isDefault\":[\"N\"],\"status\":[\"0\"],\"remark\":[\"停用状态\"]}', '0', null, '2018-09-19 16:02:03');
INSERT INTO `sys_oper_log` VALUES ('161', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2004\"],\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"查详情询\"],\"url\":[\"#\"],\"perms\":[\"user:view:detail\"],\"orderNum\":[\"5\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-19 19:14:48');
INSERT INTO `sys_oper_log` VALUES ('162', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2004\"],\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"查询详情\"],\"url\":[\"#\"],\"perms\":[\"user:view:detail\"],\"orderNum\":[\"5\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-19 19:15:12');
INSERT INTO `sys_oper_log` VALUES ('163', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', '1', 'admin', '研发部门', '/tool/gen/genCode/tb_user_info', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-19 19:23:46');
INSERT INTO `sys_oper_log` VALUES ('164', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', '1', 'admin', '研发部门', '/tool/gen/genCode/tb_user_info', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-19 19:23:46');
INSERT INTO `sys_oper_log` VALUES ('165', '字典数据', '2', 'com.ruoyi.project.system.dict.controller.DictDataController.editSave()', '1', 'admin', '研发部门', '/system/dict/data/edit', '127.0.0.1', 'XX XX', '{\"dictCode\":[\"1\"],\"dictLabel\":[\"男\"],\"dictValue\":[\"1\"],\"dictType\":[\"sys_user_sex\"],\"cssClass\":[\"\"],\"dictSort\":[\"1\"],\"listClass\":[\"\"],\"isDefault\":[\"Y\"],\"status\":[\"0\"],\"remark\":[\"性别男\"]}', '0', null, '2018-09-19 19:28:01');
INSERT INTO `sys_oper_log` VALUES ('166', '字典数据', '2', 'com.ruoyi.project.system.dict.controller.DictDataController.editSave()', '1', 'admin', '研发部门', '/system/dict/data/edit', '127.0.0.1', 'XX XX', '{\"dictCode\":[\"2\"],\"dictLabel\":[\"女\"],\"dictValue\":[\"0\"],\"dictType\":[\"sys_user_sex\"],\"cssClass\":[\"\"],\"dictSort\":[\"2\"],\"listClass\":[\"\"],\"isDefault\":[\"N\"],\"status\":[\"0\"],\"remark\":[\"性别女\"]}', '0', null, '2018-09-19 19:28:09');
INSERT INTO `sys_oper_log` VALUES ('167', '用户管理', '2', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.editSave()', '1', 'admin', '研发部门', '/system/user/edit', '127.0.0.1', 'XX XX', '{\"userId\":[\"1\"],\"deptId\":[\"103\"],\"userName\":[\"vanguardd\"],\"email\":[\"ry@163.com\"],\"phonenumber\":[\"15888888888\"],\"sex\":[\"1\"],\"status\":[\"0\"],\"roleIds\":[\"1\"],\"postIds\":[\"1\"]}', '0', null, '2018-09-19 19:28:26');
INSERT INTO `sys_oper_log` VALUES ('168', '用户管理', '1', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.addSave()', '1', 'admin', '研发部门', '/system/user/add', '127.0.0.1', 'XX XX', '{\"deptId\":[\"103\"],\"loginName\":[\"zhouyi\"],\"userName\":[\"周毅\"],\"password\":[\"12345\"],\"email\":[\"zhouyi@163.com\"],\"phonenumber\":[\"18578912343\"],\"sex\":[\"1\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"2\"]}', '0', null, '2018-09-20 12:12:56');
INSERT INTO `sys_oper_log` VALUES ('169', '字典类型', '1', 'com.ruoyi.project.system.dict.controller.DictTypeController.addSave()', '1', 'admin', '研发部门', '/system/dict/add', '127.0.0.1', 'XX XX', '{\"dictName\":[\"用户状态\"],\"dictType\":[\"sys_user_status\"],\"status\":[\"0\"],\"remark\":[\"会员用户的状态\"]}', '0', null, '2018-09-20 12:14:04');
INSERT INTO `sys_oper_log` VALUES ('170', '重置密码', '2', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.resetPwd()', '1', 'admin', '研发部门', '/system/user/resetPwd/3', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-20 16:56:53');
INSERT INTO `sys_oper_log` VALUES ('171', '用户管理', '2', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.editSave()', '1', 'admin', '研发部门', '/system/user/edit', '127.0.0.1', 'XX XX', '{\"userId\":[\"3\"],\"deptId\":[\"103\"],\"userName\":[\"周毅\"],\"email\":[\"zhouyi@163.com\"],\"phonenumber\":[\"18578912343\"],\"sex\":[\"1\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"2\"]}', '0', null, '2018-09-20 16:58:01');
INSERT INTO `sys_oper_log` VALUES ('172', '会员', '3', 'com.ruoyi.project.user.controller.UserController.remove()', '1', 'admin', '研发部门', '/user/remove', '127.0.0.1', 'XX XX', '{\"ids\":[\"22\"]}', '0', null, '2018-09-20 23:40:11');
INSERT INTO `sys_oper_log` VALUES ('173', '会员', '2', 'com.ruoyi.project.user.controller.UserController.editSave()', '1', 'admin', '研发部门', '/user/edit', '127.0.0.1', 'XX XX', '{\"id\":[\"16\"],\"userName\":[\"user123\"],\"email\":[\"user123@qq.com\"],\"mobilePhone\":[\"15529960414\"],\"state\":[\"0\"],\"password\":[\"12345\"]}', '0', null, '2018-09-21 00:12:36');
INSERT INTO `sys_oper_log` VALUES ('174', '会员', '2', 'com.ruoyi.project.user.controller.UserController.editSave()', '1', 'admin', '研发部门', '/user/edit', '127.0.0.1', 'XX XX', '{\"id\":[\"16\"],\"userName\":[\"user123\"],\"email\":[\"user123@qq.com\"],\"mobilePhone\":[\"15529960414\"],\"state\":[\"0\"],\"password\":[\"12345\"]}', '0', null, '2018-09-21 00:12:42');
INSERT INTO `sys_oper_log` VALUES ('175', '会员', '2', 'com.ruoyi.project.user.controller.UserController.editSave()', '1', 'admin', '研发部门', '/user/edit', '127.0.0.1', 'XX XX', '{\"id\":[\"16\"],\"userName\":[\"user123\"],\"email\":[\"user123@qq.com\"],\"mobilePhone\":[\"15529960414\"],\"state\":[\"0\"],\"password\":[\"12345\"]}', '0', null, '2018-09-21 00:13:11');
INSERT INTO `sys_oper_log` VALUES ('176', '会员', '2', 'com.ruoyi.project.user.controller.UserController.editSave()', '1', 'admin', '研发部门', '/user/edit', '127.0.0.1', 'XX XX', '{\"id\":[\"17\"],\"userName\":[\"user1111\"],\"email\":[\"user1111@qq.com\"],\"mobilePhone\":[\"17691229633\"],\"state\":[\"0\"],\"password\":[\"12345\"]}', '0', null, '2018-09-21 00:16:19');
INSERT INTO `sys_oper_log` VALUES ('177', '会员', '2', 'com.ruoyi.project.user.controller.UserController.editSave()', '1', 'admin', '研发部门', '/user/edit', '127.0.0.1', 'XX XX', '{\"id\":[\"17\"],\"userName\":[\"user1111\"],\"email\":[\"user1111@qq.com\"],\"mobilePhone\":[\"17691229633\"],\"state\":[\"0\"],\"password\":[\"12345\"]}', '0', null, '2018-09-21 00:18:58');
INSERT INTO `sys_oper_log` VALUES ('178', '会员', '2', 'com.ruoyi.project.user.controller.UserController.editSave()', '1', 'admin', '研发部门', '/user/edit', '127.0.0.1', 'XX XX', '{\"id\":[\"17\"],\"userName\":[\"user1111\"],\"email\":[\"user1111@qq.com\"],\"mobilePhone\":[\"17691229633\"],\"state\":[\"0\"],\"password\":[\"12345\"]}', '0', null, '2018-09-21 00:19:56');
INSERT INTO `sys_oper_log` VALUES ('179', '会员', '2', 'com.ruoyi.project.user.controller.UserController.editSave()', '1', 'admin', '研发部门', '/user/edit', '127.0.0.1', 'XX XX', '{\"id\":[\"16\"],\"userName\":[\"user123\"],\"email\":[\"user123@qq.com\"],\"mobilePhone\":[\"15529960414\"],\"state\":[\"0\"],\"password\":[\"12345\"]}', '0', null, '2018-09-21 00:20:09');
INSERT INTO `sys_oper_log` VALUES ('180', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', '1', 'admin', '研发部门', '/tool/gen/genCode/tb_order', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-21 10:54:23');
INSERT INTO `sys_oper_log` VALUES ('181', '代码生成', '8', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', '1', 'admin', '研发部门', '/tool/gen/genCode/tb_order', '127.0.0.1', 'XX XX', '{}', '0', null, '2018-09-21 10:54:25');
INSERT INTO `sys_oper_log` VALUES ('182', '用户管理', '5', 'com.ruoyi.project.system.userAdmin.controller.UserAdminController.export()', '1', 'admin', '研发部门', '/system/user/export', '127.0.0.1', 'XX XX', '{\"deptId\":[\"\"],\"parentId\":[\"\"],\"loginName\":[\"\"],\"phonenumber\":[\"\"],\"status\":[\"\"],\"params[beginTime]\":[\"\"],\"params[endTime]\":[\"\"]}', '0', null, '2018-09-21 12:40:29');
INSERT INTO `sys_oper_log` VALUES ('183', '菜单管理', '1', 'com.ruoyi.project.system.menu.controller.MenuController.addSave()', '1', 'admin', '研发部门', '/system/menu/add', '127.0.0.1', 'XX XX', '{\"parentId\":[\"2002\"],\"menuType\":[\"F\"],\"menuName\":[\"会员导出\"],\"url\":[\"\"],\"perms\":[\"user:view:export\"],\"orderNum\":[\"6\"],\"icon\":[\"\"],\"visible\":[\"0\"]}', '0', null, '2018-09-21 12:50:31');
INSERT INTO `sys_oper_log` VALUES ('184', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2011\"],\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"会员导出\"],\"url\":[\"#\"],\"perms\":[\"user:view:export\"],\"orderNum\":[\"6\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-21 12:50:59');
INSERT INTO `sys_oper_log` VALUES ('185', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2004\"],\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"查询详情\"],\"url\":[\"#\"],\"perms\":[\"user:detail\"],\"orderNum\":[\"5\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-21 12:52:01');
INSERT INTO `sys_oper_log` VALUES ('186', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2007\"],\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"会员查询\"],\"url\":[\"#\"],\"perms\":[\"user:list\"],\"orderNum\":[\"1\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-21 12:52:14');
INSERT INTO `sys_oper_log` VALUES ('187', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2008\"],\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"会员新增\"],\"url\":[\"#\"],\"perms\":[\"user:add\"],\"orderNum\":[\"2\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-21 12:52:25');
INSERT INTO `sys_oper_log` VALUES ('188', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2009\"],\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"会员修改\"],\"url\":[\"#\"],\"perms\":[\"user:edit\"],\"orderNum\":[\"3\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-21 12:52:36');
INSERT INTO `sys_oper_log` VALUES ('189', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2010\"],\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"会员删除\"],\"url\":[\"#\"],\"perms\":[\"user:remove\"],\"orderNum\":[\"4\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-21 12:52:45');
INSERT INTO `sys_oper_log` VALUES ('190', '菜单管理', '2', 'com.ruoyi.project.system.menu.controller.MenuController.editSave()', '1', 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', 'XX XX', '{\"menuId\":[\"2011\"],\"parentId\":[\"2003\"],\"menuType\":[\"F\"],\"menuName\":[\"会员导出\"],\"url\":[\"#\"],\"perms\":[\"user:export\"],\"orderNum\":[\"6\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2018-09-21 12:52:58');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES ('1', 'ceo', '董事长', '1', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('2', 'se', '项目经理', '2', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('3', 'hr', '人力资源', '3', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('4', 'user', '普通员工', '4', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `sys_role` VALUES ('2', '普通角色', 'common', '2', '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `dept_id` int(11) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('2', '100');
INSERT INTO `sys_role_dept` VALUES ('2', '101');
INSERT INTO `sys_role_dept` VALUES ('2', '105');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '3');
INSERT INTO `sys_role_menu` VALUES ('2', '100');
INSERT INTO `sys_role_menu` VALUES ('2', '101');
INSERT INTO `sys_role_menu` VALUES ('2', '102');
INSERT INTO `sys_role_menu` VALUES ('2', '103');
INSERT INTO `sys_role_menu` VALUES ('2', '104');
INSERT INTO `sys_role_menu` VALUES ('2', '105');
INSERT INTO `sys_role_menu` VALUES ('2', '106');
INSERT INTO `sys_role_menu` VALUES ('2', '107');
INSERT INTO `sys_role_menu` VALUES ('2', '108');
INSERT INTO `sys_role_menu` VALUES ('2', '109');
INSERT INTO `sys_role_menu` VALUES ('2', '110');
INSERT INTO `sys_role_menu` VALUES ('2', '111');
INSERT INTO `sys_role_menu` VALUES ('2', '112');
INSERT INTO `sys_role_menu` VALUES ('2', '113');
INSERT INTO `sys_role_menu` VALUES ('2', '114');
INSERT INTO `sys_role_menu` VALUES ('2', '500');
INSERT INTO `sys_role_menu` VALUES ('2', '501');
INSERT INTO `sys_role_menu` VALUES ('2', '1000');
INSERT INTO `sys_role_menu` VALUES ('2', '1001');
INSERT INTO `sys_role_menu` VALUES ('2', '1002');
INSERT INTO `sys_role_menu` VALUES ('2', '1003');
INSERT INTO `sys_role_menu` VALUES ('2', '1004');
INSERT INTO `sys_role_menu` VALUES ('2', '1005');
INSERT INTO `sys_role_menu` VALUES ('2', '1006');
INSERT INTO `sys_role_menu` VALUES ('2', '1007');
INSERT INTO `sys_role_menu` VALUES ('2', '1008');
INSERT INTO `sys_role_menu` VALUES ('2', '1009');
INSERT INTO `sys_role_menu` VALUES ('2', '1010');
INSERT INTO `sys_role_menu` VALUES ('2', '1011');
INSERT INTO `sys_role_menu` VALUES ('2', '1012');
INSERT INTO `sys_role_menu` VALUES ('2', '1013');
INSERT INTO `sys_role_menu` VALUES ('2', '1014');
INSERT INTO `sys_role_menu` VALUES ('2', '1015');
INSERT INTO `sys_role_menu` VALUES ('2', '1016');
INSERT INTO `sys_role_menu` VALUES ('2', '1017');
INSERT INTO `sys_role_menu` VALUES ('2', '1018');
INSERT INTO `sys_role_menu` VALUES ('2', '1019');
INSERT INTO `sys_role_menu` VALUES ('2', '1020');
INSERT INTO `sys_role_menu` VALUES ('2', '1021');
INSERT INTO `sys_role_menu` VALUES ('2', '1022');
INSERT INTO `sys_role_menu` VALUES ('2', '1023');
INSERT INTO `sys_role_menu` VALUES ('2', '1024');
INSERT INTO `sys_role_menu` VALUES ('2', '1025');
INSERT INTO `sys_role_menu` VALUES ('2', '1026');
INSERT INTO `sys_role_menu` VALUES ('2', '1027');
INSERT INTO `sys_role_menu` VALUES ('2', '1028');
INSERT INTO `sys_role_menu` VALUES ('2', '1029');
INSERT INTO `sys_role_menu` VALUES ('2', '1030');
INSERT INTO `sys_role_menu` VALUES ('2', '1031');
INSERT INTO `sys_role_menu` VALUES ('2', '1032');
INSERT INTO `sys_role_menu` VALUES ('2', '1033');
INSERT INTO `sys_role_menu` VALUES ('2', '1034');
INSERT INTO `sys_role_menu` VALUES ('2', '1035');
INSERT INTO `sys_role_menu` VALUES ('2', '1036');
INSERT INTO `sys_role_menu` VALUES ('2', '1037');
INSERT INTO `sys_role_menu` VALUES ('2', '1038');
INSERT INTO `sys_role_menu` VALUES ('2', '1039');
INSERT INTO `sys_role_menu` VALUES ('2', '1040');
INSERT INTO `sys_role_menu` VALUES ('2', '1041');
INSERT INTO `sys_role_menu` VALUES ('2', '1042');
INSERT INTO `sys_role_menu` VALUES ('2', '1043');
INSERT INTO `sys_role_menu` VALUES ('2', '1044');
INSERT INTO `sys_role_menu` VALUES ('2', '1045');
INSERT INTO `sys_role_menu` VALUES ('2', '1046');
INSERT INTO `sys_role_menu` VALUES ('2', '1047');
INSERT INTO `sys_role_menu` VALUES ('2', '1048');
INSERT INTO `sys_role_menu` VALUES ('2', '1049');
INSERT INTO `sys_role_menu` VALUES ('2', '1050');
INSERT INTO `sys_role_menu` VALUES ('2', '1051');
INSERT INTO `sys_role_menu` VALUES ('2', '1052');
INSERT INTO `sys_role_menu` VALUES ('2', '1053');
INSERT INTO `sys_role_menu` VALUES ('2', '1054');
INSERT INTO `sys_role_menu` VALUES ('2', '1055');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（1正常 0停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(20) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '103', 'admin', 'vanguardd', '00', 'ry@163.com', '15888888888', '0', '0d5520b9d4793c577949eaa701a18d07.jpg', 'bf4f17e5f8eae528caf01eeb34a5b79d', '5d5bc9', '0', '0', '127.0.0.1', '2018-09-19 18:38:47', 'admin', '2018-03-16 11:33:00', 'ry', '2018-09-19 18:38:47', '管理员');
INSERT INTO `sys_user` VALUES ('2', '105', 'ry', '若依', '00', 'ry@qq.com', '15666666667', '1', '', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '0', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'admin', '2018-09-19 15:55:35', '测试员');
INSERT INTO `sys_user` VALUES ('3', '103', 'zhouyi', '周毅', '00', 'zhouyi@163.com', '18578912343', '1', '', 'c3a032f55660740a87919fd1a7261601', 'e65f58', '0', '0', '', null, 'admin', '2018-09-20 12:12:56', 'admin', '2018-09-20 16:58:01', '');

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线用户记录';

-- ----------------------------
-- Records of sys_user_online
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `post_id` varchar(64) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES ('1', '1');
INSERT INTO `sys_user_post` VALUES ('2', '2');
INSERT INTO `sys_user_post` VALUES ('3', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '2');

-- ----------------------------
-- Table structure for tb_collection
-- ----------------------------
DROP TABLE IF EXISTS `tb_collection`;
CREATE TABLE `tb_collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `house_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='收藏信息表';

-- ----------------------------
-- Records of tb_collection
-- ----------------------------
INSERT INTO `tb_collection` VALUES ('13', '2018-09-08 12:04:20', '1000', '17');
INSERT INTO `tb_collection` VALUES ('16', '2018-09-08 12:13:00', '10000', '17');
INSERT INTO `tb_collection` VALUES ('17', '2018-09-08 14:57:55', '1007', '20');
INSERT INTO `tb_collection` VALUES ('19', '2018-09-08 23:38:17', '1007', '17');
INSERT INTO `tb_collection` VALUES ('20', '2018-09-09 12:10:11', '1007', '19');
INSERT INTO `tb_collection` VALUES ('21', '2018-09-16 17:18:58', '1006', '20');

-- ----------------------------
-- Table structure for tb_contract
-- ----------------------------
DROP TABLE IF EXISTS `tb_contract`;
CREATE TABLE `tb_contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `signing_time` datetime DEFAULT NULL,
  `contract_url` varchar(255) DEFAULT NULL,
  `effective_time` datetime DEFAULT NULL,
  `party_a_id` bigint(20) DEFAULT NULL,
  `party_b_id` bigint(20) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_contract
-- ----------------------------
INSERT INTO `tb_contract` VALUES ('1000', null, null, null, '17', '17', '0', '2018-09-13 15:28:15');
INSERT INTO `tb_contract` VALUES ('1001', null, null, null, '17', '17', '0', '2018-09-13 15:29:22');
INSERT INTO `tb_contract` VALUES ('1002', null, null, null, '17', '17', '0', '2018-09-13 15:53:55');
INSERT INTO `tb_contract` VALUES ('1003', null, null, null, '17', '17', '0', '2018-09-13 16:20:44');
INSERT INTO `tb_contract` VALUES ('1004', null, null, null, '17', '17', '0', '2018-09-13 16:28:52');
INSERT INTO `tb_contract` VALUES ('1005', null, null, null, '17', '17', '0', '2018-09-13 16:31:28');
INSERT INTO `tb_contract` VALUES ('1006', null, null, null, '17', '19', '0', '2018-09-13 19:28:45');
INSERT INTO `tb_contract` VALUES ('1007', null, null, null, '17', '19', '0', '2018-09-13 19:29:04');
INSERT INTO `tb_contract` VALUES ('1008', null, null, null, '17', '19', '0', '2018-09-13 19:31:53');
INSERT INTO `tb_contract` VALUES ('1009', null, null, null, '17', '19', '0', '2018-09-13 19:32:20');
INSERT INTO `tb_contract` VALUES ('1010', null, null, null, '17', '19', '0', '2018-09-13 20:12:34');
INSERT INTO `tb_contract` VALUES ('1011', null, null, null, '17', '19', '0', '2018-09-13 21:42:58');
INSERT INTO `tb_contract` VALUES ('1012', null, null, null, '17', '17', '0', '2018-09-17 16:47:55');

-- ----------------------------
-- Table structure for tb_device
-- ----------------------------
DROP TABLE IF EXISTS `tb_device`;
CREATE TABLE `tb_device` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `client_id` varchar(50) NOT NULL COMMENT '设备唯一标识',
  `model` varchar(50) DEFAULT NULL COMMENT '设备型号',
  `vendor` varchar(50) DEFAULT NULL COMMENT '生产厂家',
  `uuid` varchar(50) DEFAULT NULL COMMENT '设备出厂标识',
  `screen_width` varchar(20) DEFAULT NULL COMMENT '分辨率宽',
  `screen_height` varchar(20) DEFAULT NULL COMMENT '分辨率高',
  `os_name` varchar(20) DEFAULT NULL COMMENT '操作系统名称',
  `os_version` varchar(20) DEFAULT NULL COMMENT '操作系统版本',
  `os_language` varchar(20) DEFAULT NULL COMMENT '系统语言',
  `os_vendor` varchar(50) DEFAULT NULL COMMENT '操作系统厂商',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备信息表';

-- ----------------------------
-- Records of tb_device
-- ----------------------------
INSERT INTO `tb_device` VALUES ('1', '21', '34eeb239863c18653eac80d4bd43b398', 'vivo X7', 'vivo', '862885036703909,862885036703891', '1080', '1920', 'Android', '5.1.1', 'zh_CN', 'Google', '2018-09-18 22:33:05', null);
INSERT INTO `tb_device` VALUES ('2', '22', '34eeb239863c18653eac80d4bd43b398', 'vivo X7', 'vivo', '862885036703909,862885036703891', '1080', '1920', 'Android', '5.1.1', 'zh_CN', 'Google', '2018-09-18 22:44:53', null);

-- ----------------------------
-- Table structure for tb_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `tb_evaluation`;
CREATE TABLE `tb_evaluation` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '评价编号',
  `content` varchar(255) DEFAULT NULL COMMENT '评价内容',
  `user_id` int(20) DEFAULT NULL COMMENT '评价人',
  `user_name` varchar(50) DEFAULT NULL COMMENT '评价人昵称',
  `house_id` int(20) DEFAULT NULL COMMENT '房屋编号',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房屋评价信息表';

-- ----------------------------
-- Records of tb_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for tb_house
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '房屋编号',
  `region` varchar(100) DEFAULT NULL COMMENT '一级地址',
  `city` varchar(50) DEFAULT NULL COMMENT '城市名',
  `address` varchar(255) DEFAULT NULL,
  `address_coordinate` varchar(255) DEFAULT NULL,
  `audit_time` datetime DEFAULT NULL,
  `auditor` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `exposition` varchar(255) DEFAULT NULL,
  `house_keeper_id` bigint(20) DEFAULT NULL,
  `house_pattern` varchar(255) DEFAULT NULL,
  `village_introduction` varchar(255) DEFAULT NULL,
  `landlord_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `landlord_name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `audit_state` int(11) DEFAULT NULL,
  `land_lord_zhi_ma_score` int(11) DEFAULT NULL,
  `balcony` varchar(1000) DEFAULT NULL,
  `bath_room` varchar(255) DEFAULT NULL,
  `kitchen` varchar(1000) DEFAULT NULL,
  `exit_rent_rule` varchar(255) DEFAULT NULL,
  `fixtures` varchar(255) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `green_area` double DEFAULT NULL,
  `heating_way` varchar(255) DEFAULT NULL,
  `is_has_elevator` bit(1) DEFAULT NULL,
  `land_lard_zhi_ma_score` int(11) DEFAULT NULL,
  `lease_contract_images` varchar(255) DEFAULT NULL,
  `plot_name` varchar(255) DEFAULT NULL,
  `property_card_id` varchar(255) DEFAULT NULL,
  `property_card_images` varchar(255) DEFAULT NULL,
  `property_carder` varchar(255) DEFAULT NULL,
  `rent_rule` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `custom_name` decimal(19,2) DEFAULT NULL,
  `custom_pay_type` varchar(255) DEFAULT NULL,
  `custom_value` decimal(19,2) DEFAULT NULL,
  `heating_value` decimal(19,2) DEFAULT NULL,
  `heating_pay_type` varchar(255) DEFAULT NULL,
  `parking` varchar(255) DEFAULT NULL,
  `property` varchar(255) DEFAULT NULL,
  `years` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `electric_pay_type` varchar(255) DEFAULT NULL,
  `living_room` varchar(1000) DEFAULT NULL,
  `living_room_images` varchar(255) DEFAULT NULL,
  `bath_room_images` varchar(255) DEFAULT NULL,
  `balcony_image` varchar(255) DEFAULT NULL,
  `labels` varchar(255) DEFAULT NULL,
  `balcony_images` varchar(255) DEFAULT NULL,
  `kitchen_images` varchar(255) DEFAULT NULL,
  `property_pay_type` varchar(255) DEFAULT NULL,
  `property_value` decimal(19,2) DEFAULT NULL,
  `water_pay_type` varchar(255) DEFAULT NULL,
  `water_value` decimal(19,2) DEFAULT NULL,
  `electric_value` decimal(19,2) DEFAULT NULL,
  `house_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='房屋信息表';

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES ('14', '雁塔区', '西安', '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, '2018-08-25 18:33:48', '东南', null, '四室一厅', '201', '17', '2018-08-25 18:33:48', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', null, '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, 'dsfe的粉色发,feawf分为发顺丰', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, null, 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急');
INSERT INTO `tb_house` VALUES ('16', '雁塔区', '西安', '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, '2018-08-25 18:33:49', '东', null, '四室一厅', '201', '17', '2018-08-25 18:33:49', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', null, '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, 'dsfe的粉色发,feawf分为发顺丰', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, null, 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急');
INSERT INTO `tb_house` VALUES ('18', '雁塔区', '西安', '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, '2018-08-25 19:34:14', '东南', null, '四室一厅', '201', '17', '2018-08-25 19:34:14', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', '5', '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, 'dsfe的粉色发,feawf分为发顺丰', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, null, 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急');
INSERT INTO `tb_house` VALUES ('19', '雁塔区', '西安', '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, '2018-08-26 23:55:49', '北', null, '四室一厅', '201', '17', '2018-08-26 23:55:49', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', '5', '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, 'dsfe的粉色发,feawf分为发顺丰', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, null, 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急');
INSERT INTO `tb_house` VALUES ('20', '雁塔区', '西安', '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883943,34.217141', null, null, '2018-09-07 22:18:45', null, null, '三室一厅', '', '17', '2018-09-07 22:18:45', '王五', '审核通过', '1', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机,id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000115&icon:icon-bank-card&name:太阳能,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000118&icon:icon-bank-card&name:浴缸', 'id:2000156&icon:icon-bank-card&name:煤气灶,id:2000161&icon:icon-bank-card&name:高压锅,id:2000158&icon:icon-bank-card&name:电磁炉', '分分,哥大姑夫', '简装', null, '525', '人跟人', null, null, null, '还给你吧', '548525555', 'http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M,http://pckhspvcg.bkt.clouddn.com/FmFRyZbeamTvbxESxGE9QLQmpbOA,http://pckhspvcg.bkt.clouddn.com/FptI-DdccTIAKBg0wraKrcAlV1k2', '而已我', '惩罚军服,头发方便', null, null, null, null, null, '月', '沸腾鱼', '狗肉馆', '', null, '月', 'id:2000104&icon:icon-bank-card&name:茶几,id:2000106&icon:icon-bank-card&name:WIFI,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000102&icon:icon-bank-card&name:沙发,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板', 'http://pckhspvcg.bkt.clouddn.com/Fnpduwh5EwzIHfQ-6QYf1lQ9vwti', 'http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', null, null, 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', '月', '100.00', '月', '100.00', '50.00', '转租 转租');
INSERT INTO `tb_house` VALUES ('21', '雁塔区', '西安', '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883783,34.217205', null, null, '2018-09-08 13:28:59', null, null, '三室一厅', '', '17', '2018-09-08 13:28:59', '王五', '审核通过', '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机,id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000118&icon:icon-bank-card&name:浴缸,id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000154&icon:icon-bank-card&name:冰箱,id:2000157&icon:icon-bank-card&name:天然气', '测试测试,测试测试', '精装', null, '50', '集中供暖', null, null, null, '美寓华庭', '123784684678', 'http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66', '45844251761635', '测试  测试  测试,测试测试', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000104&icon:icon-bank-card&name:茶几,id:2000106&icon:icon-bank-card&name:WIFI,id:2000113&icon:icon-bank-card&name:木质地板,id:2000108&icon:icon-bank-card&name:暖气,id:2000102&icon:icon-bank-card&name:沙发', 'http://pckhspvcg.bkt.clouddn.com/FpW-k-JtefsOv4-NGPamM9sjoflM', 'http://pckhspvcg.bkt.clouddn.com/FijXSZMxzFCJHSsoartuur3g1sX1,http://pckhspvcg.bkt.clouddn.com/Fpu-1pXj3HL5ISZw7PebbROe7N48', null, null, 'http://pckhspvcg.bkt.clouddn.com/FocOm0kH6qkwTdQeoyzhgrE4N7US', 'http://pckhspvcg.bkt.clouddn.com/FmexXcCCh_gSAZvYc128TGn3nwl6,http://pckhspvcg.bkt.clouddn.com/FoQkveDGoxz4D6ShMLJkdIozvnEZ', '月', '100.00', '月', '50.00', '100.00', '美寓华庭三室一厅');

-- ----------------------------
-- Table structure for tb_identity_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_identity_auth`;
CREATE TABLE `tb_identity_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '认证编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `id_type` varchar(50) DEFAULT NULL COMMENT '证件类型',
  `id_number` varchar(50) DEFAULT NULL COMMENT '证件号',
  `image1` varchar(1000) DEFAULT NULL COMMENT '证件照1',
  `image2` varchar(1000) DEFAULT NULL COMMENT '证件照2',
  `image3` varchar(1000) DEFAULT NULL COMMENT '证件照3',
  `remark` varchar(255) DEFAULT NULL COMMENT '审核备注',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态 0=审请状态/1=审核通过/2=审核拒绝',
  `create_time` datetime DEFAULT NULL COMMENT '申请时间',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `auditor_id` bigint(20) DEFAULT NULL COMMENT '审核人编号',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='实名认证表';

-- ----------------------------
-- Records of tb_identity_auth
-- ----------------------------
INSERT INTO `tb_identity_auth` VALUES ('9', '19', '王国栋', null, '1656356864656875', 'http://pckhspvcg.bkt.clouddn.com/FiZ6nl3oDbm0mimcMZKCbWTR5cOD', 'http://pckhspvcg.bkt.clouddn.com/lkfZKpRaHDBhk4G8y4BfF_TUjpaE', null, '认证通过', '1', '2018-09-05 19:28:56', '2018-09-05 19:37:15', null);
INSERT INTO `tb_identity_auth` VALUES ('10', '17', '王五', null, '16491654816469491949', 'http://pckhspvcg.bkt.clouddn.com/Fnpduwh5EwzIHfQ-6QYf1lQ9vwti', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', null, '认证通过', '1', '2018-09-06 16:34:56', '2018-09-06 16:38:08', null);
INSERT INTO `tb_identity_auth` VALUES ('17', '20', '周毅', null, '510512199401162518', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535614873020&di=ba1c494fd0219ce204eacb3f38740b5f&imgtype=0&src=http%3A%2F%2Fcq.focus.cn%2Fupload%2Fphotos%2F1760%2F7Nh8JmKZ.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535614873020&di=38480fb27ef7ec641d8f5a599ffdf4cc&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3Db05d0b3c38fa828bc52e95a394672458%2Fd788d43f8794a4c2717d681205f41bd5ad6e39a8.jpg', null, '通过', '1', '2018-09-14 12:41:32', '2018-09-14 12:48:43', null);

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单Id',
  `order_number` varchar(50) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `renter_sign_state` int(11) DEFAULT NULL COMMENT '租客签字状态',
  `landLord_id` bigint(20) DEFAULT NULL COMMENT '房东编号',
  `landLord_sign_state` int(11) DEFAULT NULL COMMENT '房东签字状态',
  `house_id` bigint(20) DEFAULT NULL COMMENT '房屋编号',
  `contract_id` bigint(20) DEFAULT NULL COMMENT '合同编号',
  `rent_date_limit` varchar(50) DEFAULT NULL COMMENT '租住期限',
  `state` int(11) DEFAULT NULL COMMENT '订单状态',
  `pay_way` int(11) DEFAULT NULL COMMENT '支付方式',
  `amount` decimal(19,0) DEFAULT NULL COMMENT '订单金额',
  `discount_amount` decimal(19,0) DEFAULT NULL COMMENT '优惠金额',
  `business_amount` decimal(19,0) DEFAULT NULL COMMENT '交易金额',
  `renter_sign_time` datetime DEFAULT NULL COMMENT '租客签约时间',
  `landLord_sign_time` datetime DEFAULT NULL COMMENT '房东签约时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  `business_time` datetime DEFAULT NULL COMMENT '交易时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='订单信息表';

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('3', '201809131631421753', '17', '0', '17', '0', '10000', '1005', null, '9', null, '1500', null, null, null, null, '2018-09-13 16:31:42', '2018-09-13 16:31:42', null);
INSERT INTO `tb_order` VALUES ('4', '201809132143021920', '19', '0', '17', '0', '1006', '1011', null, '9', null, '2500', null, null, null, null, '2018-09-13 21:43:02', '2018-09-13 21:43:02', null);
INSERT INTO `tb_order` VALUES ('5', '201809141433442095', '20', '0', '17', '0', '1007', null, null, '9', null, '2500', null, null, null, null, '2018-09-14 14:33:44', '2018-09-14 14:33:44', null);
INSERT INTO `tb_order` VALUES ('7', '201809171647581774', '17', '0', '17', '0', '1006', '1012', 'six', '1', null, '4100', null, null, null, null, '2018-09-17 16:47:58', '2018-09-17 16:47:58', null);

-- ----------------------------
-- Table structure for tb_reservation
-- ----------------------------
DROP TABLE IF EXISTS `tb_reservation`;
CREATE TABLE `tb_reservation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `time_range` int(5) DEFAULT NULL,
  `sex` int(5) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `mobile_phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `state` int(5) DEFAULT NULL COMMENT '预约信息状态',
  `create_time` datetime DEFAULT NULL,
  `reservation_date` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='预约看房信息表';

-- ----------------------------
-- Records of tb_reservation
-- ----------------------------
INSERT INTO `tb_reservation` VALUES ('7', '1000', '17', '测试测试', '2', '1', '王五', '17691229633', '0', '2018-09-08 12:04:48', '2018-09-11 08:00:00', '2018-09-08 12:04:48');
INSERT INTO `tb_reservation` VALUES ('8', '1001', '19', '111111111111111111111111111111', '1', '1', '王国栋', '18590718679', '1', '2018-09-08 12:18:13', '2018-09-09 08:00:00', '2018-09-10 18:11:47');
INSERT INTO `tb_reservation` VALUES ('9', '1007', '19', '测试测试测试测试测试11111', '2', '1', '王国栋', '18590718679', '0', '2018-09-09 12:09:53', '2018-09-11 08:00:00', '2018-09-10 16:47:41');

-- ----------------------------
-- Table structure for tb_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_room`;
CREATE TABLE `tb_room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '房间Id',
  `house_id` bigint(20) DEFAULT NULL COMMENT '房屋Id',
  `room_name` varchar(255) DEFAULT NULL COMMENT '房间名称',
  `room_area` double DEFAULT NULL COMMENT '房间面积',
  `room_facilities` varchar(1000) DEFAULT NULL COMMENT '房间设施',
  `room_image` varchar(255) DEFAULT NULL COMMENT '房间照片（首页）',
  `room_images` varchar(1000) DEFAULT NULL COMMENT '房间照片',
  `exposition` varchar(255) DEFAULT NULL COMMENT '朝向',
  `rent` decimal(19,2) DEFAULT NULL COMMENT '租金',
  `pay_way` varchar(255) DEFAULT NULL COMMENT '支付方式',
  `rent_way` varchar(255) DEFAULT NULL COMMENT '租住方式',
  `labels` varchar(1000) DEFAULT NULL COMMENT '标签',
  `introduction` varchar(255) DEFAULT NULL COMMENT '房间介绍',
  `date_limit` varchar(50) DEFAULT NULL COMMENT '最短租住期限',
  `deposit` varchar(50) DEFAULT NULL COMMENT '押金',
  `state` int(5) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='房间信息表';

-- ----------------------------
-- Records of tb_room
-- ----------------------------
INSERT INTO `tb_room` VALUES ('1000', '19', '主卧', '30', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:piaochuang&icon:icon-bank-card&name:飘窗,id:kongtiao&icon:icon-bank-card&name:空调,id:mujiachuang&icon:icon-bank-card&name:木架床,id:closet&icon:icon-bank-card&name:衣柜,id:chair&icon:icon-bank-card&name:椅子,id:bathroom&icon:icon-bank-card&name:独卫,id:geyser1&icon:icon-bank-card&name:热水器', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Fnpduwh5EwzIHfQ-6QYf1lQ9vwti', '南', '1400.00', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信,id:xinyongka&icon:icon-bank-card&name:信用卡', '季付', '新房入驻,近地铁,清新装饰', 'sfejafjekasjfelsaf', 'six', 'yayi', '1', '2018-09-07 22:05:21', '2018-09-07 22:05:21');
INSERT INTO `tb_room` VALUES ('1001', '19', '主卧', '30', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:piaochuang&icon:icon-bank-card&name:飘窗,id:kongtiao&icon:icon-bank-card&name:空调,id:mujiachuang&icon:icon-bank-card&name:木架床,id:closet&icon:icon-bank-card&name:衣柜,id:chair&icon:icon-bank-card&name:椅子,id:bathroom&icon:icon-bank-card&name:独卫,id:geyser1&icon:icon-bank-card&name:热水器', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Fnpduwh5EwzIHfQ-6QYf1lQ9vwti', '南', '1400.00', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信,id:xinyongka&icon:icon-bank-card&name:信用卡', '季付', '新房入驻,近地铁,清新装饰', 'sfejafjekasjfelsaf', 'six', 'yasan', '1', '2018-09-07 22:05:21', '2018-09-07 22:05:21');
INSERT INTO `tb_room` VALUES ('1002', '20', '主卧', '30', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:piaochuang&icon:icon-bank-card&name:飘窗,id:kongtiao&icon:icon-bank-card&name:空调,id:mujiachuang&icon:icon-bank-card&name:木架床,id:closet&icon:icon-bank-card&name:衣柜,id:chair&icon:icon-bank-card&name:椅子,id:bathroom&icon:icon-bank-card&name:独卫,id:geyser1&icon:icon-bank-card&name:热水器', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Fnpduwh5EwzIHfQ-6QYf1lQ9vwti', '南', '1400.00', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信,id:xinyongka&icon:icon-bank-card&name:信用卡', '季付', '新房入驻,近地铁,清新装饰', 'sfejafjekasjfelsaf', 'six', 'yasan', '1', '2018-09-07 22:05:21', '2018-09-07 22:05:21');
INSERT INTO `tb_room` VALUES ('1003', '18', '主卧', '30', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:piaochuang&icon:icon-bank-card&name:飘窗,id:kongtiao&icon:icon-bank-card&name:空调,id:mujiachuang&icon:icon-bank-card&name:木架床,id:closet&icon:icon-bank-card&name:衣柜,id:chair&icon:icon-bank-card&name:椅子,id:bathroom&icon:icon-bank-card&name:独卫,id:geyser1&icon:icon-bank-card&name:热水器', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Fnpduwh5EwzIHfQ-6QYf1lQ9vwti', '南', '1400.00', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信,id:xinyongka&icon:icon-bank-card&name:信用卡', '季付', '新房入驻,近地铁,清新装饰', 'sfejafjekasjfelsaf', 'six', 'yasan', '1', '2018-09-07 22:05:21', '2018-09-07 22:05:21');
INSERT INTO `tb_room` VALUES ('1005', '16', '主卧', '30', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:piaochuang&icon:icon-bank-card&name:飘窗,id:kongtiao&icon:icon-bank-card&name:空调,id:mujiachuang&icon:icon-bank-card&name:木架床,id:closet&icon:icon-bank-card&name:衣柜,id:chair&icon:icon-bank-card&name:椅子,id:bathroom&icon:icon-bank-card&name:独卫,id:geyser1&icon:icon-bank-card&name:热水器', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Fnpduwh5EwzIHfQ-6QYf1lQ9vwti', '南', '1400.00', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信,id:xinyongka&icon:icon-bank-card&name:信用卡', '季付', '新房入驻,近地铁,清新装饰', 'sfejafjekasjfelsaf', 'six', 'yayi', '0', '2018-09-07 22:05:21', '2018-09-07 22:05:21');
INSERT INTO `tb_room` VALUES ('1006', '21', '主卧', '45', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:windows&icon:icon-bank-card&name:有窗,id:kongtiao&icon:icon-bank-card&name:空调,id:table&icon:icon-bank-card&name:桌子,id:closet&icon:icon-bank-card&name:衣柜,id:Solar&icon:icon-bank-card&name:太阳能', 'http://pckhspvcg.bkt.clouddn.com/FiAfwkyQLc_weZXnL46778K0519l', 'http://pckhspvcg.bkt.clouddn.com/FiAfwkyQLc_weZXnL46778K0519l,http://pckhspvcg.bkt.clouddn.com/FocOm0kH6qkwTdQeoyzhgrE4N7US,http://pckhspvcg.bkt.clouddn.com/FiAfwkyQLc_weZXnL46778K0519l,http://pckhspvcg.bkt.clouddn.com/FtlZdsNBGLgiT_ay3LxGaDB746Yo,http://pckhspvcg.bkt.clouddn.com/FrnXClxVh1dGJh907rlDyqv3LZ9f,http://pckhspvcg.bkt.clouddn.com/FspF_A_f9JfbRmM4nvCYjfU0yOBN', '西', '1000.00', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信,id:jingdong&icon:icon-bank-card&name:京东,id:yinlian&icon:icon-bank-card&name:银联,id:xinyongka&icon:icon-bank-card&name:信用卡', '月付', '新房入驻', null, 'three', 'yasan', '1', '2018-09-08 13:26:13', '2018-09-08 13:26:13');
INSERT INTO `tb_room` VALUES ('1007', '21', '次卧', '30', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:bathroom&icon:icon-bank-card&name:独卫,id:piaochuang&icon:icon-bank-card&name:飘窗,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:Solar&icon:icon-bank-card&name:太阳能,id:mujiachuang&icon:icon-bank-card&name:木架床,id:table&icon:icon-bank-card&name:桌子', 'http://pckhspvcg.bkt.clouddn.com/FiCzLvbyo-oGATGuNeC1akZr1CUZ', 'http://pckhspvcg.bkt.clouddn.com/FiCzLvbyo-oGATGuNeC1akZr1CUZ,http://pckhspvcg.bkt.clouddn.com/FiCzLvbyo-oGATGuNeC1akZr1CUZ,http://pckhspvcg.bkt.clouddn.com/Fn7LawBlwaorpqaYhI7QK17yOmfX', '西', '1200.00', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信,id:xinyongka&icon:icon-bank-card&name:信用卡', '月付', '新房入驻', null, 'three', 'yayi', '1', '2018-09-08 13:27:36', '2018-09-08 13:27:36');
INSERT INTO `tb_room` VALUES ('10000', '20', '主卧', '30', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:piaochuang&icon:icon-bank-card&name:飘窗,id:kongtiao&icon:icon-bank-card&name:空调,id:mujiachuang&icon:icon-bank-card&name:木架床,id:closet&icon:icon-bank-card&name:衣柜,id:chair&icon:icon-bank-card&name:椅子,id:bathroom&icon:icon-bank-card&name:独卫,id:geyser1&icon:icon-bank-card&name:热水器', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66', 'http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Ftyb6RK4dYBTtQAcwDuOdGLYXL66,http://pckhspvcg.bkt.clouddn.com/Fnpduwh5EwzIHfQ-6QYf1lQ9vwti', '南', '1400.00', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信,id:xinyongka&icon:icon-bank-card&name:信用卡', '季付', '新房入驻,近地铁,清新装饰', 'sfejafjekasjfelsaf', 'six', 'wu', '1', '2018-09-07 22:05:21', '2018-09-07 22:05:21');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `mobile_phone` varchar(25) DEFAULT NULL COMMENT '手机号',
  `password` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `last_password_reset_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '用户 状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='会员信息表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('16', 'user123', '15529960414', '12345', 'user123@qq.com', '2018-08-19 15:12:19', '0');
INSERT INTO `tb_user` VALUES ('17', 'user1111', '17691229633', '12345', 'user1111@qq.com', '2018-08-19 15:31:58', '0');
INSERT INTO `tb_user` VALUES ('18', 'user567896', '17691229635', '$2a$10$tV2oTvX6ZtQhQ9nHh630bO1c5xG/1q952bNUB8IECkVnAX.80OR/S', null, '2018-08-28 12:12:40', '0');
INSERT INTO `tb_user` VALUES ('19', 'user15874', '18590718679', '$2a$10$cRbWAZAYOFnJXXosq4OgO.4goDGtBxn3wnsaRUmU1L0XJtQsPE236', null, '2018-09-02 20:57:00', '0');
INSERT INTO `tb_user` VALUES ('20', '很美味', '18142346863', '$2a$10$g7MfU.5BQv2Wx012vLFiuuqWs479vfi6Hb62k8Um6s/ZwToylBClS', null, '2018-09-07 22:13:26', '0');
INSERT INTO `tb_user` VALUES ('21', '你猜', '15249271170', '$2a$10$6JxV4IsgkJ9Ld53vGed7eeQstGso5dl88UbNnx2ci8kNCg6r.D5jS', null, '2018-09-18 22:33:04', '0');

-- ----------------------------
-- Table structure for tb_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_info`;
CREATE TABLE `tb_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户信息编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `mobile_phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `sex` int(1) DEFAULT NULL COMMENT '性别 0=女/1=男',
  `born_date` datetime DEFAULT NULL COMMENT '出生年月',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `company_address` varchar(200) DEFAULT NULL COMMENT '公司地址',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='会员详细信息表';

-- ----------------------------
-- Records of tb_user_info
-- ----------------------------
INSERT INTO `tb_user_info` VALUES ('13', '16', 'user123', '15529960414', 'user123@qq.com', '1', '1995-01-04 18:25:02', null, 'https://pic.tujia.com/upload/landlordStorelogo/day_180420/201804201954454197.jpg', '', '2018-08-19 15:12:23', '2018-08-19 15:12:23');
INSERT INTO `tb_user_info` VALUES ('14', '17', 'user1111', '17691229633', 'user1111@qq.com', '0', '1995-08-19 08:00:00', '王五', 'http://pckhspvcg.bkt.clouddn.com/FmE0MWysCJiOhklc8bHinHXyen4y', '北京东城区西城区', '2018-08-19 15:31:58', '2018-08-19 15:31:58');
INSERT INTO `tb_user_info` VALUES ('15', '18', 'user567896', '17691229635', null, '1', '1994-08-28 08:00:00', '', 'https://pic.tujia.com/upload/landlordStorelogo/day_180420/201804201954454197.jpg', '北京东城区东城区', '2018-08-28 12:12:40', '2018-08-28 12:12:40');
INSERT INTO `tb_user_info` VALUES ('16', '19', 'user15874', '18590718679', null, '1', '1995-05-02 08:00:00', '王国栋', 'http://pckhspvcg.bkt.clouddn.com/FizbLFTChKtoZYwo9VA5X3lJyiEP', '北京东城区崇文区', '2018-09-02 20:57:00', '2018-09-02 20:57:00');
INSERT INTO `tb_user_info` VALUES ('17', '20', '很美味', '18142346863', null, '1', '1994-01-15 08:00:00', '周毅', null, '北京东城区东城区', '2018-09-07 22:13:26', '2018-09-07 22:13:26');
INSERT INTO `tb_user_info` VALUES ('18', '21', '你猜', '15249271170', null, '1', '2018-09-18 08:00:00', null, 'http://pckhspvcg.bkt.clouddn.com/FgbeUP5dGrpsE9gwE8QBLT-Z7snD', '北京东城区东城区', '2018-09-18 22:33:04', '2018-09-18 22:33:04');
INSERT INTO `tb_user_info` VALUES ('19', '22', '周会', '17809268868', null, '1', null, null, 'https://pic.tujia.com/upload/landlordStorelogo/day_180420/201804201954454197.jpg', '', '2018-09-18 22:44:53', '2018-09-18 22:44:53');

-- ----------------------------
-- Table structure for tb_zhima_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_zhima_auth`;
CREATE TABLE `tb_zhima_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `zm_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='芝麻信用认证表';

-- ----------------------------
-- Records of tb_zhima_auth
-- ----------------------------
INSERT INTO `tb_zhima_auth` VALUES ('1', null, null, '5', '700');
