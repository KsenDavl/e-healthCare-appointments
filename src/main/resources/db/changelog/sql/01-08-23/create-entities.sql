create sequence if not exists patients_seq;
create sequence if not exists doctors_seq;

        create table patients (
        id BIGINT not null primary key,
        first_name VARCHAR(100) not null,
        last_name VARCHAR(100) not null,
        pass_no VARCHAR(100) not null unique,
        address VARCHAR(100) not null,
        work_info VARCHAR(1024) not null,
        phone_number INTEGER not null,
        birth_date DATE not null
        );

        create table doctors (
        id BIGINT not null primary key,
        first_name VARCHAR(100) not null,
        last_name VARCHAR(100) not null,
        room_no INTEGER
        );

        CREATE TABLE appointments (
        patient_id INTEGER references patients(id),
        doctor_id INTEGER references doctors(id),
        date DATE,
        time_spot VARCHAR(1)
        );


