
    create table booking_devices (
       booking_id bigint not null,
        device_id bigint not null,
        primary key (booking_id, device_id)
    );

    create table bookings (
       id bigint identity not null,
        created_at datetime2(6),
        description varchar(255),
        title varchar(255),
        updated_at datetime2(6),
        valid_from datetime2(6),
        valid_to datetime2(6),
        created_by bigint not null,
        room_id bigint,
        updated_by bigint not null,
        primary key (id)
    );

    create table comments (
       id bigint identity not null,
        body varchar(255),
        comment_object_id int not null,
        comment_object_type_id int not null,
        created_at datetime2(6),
        title varchar(255),
        created_by bigint not null,
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

    alter table booking_devices 
       add constraint FKbd6gra5wfrr1uppkeeis0ohju 
       foreign key (device_id) 
       references devices;

    alter table booking_devices 
       add constraint FK9rvo2d63ro4pkai6a1aunjf6w 
       foreign key (booking_id) 
       references bookings;

    alter table bookings 
       add constraint FK4lsaxxymtu2xxvqp0mg2tqqya 
       foreign key (created_by) 
       references users;

    alter table bookings 
       add constraint FKrgoycol97o21kpjodw1qox4nc 
       foreign key (room_id) 
       references rooms;

    alter table bookings 
       add constraint FK4rwqlw5c58h0970nxu1bhxfop 
       foreign key (updated_by) 
       references users;

    alter table comments 
       add constraint FK44lfn5qjtv4kjiuvwnq6nl0e7 
       foreign key (created_by) 
       references users;

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

    create table booking_devices (
       booking_id bigint not null,
        device_id bigint not null,
        primary key (booking_id, device_id)
    );

    create table bookings (
       id bigint identity not null,
        created_at datetime2(6),
        description varchar(255),
        title varchar(255),
        updated_at datetime2(6),
        valid_from datetime2(6),
        valid_to datetime2(6),
        created_by bigint not null,
        room_id bigint,
        updated_by bigint not null,
        primary key (id)
    );

    create table comments (
       id bigint identity not null,
        body varchar(255),
        comment_object_id int not null,
        comment_object_type_id int not null,
        created_at datetime2(6),
        title varchar(255),
        created_by bigint not null,
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

    alter table booking_devices 
       add constraint FKbd6gra5wfrr1uppkeeis0ohju 
       foreign key (device_id) 
       references devices;

    alter table booking_devices 
       add constraint FK9rvo2d63ro4pkai6a1aunjf6w 
       foreign key (booking_id) 
       references bookings;

    alter table bookings 
       add constraint FK4lsaxxymtu2xxvqp0mg2tqqya 
       foreign key (created_by) 
       references users;

    alter table bookings 
       add constraint FKrgoycol97o21kpjodw1qox4nc 
       foreign key (room_id) 
       references rooms;

    alter table bookings 
       add constraint FK4rwqlw5c58h0970nxu1bhxfop 
       foreign key (updated_by) 
       references users;

    alter table comments 
       add constraint FK44lfn5qjtv4kjiuvwnq6nl0e7 
       foreign key (created_by) 
       references users;

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

    create table booking_devices (
       booking_id bigint not null,
        device_id bigint not null,
        primary key (booking_id, device_id)
    );

    create table bookings (
       id bigint identity not null,
        created_at datetime2(6) not null,
        description varchar(255) not null,
        title varchar(255) not null,
        updated_at datetime2(6) not null,
        valid_from datetime2(6) not null,
        valid_to datetime2(6) not null,
        created_by bigint not null,
        room_id bigint,
        updated_by bigint not null,
        primary key (id)
    );

    create table comments (
       id bigint identity not null,
        body varchar(255) not null,
        comment_object_id int not null,
        comment_object_type_id int not null,
        created_at datetime2(6) not null,
        title varchar(255) not null,
        created_by bigint not null,
        primary key (id)
    );

    create table device_groups (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table devices (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
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
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table rooms (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        location varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table users (
       id bigint identity not null,
        archived bit default 0 not null,
        email_address varchar(255) not null,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        password varchar(255) not null,
        phone_number varchar(255),
        username varchar(255) not null,
        primary key (id)
    );

    alter table users 
       add constraint UK_1ar956vx8jufbghpyi09yr16l unique (email_address);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table booking_devices 
       add constraint FKbd6gra5wfrr1uppkeeis0ohju 
       foreign key (device_id) 
       references devices;

    alter table booking_devices 
       add constraint FK9rvo2d63ro4pkai6a1aunjf6w 
       foreign key (booking_id) 
       references bookings;

    alter table bookings 
       add constraint FK4lsaxxymtu2xxvqp0mg2tqqya 
       foreign key (created_by) 
       references users;

    alter table bookings 
       add constraint FKrgoycol97o21kpjodw1qox4nc 
       foreign key (room_id) 
       references rooms;

    alter table bookings 
       add constraint FK4rwqlw5c58h0970nxu1bhxfop 
       foreign key (updated_by) 
       references users;

    alter table comments 
       add constraint FK44lfn5qjtv4kjiuvwnq6nl0e7 
       foreign key (created_by) 
       references users;

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

    create table booking_devices (
       booking_id bigint not null,
        device_id bigint not null,
        primary key (booking_id, device_id)
    );

    create table bookings (
       id bigint identity not null,
        created_at datetime2(6) not null,
        description varchar(255) not null,
        title varchar(255) not null,
        updated_at datetime2(6) not null,
        valid_from datetime2(6) not null,
        valid_to datetime2(6) not null,
        created_by bigint not null,
        room_id bigint,
        updated_by bigint not null,
        primary key (id)
    );

    create table comments (
       id bigint identity not null,
        body varchar(255) not null,
        comment_object_id int not null,
        comment_object_type_id int not null,
        created_at datetime2(6) not null,
        title varchar(255) not null,
        created_by bigint not null,
        primary key (id)
    );

    create table device_groups (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table devices (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
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
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table rooms (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        location varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table users (
       id bigint identity not null,
        archived bit default 0 not null,
        email_address varchar(255) not null,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        password varchar(255) not null,
        phone_number varchar(255),
        username varchar(255) not null,
        primary key (id)
    );

    alter table users 
       add constraint UK_1ar956vx8jufbghpyi09yr16l unique (email_address);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table booking_devices 
       add constraint FKbd6gra5wfrr1uppkeeis0ohju 
       foreign key (device_id) 
       references devices;

    alter table booking_devices 
       add constraint FK9rvo2d63ro4pkai6a1aunjf6w 
       foreign key (booking_id) 
       references bookings;

    alter table bookings 
       add constraint FK4lsaxxymtu2xxvqp0mg2tqqya 
       foreign key (created_by) 
       references users;

    alter table bookings 
       add constraint FKrgoycol97o21kpjodw1qox4nc 
       foreign key (room_id) 
       references rooms;

    alter table bookings 
       add constraint FK4rwqlw5c58h0970nxu1bhxfop 
       foreign key (updated_by) 
       references users;

    alter table comments 
       add constraint FK44lfn5qjtv4kjiuvwnq6nl0e7 
       foreign key (created_by) 
       references users;

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

    create table booking_devices (
       booking_id bigint not null,
        device_id bigint not null,
        primary key (booking_id, device_id)
    );

    create table bookings (
       id bigint identity not null,
        created_at datetime2(6) not null,
        description varchar(255) not null,
        title varchar(255) not null,
        updated_at datetime2(6) not null,
        valid_from datetime2(6) not null,
        valid_to datetime2(6) not null,
        created_by bigint not null,
        room_id bigint,
        updated_by bigint not null,
        primary key (id)
    );

    create table comments (
       id bigint identity not null,
        body varchar(255) not null,
        comment_object_id int not null,
        comment_object_type_id int not null,
        created_at datetime2(6) not null,
        title varchar(255) not null,
        created_by bigint not null,
        primary key (id)
    );

    create table device_groups (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table devices (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
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
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table rooms (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        location varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table users (
       id bigint identity not null,
        archived bit default 0 not null,
        email_address varchar(255) not null,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        password varchar(255) not null,
        phone_number varchar(255),
        username varchar(255) not null,
        primary key (id)
    );

    alter table users 
       add constraint UK_1ar956vx8jufbghpyi09yr16l unique (email_address);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table booking_devices 
       add constraint FKbd6gra5wfrr1uppkeeis0ohju 
       foreign key (device_id) 
       references devices;

    alter table booking_devices 
       add constraint FK9rvo2d63ro4pkai6a1aunjf6w 
       foreign key (booking_id) 
       references bookings;

    alter table bookings 
       add constraint FK4lsaxxymtu2xxvqp0mg2tqqya 
       foreign key (created_by) 
       references users;

    alter table bookings 
       add constraint FKrgoycol97o21kpjodw1qox4nc 
       foreign key (room_id) 
       references rooms;

    alter table bookings 
       add constraint FK4rwqlw5c58h0970nxu1bhxfop 
       foreign key (updated_by) 
       references users;

    alter table comments 
       add constraint FK44lfn5qjtv4kjiuvwnq6nl0e7 
       foreign key (created_by) 
       references users;

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

    create table booking_devices (
       booking_id bigint not null,
        device_id bigint not null,
        primary key (booking_id, device_id)
    );

    create table bookings (
       id bigint identity not null,
        created_at datetime2(6) not null,
        description varchar(255) not null,
        title varchar(255) not null,
        updated_at datetime2(6) not null,
        valid_from datetime2(6) not null,
        valid_to datetime2(6) not null,
        created_by bigint not null,
        room_id bigint,
        updated_by bigint not null,
        primary key (id)
    );

    create table comments (
       id bigint identity not null,
        body varchar(255) not null,
        comment_object_id int not null,
        comment_object_type_id int not null,
        created_at datetime2(6) not null,
        title varchar(255) not null,
        created_by bigint not null,
        primary key (id)
    );

    create table device_groups (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table devices (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
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
        available bit default 1 not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table rooms (
       id bigint identity not null,
        available bit default 1 not null,
        description varchar(255) not null,
        location varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table users (
       id bigint identity not null,
        archived bit default 0 not null,
        email_address varchar(255) not null,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        password varchar(255) not null,
        phone_number varchar(255),
        username varchar(255) not null,
        primary key (id)
    );

    alter table users 
       add constraint UK_1ar956vx8jufbghpyi09yr16l unique (email_address);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table booking_devices 
       add constraint FKbd6gra5wfrr1uppkeeis0ohju 
       foreign key (device_id) 
       references devices;

    alter table booking_devices 
       add constraint FK9rvo2d63ro4pkai6a1aunjf6w 
       foreign key (booking_id) 
       references bookings;

    alter table bookings 
       add constraint FK4lsaxxymtu2xxvqp0mg2tqqya 
       foreign key (created_by) 
       references users;

    alter table bookings 
       add constraint FKrgoycol97o21kpjodw1qox4nc 
       foreign key (room_id) 
       references rooms;

    alter table bookings 
       add constraint FK4rwqlw5c58h0970nxu1bhxfop 
       foreign key (updated_by) 
       references users;

    alter table comments 
       add constraint FK44lfn5qjtv4kjiuvwnq6nl0e7 
       foreign key (created_by) 
       references users;

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
