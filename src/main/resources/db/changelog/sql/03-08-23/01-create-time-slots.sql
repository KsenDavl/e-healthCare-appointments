create sequence if not exists timeslots_seq;

CREATE TABLE timeslots (
                              id BIGINT not null primary key,
                              doctor_id INTEGER references doctors(id),
                              app_date DATE,
                              time_slot VARCHAR(1)
);