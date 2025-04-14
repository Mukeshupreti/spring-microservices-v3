use mydb;

CREATE TABLE USER
(
    ID INT NOT NULL AUTO_INCREMENT,
    FIRST_NAME VARCHAR(20),
    LAST_NAME VARCHAR(20),
    EMAIL VARCHAR(20),
    PASSWORD VARCHAR(256),
    PRIMARY KEY (ID),
    UNIQUE KEY (EMAIL)
);

CREATE TABLE ROLE
(
    ID INT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(20),
    PRIMARY KEY (ID)
);

CREATE TABLE USER_ROLE(
                          USER_ID int,
                          ROLE_ID int,
                          FOREIGN KEY (user_id)
                              REFERENCES USER(id),
                          FOREIGN KEY (role_id)
                              REFERENCES ROLE(id)
);

insert into USER(first_name,last_name,email,password) values ('doug','bailey','doug@bailey.com','$2a$10$U2STWqktwFbvPPsfblVeIuy11vQ1S/0LYLeXQf1ZL0cMXc9HuTEA2');
insert into USER(first_name,last_name,email,password) values ('john','ferguson','john@ferguson.com','$2a$10$YzcbPL.fnzbWndjEcRkDmO1E4vOvyVYP5kLsJvtZnR1f8nlXjvq/G');

insert into ROLE values(1,'ROLE_ADMIN');
insert into ROLE values(2,'ROLE_USER');

insert into USER_ROLE values(1,1);
insert into USER_ROLE values(2,2);

select * from USER;
select * from ROLE;
select * from USER_ROLE;





create table programmer(
                           id int PRIMARY KEY AUTO_INCREMENT,
                           name varchar(20),
                           salary int
);

create table project(
                        id int PRIMARY KEY AUTO_INCREMENT,
                        name varchar(20)
);

create table programmers_projects(
                                     programmer_id int,
                                     project_id int,
                                     FOREIGN KEY (programmer_id)
                                         REFERENCES programmer(id),
                                     FOREIGN KEY (project_id)
                                         REFERENCES project(id)
);


-- one to Many
create table customer(
                         id int PRIMARY KEY AUTO_INCREMENT,
                         name varchar(20)
);

create table phone_number(
                             id int PRIMARY KEY AUTO_INCREMENT,
                             customer_id int,
                             number varchar(20),
                             type varchar(20),
                             FOREIGN KEY (customer_id)
                                 REFERENCES customer(id)
)

select * from customer;

select * from phone_number;

create table person(
                       id int PRIMARY KEY AUTO_INCREMENT,
                       first_name varchar(20),
                       last_name varchar(20),
                       age int
);

create table license(
                        id int PRIMARY KEY AUTO_INCREMENT,
                        type varchar(20),
                        valid_from date,
                        valid_to date,
                        person_id int,
                        FOREIGN KEY (person_id)
                        REFERENCES person(id)
)


select * from person;

select * from license;





























