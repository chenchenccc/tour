/*
MySQL Data Transfer
Source Host: 127.0.0.1
Source Database: tour_manager_db
Target Host: 127.0.0.1
Target Database: tour_manager_db
Date: 2015/5/14 17:31:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sm_autho
-- ----------------------------
CREATE TABLE `sm_autho` (
  `id` int(11) NOT NULL DEFAULT '0',
  `autho_name` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `super_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  `autho_icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_role
-- ----------------------------
CREATE TABLE `sm_role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_role_autho
-- ----------------------------
CREATE TABLE `sm_role_autho` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `autho_id` int(11) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user
-- ----------------------------
CREATE TABLE `sm_user` (
  `id` int(11) NOT NULL,
  `login_name` varchar(50) NOT NULL,
  `real_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL COMMENT '0：未知 1：男 2：女',
  `is_admin` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态 1：在线 2：离线',
  `is_del` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ_sm_user_login_name` (`login_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sm_user_role
-- ----------------------------
CREATE TABLE `sm_user_role` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_customer
-- ----------------------------
CREATE TABLE `tm_customer` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `identity_num` varchar(50) NOT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1：成人 2：小孩 3:学生',
  `classify` int(11) DEFAULT NULL COMMENT '1：散客 2：组团:',
  `is_key` int(11) DEFAULT NULL COMMENT '1:是负责人 2：否',
  `super_id` int(11) DEFAULT NULL COMMENT '所属负责人',
  `sex` int(11) DEFAULT NULL COMMENT '0:未知 1：男 2：女',
  `age` int(11) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `identity_pic` varchar(255) DEFAULT NULL COMMENT '身份证照片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_customer_group
-- ----------------------------
CREATE TABLE `tm_customer_group` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `enter_time` int(11) DEFAULT NULL,
  `oper_id` int(11) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_department
-- ----------------------------
CREATE TABLE `tm_department` (
  `id` int(11) NOT NULL,
  `dept_name` varchar(50) DEFAULT NULL,
  `super_id` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `dept_icon` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_detail
-- ----------------------------
CREATE TABLE `tm_detail` (
  `id` int(11) NOT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `tour` varchar(100) DEFAULT NULL COMMENT '旅游路线',
  `walk` varchar(50) DEFAULT NULL COMMENT '行',
  `eat` varchar(50) DEFAULT NULL,
  `hotel_name` varchar(50) DEFAULT NULL,
  `info` varchar(50) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_employee
-- ----------------------------
CREATE TABLE `tm_employee` (
  `id` int(11) NOT NULL,
  `employee_num` varchar(50) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL COMMENT '0:未知 1：男 2：女',
  `is_guider` int(11) DEFAULT NULL COMMENT '是否是导游 1：是 2：否',
  `is_del` char(2) DEFAULT NULL,
  `head` varchar(255) DEFAULT NULL COMMENT '头像URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_group
-- ----------------------------
CREATE TABLE `tm_group` (
  `id` int(11) NOT NULL,
  `group_name` varchar(50) DEFAULT NULL,
  `tour_id` int(11) DEFAULT NULL COMMENT '导游ID 关联employee',
  `is_del` char(2) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态 1：未开始 2：正在路上 3：已经结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_hotel
-- ----------------------------
CREATE TABLE `tm_hotel` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_info
-- ----------------------------
CREATE TABLE `tm_info` (
  `id` int(11) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '新闻类型 1：文字新闻 2：图片新闻 3：视频新闻 4：新闻URL',
  `is_del` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_order
-- ----------------------------
CREATE TABLE `tm_order` (
  `id` int(11) NOT NULL,
  `custom_id` int(11) DEFAULT NULL,
  `total_people` int(11) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `is_confirm` int(11) DEFAULT NULL COMMENT '是否确认订单 1：是 2：否',
  `is_pay` int(11) DEFAULT NULL COMMENT '是否付款 1：是 2：否',
  `is_del` char(2) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型 1：散客订单 2：包团订单',
  `order_desc` varchar(255) DEFAULT NULL COMMENT '订单描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tm_schedule
-- ----------------------------
CREATE TABLE `tm_schedule` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `total_day` int(11) DEFAULT NULL COMMENT '天',
  `total_people` int(11) DEFAULT NULL COMMENT '总人数',
  `price` double DEFAULT NULL,
  `departure` varchar(100) DEFAULT NULL,
  `destination` varchar(100) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1:短线 2：长线',
  `grade` int(11) DEFAULT NULL COMMENT '等级 1:标准团 2：定制团',
  `line_code` varchar(50) DEFAULT NULL COMMENT '线路分类',
  `guider_ids` varchar(50) DEFAULT NULL COMMENT '导游id，用逗号分隔,',
  `detail_id` varchar(50) DEFAULT NULL COMMENT '行程，用逗号隔开',
  `create_time` date DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL COMMENT '	',
  `update_time` date DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  `is_del` char(2) DEFAULT NULL,
  `schedule_desc` varchar(255) DEFAULT NULL COMMENT '日程描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sm_autho` VALUES ('1', '系统管理', '', '', null, null, '0', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('2', '旅游管理', null, null, null, null, '0', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('3', '系统消息', null, null, null, null, '0', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('4', '员工管理', null, '/html/employeeMgr.jsp', null, null, '1', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('5', '部门管理', null, '/html/departmentMgr.jsp', null, null, '1', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('6', '角色管理', null, '/html/roleMgr.jsp', null, null, '1', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('7', '权限管理', null, '/html/authoMgr.jsp', null, null, '1', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('8', '酒店管理', null, '/html/hotelMgr.jsp', null, null, '2', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('9', '导游管理', null, '/html/guiderMgr.jsp', null, null, '2', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('10', '客户管理', null, '/html/customerMgr.jsp', null, null, '2', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('11', '日程管理', null, '/html/scheduleMgr.jsp', null, null, '2', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('12', '订单管理', null, '/html/orderMgr.jsp', null, null, '2', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('13', '旅游团管理', null, '/html/groupMgr.jsp', null, null, '2', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('14', '发布消息', null, '/html/publishInfoMgr.jsp', null, null, '3', null, null, '1', null);
INSERT INTO `sm_autho` VALUES ('15', '查看消息', null, '/html/queryInfoMgr.jsp', null, null, '3', null, null, '1', null);
INSERT INTO `sm_role` VALUES ('1', '管理员', null, null, null, null, null, '1');
INSERT INTO `sm_role_autho` VALUES ('1', '1', '1', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('2', '1', '2', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('3', '1', '3', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('4', '1', '4', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('5', '1', '5', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('6', '1', '6', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('7', '1', '7', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('8', '1', '8', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('9', '1', '9', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('10', '1', '10', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('11', '1', '11', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('12', '1', '12', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('13', '1', '13', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('14', '1', '14', '1', null, null, null, null);
INSERT INTO `sm_role_autho` VALUES ('15', '1', '15', '1', null, null, null, null);
INSERT INTO `sm_user` VALUES ('1', 'admin', '管理员', '123456', '123456789', '0', '1', '18', null, null, null, null, '1', '1');
INSERT INTO `sm_user_role` VALUES ('1', '1', '1', '1', null, null, null, null);
INSERT INTO `tm_department` VALUES ('1', 'xxx', null, null, '1', null, null, null, null, null);
INSERT INTO `tm_employee` VALUES ('1', '12306', '陈瑞红', '1111111111', '1', '1', '2', '2', '1', 'ddd');
INSERT INTO `tm_employee` VALUES ('2', null, null, null, null, null, null, null, '1', 'fff');
INSERT INTO `tm_employee` VALUES ('3', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_employee` VALUES ('4', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_employee` VALUES ('5', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_employee` VALUES ('6', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_employee` VALUES ('7', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_employee` VALUES ('8', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_employee` VALUES ('9', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_employee` VALUES ('10', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_employee` VALUES ('11', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_employee` VALUES ('12', null, null, null, null, null, null, null, '1', null);
INSERT INTO `tm_hotel` VALUES ('1', '阿波罗', '1', '5', '2015-05-13', '1', null, null, '1');
INSERT INTO `tm_hotel` VALUES ('2', 'xxx', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('3', 'zzz', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('4', 'f', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('5', 'f', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('6', 'f', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('7', 'f', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('8', 'f', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('9', 'f', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('10', 'f', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('11', 'f', null, null, null, null, null, null, '1');
INSERT INTO `tm_hotel` VALUES ('12', 'f', null, null, null, null, null, null, '1');
