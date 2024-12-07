CREATE TABLE USERS (
                      user_id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255),
                      password VARCHAR(255)
);


CREATE TABLE NOTE_PROFILE (
                              user_id INT,
                              id INT,
                              PRIMARY KEY (user_id, id),
                              FOREIGN KEY (user_id) REFERENCES USERS(user_id),
                              FOREIGN KEY (id) REFERENCES NOTE(id)
);