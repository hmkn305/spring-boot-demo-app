CREATE TABLE height
(
    id            INT AUTO_INCREMENT                    NOT NULL,
    user_id       INT(30)                               NOT NULL,
    height        INT(30)                               NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP   NOT NULL,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP   ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES accounts (`id`)
);

INSERT INTO
height (user_id, height)
VALUES(2, 172);