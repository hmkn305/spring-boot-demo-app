CREATE TABLE accounts
(
    id         INT AUTO_INCREMENT                                              NOT NULL PRIMARY KEY,
    user_id    INT                                                             NOT NULL,
    name       VARCHAR(30)                                                     NOT NULL,
    email      VARCHAR(30)                                                     NOT NULL,
    password   VARCHAR(30)                                                     NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);

INSERT
accounts (user_id, name, email, password)
VALUES  (1, 'tanaka', 'akamatsufumihito@example.co.jp', 'test'),
        (2, 'suzuki', 'ito_523@example.com', 'test'),
        (3, 'matsuura', 'nishida119@example.org', 'test'),
        (4, 'hotta', 'yamashita_tetsuya@example.net', 'test'),
        (5, 'tanabe', 'kosugi_takehiro@example.com', 'test'),
        (6, 'tanimoto', 'ishikawa_89@example.jp', 'test'),
        (7, 'tsuruta', 'junya_kondou@example.org', 'test'),
        (8, 'katayama', 'kento_kanou@example.org', 'test'),
        (9, 'simazaki', 'kinoshita1017@example.ne.jp', 'test'),
        (10, 'oosawa', 'ito1117@example.net', 'test');