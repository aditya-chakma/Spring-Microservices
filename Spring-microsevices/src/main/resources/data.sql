INSERT INTO login(id, user_name, email, first_name, last_name) VALUES (0, 'larma', 'adityachakma199@gmail.com', 'Aditya', 'Larma');
INSERT INTO login(id, user_name, email, first_name, last_name) VALUES (1, 'larma1', 'adityachakma200@gmail.com', 'Aditya', 'Larma');
INSERT INTO login(id, user_name, email, first_name, last_name) VALUES (2, 'larma2', 'adityachakma201@gmail.com', 'Aditya', 'Larma');

INSERT INTO post(id, login_id, title, details) VALUES (0, 0, 'Tutorial', 'AWS');
INSERT INTO post(id, login_id, title, details) VALUES (1, 0, 'Tutorial 2', 'Spring');
INSERT INTO post(id, login_id, title, details) VALUES (2, 0, 'Tutorial 3', 'Kuberates');

INSERT INTO post(id, login_id, title, details) VALUES (3, 1, 'Interview', 'Google');
INSERT INTO post(id, login_id, title, details) VALUES (4, 1, 'Interview', 'Amazon');