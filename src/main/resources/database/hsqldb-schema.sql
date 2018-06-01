
create table user (
    username varchar(25) not null,
    password varchar(25)  not null,
    name varchar(80) null,
    status varchar(1) not null,
    login_failure_ct int,
    last_login_ts timestamp default null,
    last_login_failure_ts timestamp not null 
    default current_timestamp on update current_timestamp,
    constraint pk_user primary key (username)
);


create table product (
    id varchar(10) not null,
    category varchar(10) not null,
    name varchar(80) null,
    description varchar(255) null,
    constraint pk_product primary key (id)
);


CREATE TABLE role (
	rolename VARCHAR(25) NOT NULL,
	description VARCHAR(80),
	constraint pk_role primary key (rolename)
);

CREATE TABLE permission (
	permission VARCHAR(25) NOT NULL,
	description VARCHAR(80),
	constraint pk_permission primary key (permission)
);

CREATE TABLE user_role (
	username VARCHAR(25) NOT NULL,
	rolename VARCHAR(25) NOT NULL,
	constraint pk_USER_ROLE primary key (username, rolename),
    constraint fk_USER_ROLE_1 foreign key (username) references user (username),
    constraint fk_USER_ROLE_2 foreign key (rolename) references role (rolename)
);

CREATE TABLE role_permission (
	rolename VARCHAR(25),
	permission VARCHAR(25) NOT NULL,
	constraint pk_ROLE_PERMISSION primary key (rolename, permission),
    constraint fk_ROLE_PERMISSION_1 foreign key (rolename) references role (rolename)
);

