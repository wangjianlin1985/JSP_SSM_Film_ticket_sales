/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : ssm_zxdydp

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2020-01-11 00:30:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminid` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('A20190322210709793', 'zyj', '123456', '邹旖君', '18770622227', '2019-03-22');
INSERT INTO `admin` VALUES ('A20190322210754998', 'admin', 'admin', '管理员', '123456', '2019-03-22');

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleid` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  `hits` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`articleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('A20190119125646594', '测试测试', 'upfiles/20190119125643.jpg', '<p>七个女人的故事七个女人的故事</p>\r\n', '2019-01-19', '1');
INSERT INTO `article` VALUES ('A20190119125705582', '七个女人的故事', 'upfiles/20190119125702.jpg', '<p>七个女人的故事七个女人的故事七个女人的故事七个女人的故事</p>\r\n', '2019-01-19', '3');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartid` varchar(255) NOT NULL,
  `usersid` varchar(255) DEFAULT NULL,
  `filmid` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `zws` varchar(255) DEFAULT NULL,
  `skid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for `cate`
-- ----------------------------
DROP TABLE IF EXISTS `cate`;
CREATE TABLE `cate` (
  `cateid` varchar(255) NOT NULL,
  `catename` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cate
-- ----------------------------
INSERT INTO `cate` VALUES ('C20190119125801744', '动作片', '动作', '2019-01-19');
INSERT INTO `cate` VALUES ('C20190119142300664', '动画片', '动画', '2019-01-19');
INSERT INTO `cate` VALUES ('C20190119142722187', '科幻片', '科幻', '2019-01-19');

-- ----------------------------
-- Table structure for `cinema`
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `cinemaid` varchar(255) NOT NULL,
  `cinemaname` varchar(255) DEFAULT NULL,
  `cityid` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cinemaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cinema
-- ----------------------------
INSERT INTO `cinema` VALUES ('C20190119125823269', '万达影城（南昌青山湖万达广场店）', 'C20190119125813209', '青山湖区京东大道999号青山湖万达广场3层', '0791-83802295', '普通厅1.3米以下儿童可免费无座观影');
INSERT INTO `cinema` VALUES ('C20190119125837885', '北京博纳晶品国际影城', 'C20190320222453176', '海淀区复兴路51号凯德晶品购物中心四层', '010-88178880', '儿童无票需要3D眼镜押金');
INSERT INTO `cinema` VALUES ('C20190119125845136', '北京沃美影城回龙观店', 'C20190320222453176', '昌平区回龙观育知东路30号院华联购物中心4层', '010-56455166,8012', '使用3D眼镜无需缴纳押金及其他费用');
INSERT INTO `cinema` VALUES ('C20190119125854288', '北京房山环球国际影城', 'C20190320222453176', '房山区兴房大街38号华冠欢乐楼四楼', '010-61375512', '该影院支持线上购买小食');
INSERT INTO `cinema` VALUES ('C20190322192353984', '江西华影国际影城', 'C20190119125813209', '西湖区中山路天虹商场九楼', '0791-86767275', 'VIP厅为特殊影厅，1.3米以下儿童也需购票');
INSERT INTO `cinema` VALUES ('C20190322192615833', '南昌博纳国际影城', 'C20190119125813209', '红谷滩新区铜锣湾广场5楼', '0791-88538229', '儿童观看中国巨幕影厅需要等同成年人购票');
INSERT INTO `cinema` VALUES ('C20190322192816110', '深影五洲国际影城', 'C20190119125810218', '龙岗区龙城街道华润万家3楼', '0755-23255051', '支持开场前15分钟改签');
INSERT INTO `cinema` VALUES ('C20190322202402795', '华谊兄弟影院（方大城店）', 'C20190119125810218', '南山区龙珠四路方大广场二号楼三楼', '0755-21621208', '提供一次性3D眼镜');
INSERT INTO `cinema` VALUES ('C20190322202835645', '橙天嘉禾影城（卓悦汇店）', 'C20190119125810218', '福田区梅林街道卓悦汇购物中心L4-27号', '0755-83217930', '免费3D眼镜');

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityid` varchar(255) NOT NULL,
  `cityname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('C20190119125810218', '深圳');
INSERT INTO `city` VALUES ('C20190119125813209', '南昌');
INSERT INTO `city` VALUES ('C20190320222453176', '北京');

-- ----------------------------
-- Table structure for `details`
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details` (
  `detailsid` varchar(255) NOT NULL,
  `ordercode` varchar(255) DEFAULT NULL,
  `filmid` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `cityid` varchar(255) DEFAULT NULL,
  `cinemaid` varchar(255) DEFAULT NULL,
  `viewdate` varchar(255) DEFAULT NULL,
  `zws` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`detailsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of details
-- ----------------------------
INSERT INTO `details` VALUES ('201912120041556819.297846771391', 'PD20191212004155', 'F20190119143007529', '3', '264.0', 'C20190119125813209', 'C20190119125823269', '2019-12-12', '3,5,7,');
INSERT INTO `details` VALUES ('2019121200443311243.764230329072', 'PD20191212004433', 'F20190119143007529', '4', '352.0', 'C20190119125813209', 'C20190119125823269', '2019-12-12', '9,17,20,19,');
INSERT INTO `details` VALUES ('201912120044338216.133321362033', 'PD20191212004433', 'F20190119143007529', '2', '176.0', 'C20190119125813209', 'C20190119125823269', '2019-12-12', '11,12,');

-- ----------------------------
-- Table structure for `dysk`
-- ----------------------------
DROP TABLE IF EXISTS `dysk`;
CREATE TABLE `dysk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `funddate` varchar(255) DEFAULT NULL,
  `dates` varchar(255) DEFAULT NULL,
  `filmid` varchar(255) DEFAULT NULL,
  `zwsum` int(11) DEFAULT NULL COMMENT '0',
  `cid` varchar(50) DEFAULT NULL,
  `cinid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dysk
-- ----------------------------
INSERT INTO `dysk` VALUES ('1', '2019-12-06', '20:31:00', 'F20190120171722784', '25', null, null);
INSERT INTO `dysk` VALUES ('2', '2019-12-09', '14:00:00', 'F20191208085433598', '25', null, null);
INSERT INTO `dysk` VALUES ('3', '2019-12-09', '10:00:00', 'F20191208085433598', '25', null, null);
INSERT INTO `dysk` VALUES ('4', '2019-12-09', '13:20:00', 'F20190120171722784', '25', null, null);
INSERT INTO `dysk` VALUES ('5', '2019-12-09', '21:51:29', 'F20190120171722784', '25', null, null);
INSERT INTO `dysk` VALUES ('6', '2019-12-09', '14:10:30', 'F20190119143007529', '10', null, null);
INSERT INTO `dysk` VALUES ('7', '2019-12-09', '17:13:00', 'F20190119143007529', '25', null, null);
INSERT INTO `dysk` VALUES ('8', '2019-12-09', '21:13:00', 'F20190119143007529', '25', null, null);
INSERT INTO `dysk` VALUES ('9', '2019-12-11', '18:42:55', 'F20190119142932172', '10', null, null);
INSERT INTO `dysk` VALUES ('10', '2019-12-12', '19:56:30', 'F20190119143007529', '20', 'C20190119125813209', 'C20190119125823269');
INSERT INTO `dysk` VALUES ('11', '2019-12-12', '23:15:30', 'F20190119143007529', '80', 'C20190119125813209', 'C20190119125823269');
INSERT INTO `dysk` VALUES ('12', '2019-12-12', '23:15:30', 'F20190119143007529', '30', 'C20190320222453176', 'C20190119125837885');

-- ----------------------------
-- Table structure for `film`
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `filmid` varchar(255) NOT NULL,
  `filmname` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `cateid` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `recommend` varchar(255) DEFAULT NULL,
  `thestart` varchar(255) DEFAULT NULL,
  `theend` varchar(255) DEFAULT NULL,
  `hits` varchar(255) DEFAULT NULL,
  `sellnum` varchar(255) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`filmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES ('F20190119134347777', '复仇岛', 'upfiles/20190119134324.jpg', 'C20190119125801744', '88', '是', '2019-01-19', '2019-01-26', '21', '1', '<p>复仇岛复仇岛复仇岛复仇岛</p>\r\n');
INSERT INTO `film` VALUES ('F20190119134409970', '海王', 'upfiles/20190119134355.jpg', 'C20190119125801744', '89', '是', '2019-01-12', '2019-01-26', '3', '1', '<p>海王海王海王海王海王海王</p>\r\n');
INSERT INTO `film` VALUES ('F20190119134524745', '红海行动', 'upfiles/20190119134512.jpg', 'C20190119125801744', '65', '是', '2019-01-05', '2019-01-26', '0', '0', '<p>红海行动红海行动红海行动红海行动</p>\r\n');
INSERT INTO `film` VALUES ('F20190119134540659', '扬战血路', 'upfiles/20190119134529.jpg', 'C20190119125801744', '88', '是', '2019-01-19', '2019-01-26', '0', '0', '<p>扬战血路</p>\r\n');
INSERT INTO `film` VALUES ('F20190119134630771', '叶问4', 'upfiles/20190119134620.jpg', 'C20190119125801744', '89', '是', '2019-01-19', '2019-01-26', '2', '2', '<p>叶问4</p>\r\n');
INSERT INTO `film` VALUES ('F20190119141900951', '叶问外传 张天志', 'upfiles/20190119141848.jpg', 'C20190119125801744', '89', '是', '2019-01-20', '2019-01-26', '0', '0', '<p>叶问外传 张天志</p>\r\n');
INSERT INTO `film` VALUES ('F20190119142322106', '风语咒', 'upfiles/20190119142310.jpg', 'C20190119142300664', '65', '是', '2019-01-19', '2019-01-26', '6', '2', '<p>风语咒风语咒风语咒风语咒风语咒</p>\r\n');
INSERT INTO `film` VALUES ('F20190119142341738', '公牛历险记', 'upfiles/20190119142329.jpg', 'C20190119142300664', '66', '是', '2019-01-19', '2019-01-26', '3', '2', '<p>公牛历险记</p>\r\n');
INSERT INTO `film` VALUES ('F20190119142402162', '龙猫', 'upfiles/20190119142350.jpg', 'C20190119142300664', '80', '是', '2019-01-19', '2019-01-26', '1', '0', '<p>龙猫</p>\r\n');
INSERT INTO `film` VALUES ('F20190119142522863', '绿毛怪格林奇', 'upfiles/20190119142509.jpg', 'C20190119142300664', '65', '是', '2019-01-19', '2019-01-26', '0', '0', '<p>绿毛怪格林奇绿毛怪格林奇</p>\r\n');
INSERT INTO `film` VALUES ('F20190119142554782', '毛毛虫波罗', 'upfiles/20190119142543.jpg', 'C20190119142300664', '54', '是', '2019-01-19', '2019-01-26', '1', '0', '<p>毛毛虫波罗</p>\r\n');
INSERT INTO `film` VALUES ('F20190119142635305', '我想吃掉你的胰脏', 'upfiles/20190119142622.jpg', 'C20190119142300664', '68', '是', '2019-01-19', '2019-01-26', '1', '1', '<p>我想吃掉你的胰脏我想吃掉你的胰脏我想吃掉你的胰脏</p>\r\n');
INSERT INTO `film` VALUES ('F20190119142705136', '无敌破坏王2 大闹互联网', 'upfiles/20190119142652.jpg', 'C20190119142300664', '64', '是', '2019-01-19', '2019-01-26', '1', '1', '<p>无敌破坏王2 大闹互联网</p>\r\n');
INSERT INTO `film` VALUES ('F20190119142932172', '毒液 致命守护者', 'upfiles/20190119142922.jpg', 'C20190119142722187', '85', '是', '2019-01-19', '2019-01-26', '0', '0', '<p>毒液 致命守护者</p>\r\n');
INSERT INTO `film` VALUES ('F20190119142950187', '复仇者联盟3 无限战争', 'upfiles/20190119142937.jpg', 'C20190119142722187', '88', '是', '2019-01-19', '2019-01-26', '12', '2', '<p>复仇者联盟3 无限战争</p>\r\n');
INSERT INTO `film` VALUES ('F20190119143007529', '金刚狼3 殊死一战', 'upfiles/20190119142955.jpg', 'C20190119142722187', '88', '是', '2019-01-19', '2019-01-26', '89', '26', '<p>金刚狼3 殊死一战</p>\r\n');
INSERT INTO `film` VALUES ('F20190120171722784', '太空旅客', 'upfiles/20190120171708.jpg', 'C20190119142722187', '78', '是', '2019-01-20', '2019-01-26', '61', '10', '<p>太空旅客</p>\r\n');
INSERT INTO `film` VALUES ('F20190322220037441', '惊奇队长', 'upfiles/20190322215944.JPG', 'C20190119142722187', '49', '是', '2019-03-08', '2019-05-05', '10', '0', '<p>惊奇队长</p>\r\n');
INSERT INTO `film` VALUES ('F20191206152345979', 'sdfsad', 'upfiles/20191206152315.png', 'C20190119142300664', '20', '是', '2019-12-06', '2019-12-28', '1', '0', '<p>asdfsadfsadfsfda</p>\r\n');
INSERT INTO `film` VALUES ('F20191208085433598', '魔童降世', 'upfiles/20191208085409.jpg', 'C20190119142300664', '35', '是', '2019-12-08', '2019-12-28', '22', '8', '<p>测试</p>\r\n');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersid` varchar(255) NOT NULL,
  `ordercode` varchar(255) DEFAULT NULL,
  `usersid` varchar(255) DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ordersid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('O20191212003449611', 'PD20191212003449', 'U20190322185600284', '176.0', '已付款', '2019-12-12');
INSERT INTO `orders` VALUES ('O20191212004155818', 'PD20191212004155', 'U20190322185600284', '264.0', '已付款', '2019-12-12');
INSERT INTO `orders` VALUES ('O20191212004433504', 'PD20191212004433', 'U20190322185600284', '528.0', '已付款', '2019-12-12');

-- ----------------------------
-- Table structure for `topic`
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `topicid` varchar(255) NOT NULL,
  `usersid` varchar(255) DEFAULT NULL,
  `filmid` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `addtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`topicid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('T20190119171642389', 'U20190119170545761', 'F20190119134347777', '5', '阿阿斯顿发斯蒂芬', '2019-01-19');
INSERT INTO `topic` VALUES ('T20190120171745583', 'U20190120171737997', 'F20190120171722784', '5', '2222222222', '2019-01-20');
INSERT INTO `topic` VALUES ('T20190120171751576', 'U20190120171737997', 'F20190120171722784', '4', '333333333333333', '2019-01-20');
INSERT INTO `topic` VALUES ('T20190916100007869', 'U20190916090252272', 'F20190119142950187', '1', '好看', '2019-09-16');
INSERT INTO `topic` VALUES ('T20191206161034402', 'U20190322185600284', 'F20190119143007529', '1', '', '2019-12-06');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `usersid` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `regdate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usersid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('U20190322185600284', 'zs', 'zhangsan', '张三', '男', '1997-01-31', '111', '2019-03-22');
INSERT INTO `users` VALUES ('U20190322185753682', 'ls', 'lisi', '李四', '女', '1998-06-01', '222', '2019-03-22');
INSERT INTO `users` VALUES ('U20190322185827513', 'ww', 'wangwu', '王五', '男', '1994-12-06', '333', '2019-03-22');
INSERT INTO `users` VALUES ('U20190322185930190', 'll', 'liuliu', '刘六', '男', '1973-04-05', '444', '2019-03-22');
INSERT INTO `users` VALUES ('U20190916090252272', 'ysj', '123456', '袁世杰', '男', '2019-09-16', '13022502404', '2019-03-22');

-- ----------------------------
-- Table structure for `zuowei`
-- ----------------------------
DROP TABLE IF EXISTS `zuowei`;
CREATE TABLE `zuowei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filmid` varchar(255) DEFAULT NULL COMMENT '电影ID',
  `skid` int(11) DEFAULT NULL,
  `bianhao` varchar(255) DEFAULT NULL,
  `cinid` varchar(50) DEFAULT NULL,
  `cid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zuowei
-- ----------------------------
INSERT INTO `zuowei` VALUES ('47', 'F20190119143007529', '10', '3', null, null);
INSERT INTO `zuowei` VALUES ('48', 'F20190119143007529', '10', '5', null, null);
INSERT INTO `zuowei` VALUES ('49', 'F20190119143007529', '10', '7', null, null);
INSERT INTO `zuowei` VALUES ('50', 'F20190119143007529', '10', '9', null, null);
INSERT INTO `zuowei` VALUES ('51', 'F20190119143007529', '10', '17', null, null);
INSERT INTO `zuowei` VALUES ('52', 'F20190119143007529', '10', '20', null, null);
INSERT INTO `zuowei` VALUES ('53', 'F20190119143007529', '10', '19', null, null);
INSERT INTO `zuowei` VALUES ('54', 'F20190119143007529', '10', '11', null, null);
INSERT INTO `zuowei` VALUES ('55', 'F20190119143007529', '10', '12', null, null);
