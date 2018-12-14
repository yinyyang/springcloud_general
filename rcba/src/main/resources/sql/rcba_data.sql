INSERT INTO `t_permission` VALUES (1, 'p001', '读取订单');
INSERT INTO `t_permission` VALUES (2, 'P002', '修改订单');
INSERT INTO `t_group` VALUES (1, 'g001', '财务组');
INSERT INTO `t_group_permission` VALUES (1, 1, 1);
INSERT INTO `t_permission_resource` VALUES (1, 1, 1);
INSERT INTO `t_permission_resource` VALUES (2, 2, 2);
INSERT INTO `t_resource` VALUES (1, 'res001', '订单显示', '/resource/order');
INSERT INTO `t_resource` VALUES (2, 'res002', '订单修改', '/resource/order/update');
INSERT INTO `t_role` VALUES (1, 'r001', '普通用户', '2018-12-06 16:33:53', NULL, '2018-12-06 16:33:53', NULL);
INSERT INTO `t_role_permission` VALUES (1, 1, 1);
INSERT INTO `t_role_permission` VALUES (2, 1, 2);
INSERT INTO `t_user` VALUES (1, 'test', '$2a$10$ZbfrU6E8LuTjsw1pvfnr9.l3JcwWF2IMhuJNknEYUoIzTp4sXkeQe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_user_group` VALUES (1, 1, 1);
INSERT INTO `t_user_role` VALUES (1, 1, 1);
