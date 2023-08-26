
    create table bookings (
       id bigint identity not null,
        primary key (id)
    );

    create table device_groups (
       id bigint identity not null,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table devices (
       id bigint identity not null,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table group_devices (
       group_id bigint not null,
        device_id bigint not null,
        primary key (group_id, device_id)
    );

    create table group_rooms (
       group_id bigint not null,
        room_id bigint not null,
        primary key (group_id, room_id)
    );

    create table locks (
       id bigint identity not null,
        primary key (id)
    );

    create table room_groups (
       id bigint identity not null,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table rooms (
       id bigint identity not null,
        primary key (id)
    );

    create table users (
       id bigint identity not null,
        archived bit not null,
        email_address varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    );

    alter table users 
       add constraint UK_1ar956vx8jufbghpyi09yr16l unique (email_address);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table group_devices 
       add constraint FKfukmewy1qiepipo38xujc2h7 
       foreign key (device_id) 
       references devices;

    alter table group_devices 
       add constraint FK1ianhtxjjl5pipsuutvi4e8hb 
       foreign key (group_id) 
       references device_groups;

    alter table group_rooms 
       add constraint FKfkcf1dxeh39vhm5dyin1cpnwa 
       foreign key (room_id) 
       references rooms;

    alter table group_rooms 
       add constraint FK6ctxkptof7sx566l6xcs5iuh2 
       foreign key (group_id) 
       references room_groups;

    create table bookings (
       id bigint identity not null,
        primary key (id)
    );

    create table device_groups (
       id bigint identity not null,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table devices (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table group_devices (
       group_id bigint not null,
        device_id bigint not null,
        primary key (group_id, device_id)
    );

    create table group_rooms (
       group_id bigint not null,
        room_id bigint not null,
        primary key (group_id, room_id)
    );

    create table locks (
       id bigint identity not null,
        primary key (id)
    );

    create table room_groups (
       id bigint identity not null,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table rooms (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        location varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table users (
       id bigint identity not null,
        archived bit not null,
        email_address varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    );

    alter table users 
       add constraint UK_1ar956vx8jufbghpyi09yr16l unique (email_address);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table group_devices 
       add constraint FKfukmewy1qiepipo38xujc2h7 
       foreign key (device_id) 
       references devices;

    alter table group_devices 
       add constraint FK1ianhtxjjl5pipsuutvi4e8hb 
       foreign key (group_id) 
       references device_groups;

    alter table group_rooms 
       add constraint FKfkcf1dxeh39vhm5dyin1cpnwa 
       foreign key (room_id) 
       references rooms;

    alter table group_rooms 
       add constraint FK6ctxkptof7sx566l6xcs5iuh2 
       foreign key (group_id) 
       references room_groups;

    create table bookings (
       id bigint identity not null,
        primary key (id)
    );

    create table device_groups (
       id bigint identity not null,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table devices (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table group_devices (
       group_id bigint not null,
        device_id bigint not null,
        primary key (group_id, device_id)
    );

    create table group_rooms (
       group_id bigint not null,
        room_id bigint not null,
        primary key (group_id, room_id)
    );

    create table locks (
       id bigint identity not null,
        primary key (id)
    );

    create table room_groups (
       id bigint identity not null,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table rooms (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        location varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table users (
       id bigint identity not null,
        archived bit not null,
        email_address varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    );

    alter table users 
       add constraint UK_1ar956vx8jufbghpyi09yr16l unique (email_address);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table group_devices 
       add constraint FKfukmewy1qiepipo38xujc2h7 
       foreign key (device_id) 
       references devices;

    alter table group_devices 
       add constraint FK1ianhtxjjl5pipsuutvi4e8hb 
       foreign key (group_id) 
       references device_groups;

    alter table group_rooms 
       add constraint FKfkcf1dxeh39vhm5dyin1cpnwa 
       foreign key (room_id) 
       references rooms;

    alter table group_rooms 
       add constraint FK6ctxkptof7sx566l6xcs5iuh2 
       foreign key (group_id) 
       references room_groups;

    create table bookings (
       id bigint identity not null,
        primary key (id)
    );

    create table device_groups (
       id bigint identity not null,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table devices (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table group_devices (
       group_id bigint not null,
        device_id bigint not null,
        primary key (group_id, device_id)
    );

    create table group_rooms (
       group_id bigint not null,
        room_id bigint not null,
        primary key (group_id, room_id)
    );

    create table locks (
       id bigint identity not null,
        primary key (id)
    );

    create table room_groups (
       id bigint identity not null,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table rooms (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        location varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table users (
       id bigint identity not null,
        archived bit not null,
        email_address varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    );

    alter table users 
       add constraint UK_1ar956vx8jufbghpyi09yr16l unique (email_address);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table group_devices 
       add constraint FKfukmewy1qiepipo38xujc2h7 
       foreign key (device_id) 
       references devices;

    alter table group_devices 
       add constraint FK1ianhtxjjl5pipsuutvi4e8hb 
       foreign key (group_id) 
       references device_groups;

    alter table group_rooms 
       add constraint FKfkcf1dxeh39vhm5dyin1cpnwa 
       foreign key (room_id) 
       references rooms;

    alter table group_rooms 
       add constraint FK6ctxkptof7sx566l6xcs5iuh2 
       foreign key (group_id) 
       references room_groups;

    create table bookings (
       id bigint identity not null,
        primary key (id)
    );

    create table device_groups (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table devices (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table group_devices (
       group_id bigint not null,
        device_id bigint not null,
        primary key (group_id, device_id)
    );

    create table group_rooms (
       group_id bigint not null,
        room_id bigint not null,
        primary key (group_id, room_id)
    );

    create table locks (
       id bigint identity not null,
        primary key (id)
    );

    create table room_groups (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table rooms (
       id bigint identity not null,
        available bit default 1,
        description varchar(255),
        location varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table users (
       id bigint identity not null,
        archived bit not null,
        email_address varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    );

    alter table users 
       add constraint UK_1ar956vx8jufbghpyi09yr16l unique (email_address);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table group_devices 
       add constraint FKfukmewy1qiepipo38xujc2h7 
       foreign key (device_id) 
       references devices;

    alter table group_devices 
       add constraint FK1ianhtxjjl5pipsuutvi4e8hb 
       foreign key (group_id) 
       references device_groups;

    alter table group_rooms 
       add constraint FKfkcf1dxeh39vhm5dyin1cpnwa 
       foreign key (room_id) 
       references rooms;

    alter table group_rooms 
       add constraint FK6ctxkptof7sx566l6xcs5iuh2 
       foreign key (group_id) 
       references room_groups;
