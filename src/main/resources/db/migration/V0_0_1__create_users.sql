CREATE TABLE accounts
(
    id         INT AUTO_INCREMENT                                              NOT NULL PRIMARY KEY,
    user_id    INT AUTO_INCREMENT                                              NOT NULL,
    name       VARCHAR(30)                                                     NOT NULL,
    email      VARCHAR(30)                                                     NOT NULL,
    password   VARCHAR(30)                                                     NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);

INSERT
accounts (name, email, password)
VALUES  ('tanaka', 'akamatsufumihito@example.co.jp', 'test'),
        ('suzuki', 'ito_523@example.com', 'test'),
        ('matsuura', 'nishida119@example.org', 'test'),
        ('hotta', 'yamashita_tetsuya@example.net', 'test'),
        ('tanabe', 'kosugi_takehiro@example.com', 'test'),
        ('tanimoto', 'ishikawa_89@example.jp', 'test'),
        ('tsuruta', 'junya_kondou@example.org', 'test'),
        ('katayama', 'kento_kanou@example.org', 'test'),
        ('simazaki', 'kinoshita1017@example.ne.jp', 'test'),
        ('oosawa', 'ito1117@example.net', 'test');