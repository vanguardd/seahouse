/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : seahouse

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-09-07 15:26:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `uid` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT '1',
  `salt` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `is_system` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `unique_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('1e67f167d99c43f897ec6566043ad6ec', 'flyshy', 'eb3a90502fbe02c2d8de91e0aa307268', '1', '5016b9942433201bf3fe61992eacba71', '0', '2016-12-07 13:24:17', '2017-11-02 09:27:37');
INSERT INTO `sys_admin` VALUES ('ad313d38fe9447ce863fe8584743a010', 'admin', 'c5941c5f3bc693a75e6e863bd2c55ce3', '1', '1ab6d62faa91ae7deec76d6f13ef1600', '1', '2016-12-06 11:16:51', '2017-05-11 13:59:25');

-- ----------------------------
-- Table structure for sys_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_role`;
CREATE TABLE `sys_admin_role` (
  `admin_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `role_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`admin_id`,`role_id`),
  KEY `admin_role_foreign` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_admin_role
-- ----------------------------
INSERT INTO `sys_admin_role` VALUES ('1e67f167d99c43f897ec6566043ad6ec', 'cbe8356d64a8433cb5dad5c7fccf8dce');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `log_id` varchar(32) NOT NULL,
  `log_user` varchar(32) DEFAULT NULL,
  `log_time` datetime DEFAULT NULL,
  `log_ip` varchar(15) DEFAULT NULL,
  `log_action` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('00a194e3b4ef4d8984c0bc0a7f32c35d', 'admin', '2018-07-28 15:26:23', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('0165d85a678543c9beac5960e2be9a02', 'admin', '2018-06-14 15:54:55', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('02305d9b25214197b9e12bb8f2cd6cc5', 'admin', '2017-11-13 10:47:27', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('024021f259444cbfbee7b40a2384d43b', 'admin', '2017-03-09 17:23:54', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('0885b563e6a34b95a776d46df5b63b2c', 'admin', '2018-07-28 15:58:39', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('29064846cb6a4de2ba6806231e7347af', 'admin', '2018-07-30 17:56:17', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('2adb988d20f34536806bb51c2576ec96', 'admin', '2018-07-31 12:28:42', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('3eb6d122a6b84e6598253fa9f4154e48', 'admin', '2018-07-27 16:03:45', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('765c0e6550b44526b9ceb681d3edd4db', 'admin', '2018-07-31 20:42:13', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('7b513a9b65bd4f7cb2a935e4cb366681', 'admin', '2018-07-28 15:53:15', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('8b73e8c106df4a4eb5fd3a6c252ba4b3', 'admin', '2018-07-31 20:49:25', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('8eb609a94ced49cc81a428ac6243b110', 'admin', '2018-07-28 14:52:07', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('8ff37ad74130498bb5f3c0a9d86e4529', 'admin', '2018-07-31 12:17:43', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('ad29d10848c84020a4b9111b0c1acfb7', 'admin', '2018-07-28 14:59:18', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('adbdd0ed3a6e4f758d0e9070d0287929', 'admin', '2018-07-31 18:42:01', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('b3f79f28b9294451859afa032afa1924', 'admin', '2018-07-31 12:47:38', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('cd15c72d20d5453986cbdca5ccb96b87', 'admin', '2018-07-30 17:24:23', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('d5dc9911ea7b4aa2ad524159e82e4176', 'admin', '2018-07-31 12:24:51', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('df418271b8a0472fa5d2265edf252d35', 'admin', '2018-07-31 16:04:20', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('e48022790414497ca2ed21a1e2709d06', 'admin', '2018-07-31 20:21:36', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('e8d7820dd5b143538994db64c96e40fa', 'admin', '2018-07-31 20:49:17', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('f039e09766ce4f16bc13ae04fbb21875', 'admin', '2018-07-28 15:11:09', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('f23bfeb65337415092c3c448cb2a1c23', 'admin', '2018-07-30 19:30:05', '127.0.0.1', '');
INSERT INTO `sys_log` VALUES ('f497162638494361bb562fea89692274', 'admin', '2018-07-31 12:23:16', '127.0.0.1', '');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `menu_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `menu_type` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '资源类型，菜单或都按钮(menu,button)',
  `menu_url` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `menu_code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `parent_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `parent_ids` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `child_num` int(10) NOT NULL DEFAULT '0',
  `listorder` int(10) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('00dc5c51e4824f49a30013385f680b0c', '日志管理', 'auth', '/log/index', 'log:index', 'e5f52fe2115e46229c60803e478d2e9a', null, '0', '1', '2017-01-06 14:11:23', '2017-05-08 14:55:21');
INSERT INTO `sys_menu` VALUES ('1cc3d9ad04e4424db1bb086d1678925e', '菜单删除', 'auth', '/menu/delete', 'menu:delete', '736bdf0b9aec4c59928a530e34bd9aad', null, '0', '0', '2017-05-10 16:45:30', '2017-05-10 16:45:30');
INSERT INTO `sys_menu` VALUES ('2191c9efc2fa431bb427b81ad938e8aa', '角色保存', 'auth', '/role/save', 'role:save', '6cda978dc9404ba2bf5854b74735b0bc', null, '0', '0', '2017-05-10 16:41:21', '2017-05-10 16:41:21');
INSERT INTO `sys_menu` VALUES ('362923d31e064f84adb8c23ba91e54d8', '管理员编辑', 'auth', '/admin/from', 'admin:edit', 'e0dde3b9227c471eb3bd2ba0a7fab131', null, '0', '0', '2017-05-08 14:57:39', '2017-05-10 16:40:47');
INSERT INTO `sys_menu` VALUES ('3ac96215e82f40b5bfe442e6828641df', '系统管理', 'menu', '/system/admin', 'system:admin', '0', null, '3', '1', '2016-12-07 16:00:00', '2017-05-10 16:46:27');
INSERT INTO `sys_menu` VALUES ('6580896645d046a0acf3c1194d7bbf8e', '管理员删除', 'menu', '/admin/delete', 'admin:delete', 'e0dde3b9227c471eb3bd2ba0a7fab131', null, '0', '0', '2017-05-10 16:39:44', '2017-05-10 16:39:44');
INSERT INTO `sys_menu` VALUES ('6cda978dc9404ba2bf5854b74735b0bc', '角色管理', 'auth', '/role/index', 'role:index', '3ac96215e82f40b5bfe442e6828641df', null, '4', '2', '2016-12-07 16:47:40', '2016-12-07 16:47:40');
INSERT INTO `sys_menu` VALUES ('736bdf0b9aec4c59928a530e34bd9aad', '菜单管理', 'auth', '/menu/index', 'menu:index', '3ac96215e82f40b5bfe442e6828641df', null, '3', '3', '2016-12-07 16:50:17', '2016-12-07 16:50:17');
INSERT INTO `sys_menu` VALUES ('85dad2bd9023451fab632dcfc4357d3b', '管理员保存', 'auth', '/admin/save', 'admin:save', 'e0dde3b9227c471eb3bd2ba0a7fab131', null, '0', '0', '2017-05-10 16:38:07', '2017-05-10 16:41:00');
INSERT INTO `sys_menu` VALUES ('8a653e3fb15642d9be6aad13b02009fb', '角色授权', 'auth', '/role/grant', 'role:grant', '6cda978dc9404ba2bf5854b74735b0bc', null, '0', '0', '2017-05-10 16:42:37', '2017-05-10 16:42:37');
INSERT INTO `sys_menu` VALUES ('984909260a06410d9be37c300e3df09d', '会员管理', 'menu', '/user/default', 'member:default', '0', null, '1', '0', '2017-05-10 16:50:16', '2018-06-13 14:36:46');
INSERT INTO `sys_menu` VALUES ('9f41af1454d046b596023a2822c5078c', '角色编辑', 'auth', '/role/from', 'role:edit', '6cda978dc9404ba2bf5854b74735b0bc', null, '0', '0', '2017-05-08 14:59:25', '2017-05-08 14:59:25');
INSERT INTO `sys_menu` VALUES ('aab7966c97db4643a36cb5afa24be38b', '角色删除', 'menu', '/role/delete', 'role:delete', '6cda978dc9404ba2bf5854b74735b0bc', null, '0', '0', '2017-05-10 16:43:37', '2017-05-10 16:43:37');
INSERT INTO `sys_menu` VALUES ('c5cca135ee534bfeb482fb04b9311982', '菜单编辑', 'auth', '/menu/from', 'menu:from', '736bdf0b9aec4c59928a530e34bd9aad', null, '0', '0', '2016-12-07 16:51:31', '2017-05-08 15:00:02');
INSERT INTO `sys_menu` VALUES ('e0dde3b9227c471eb3bd2ba0a7fab131', '管理员管理', 'auth', '/admin/index', 'admin:index', '3ac96215e82f40b5bfe442e6828641df', null, '3', '1', '2016-12-07 16:45:47', '2017-05-10 16:39:08');
INSERT INTO `sys_menu` VALUES ('e5f52fe2115e46229c60803e478d2e9a', '扩展设置', 'menu', '/system/setting', 'system:setting', '0', null, '1', '3', '2016-12-07 16:36:42', '2017-05-10 16:50:00');
INSERT INTO `sys_menu` VALUES ('e85b2fb3e6ee4d0a9711c577bc842821', '会员管理', 'auth', '/user/index', 'member:index', '984909260a06410d9be37c300e3df09d', null, '0', '0', '2017-05-10 16:51:20', '2017-05-10 16:51:20');
INSERT INTO `sys_menu` VALUES ('f4237d06c0c94906bdc04f5ed19cbaeb', '菜单保存', 'auth', '/menu/save', 'menu:save', '736bdf0b9aec4c59928a530e34bd9aad', null, '0', '0', '2017-05-10 16:44:51', '2017-05-10 16:44:51');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `role_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `role_desc` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name_unique` (`role_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('36f1dd1296674fc08484c5abf6a5806b', '系统管理员', '系统管理员', '1', '2016-12-07 08:53:57', '2017-05-11 13:59:03');
INSERT INTO `sys_role` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', '普通管理员', '普通管理员', '1', '2016-12-07 13:21:21', '2017-05-05 12:58:38');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `menu_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `role_menu_foreign` (`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', '00dc5c51e4824f49a30013385f680b0c');
INSERT INTO `sys_role_menu` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', '984909260a06410d9be37c300e3df09d');
INSERT INTO `sys_role_menu` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', 'e5f52fe2115e46229c60803e478d2e9a');
INSERT INTO `sys_role_menu` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', 'e85b2fb3e6ee4d0a9711c577bc842821');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_collection
-- ----------------------------
INSERT INTO `tb_collection` VALUES ('2', '2018-08-28 21:51:02', '18', '17');
INSERT INTO `tb_collection` VALUES ('8', '2018-08-31 22:14:20', '17', '17');
INSERT INTO `tb_collection` VALUES ('9', '2018-09-04 16:45:41', '14', '19');
INSERT INTO `tb_collection` VALUES ('10', '2018-09-05 19:53:38', '18', '19');
INSERT INTO `tb_collection` VALUES ('11', '2018-09-06 17:11:52', '12', '17');
INSERT INTO `tb_collection` VALUES ('12', '2018-09-06 17:12:00', '10', '17');

-- ----------------------------
-- Table structure for tb_contract
-- ----------------------------
DROP TABLE IF EXISTS `tb_contract`;
CREATE TABLE `tb_contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `signing_time` datetime DEFAULT NULL,
  `contract_url` varchar(255) DEFAULT NULL,
  `effective_time` datetime DEFAULT NULL,
  `partya_id` bigint(20) DEFAULT NULL,
  `partyb_id` bigint(20) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_contract
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for tb_house
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '房屋编号',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `first_address` varchar(100) DEFAULT NULL COMMENT '一级地址',
  `address` varchar(255) DEFAULT NULL,
  `address_coordinate` varchar(255) DEFAULT NULL,
  `audit_state` varchar(255) DEFAULT NULL,
  `audit_time` datetime DEFAULT NULL,
  `auditor` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `exposition` varchar(255) DEFAULT NULL,
  `house_keeper_id` bigint(20) DEFAULT NULL,
  `house_pattern` varchar(255) DEFAULT NULL,
  `village_introduction` varchar(255) DEFAULT NULL,
  `landlord_id` bigint(20) DEFAULT NULL,
  `pay_way` varchar(255) DEFAULT NULL,
  `rent_way` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `landlord_name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
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
  `rent` decimal(19,2) DEFAULT NULL,
  `rent_rule` varchar(255) DEFAULT NULL,
  `room_area` double DEFAULT NULL,
  `room_facilities` varchar(255) DEFAULT NULL,
  `room_images` varchar(255) DEFAULT NULL,
  `room_name` varchar(255) DEFAULT NULL,
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
  `date_limit` varchar(50) DEFAULT NULL COMMENT '最短租住期限',
  `room_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES ('8', '急转租 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-23 17:54:29', '东南', null, '四室一厅', null, '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-23 17:54:29', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'null,null,null', '简装', '12', '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'null,null', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('9', '急转租 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-23 18:14:36', '东南', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-23 18:14:36', null, null, '2', '1', null, 'id:2000165&icon:icon-bank-card&name:洗衣机,id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', '11', '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('10', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-23 18:14:52', '西', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-23 18:14:52', null, null, '2', '1', null, 'id:2000166&icon:icon-bank-card&name:洗衣机,id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', '11', '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('11', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-25 18:33:45', '东南', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-25 18:33:45', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', null, '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('12', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-25 18:33:46', '东南', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-25 18:33:46', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', null, '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('13', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-25 18:33:47', '南', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-25 18:33:47', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', null, '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('14', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-25 18:33:48', '东南', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-25 18:33:48', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', null, '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('15', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-25 18:33:49', '东南', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-25 18:33:49', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', null, '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('16', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-25 18:33:49', '东', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-25 18:33:49', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', null, '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('17', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-25 18:33:50', '东南', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-25 18:33:50', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', null, '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX');
INSERT INTO `tb_house` VALUES ('18', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-25 19:34:14', '东南', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-25 19:34:14', null, null, '2', '1', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', '5', '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://wwwb.benbenla.cn/images/20110907/benbenla-03c.jpg');
INSERT INTO `tb_house` VALUES ('19', '急转租 急急急 次卧', null, '陕西省西安市雁塔区科技五路靠近南窑头社区东区', '108.883937,34.217154', null, null, null, '2018-08-26 23:55:49', '北', null, '四室一厅', '201', '17', 'id:zhifubao&icon:icon-bank-card&name:支付宝,id:weixin&icon:icon-bank-card&name:微信', '月付', '2018-08-26 23:55:49', null, null, '2', '0', null, 'id:2000164&icon:icon-bank-card&name:洗衣机', 'id:2000114&icon:icon-bank-card&name:马桶,id:2000117&icon:icon-bank-card&name:洗漱台,id:2000116&icon:icon-bank-card&name:热水器', 'id:2000158&icon:icon-bank-card&name:电磁炉,id:2000161&icon:icon-bank-card&name:高压锅,id:2000155&icon:icon-bank-card&name:微波炉,id:2000156&icon:icon-bank-card&name:煤气灶,id:2000157&icon:icon-bank-card&name:天然气', 'fewfse 的粉色发色粉王企鹅,粉色粉色驱蚊器,qweq请问二群无而且', '简装', '5', '50', '集中供暖', null, null, 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq', '美寓华庭', null, null, null, '1000.00', 'dsfe的粉色发,feawf分为发顺丰', '25', 'id:michuang1&icon:icon-bank-card&name:1.2米床,id:michuang3&icon:icon-bank-card&name:2米床,id:tiejiachuang&icon:icon-bank-card&name:铁架床,id:closet&icon:icon-bank-card&name:衣柜,id:table&icon:icon-bank-card&name:桌子,id:windows&icon:icon-bank-card&name:有窗', 'http://pckhspvcg.bkt.clouddn.com/FlHjNvm1RMJRbzAJ1UGQQuFZFWBX,http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg,http://pckhspvcg.bkt.clouddn.com/Fkc_ijHeBdJg0bbF7u01c1mn3A5M', '次卧', null, null, null, null, null, '月', '', '', '', null, '月', 'id:2000106&icon:icon-bank-card&name:WIFI,id:2000105&icon:icon-bank-card&name:饭桌,id:2000103&icon:icon-bank-card&name:机顶盒,id:2000111&icon:icon-bank-card&name:智能锁,id:2000109&icon:icon-bank-card&name:防盗门,id:2000108&icon:icon-bank-card&name:暖气,id:2000112&icon:icon-bank-card&name:瓷砖地板,id:2000104&icon:icon-bank-card&name:茶几', 'http://pckhspvcg.bkt.clouddn.com/Fj8lR7C6OD8zeGiU4jFke8RRFQRO,http://pckhspvcg.bkt.clouddn.com/Fu4Ij7CLfn1qgiVJ9P8xzva-8vMV', 'http://pckhspvcg.bkt.clouddn.com/Fh-GqGLZiycSvF8cwJaXFNj6tREH', null, '新房入驻,近地铁', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', 'http://pckhspvcg.bkt.clouddn.com/FrTzW5kigKnkKr4VglRb2nv6xudq,http://pckhspvcg.bkt.clouddn.com/Fm9EvUPKOmFR4mC_epGagzBn_f1z', '月', '100.00', '月', '10.00', '10.00', '急转租 急急急', null, 'http://wwwb.benbenla.cn/images/20110907/benbenla-03c.jpg');

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
  `image1` varchar(255) DEFAULT NULL COMMENT '证件照1',
  `image2` varchar(255) DEFAULT NULL COMMENT '证件照2',
  `image3` varchar(255) DEFAULT NULL COMMENT '证件照3',
  `remark` varchar(255) DEFAULT NULL COMMENT '审核备注',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态 0=审请状态/1=审核通过/2=审核拒绝',
  `create_time` datetime DEFAULT NULL COMMENT '申请时间',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `auditor_id` bigint(20) DEFAULT NULL COMMENT '审核人编号',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='实名认证表';

-- ----------------------------
-- Records of tb_identity_auth
-- ----------------------------
INSERT INTO `tb_identity_auth` VALUES ('9', '19', '王国栋', null, '1656356864656875', 'http://pckhspvcg.bkt.clouddn.com/FiZ6nl3oDbm0mimcMZKCbWTR5cOD', 'http://pckhspvcg.bkt.clouddn.com/lkfZKpRaHDBhk4G8y4BfF_TUjpaE', null, '认证通过', '1', '2018-09-05 19:28:56', '2018-09-05 19:37:15', null);
INSERT INTO `tb_identity_auth` VALUES ('10', '17', '王五', null, '16491654816469491949', 'http://pckhspvcg.bkt.clouddn.com/Fnpduwh5EwzIHfQ-6QYf1lQ9vwti', 'http://pckhspvcg.bkt.clouddn.com/Fv1eiEx7JVEzEfC-S3v0HXi6DvMg', null, '认证通过', '1', '2018-09-06 16:34:56', '2018-09-06 16:38:08', null);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Records of tb_order
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reservation
-- ----------------------------
INSERT INTO `tb_reservation` VALUES ('1', '19', '19', null, '4', '1', '王国栋', '18590718679', null, '2018-09-03 17:31:17', '2018-09-04 08:00:00', '2018-09-03 17:31:17');
INSERT INTO `tb_reservation` VALUES ('2', '14', '19', '方法合适的', '1', '1', '王国栋', '18590718679', null, '2018-09-04 16:49:12', '2018-09-08 08:00:00', '2018-09-04 16:49:12');
INSERT INTO `tb_reservation` VALUES ('3', '19', '17', '度过的', '2', '1', '王五', '17691229633', null, '2018-09-04 17:00:51', '2018-09-05 08:00:00', '2018-09-04 17:00:51');
INSERT INTO `tb_reservation` VALUES ('4', '18', '17', '请问哇啊\n', '2', '1', '王五', '17691229633', null, '2018-09-04 17:01:20', '2018-09-06 08:00:00', '2018-09-04 17:01:20');
INSERT INTO `tb_reservation` VALUES ('5', '18', '19', '111111111111111111111', '1', '1', '王国栋', '18590718679', null, '2018-09-05 16:49:29', '2018-09-06 08:00:00', '2018-09-05 16:49:29');
INSERT INTO `tb_reservation` VALUES ('6', '19', null, '13213123', '1', '1', '王国栋', '18590718679', null, '2018-09-05 23:09:37', '2018-09-05 08:00:00', '2018-09-05 23:09:37');

-- ----------------------------
-- Table structure for tb_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_room`;
CREATE TABLE `tb_room` (
  `id` bigint(20) NOT NULL COMMENT '房间Id',
  `house_id` bigint(20) DEFAULT NULL COMMENT '房屋Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room
-- ----------------------------

-- ----------------------------
-- Table structure for tb_track
-- ----------------------------
DROP TABLE IF EXISTS `tb_track`;
CREATE TABLE `tb_track` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `house_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_track
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('16', 'user123', '15529960414', '$2a$10$qtRGgq5KKYORzTzUVjVHa.GQaKoLs1M7UfB5kbf8.IxHo5LB4NqlO', null, '2018-08-19 15:12:19', '1');
INSERT INTO `tb_user` VALUES ('17', 'user1111', '17691229633', '$2a$10$bP4uNKitPAF.14PBIveuxORe/Sum0qt8quuQkCOV6C.seiJCgIPZS', null, '2018-08-19 15:31:58', '1');
INSERT INTO `tb_user` VALUES ('18', 'user567896', '17691229635', '$2a$10$tV2oTvX6ZtQhQ9nHh630bO1c5xG/1q952bNUB8IECkVnAX.80OR/S', null, '2018-08-28 12:12:40', '1');
INSERT INTO `tb_user` VALUES ('19', 'user15874', '18590718679', '$2a$10$cRbWAZAYOFnJXXosq4OgO.4goDGtBxn3wnsaRUmU1L0XJtQsPE236', null, '2018-09-02 20:57:00', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_info
-- ----------------------------
INSERT INTO `tb_user_info` VALUES ('13', '16', 'user123', '15529960414', null, null, null, null, 'https://pic.tujia.com/upload/landlordStorelogo/day_180420/201804201954454197.jpg', '', '2018-08-19 15:12:23', '2018-08-19 15:12:23');
INSERT INTO `tb_user_info` VALUES ('14', '17', 'user1111', '17691229633', null, '1', '1995-08-19 08:00:00', '王五', 'https://pic.tujia.com/upload/landlordStorelogo/day_180420/201804201954454197.jpg', '北京东城区西城区', '2018-08-19 15:31:58', '2018-08-19 15:31:58');
INSERT INTO `tb_user_info` VALUES ('15', '18', 'user567896', '17691229635', null, '1', '1994-08-28 08:00:00', '', 'https://pic.tujia.com/upload/landlordStorelogo/day_180420/201804201954454197.jpg', '北京东城区东城区', '2018-08-28 12:12:40', '2018-08-28 12:12:40');
INSERT INTO `tb_user_info` VALUES ('16', '19', 'user15874', '18590718679', null, '1', '1995-05-02 08:00:00', '王国栋', 'http://pckhspvcg.bkt.clouddn.com/FizbLFTChKtoZYwo9VA5X3lJyiEP', '北京东城区崇文区', '2018-09-02 20:57:00', '2018-09-02 20:57:00');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_zhima_auth
-- ----------------------------
INSERT INTO `tb_zhima_auth` VALUES ('1', null, null, '5', '700');
