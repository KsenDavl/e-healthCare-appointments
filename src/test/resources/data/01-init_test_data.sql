delete from timeslots;
delete from doctors;
delete from patients;

insert into doctors(id, first_name, last_name, room_no, specialization)
values (1, 'Maria', 'Ivanova', 201, 'DRM');

insert into doctors(id, first_name, last_name, room_no, specialization)
values (2, 'Petr', 'Myshkin', 203, 'ONC');

insert into patients (id, first_name, last_name, pass_no, address, work_info, phone_number, birth_date, blood_group, rh_factor)
values (1, 'Dobr', 'Dobreev', '12345', 'Lenina, 86-45', 'no info', 89651234563, '02-02-1992', 1, false);

insert into patients(id, first_name, last_name, pass_no, address, work_info, phone_number, birth_date, blood_group, rh_factor)
values (2, 'Max', 'Korzh', '7623456', 'Pushkina, 90-40', 'no work', 89563452341, '10-10-1998', 2, true);

insert into timeslots(id, doctor_id, app_date, time_slot)
values (10, 1, '10-10-2023', 'A');

insert into timeslots(id, doctor_id, app_date, time_slot)
values (11, 1, '10-10-2023', 'B');

insert into timeslots(id, doctor_id, app_date, time_slot)
values (12, 1, '10-11-2023', 'C');