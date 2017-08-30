INSERT INTO department ( code, name ) VALUES (1, '開発部');
INSERT INTO department ( code, name ) VALUES (2, '営業部');

INSERT INTO employee ( no, birthday, first_name, last_name, mail_address, sex, department_code, version ) VALUES (1, '1980-01-31', '太郎', '山田', 'taro.yamada@mail.com', 'male', 1, 1);

INSERT INTO employee ( no, birthday, first_name, last_name, mail_address, sex, department_code, version ) VALUES (2, '1985-02-10', '一郎', '鈴木', 'ichiro.suzuki@mail.com', 'male', 1, 1);

INSERT INTO employee ( no, birthday, first_name, last_name, mail_address, sex, department_code, version ) VALUES (3, null, '花子', '石井', null, 'female', 2, 2);

INSERT INTO authentication (id, password, valid_date, employee_no) VALUES ('yamada', 'taro', '2019-12-31', 1);