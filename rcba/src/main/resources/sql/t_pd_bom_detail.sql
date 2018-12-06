/*
 Navicat Premium Data Transfer

 Source Server         : ariec
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 192.168.1.4:3306
 Source Schema         : airec

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 05/12/2018 13:50:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_pd_bom_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_pd_bom_detail`;
CREATE TABLE `t_pd_bom_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'BOM 明细id',
  `pp_id` int(11) NOT NULL COMMENT '所属企业',
  `bom_basic_id` int(11) NOT NULL COMMENT '关联BOM管理id',
  `volume` float NOT NULL COMMENT '单位用量',
  `status` int(11) NOT NULL COMMENT '默认状态(0代表停用,1代表启用)',
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '版本',
  `craft_id` int(11) NULL DEFAULT NULL COMMENT '关联生产工艺',
  `workmethod_id` int(11) NULL DEFAULT NULL COMMENT '关联工序',
  `descript` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user` int(11) NOT NULL COMMENT '创建人（电子人）',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` int(11) NULL DEFAULT NULL COMMENT '更新人（电子人）',
  PRIMARY KEY (`id`, `pp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'BOM明细表' ROW_FORMAT = Dynamic PARTITION BY HASH (pp_id)
PARTITIONS 6
(PARTITION `p0` ENGINE = InnoDB MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p1` ENGINE = InnoDB MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p2` ENGINE = InnoDB MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p3` ENGINE = InnoDB MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p4` ENGINE = InnoDB MAX_ROWS = 0 MIN_ROWS = 0 ,
PARTITION `p5` ENGINE = InnoDB MAX_ROWS = 0 MIN_ROWS = 0 )
;

SET FOREIGN_KEY_CHECKS = 1;
