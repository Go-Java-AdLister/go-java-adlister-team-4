USE adlister_db;

DROP TABLE IF EXISTS ad_images;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;


CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email    VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    category    VARCHAR(240),
    plant_name  VARCHAR(240),
    location    VARCHAR(240),
    price       VARCHAR(50),
    description TEXT,
    photo VARCHAR(300),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

INSERT INTO  users (username, email, password) VALUES ('bob', 'bob@email.com', 'pass123');

# CREATE TABLE ad_images
# (
#     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
#     ad_id INT UNSIGNED NOT NULL,
#     photo VARCHAR(300) NOT NULL,
#     PRIMARY KEY (id),
#     FOREIGN KEY (ad_id) REFERENCES ads (id)
#         ON DELETE CASCADE
# )


