CREATE TABLE health_diary
(
    id            INT AUTO_INCREMENT                  NOT NULL,
    user_id       INT(30)                             NOT NULL,
    weight        INT                                 NOT NULL,
    distinct_date DATE                                NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES accounts (`id`)
);

INSERT
health_diary (user_id, weight, distinct_date)
VALUES (1, 61, '2023-02-09'),
       (1, 62, '2023-02-10'),
       (1, 63, '2023-02-11'),
       (1, 64, '2023-02-12'),
       (3, 65, '2023-02-13'),
       (3, 66, '2023-02-14'),
       (3, 67, '2023-02-15'),
       (3, 68, '2023-02-16'),
       (3, 69, '2023-02-17');

