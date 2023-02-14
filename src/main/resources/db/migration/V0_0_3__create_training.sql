CREATE TABLE training
(
    id            INT AUTO_INCREMENT                    NOT NULL,
    user_id       INT(30)                               NOT NULL,
    training_menu VARCHAR(30)                           NOT NULL,
    times         INT(30)                               NOT NULL,
    reps          INT(30)                               NOT NULL,
    training_date DATETIME                              NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP   NOT NULL,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP   ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES accounts (`id`)
);

INSERT INTO
training (user_id, training_menu, times, reps, training_date)
VALUES (1, 'インクラインベンチプレス', 10, 3, '2023-02-09'),
       (1, 'ベンチプレス', 10, 3, '2023-02-10'),
       (1, 'ケーブルフライ', 10, 3, '2023-02-11'),
       (1, 'ケーブルフライ', 10, 3, '2023-02-12'),
       (1, 'ケーブルフライ', 10, 3, '2023-02-13'),
       (1, 'ベンチプレス', 10, 3, '2023-02-14'),
       (1, 'ベンチプレス', 10, 3, '2023-02-15'),
       (1, 'ケーブルフライ', 10, 3, '2023-02-16'),
       (1, 'ベンチプレス', 10, 3, '2023-02-17');