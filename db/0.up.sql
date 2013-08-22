CREATE DATABASE bizwise;

CREATE USER 'biz'@'localhost' IDENTIFIED BY 'wise';

GRANT ALL privileges ON bizwise.* TO 'biz'@'localhost'IDENTIFIED BY 'wise';