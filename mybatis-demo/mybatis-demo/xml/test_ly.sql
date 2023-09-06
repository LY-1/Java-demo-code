/*
 Navicat Premium Data Transfer

 Source Server         : hotpay_dev
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : 121.40.98.103:13306
 Source Schema         : corehr-develop

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 18/08/2023 17:13:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_ly
-- ----------------------------
DROP TABLE IF EXISTS `test_ly`;
CREATE TABLE `test_ly`  (
  `id` int(11) NOT NULL,
  `name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_ly
-- ----------------------------
INSERT INTO `test_ly` VALUES (0, '张三', 14);
INSERT INTO `test_ly` VALUES (1, 'Tom', 19);
INSERT INTO `test_ly` VALUES (2, '王五', 16);
INSERT INTO `test_ly` VALUES (6, 'Tom', 19);

SET FOREIGN_KEY_CHECKS = 1;
