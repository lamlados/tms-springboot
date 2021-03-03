# /-- 删除时去除外键 --/
DROP TABLE IF EXISTS `tms_user`;
CREATE TABLE IF NOT EXISTS `tms_user`
(
    `id`          int unsigned NOT NULL auto_increment COMMENT '序号',
    `username`    varchar(64)  NOT NULL COMMENT '登录名',
    `password`    varchar(128) default '000000' COMMENT '登陆密码',
    `real_name`   varchar(64)  NOT NULL COMMENT '真实名',
    `last_login`  datetime     NOT NULL COMMENT '最后登陆时间',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `update_time` datetime COMMENT '最后密码修改时间',
    `comment`     text COMMENT '备注',
    PRIMARY KEY (`username`),
    UNIQUE (id),
    UNIQUE (username)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8
    COMMENT = '用户表';

DROP TABLE IF EXISTS `tms_item_main`;
CREATE TABLE IF NOT EXISTS `test_item_main`
(
    `id`          int unsigned NOT NULL auto_increment COMMENT '序号',
    `item_mark`   varchar(128) NOT NULL COMMENT '项目标识',
    `item_name`   varchar(128) NOT NULL COMMENT '项目名',
    `item_type`   varchar(8)   NOT NULL COMMENT '项目类型',
    `create_by`   varchar(64) COMMENT '创建者',
    `update_by`   varchar(64) COMMENT '最后更新者',
    `create_time` datetime COMMENT '创建时间',
    `update_time` datetime COMMENT '最后更新时间',
    `comment`     text COMMENT '备注',
    PRIMARY KEY (`item_mark`),
    FOREIGN KEY (`create_by`) REFERENCES tms_user (username),
    FOREIGN KEY (`update_by`) REFERENCES tms_user (username),
    UNIQUE (id),
    UNIQUE (item_mark)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8
    COMMENT = '测试项目表';

DROP TABLE IF EXISTS `test_item_classification`;
CREATE TABLE IF NOT EXISTS `test_item_classification`
(
    `id`                    int unsigned  NOT NULL auto_increment COMMENT '序号',
    `item_mark`             varchar(128)  NOT NULL COMMENT '项目标识',
    `item_ability`          varchar(16)   NOT NULL COMMENT '项目能力点',
    `classification_big`    varchar(128) COMMENT '大分类',
    `big_mark`              varchar(128) COMMENT '大分类标识',
    `classification_medium` varchar(128) COMMENT '中分类',
    `medium_mark`           varchar(128) COMMENT '中分类标识',
    `classification_small`  varchar(128) COMMENT '小分类',
    `small_mark`            varchar(128) COMMENT '小分类标识',
    `classification_mark`   varchar(1024) NOT NULL COMMENT '分类标识',
    `create_by`             varchar(64) COMMENT '创建者',
    `update_by`             varchar(64) COMMENT '最后更新者',
    `create_time`           datetime COMMENT '创建时间',
    `update_time`           datetime COMMENT '最后更新时间',
    `comment`               text COMMENT '备注',
    PRIMARY KEY (`classification_mark`),
    FOREIGN KEY (`item_mark`) REFERENCES test_item_main (item_mark),
    FOREIGN KEY (`create_by`) REFERENCES tms_user (username),
    FOREIGN KEY (`update_by`) REFERENCES tms_user (username),
    UNIQUE (id),
    UNIQUE (item_mark)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8
    COMMENT = '测试项目分类表';

DROP TABLE IF EXISTS `test_case_design`;
CREATE TABLE IF NOT EXISTS `test_case_design`
(
    `id`                    int unsigned  NOT NULL auto_increment COMMENT '序号',
    `item_mark`             varchar(128)  NOT NULL COMMENT '项目标识',
    `classification_mark`   varchar(1024) NOT NULL COMMENT '项目分类标识',
    `case_mark`             varchar(1024) NOT NULL COMMENT '用例标识',
    `test_track`            varchar(512)  NOT NULL COMMENT '测试追踪',
    `test_method`           varchar(512)  NOT NULL COMMENT '测试方法',
    `test_description`      varchar(512)  NOT NULL COMMENT '测试说明',
    `premise_constraint`    varchar(512)  NOT NULL COMMENT '前提和约束',
    `end_condition`         varchar(512)  NOT NULL COMMENT '终止条件',
    `operating_description` text          NOT NULL COMMENT '输入及操作说明',
    `expected_result`       text          NOT NULL COMMENT '期望测试结果',
    `evaluation_criteria`   varchar(512)  NOT NULL COMMENT '评估准则',
    `create_by`             varchar(64) COMMENT '创建者',
    `update_by`             varchar(64) COMMENT '最后更新者',
    `create_time`           datetime COMMENT '创建时间',
    `update_time`           datetime COMMENT '最后修改时间',
    `comment`               text COMMENT '备注',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`create_by`) REFERENCES tms_user (username),
    FOREIGN KEY (`update_by`) REFERENCES tms_user (username),
    FOREIGN KEY (`item_mark`) REFERENCES test_item_main (item_mark),
    FOREIGN KEY (`classification_mark`) REFERENCES test_item_classification (classification_mark),
    UNIQUE (id),
    UNIQUE (case_mark)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8
    COMMENT = '测试用例设计表';

DROP TABLE IF EXISTS `problem_description`;
CREATE TABLE IF NOT EXISTS `problem_description`
(
    `id`                  int unsigned NOT NULL auto_increment COMMENT '序号',
    `item_mark`           varchar(128) NOT NULL COMMENT '项目标识',
    `problem_mark`        varchar(128) NOT NULL COMMENT '问题标识',
    `case_number`         int unsigned NOT NULL COMMENT '用例测试号',
    `problem_type`        varchar(16)  NOT NULL COMMENT '问题类别',
    `problem_level`       varchar(16)  NOT NULL COMMENT '问题级别',
    `problem_description` text COMMENT '问题描述',
    `create_by`           varchar(64) COMMENT '创建者',
    `update_by`           varchar(64) COMMENT '最后更新者',
    `create_time`         datetime COMMENT '创建时间',
    `update_time`         datetime COMMENT '最后修改时间',
    `comment`             text COMMENT '备注',
    PRIMARY KEY (`problem_mark`),
    FOREIGN KEY (`create_by`) REFERENCES tms_user (username),
    FOREIGN KEY (`update_by`) REFERENCES tms_user (username),
    FOREIGN KEY (`item_mark`) REFERENCES test_item_main (item_mark),
    FOREIGN KEY (`case_number`) REFERENCES test_case_design (id),
    UNIQUE (id),
    UNIQUE (problem_mark)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8
    COMMENT = '问题描述表';

DROP TABLE IF EXISTS `test_case_test`;
CREATE TABLE IF NOT EXISTS `test_case_test`
(
    `id`               int unsigned NOT NULL auto_increment COMMENT '序号',
    `item_mark`        varchar(128) NOT NULL COMMENT '项目标识',
    `case_mark`        int unsigned NOT NULL COMMENT '用例标识',
    `test_version`     varchar(32)  NOT NULL COMMENT '测试版本',
    `actual_result`    text         NOT NULL COMMENT '实际测试结果',
    `execution_result` varchar(16)  NOT NULL COMMENT '执行结果',
    `problem_mark`     varchar(128) COMMENT '问题标识',
    `test_by`          varchar(64)  NOT NULL COMMENT '测试人员',
    `supervised_by`    varchar(64)  NOT NULL COMMENT '测试监督员',
    `execution_date`   datetime     NOT NULL COMMENT '执行日期',
    `create_by`        varchar(64) COMMENT '创建者',
    `update_by`        varchar(64) COMMENT '最后更新者',
    `create_time`      datetime COMMENT '创建时间',
    `update_time`      datetime COMMENT '最后修改时间',
    `comment`          text COMMENT '备注',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`create_by`) REFERENCES tms_user (username),
    FOREIGN KEY (`update_by`) REFERENCES tms_user (username),
    FOREIGN KEY (`item_mark`) REFERENCES test_item_main (item_mark),
    FOREIGN KEY (`case_mark`) REFERENCES test_case_design (id),
    FOREIGN KEY (`problem_mark`) REFERENCES problem_description (problem_mark),
    UNIQUE (id)
) ENGINE = innoDB
  DEFAULT CHARSET = utf8
    COMMENT = '测试用例测试表';

drop table if exists `tms_dict_type`;
create table `tms_dict_type`
(
    `dict_id`     bigint(20) not null auto_increment comment '字典主键',
    `dict_name`   varchar(100) default '' comment '字典名称',
    `dict_type`   varchar(100) default '' comment '字典类型',
    `status`      char(1)      default '0' comment '状态（0正常 1停用）',
    `create_by`   varchar(64) comment '创建者',
    `update_by`   varchar(64) comment '最后更新者',
    `create_time` datetime comment '创建时间',
    `update_time` datetime comment '最后修改时间',
    `comment`     text comment '备注',
    primary key (`dict_id`),
    unique (dict_type)
) engine = innodb
  DEFAULT CHARSET = utf8
  auto_increment = 100 comment = '字典类型表';

insert into tms_dict_type
values (1, '大分类', 'tms_cl_big', '0', 'admin', 'admin',       '2021-02-15 14:12:08', '2021-02-15 14:12:08','大分类列表');
insert into tms_dict_type
values (2, '中分类', 'tms_cl_medium', '0', 'admin', 'admin',    '2021-02-15 14:12:08', '2021-02-15 14:12:08','中分类列表');
insert into tms_dict_type
values (3, '小分类', 'tms_cl_small', '0', 'admin', 'admin',     '2021-02-15 14:12:08', '2021-02-15 14:12:08','小分类列表');
insert into tms_dict_type
values (4, '项目类型', 'tms_item_type', '0', 'admin', 'admin',   '2021-02-15 14:12:08', '2021-02-15 14:12:08','项目类型列表');
insert into tms_dict_type
values (5, '军用能力点', 'tms_m_ability', '0', 'admin', 'admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08','军用能力列表');
insert into tms_dict_type
values (6, '民用能力点', 'tms_c_ability', '0', 'admin', 'admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08','民用能力列表');
insert into tms_dict_type
values (7, '测试追踪', 'tms_test_track', '0', 'admin', 'admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08','测试追踪列表');
insert into tms_dict_type
values (8, '测试方法', 'tms_test_method', '0', 'admin', 'admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08','测试方法列表');
insert into tms_dict_type
values (9, '问题类别', 'tms_pb_type', '0', 'admin', 'admin',     '2021-02-15 14:12:08', '2021-02-15 14:12:08','问题类别列表');
insert into tms_dict_type
values (10, '问题级别', 'tms_pb_level', '0', 'admin', 'admin',   '2021-02-15 14:12:08', '2021-02-15 14:12:08', '问题级别列表');



drop table if exists `tms_dict_data`;
create table `tms_dict_data`
(
    `dict_code` bigint(20) not null auto_increment comment '字典编码',
    `dict_sort` int(4)       default 0 comment '字典排序',
    `dict_label` varchar(100) default '' comment '字典标签',
    `dict_value` varchar(100) default '' comment '字典键值',
    `dict_type` varchar(100) default '' comment '字典类型',
    `is_default` char(1)      default 'N' comment '是否默认（Y是 N否）',
    `status` char(1)      default '0' comment '状态（0正常 1停用）',
    `create_by` varchar(64)  default '' comment '创建者',
    `update_by` varchar(64)  default '' comment '最后更新者',
    `create_time` datetime comment '创建时间',
    `update_time` datetime comment '最后修改时间',
    `comment`  text comment '备注',
    primary key (`dict_code`)
) engine = innodb
  DEFAULT CHARSET = utf8
  auto_increment = 100 comment = '字典数据表';

insert into tms_dict_data values(1,  1,  '设备信息管理',       '1',       'tms_cl_big',      'Y', '0', 'admin','admin',     '2021-02-15 14:12:08', '2021-02-15 14:12:08', '大分类1');
insert into tms_dict_data values(2,  2,  '数据类型管理',       '2',       'tms_cl_big',      'N', '0', 'admin','admin',     '2021-02-15 14:12:08', '2021-02-15 14:12:08','大分类2');
insert into tms_dict_data values(3,  1,  '军用设备管理',       '1',       'tms_cl_medium',      'Y', '0', 'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08', '中分类1-1');
insert into tms_dict_data values(4,  2,  '民用设备管理',       '2',       'tms_cl_medium',      'N', '0', 'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08','中分类1-2');
insert into tms_dict_data values(5,  3,  '视频数据',       '3',       'tms_cl_medium',      'N', '0', 'admin','admin',    '2021-02-15 14:12:08', '2021-02-15 14:12:08', '中分类2-1');
insert into tms_dict_data values(6,  4,  '音频数据',       '4',       'tms_cl_medium',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '中分类2-2');
insert into tms_dict_data values(7,  5,  '日志数据',       '5',       'tms_cl_medium',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '中分类2-3');
insert into tms_dict_data values(8,  6,  '文电数据',       '6',       'tms_cl_medium',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '中分类2-4');
insert into tms_dict_data values(9,  1,   'I型',       '1',        'tms_cl_small',      'Y', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '小分类1');
insert into tms_dict_data values(10,  2,  'II型',       '2',       'tms_cl_small',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '小分类2');
insert into tms_dict_data values(11,  1,  '军用',       '1',       'tms_item_type',      'Y', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '项目类型1');
insert into tms_dict_data values(12,  2,  '民用',       '2',       'tms_item_type',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '项目类型2');
insert into tms_dict_data values(13,  1,  '功能',       '1',       'tms_m_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '军用能力点1');
insert into tms_dict_data values(14,  2,  '兼容性',       '2',       'tms_m_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '军用能力点2');
insert into tms_dict_data values(15,  3,  '易用性',       '3',       'tms_m_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '军用能力点3');
insert into tms_dict_data values(16,  4,  '效率性',       '4',       'tms_m_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '军用能力点4');
insert into tms_dict_data values(17,  5,  '维护性',       '5',       'tms_m_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '军用能力点5');
insert into tms_dict_data values(18,  6,  '可移植性',       '6',       'tms_m_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08','军用能力点6');
insert into tms_dict_data values(19,  1,  '功能',       '1',       'tms_c_ability',      'Y', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '民用能力点1');
insert into tms_dict_data values(20,  2,  '性能',       '2',       'tms_c_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '民用能力点2');
insert into tms_dict_data values(21,  3,  '接口',       '3',       'tms_c_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '民用能力点3');
insert into tms_dict_data values(22,  4,  '边界',       '4',       'tms_c_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '民用能力点4');
insert into tms_dict_data values(23,  5,  '强度',       '5',       'tms_c_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '民用能力点5');
insert into tms_dict_data values(24,  6,  '余量',       '6',       'tms_c_ability',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '民用能力点6');
insert into tms_dict_data values(25,  7,  '人机交互界面',       '7',       'tms_c_ability',      'N', '0', 'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08', '民用能力点7');
insert into tms_dict_data values(26,  1,  '测试追踪1',       '1',       'tms_test_track',      'Y', '0', 'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08', '测试追踪1');
insert into tms_dict_data values(27,  2,  '测试追踪2',       '2',       'tms_test_track',      'N', '0', 'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08', '测试追踪2');
insert into tms_dict_data values(28,  3,  '测试追踪3',       '3',       'tms_test_track',      'N', '0', 'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08', '测试追踪3');
insert into tms_dict_data values(29,  1,  '等价分类法',       '1',       'tms_test_method',      'Y', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '测试方法1');
insert into tms_dict_data values(30,  2,  '边界值法',       '2',       'tms_test_method',      'N', '0', 'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08', '测试方法2');
insert into tms_dict_data values(31,  3,  '因果图法',       '3',       'tms_test_method',      'N', '0', 'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08', '测试方法3');
insert into tms_dict_data values(32,  4,  '场景法',       '4',       'tms_test_method',      'N', '0', 'admin','admin',   '2021-02-15 14:12:08', '2021-02-15 14:12:08', '测试方法4');
insert into tms_dict_data values(33,  5,  '错误推测法',       '5',       'tms_test_method',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '测试方法5');
insert into tms_dict_data values(34,  1,  '设计',       '1',       'tms_pb_type',      'Y', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08','问题类别1');
insert into tms_dict_data values(35,  2,  '文档',       '2',       'tms_pb_type',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08','问题类别2');
insert into tms_dict_data values(36,  3,  '程序',       '3',       'tms_pb_type',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08','问题类别3');
insert into tms_dict_data values(37,  4,  '规范性问题',       '4',       'tms_pb_type',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08','问题类别4');
insert into tms_dict_data values(38,  5,  '其他问题',       '5',       'tms_pb_type',      'N', '0', 'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08', '问题类别5');
insert into tms_dict_data values(39,  1,  '致命',       '1',       'tms_pb_level',      'Y', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '问题级别1');
insert into tms_dict_data values(40,  2,  '严重',       '2',       'tms_pb_level',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '问题级别2');
insert into tms_dict_data values(41,  3,  '一般',       '3',       'tms_pb_level',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '问题级别3');
insert into tms_dict_data values(42,  4,  '建议',       '4',       'tms_pb_level',      'N', '0', 'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08', '问题级别4');





INSERT INTO tms_user (id, username, password, real_name, last_login, create_time, update_time, comment)
VALUES (1, 'lamlados', 'hurrican3', '鲁霄', '2021-02-15 11:49:18', '2021-02-12 11:49:09', '2021-02-15 11:49:24',
        'One True User');
INSERT INTO tms_user (id, username, password, real_name, last_login, create_time, update_time, comment)
VALUES (2, 'rcyrcyrcy', '19971007', 'Leon', '2021-02-12 11:42:18', '2021-02-12 11:49:09', '2021-02-15 11:49:24',
        'Two True User');
INSERT INTO tms_user (id, username, password, real_name, last_login, create_time, update_time, comment)
VALUES (3, 'colanexo', '19981008', 'Lam', '2021-02-12 11:42:18', '2021-02-12 11:49:09', '2021-02-15 11:49:24',
        'Three True User');

INSERT INTO test_item_main (id, item_mark, item_name, item_type, create_by, update_by, create_time, update_time,
                            comment)
VALUES (1, 'DYJK', '多源监控管理系统', '军用', 'lamlados', 'lamlados', '2021-02-10 12:00:00', '2021-02-15 12:00:04',
        '第一个测试项目。 The first test item.');
INSERT INTO test_item_main (id, item_mark, item_name, item_type, create_by, update_by, create_time, update_time,
                            comment)
VALUES (2, 'CSGL', '测试管理系统', '民用', 'lamlados', 'rcyrcyrcy', '2021-02-13 12:03:00', '2021-02-15 12:00:04',
        '第二个测试项目。 The second test item.');
INSERT INTO test_item_main (id, item_mark, item_name, item_type, create_by, update_by, create_time, update_time,
                            comment)
VALUES (3, 'YLJC', '用例检查系统', '军用', 'lamlados', 'rcyrcyrcy', '2021-02-13 12:03:00', '2021-02-15 12:00:04',
        '第二个测试项目。 The second test item.');
INSERT INTO test_item_main (id, item_mark, item_name, item_type, create_by, update_by, create_time, update_time,
                            comment)
VALUES (4, 'YHGL', '用户管理系统', '民用', 'lamlados', 'colanexo', '2021-02-13 12:03:00', '2021-02-15 12:00:04',
        '第二个测试项目。 The second test item.');

INSERT INTO test_item_classification (id, item_mark, item_ability, classification_big, big_mark, classification_medium,
                                      medium_mark, classification_small, small_mark, classification_mark, create_by,
                                      update_by, create_time, update_time, comment)
VALUES (1, 'DYJK', '兼容性', '设备信息管理', 'SBXX', '军用设备管理', 'JYSB', 'I型', 'IX', 'DYJK-JRX-SBXX-JYSB-IX', 'lamlados', 'lamlados',
        '2021-02-15 13:50:30', '2021-02-15 13:50:36', '项目分类第一条。 This is item classification.');
INSERT INTO test_item_classification (id, item_mark, item_ability, classification_big, big_mark, classification_medium,
                                      medium_mark, classification_small, small_mark, classification_mark, create_by,
                                      update_by, create_time, update_time, comment)
VALUES (2, 'CSGL', '性能', '数据类型管理', 'SJLX', '民用设备管理', 'MYSB', 'II型', 'IIX', 'CSGL-XN-SJLX-MYSB-IIX', 'rcyrcyrcy', 'lamlados',
        '2021-02-15 13:50:30', '2021-02-15 13:50:36', '项目分类第二条。 This is item classification 2.');

INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (1, 'DYJK', 'DYJK-JRX-SBXX-JYSB-IX', 'DYJK-JRX-SBXX-JYSB-IX-1', '测试追踪1', '等价分类法', '测试设备的查询功能。', '环境必须正常。', '正常终止条件：在前置条件满足的情况下，测试用例按照设计步骤全部输入完毕。
异常终止条件：前提条件不能满足，导致无法完成测试步骤；或前提条件可以满足，但测试步骤无法完成。', '可放入图片的说明。', '可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过，否则不通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:06:23', '用例设计。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (2, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-1', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (3, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-2', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (4, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-3', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (5, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-4', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (6, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-5', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (7, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-6', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (8, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-7', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (9, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-8', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (10, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-9', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');
INSERT INTO test_case_design (id, item_mark, classification_mark, case_mark, test_track, test_method, test_description,
                              premise_constraint, end_condition, operating_description, expected_result,
                              evaluation_criteria, create_by, update_by, create_time, update_time, comment)
VALUES (11, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX', 'CSGL-XN-SJLX-MYSB-IIX-10', '测试追踪2', '对比法', '测试设备的所有功能。', '环境正常。', '正常终止条件，
异常终止条件', '不可放入图片的说明。', '不可放入图片的预期结果。', '测试用例正常终止且与预期输出一致则通过。', 'lamlados',
        'lamlados', '2021-02-15 14:06:18', '2021-02-15 14:26:23', '用例设计2。');


INSERT INTO problem_description (id, item_mark, problem_mark, case_number, problem_type, problem_level,
                                 problem_description, create_by, update_by, create_time, update_time, comment)
VALUES (1, 'DYJK', 'DYJK-JRX-SBXX-JYSB-IX-1', 1, '规范性问题', '一般', '可放入图片的描述。', 'lamlados', 'lamlados', '2021-02-15 14:16:11',
        '2021-02-15 14:16:14', '问题描述。');
INSERT INTO problem_description (id, item_mark, problem_mark, case_number, problem_type, problem_level,
                                 problem_description, create_by, update_by, create_time, update_time, comment)
VALUES (2, 'CSGL', 'CSGL-XN-SJLX-MYSB-IIX-2', 1, '规范问题', '严重', '不可放入图片的描述。', 'lamlados', 'rcyrcyrcy', '2021-02-15 14:16:11',
        '2021-02-15 14:16:14', '问题描述2。');

INSERT INTO test_case_test (id, item_mark, case_mark, test_version, actual_result, execution_result, problem_mark,
                            test_by, supervised_by, execution_date, create_by, update_by, create_time, update_time,
                            comment)
VALUES (1, 'DYJK', 1, '1.0.0', '可加附件的实际结果。', '执行结果。通过或否。', 'DYJK-JRX-SBXX-JYSB-IX-1', 'Someone', 'Somebody', '2021-02-15 14:11:54',
        'lamlados', 'lamlados', '2021-02-15 14:12:08', '2021-02-15 14:12:12', '用例测试。');
INSERT INTO test_case_test (id, item_mark, case_mark, test_version, actual_result, execution_result, problem_mark,
                            test_by, supervised_by, execution_date, create_by, update_by, create_time, update_time,
                            comment)
VALUES (2, 'CSGL', 2, '1.1.0', '不可加附件的实际结果。', '执行结果。通过。', 'CSGL-XN-SJLX-MYSB-IIX-2', 'Anyone', 'Anybody', '2021-02-12 14:11:54',
        'rcyrcyrcy', 'rcyrcyrcy', '2021-02-15 14:12:08', '2021-02-15 14:12:12', '用例测试2。');



