CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (username, password, enabled) VALUES
    ('user', 'jdbcDefault', true);


INSERT INTO authorities (username, authority) VALUES
    ('user', 'ROLE_USER');