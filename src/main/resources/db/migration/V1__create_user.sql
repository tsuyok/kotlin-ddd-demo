CREATE TABLE IF NOT EXISTS users (
  id            INT(11)      NOT NULL AUTO_INCREMENT,
  user_name     VARCHAR(255) NOT NULL COMMENT 'ユーザ名（半角）',
  mail_address  VARCHAR(255) NOT NULL COMMENT '利用者のメールアドレス',
  first_name    VARCHAR(40)  NOT NULL COMMENT '利用者の名前',
  last_name     VARCHAR(40)  NOT NULL COMMENT '利用者の名字',
  password     VARCHAR(255) NOT NULL COMMENT 'ログインパスワード',
  created_at    TIMESTAMP DEFAULT current_timestamp() COMMENT 'レコードの作成日時',
  PRIMARY KEY (id),
  UNIQUE (user_name),
  UNIQUE (mail_address)
) ENGINE InnoDB AUTO_INCREMENT 1 DEFAULT CHARSET utf8mb4 DEFAULT COLLATE utf8mb4_bin COMMENT '利用者';