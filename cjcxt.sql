/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306 
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : cjcxt

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2020-03-10 10:28:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bus`
-- ----------------------------
DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus` (
  `bus_id` varchar(20) NOT NULL,
  `start` varchar(45) DEFAULT NULL,
  `stop` varchar(45) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `stop_time` time DEFAULT NULL,
  `seat` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `bus_station` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`bus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus
-- ----------------------------
INSERT INTO `bus` VALUES ('001001', '湛江', '阳春', '09:00:00', '13:00:00', '35', '82', '麻章车站');
INSERT INTO `bus` VALUES ('001002', '湛江', '阳春', '13:00:00', '19:00:00', '35', '80', '麻章车站');
INSERT INTO `bus` VALUES ('001003', '湛江', '阳春', '13:10:00', '19:00:00', '45', '75', '汽车南站');
INSERT INTO `bus` VALUES ('001004', '湛江', '阳春', '07:10:00', '13:00:00', '45', '74', '海田车站');
INSERT INTO `bus` VALUES ('001005', '湛江', '阳春', '08:00:00', '13:00:00', '45', '88', '海田车站');
INSERT INTO `bus` VALUES ('001006', '湛江', '阳春', '08:30:00', '14:00:00', '45', '82', '海田车站');
INSERT INTO `bus` VALUES ('001007', '湛江', '广州省站', '08:10:00', '15:00:00', '45', '120', '麻章车站');
INSERT INTO `bus` VALUES ('001008', '湛江', '广州省站', '10:10:00', '17:00:00', '45', '120', '麻章车站');
INSERT INTO `bus` VALUES ('001009', '湛江', '广州省站', '12:20:00', '19:00:00', '45', '120', '麻章车站');
INSERT INTO `bus` VALUES ('001010', '湛江', '广州省站', '08:10:00', '15:30:00', '45', '120', '海田车站');
INSERT INTO `bus` VALUES ('001011', '湛江', '广州省站', '09:50:00', '17:00:00', '45', '120', '海田车站');
INSERT INTO `bus` VALUES ('001012', '湛江', '深圳福田', '08:45:00', '16:00:00', '45', '150', '海田车站');
INSERT INTO `bus` VALUES ('001013', '湛江', '深圳福田', '20:30:00', '08:00:00', '45', '160', '海田车站');
INSERT INTO `bus` VALUES ('001014', '湛江', '深圳福田', '08:10:00', '15:30:00', '45', '150', '麻章车站');
INSERT INTO `bus` VALUES ('001015', '湛江', '深圳福田', '09:00:00', '16:00:00', '45', '120', '麻章车站');
INSERT INTO `bus` VALUES ('001016', '湛江', '广州', '14:56:15', '20:56:33', '40', '80', '麻章车站');

-- ----------------------------
-- Table structure for `bus_route`
-- ----------------------------
DROP TABLE IF EXISTS `bus_route`;
CREATE TABLE `bus_route` (
  `bus_route_ID` varchar(25) NOT NULL,
  `start` varchar(20) DEFAULT NULL,
  `pass` text,
  `stop` varchar(20) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `stop_time` time DEFAULT NULL,
  PRIMARY KEY (`bus_route_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus_route
-- ----------------------------
INSERT INTO `bus_route` VALUES ('01路', '霞山分站', '儿童医院、花圃、国贸大厦、岭南路、海头、通用机械厂、棉织厂、南华广场、金康东路', '麻章车站', '06:00:00', '23:00:00');
INSERT INTO `bus_route` VALUES ('09路', '平乐码头', '四二二医院、海上城市、临西村、群麻坡村、海尾村、海洋大学路口、湖光岩东门、广东海洋大学寸金学院', '湛江教育基地', '06:30:00', '21:00:00');
INSERT INTO `bus_route` VALUES ('22路', '麻章车站', '金康东路、寸宝路口、寸金公园、康顺大厦、会展中心、霞海村、中澳花园、四二二医院、市第二人民医院、民治路、海湾宾馆、港务局', '火车南站', '06:00:00', '23:00:00');
INSERT INTO `bus_route` VALUES ('23路', '新二中', '海关缉私局、南桥、体育场、南华广场、寸金公园、岭南师范、金康东路、海大寸金学院、中医学院', '麻章车站', '06:30:00', '22:00:00');
INSERT INTO `bus_route` VALUES ('507路', '赤坎海田车站', '麻章车站、恒兴总公司、铁路西客运站、海洋大学路口', '龙海天客运站', null, null);
INSERT INTO `bus_route` VALUES ('51路', '海田车站', '金海度假村、金沙湾小区、金沙湾广场、中心人民医院南门、湛江艺校、南华广场、寸金公园', '寸金公交站', '06:30:00', '22:00:00');
INSERT INTO `bus_route` VALUES ('东南码头专线', '海田车站', '麻章车站、湖光路口、电子城、龙圩', '东南码头', null, null);

-- ----------------------------
-- Table structure for `train`
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `train_id` varchar(20) NOT NULL,
  `start` varchar(45) DEFAULT NULL,
  `stop` varchar(45) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `stop_time` time DEFAULT NULL,
  `seat` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('100101', '湛江', '广州', '08:00:00', '12:00:00', '60', '80', '茂名、阳江');
INSERT INTO `train` VALUES ('100102', '湛江', '深圳', '08:30:00', '14:00:00', '60', '120', null);
INSERT INTO `train` VALUES ('100103', '湛江', '茂名', '09:00:00', '10:30:00', '60', '50', null);

-- ----------------------------
-- Table structure for `t_banner`
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `rid` int(11) NOT NULL DEFAULT '0',
  `tour` char(13) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_banner
-- ----------------------------
INSERT INTO `t_banner` VALUES ('1', '001');
INSERT INTO `t_banner` VALUES ('2', '002');
INSERT INTO `t_banner` VALUES ('3', '003');
INSERT INTO `t_banner` VALUES ('4', '004');
INSERT INTO `t_banner` VALUES ('5', '005');
INSERT INTO `t_banner` VALUES ('6', '006');

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `name` char(30) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `message` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('123456', '2019-06-08 23:01:24', '你好！');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 21:42:34', '00');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 21:42:39', '??');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 21:42:43', '11');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 21:57:01', 'a');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 21:57:06', '??\n');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 22:13:15', '??');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 22:13:19', 'v');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 22:13:24', '??????');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 22:17:22', '浣?');
INSERT INTO `t_message` VALUES ('123456', '2019-06-17 22:33:08', '浣?');
INSERT INTO `t_message` VALUES ('123456', '2019-06-21 21:47:34', '浣?');
INSERT INTO `t_message` VALUES ('123456', '2019-06-21 21:54:04', '一');
INSERT INTO `t_message` VALUES ('123456', '2019-06-21 21:54:12', '你好！');
INSERT INTO `t_message` VALUES ('123456', '2019-06-24 22:49:00', '呵呵');
INSERT INTO `t_message` VALUES ('123456', '2019-06-27 22:10:08', '你好');
INSERT INTO `t_message` VALUES ('789456', '2019-06-29 22:41:57', 'hhhhhhhhhhhhh哈哈哈哈好');
INSERT INTO `t_message` VALUES ('123456', '2019-07-01 12:22:45', '你');
INSERT INTO `t_message` VALUES ('123456', '2019-07-01 15:11:25', '123\r\n');
INSERT INTO `t_message` VALUES (null, null, null);

-- ----------------------------
-- Table structure for `t_recommended`
-- ----------------------------
DROP TABLE IF EXISTS `t_recommended`;
CREATE TABLE `t_recommended` (
  `rid` int(11) NOT NULL DEFAULT '0',
  `tour` char(13) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_recommended
-- ----------------------------
INSERT INTO `t_recommended` VALUES ('1', '001');
INSERT INTO `t_recommended` VALUES ('2', '002');
INSERT INTO `t_recommended` VALUES ('3', '003');
INSERT INTO `t_recommended` VALUES ('4', '004');
INSERT INTO `t_recommended` VALUES ('5', '005');
INSERT INTO `t_recommended` VALUES ('6', '006');

-- ----------------------------
-- Table structure for `t_tour`
-- ----------------------------
DROP TABLE IF EXISTS `t_tour`;
CREATE TABLE `t_tour` (
  `isbn` char(13) NOT NULL DEFAULT '',
  `title` varchar(80) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `chara` varchar(45) DEFAULT NULL,
  `txt` text,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tour
-- ----------------------------
INSERT INTO `t_tour` VALUES ('001', '东海岛', '广东省湛江市', '雷州文化 人龙舞 ;中国第一长滩、龙水岭', '东海岛在中国雷州半岛东部，历史上属雷州府遂溪县辖岛。');
INSERT INTO `t_tour` VALUES ('002', '湖光岩', '广东省湛江市区西南部18公里', '龙鱼神龟', '湖光岩风景区位于中国大陆最南端湛江市区西南18公里处，被联合国地质专家称为研究地球与地质科学的“天然年鉴”。总面积为38平方公里，园区是一个以玛珥火山地质地貌为主体，兼有海岸地貌、构造地质地貌等多种地质遗迹，自然生态良好的公园。');
INSERT INTO `t_tour` VALUES ('003', '金沙湾', '湛江市赤坎区东海岸', '金沙湾观海长廊、海滨浴场，双子岛、水上运动中心', '国家AAAA级景区，有金沙湾观海长廊、海滨浴场，双子岛、水上运动中心等景点');
INSERT INTO `t_tour` VALUES ('004', '孔子文化城', '广东省湛江市遂溪县', '孔庙、文昌阁、鲁国街、码头亭', '总面积约2900亩，以5A级旅游区标准分三期来打造。文化城由“孔、古、石、南门区、东门区等十个区域组成，集旅游观光、文化教育、休闲度假、体验生态、虔诚朝拜于一体，体现恢宏、大气、生态等特色。');
INSERT INTO `t_tour` VALUES ('005', '硇洲岛', '湛江市东南约40公里处', '硇洲鲍鱼，硇洲青龙虾等', '它北傍东海岛，西依雷州湾，东南面是南海，纵深是太平洋，总面积约56平方公里。硇洲岛是一个大约20—50万年前由海底火山爆发而形成的海岛。');
INSERT INTO `t_tour` VALUES ('006', '特呈岛', '雷州半岛东北部', '白沙滩、火山石、大海、海鸥', '“特呈”是古越语，“特”即地方，“呈”是和谐吉祥的意思。\'');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `phone` char(11) NOT NULL DEFAULT '',
  `uname` varchar(30) DEFAULT NULL,
  `upwd` char(32) DEFAULT '000000',
  `email` varchar(30) DEFAULT NULL,
  `role` int(11) DEFAULT '0',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1234135', '11111111', '11111111', '1111@qq.com', '0');
INSERT INTO `t_user` VALUES ('12345678900', 'admin1', '000000', 'admin1@abc', '1');
INSERT INTO `t_user` VALUES ('13421296777', '123789', '123789', '1236@qq.com', '1');
INSERT INTO `t_user` VALUES ('13822507458', 'ccccwwww', '123456', '12345@qq.com', '0');
INSERT INTO `t_user` VALUES ('13822507459', '789456', '789456', '789@qq.com', '0');
INSERT INTO `t_user` VALUES ('15218157201', '123456', '123456', '953210689@qq.com', '1');
INSERT INTO `t_user` VALUES ('18144437910', 'chenwei', '123456', '821727229@qq.com', '0');
