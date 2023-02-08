CREATE TABLE accounts
(
    id         INT AUTO_INCREMENT                                              NOT NULL PRIMARY KEY,
    name       VARCHAR(30)                                                     NOT NULL,
    email      VARCHAR(30)                                                     NOT NULL,
    password   VARCHAR(30)                                                     NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);

INSERT
accounts (name, email, password)
VALUES ('田中太郎', 'akamatsufumihito@example.co.jp', 'test'),
        ('鈴木一郎', 'ito_523@example.com', 'test'),
        ('松浦 多栄子', 'nishida119@example.org', 'test'),
        ('堀田 隆次', 'yamashita_tetsuya@example.net', 'test'),
        ('田辺 雅生', 'kosugi_takehiro@example.com', 'test'),
        ('谷本 恵治', 'ishikawa_89@example.jp', 'test'),
        ('鶴田 光範', 'junya_kondou@example.org', 'test'),
        ('片山 有', 'kento_kanou@example.org', 'test'),
        ('島崎 直秋', 'kinoshita1017@example.ne.jp', 'test'),
        ('大沢 祐美', 'ito1117@example.net', 'test');