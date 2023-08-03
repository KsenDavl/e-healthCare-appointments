CREATE TABLE timeslots (
                              id BIGINT not null primary key,
                              doctor_id INTEGER references doctors(id),
                              app_date DATE,
                              time_spot VARCHAR(1)
);