
CREATE DATABASE IF NOT EXISTS student;

CREATE TABLE IF NOT EXISTS student.groups
(
  id  int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name_group varchar(255)
);

CREATE TABLE IF NOT EXISTS student.students
(
  id  int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  full_name  varchar(255),
  group_id int,
  year_admission  int,
  FOREIGN KEY (group_id) REFERENCES student.groups (id)
);

CREATE TABLE IF NOT EXISTS student.departments
(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name  varchar(255),
    chief varchar(255)
);

CREATE TABLE IF NOT EXISTS student.teachers
(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name  varchar(255),
	departments_id int,
    FOREIGN KEY (departments_id) REFERENCES student.departments (id)
);

CREATE TABLE IF NOT EXISTS student.classes
(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(255),
	teacher_id int,
	semester int,
	year int,
    FOREIGN KEY (teacher_id) REFERENCES student.teachers (id)
);

CREATE TABLE IF NOT EXISTS student.points
(
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  student_id int,
  class_id  int,
  point int,
  FOREIGN KEY (student_id) REFERENCES student.students (id),
  FOREIGN KEY (class_id) REFERENCES student.classes (id)
);

INSERT into student.groups (name_group) value ('theorists');
INSERT into student.groups (name_group) value ('practices');

INSERT into student.students (full_name, group_id, year_admission ) value ('Petrov Petr', 1, 2016);
INSERT into student.students (full_name, group_id, year_admission ) value ('Semenov Semen', 2, 2018);
INSERT into student.students (full_name, group_id, year_admission ) value ('Ivanov Ivan', 2, 2018);

INSERT into student.departments (name, chief) value ('theoretical physics', 'Victorov Victor');
INSERT into student.teachers (full_name, departments_id ) value ('Victorov Victor', 1);

INSERT into student.classes (name, teacher_id, semester, year ) value ('thermodynamics', 1, 2, 2020 );

INSERT into student.points (student_id, class_id, point ) value (1, 1, 95);
INSERT into student.points (student_id, class_id, point) value (2, 1, 90);