INSERT INTO address (id, address_line1, address_line2, city, postal_code)
VALUES
    (1, 'Testowa 1', 'Apt 1', 'Warszawa', '00-001'),
    (2, 'Lipowa 2', 'Apt 2', 'Kraków', '30-002'),
    (3, 'Dębowa 3', 'Apt 3', 'Poznań', '60-003');
INSERT INTO doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id)
VALUES
    (1, 'DOC1001', 'john.smith@test.com', 'John', 'Smith', 'GP', '+48123456701', 1),
    (2, 'DOC1002', 'anna.kowalska@test.com', 'Anna', 'Kowalska', 'DERMATOLOGIST', '+48123456702', 2);
INSERT INTO patient (id, patient_number, date_of_birth, email, first_name, last_name, gender, telephone_number, address_id)
VALUES
    (1, 'PAT1001', '1980-01-01', 'adam.nowak@test.com', 'Adam', 'Nowak', 'MALE', '+48123456789', 1),
    (2, 'PAT1002', '1995-06-15', 'ewa.kowalska@test.com', 'Ewa', 'Kowalska', 'FEMALE', '+48123456790', 2),
    (3, 'PAT1003', '2000-12-30', 'jan.kowalski@test.com', 'Jan', 'Kowalski', 'MALE', '+48123456791', 3);
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES
    (1, 'Routine checkup', '2024-12-01 09:00:00', 1, 1),
    (2, 'Follow-up visit', '2024-12-02 10:00:00', 1, 2),
    (3, 'General consultation', '2024-12-03 11:00:00', 2, 1),
    (4, 'Skin consultation', '2024-12-04 12:00:00', 3, 2),
    (5, 'Routine checkup', '2024-12-05 13:00:00', 2, 1);
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES
    (1, 'Blood test', 'LABORATORY', 1),
    (2, 'Skin biopsy', 'DIAGNOSTIC', 4),
    (3, 'X-ray', 'RADIOLOGICAL', 2),
    (4, 'Vaccination', 'PREVENTIVE', 3);
