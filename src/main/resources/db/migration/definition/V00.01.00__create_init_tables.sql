CREATE TABLE users
(
    id         INT AUTO_INCREMENT                                              NOT NULL PRIMARY KEY,
    name       VARCHAR(30)                                                     NOT NULL,
    email      VARCHAR(30)                                                     NOT NULL,
    password   VARCHAR(30)                                                     NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);