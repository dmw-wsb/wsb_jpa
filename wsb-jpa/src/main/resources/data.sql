-- Addresses
INSERT INTO address (id, address_line1, address_line2, city, postal_code, version) VALUES
(1, 'Maple Street', 'Apt 101', 'Warsaw', '01-001', 0),
(2, 'Oak Avenue', 'Suite 202', 'Cracow', '31-002', 0),
(3, 'Pine Drive', 'House 303', 'Poznan', '61-003', 0),
(4, 'Birch Road', 'Block A', 'Gdansk', '81-004', 0),
(5, 'Elm Lane', 'Flat 405', 'Wroclaw', '51-005', 0);

-- Doctors
INSERT INTO doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) VALUES
(1, 'DOC001', 'john.doe@example.com', 'John', 'Doe', 'CARDIOLOGIST', '+4811111111', 1),
(2, 'DOC002', 'jane.doe@example.com', 'Jane', 'Doe', 'DERMATOLOGIST', '+4811111112', 2),
(3, 'DOC003', 'mike.ross@example.com', 'Mike', 'Ross', 'SURGEON', '+4811111113', 3);

INSERT INTO patient (id, patient_number, date_of_birth, email, first_name, gender, last_name, telephone_number, address_id) VALUES
(1, 'PAT001', '1990-01-01', 'adam.kowalski@example.com', 'Adam', 'MALE', 'Kowalski', '+4811112221', 1),
(2, 'PAT002', '1985-05-15', 'ewa.novak@example.com', 'Ewa', 'FEMALE', 'Novak', '+4811112222', 2),
(3, 'PAT003', '1995-12-20', 'marek.lebowski@example.com', 'Marek', 'MALE', 'Lebowski', '+4811112223', 3);

-- Visits
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES
(1, 'Routine checkup', '2024-12-01 09:00:00', 1, 1),
(2, 'Follow-up visit', '2024-12-02 10:00:00', 1, 2),
(3, 'General consultation', '2024-12-03 11:00:00', 2, 1),
(4, 'Skin consultation', '2024-12-04 12:00:00', 3, 2),
(5, 'Routine checkup', '2024-12-05 13:00:00', 2, 1);


-- Medical Treatments
INSERT INTO medical_treatment (id, description, type, visit_id) VALUES
(1, 'Ultrasound of abdomen', 'USG', 1),
(2, 'Skin biopsy', 'BIOPSY', 2),
(3, 'Wound dressing', 'DRESSING', 3);
