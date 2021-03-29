# /-- 删除时去除外键 --/
drop table if exists `tms_dict_mark`;
create table `tms_dict_mark`
(
    `dict_id`     bigint(20) not null auto_increment comment '字典序号',
    `dict_type`   varchar(100) default '' comment '字典类型',
    `dict_content`   varchar(100) default '' comment '字典内容',
    `dict_mark`   varchar(100) default '' comment '字典标识',
    `create_by`   varchar(64) comment '创建者',
    `update_by`   varchar(64) comment '最后更新者',
    `create_time` datetime comment '创建时间',
    `update_time` datetime comment '最后修改时间',
    primary key (`dict_id`),
    unique (dict_id)
) engine = innodb
  DEFAULT CHARSET = utf8
  auto_increment = 100 comment = '字典总表';

insert into tms_dict_mark values(1,    '大分类1',    '设备信息管理',   'SBXX',   'admin','admin',     '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(2,    '大分类2',    '数据类型管理',   'SJLX',    'admin','admin',     '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(3,    '大分类3',    '军用设备管理',   'JYSB',    'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(4,    '大分类4',    '民用设备管理',   'MYSB',    'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(5,    '中分类1',    '视频数据',     'SPSJ',    'admin','admin',    '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(6,    '中分类2',    '音频数据',     'YPSJ',    'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(7,    '小分类1',    '日志数据',     'RZSJ',     'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(8,    '小分类2',    '文电数据',     'WDSJ',     'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(9,    '小分类3',     'I型',      'IX',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(10,   '小分类4',     'II型',     'IIX',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(11,   '军用能力点1',     '效率性',    'XL',        'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(12,   '军用能力点2',     '维护性',    'WH',        'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(13,   '军用能力点3',     '功能',     'GN',       'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(14,   '军用能力点4',     '兼容性',    'JR',       'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(15,   '军用能力点5',     '易用性',    'YY',       'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(16,   '军用能力点6',     '可移植性',   'KYZ',        'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(17,   '民用能力点1',     '兼容性',    'JR',       'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(18,   '民用能力点2',     '安全性',    'AQ',     'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(19,   '民用能力点3',     '功能',     'GN',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(20,   '民用能力点4',     '性能',     'XN',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(21,   '民用能力点5',     '接口',     'JK',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(22,   '民用能力点6',     '边界',     'BJ',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(23,   '民用能力点7',     '强度',     'QD',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(24,   '民用能力点8',     '余量',     'YL',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(25,   '民用能力点9',     '人机交互界面', 'RJ',     'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(26,   '测试项目1',     '测试管理系统',      'CSGL',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(27,   '测试项目2',     '多元监控管理系统',    'DYJK',       ' admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(28,   '测试项目3',     '用户管理系统',      'YHGL',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_mark values(29,   '测试项目4',     '用例检查系统',      'YLJC',     ' admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');


drop table if exists `tms_dict_nomark`;
create table `tms_dict_nomark`
(
    `dict_id`     bigint(20) not null auto_increment comment '字典序号',
    `dict_type`   varchar(100) default '' comment '字典类型',
    `dict_content`   varchar(100) default '' comment '字典内容',
    `create_by`   varchar(64) comment '创建者',
    `update_by`   varchar(64) comment '最后更新者',
    `create_time` datetime comment '创建时间',
    `update_time` datetime comment '最后修改时间',
    primary key (`dict_id`),
    unique (dict_id)
) engine = innodb
  DEFAULT CHARSET = utf8
  auto_increment = 100 comment = '字典总表';

insert into tms_dict_nomark values(1,   '测试方法1',     '等价分类法',      'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(2,   '测试方法2',     '边界值法',        'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(3,   '测试方法3',     '因果图法',          'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(4,   '测试方法4',     '场景法',             'admin','admin',   '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(5,   '测试方法5',     '错误推测法',            'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(6,   '问题类别1',     '设计',              'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(7,   '问题类别2',     '文档',              'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(8,   '问题类别3',     '程序',              'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(9,   '问题类别4',     '规范性问题',            'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(10,   '问题类别5',     '其他问题',            'admin','admin',  '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(11,   '问题级别1',     '致命',              'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(12,   '问题级别2',     '严重',             ' admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(13,   '问题级别3',     '一般',              'admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');
insert into tms_dict_nomark values(14,   '问题级别4',     '建议',             ' admin','admin', '2021-02-15 14:12:08', '2021-02-15 14:12:08');




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



