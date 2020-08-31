# springboot-mybaties-xml
springboot-mybaties整合xml方式增删改查

相关sql

```
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) DEFAULT '' COMMENT '姓名',
  `hobbies` varchar(255) DEFAULT '' COMMENT '爱好',
  `age` int(11) DEFAULT NULL  COMMENT '年龄',
  `height` int(11) DEFAULT NULL  COMMENT '身高',
  `weight` int(11) DEFAULT NULL  COMMENT '体重',
  `create_time` datetime NOT NULL DEFAULT NOW(),
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `url` varchar(255) DEFAULT '',
  `work` char(20) DEFAULT '' COMMENT 'Alexa 排名',
  `country` char(10) DEFAULT '' COMMENT '国家',
  `telephone` char(11) DEFAULT '' ,
  `company_id` int (11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

```
