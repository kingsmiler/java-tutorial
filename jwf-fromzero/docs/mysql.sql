CREATE DATABASE IF NOT EXISTS `jwf`
    CHARACTER SET utf8
    COLLATE utf8_general_ci;

CREATE USER 'jwf'@'%'
    IDENTIFIED BY 'jwf';

USE jwf;
DROP TABLE customer;

CREATE TABLE customer
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(128) NOT NULL
    COMMENT '客户名称',
    contact VARCHAR(128) NOT NULL
    COMMENT '联系人',
    phone   VARCHAR(16) COMMENT '电话号码',
    mail    VARCHAR(32) COMMENT '邮箱地址',
    remark  TEXT COMMENT '备注'
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

ALTER TABLE jwf.customer
    COMMENT = '客户表';

INSERT INTO customer VALUES ('1', 'c1', 'Jack', '13811112222', 'jack@xman.com', NULL );
INSERT INTO customer VALUES ('2', 'c2', 'Rose', '13822224444', 'rose@xman.com', NULL );