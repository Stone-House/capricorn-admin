/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : area

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-25 07:36:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `code` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `province` varchar(10) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for county
-- ----------------------------
DROP TABLE IF EXISTS `county`;
CREATE TABLE `county` (
  `code` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `city` varchar(50) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of county
-- ----------------------------

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `code` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `url` varchar(1000) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('11', '北京市', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/11.html');
INSERT INTO `province` VALUES ('12', '天津市', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/12.html');
INSERT INTO `province` VALUES ('13', '河北省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/13.html');
INSERT INTO `province` VALUES ('14', '山西省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/14.html');
INSERT INTO `province` VALUES ('15', '内蒙古自治区', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/15.html');
INSERT INTO `province` VALUES ('21', '辽宁省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/21.html');
INSERT INTO `province` VALUES ('22', '吉林省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/22.html');
INSERT INTO `province` VALUES ('23', '黑龙江省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/23.html');
INSERT INTO `province` VALUES ('31', '上海市', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/31.html');
INSERT INTO `province` VALUES ('32', '江苏省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/32.html');
INSERT INTO `province` VALUES ('33', '浙江省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/33.html');
INSERT INTO `province` VALUES ('34', '安徽省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/34.html');
INSERT INTO `province` VALUES ('35', '福建省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/35.html');
INSERT INTO `province` VALUES ('36', '江西省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/36.html');
INSERT INTO `province` VALUES ('37', '山东省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/37.html');
INSERT INTO `province` VALUES ('41', '河南省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/41.html');
INSERT INTO `province` VALUES ('42', '湖北省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/42.html');
INSERT INTO `province` VALUES ('43', '湖南省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/43.html');
INSERT INTO `province` VALUES ('44', '广东省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/44.html');
INSERT INTO `province` VALUES ('45', '广西壮族自治区', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/45.html');
INSERT INTO `province` VALUES ('46', '海南省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/46.html');
INSERT INTO `province` VALUES ('50', '重庆市', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/50.html');
INSERT INTO `province` VALUES ('51', '四川省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/51.html');
INSERT INTO `province` VALUES ('52', '贵州省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/52.html');
INSERT INTO `province` VALUES ('53', '云南省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/53.html');
INSERT INTO `province` VALUES ('54', '西藏自治区', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/54.html');
INSERT INTO `province` VALUES ('61', '陕西省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/61.html');
INSERT INTO `province` VALUES ('62', '甘肃省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/62.html');
INSERT INTO `province` VALUES ('63', '青海省', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/63.html');
INSERT INTO `province` VALUES ('64', '宁夏回族自治区', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/64.html');
INSERT INTO `province` VALUES ('65', '新疆维吾尔自治区', 'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/65.html');

-- ----------------------------
-- Table structure for town
-- ----------------------------
DROP TABLE IF EXISTS `town`;
CREATE TABLE `town` (
  `code` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `county` varchar(50) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of town
-- ----------------------------

-- ----------------------------
-- Table structure for village
-- ----------------------------
DROP TABLE IF EXISTS `village`;
CREATE TABLE `village` (
  `code` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rural_code` varchar(10) DEFAULT NULL,
  `town` varchar(50) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of village
-- ----------------------------
