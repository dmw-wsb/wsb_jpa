insert into address (id, address_line1, address_line2, city, postal_code) values (1, 'ulica Dębowa', '12A', 'Warszawa', '00-001');
insert into address (id, address_line1, address_line2, city, postal_code) values (2, 'ulica Lipowa', '34B', 'Kraków', '30-002');
insert into address (id, address_line1, address_line2, city, postal_code) values (3, 'ulica Sosnowa', '7C', 'Poznań', '60-003');
insert into address (id, address_line1, address_line2, city, postal_code) values (4, 'ulica Klonowa', '19', 'Gdańsk', '80-004');
insert into address (id, address_line1, address_line2, city, postal_code) values (5, 'ulica Akacjowa', '5A', 'Wrocław', '50-005');
insert into address (id, address_line1, address_line2, city, postal_code) values (6, 'ulica Wiśniowa', '22', 'Łódź', '90-006');
insert into address (id, address_line1, address_line2, city, postal_code) values (7, 'ulica Kasztanowa', '33B', 'Szczecin', '70-007');
insert into address (id, address_line1, address_line2, city, postal_code) values (8, 'ulica Świerkowa', '10', 'Bydgoszcz', '85-008');
insert into address (id, address_line1, address_line2, city, postal_code) values (9, 'ulica Wierzbowa', '4D', 'Lublin', '20-009');

insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values (1, 'DOC1001', 'john.smith@example.com', 'John', 'Smith', 'GP', '+48123456701', 1);
insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values (2, 'DOC1002', 'anna.brown@example.com', 'Anna', 'Brown', 'DERMATOLOGIST', '+48123456702', 2);
insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values (3, 'DOC1003', 'peter.white@example.com', 'Peter', 'White', 'SURGEON', '+48123456703', 3);

insert into patient (id, patient_number, date_of_birth, email, first_name, gender, last_name, telephone_number, address_id, version)
values (1, 'PAT1001', '1985-03-25', 'adam.nowak@example.com', 'Adam', 'MALE', 'Nowak', '+48123456781', 4, 0);
insert into patient (id, patient_number, date_of_birth, email, first_name, gender, last_name, telephone_number, address_id, version)
values (2, 'PAT1002', '1992-07-14', 'ewa.kowalska@example.com', 'Ewa', 'FEMALE', 'Kowalska', '+48123456782', 5, 0);
insert into patient (id, patient_number, date_of_birth, email, first_name, gender, last_name, telephone_number, address_id, version)
values (3, 'PAT1003', '1978-11-02', 'marek.wisniewski@example.com', 'Marek', 'MALE', 'Wiśniewski', '+48123456783', 6, 0);
insert into patient (id, patient_number, date_of_birth, email, first_name, gender, last_name, telephone_number, address_id, version)
values (4, 'PAT1004', '2000-01-18', 'anna.zielinska@example.com', 'Anna', 'FEMALE', 'Zielińska', '+48123456784', 7, 0);
insert into patient (id, patient_number, date_of_birth, email, first_name, gender, last_name, telephone_number, address_id, version)
values (5, 'PAT1005', '1969-06-09', 'jan.kowalski@example.com', 'Jan', 'MALE', 'Kowalski', '+48123456785', 8, 0);
insert into patient (id, patient_number, date_of_birth, email, first_name, gender, last_name, telephone_number, address_id, version)
values (6, 'PAT1006', '1988-10-30', 'magdalena.nowak@example.com', 'Magdalena', 'FEMALE', 'Nowak', '+48123456786', 9, 0);

insert into visit (id, description, time, doctor_id, patient_id) values (1, 'Routine checkup', '2024-12-05 09:00:00', 1, 1);
insert into visit (id, description, time, doctor_id, patient_id) values (2, 'Follow-up appointment', '2024-12-05 09:30:00', 2, 2);
insert into visit (id, description, time, doctor_id, patient_id) values (3, 'Dermatology consultation', '2024-12-05 10:00:00', 3, 3);
insert into visit (id, description, time, doctor_id, patient_id) values (4, 'Eye examination', '2024-12-05 10:30:00', 1, 4);
insert into visit (id, description, time, doctor_id, patient_id) values (5, 'Surgery follow-up', '2024-12-05 11:00:00', 2, 5);
insert into visit (id, description, time, doctor_id, patient_id) values (6, 'Routine checkup', '2024-12-05 11:30:00', 3, 6);
insert into visit (id, description, time, doctor_id, patient_id) values (7, 'General consultation', '2024-12-05 12:00:00', 1, 6);
insert into visit (id, description, time, doctor_id, patient_id) values (8, 'Skin rash diagnosis', '2024-12-05 12:30:00', 2, 5);
insert into visit (id, description, time, doctor_id, patient_id) values (9, 'Eye strain consultation', '2024-12-05 13:00:00', 3, 4);
insert into visit (id, description, time, doctor_id, patient_id) values (10, 'Post-surgery review', '2024-12-05 13:30:00', 1, 3);
insert into visit (id, description, time, doctor_id, patient_id) values (11, 'Routine checkup', '2024-12-05 14:00:00', 1, 2);
insert into visit (id, description, time, doctor_id, patient_id) values (12, 'Follow-up appointment', '2024-12-05 14:30:00', 2, 1);
insert into visit (id, description, time, doctor_id, patient_id) values (13, 'Dermatology consultation', '2024-12-05 15:00:00', 2, 1);
insert into visit (id, description, time, doctor_id, patient_id) values (14, 'Eye examination', '2024-12-05 15:30:00', 2, 4);
insert into visit (id, description, time, doctor_id, patient_id) values (15, 'Surgery follow-up', '2024-12-05 16:00:00', 3, 5);
insert into visit (id, description, time, doctor_id, patient_id) values (16, 'Routine checkup', '2024-12-06 09:00:00', 3, 6);
insert into visit (id, description, time, doctor_id, patient_id) values (17, 'General consultation', '2024-12-06 09:30:00', 3, 2);
insert into visit (id, description, time, doctor_id, patient_id) values (18, 'Skin rash diagnosis', '2024-12-06 10:00:00', 3, 1);

insert into medical_treatment (id, description, type, visit_id) values (1, 'Ultrasound of the abdomen', 'USG', 1);
insert into medical_treatment (id, description, type, visit_id) values (2, 'Chest X-ray', 'RTG', 4);
insert into medical_treatment (id, description, type, visit_id) values (3, 'Electrocardiogram', 'EKG', 13);
insert into medical_treatment (id, description, type, visit_id) values (4, 'Ultrasound of the thyroid', 'USG', 18);
insert into medical_treatment (id, description, type, visit_id) values (5, 'Chest X-ray', 'RTG', 5);
insert into medical_treatment (id, description, type, visit_id) values (6, 'Electrocardiogram', 'EKG', 17);
insert into medical_treatment (id, description, type, visit_id) values (7, 'Ultrasound of the pelvis', 'USG', 8);
insert into medical_treatment (id, description, type, visit_id) values (8, 'Chest X-ray with lateral view', 'RTG', 7);
insert into medical_treatment (id, description, type, visit_id) values (9, 'Stress test EKG', 'EKG', 5);
insert into medical_treatment (id, description, type, visit_id) values (10, 'Doppler ultrasound of the legs', 'USG', 3);
