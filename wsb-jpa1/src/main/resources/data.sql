-- Address data
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES
(1, 'Street 1', 'Apt 1', 'City A', '62-001'),
(2, 'Street 2', 'Apt 10', 'City B', '62-002'),
(3, 'Street 3', 'Apt 5', 'City C', '62-003'),
(4, 'Street 4', 'Apt 4', 'City D', '62-004'),
(5, 'Street 5', 'Apt 16', 'City E', '62-005'),
(6, 'Street 6', 'Apt 6', 'City F', '62-006'),
(7, 'Street 7', 'Apt 8', 'City G', '62-007'),
(8, 'Street 8', 'Apt 2', 'City H', '62-008'),
(9, 'Street 9', 'Apt 12', 'City I', '62-009'),
(10, 'Street 10', 'Apt 20', 'City J', '62-010');

-- Patient data
INSERT INTO patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id) VALUES
(1, '1985-01-01', 'john.doe@example.com', 'John', 'Doe', 'P12345', '123456789', 1),
(2, '1990-01-01', 'jane.smith@example.com', 'Jane', 'Smith', 'P67890', '845761234', 2),
(3, '1978-07-12', 'paul.jones@example.com', 'Paul', 'Jones', 'P11111', '345612351', 3),
(4, '1989-04-25', 'emma.white@example.com', 'Emma', 'White', 'P22222', '437858643', 4),
(5, '1995-11-15', 'olivia.brown@example.com', 'Olivia', 'Brown', 'P33333', '184653212', 5),
(6, '1980-03-30', 'michael.green@example.com', 'Michael', 'Green', 'P44444', '234567890', 6),
(7, '1992-08-10', 'sophia.adams@example.com', 'Sophia', 'Adams', 'P55555', '134728763', 7),
(8, '1987-12-22', 'liam.wilson@example.com', 'Liam', 'Wilson', 'P66666', '965375324', 8),
(9, '1994-05-18', 'mia.harris@example.com', 'Mia', 'Harris', 'P77777', '632463426', 9),
(10, '1982-09-05', 'noah.clark@example.com', 'Noah', 'Clark', 'P88888', '457853252', 10);

-- Doctor data
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization) VALUES
(1, 'Emily', 'Johnson', '111111111', 'emily.johnson@example.com', 'D0001', 'CARDIOLOGIST'),
(2, 'James', 'Brown', '222222222', 'james.brown@example.com', 'D0002', 'DERMATOLOGIST'),
(3, 'Sophia', 'Miller', '333333333', 'sophia.miller@example.com', 'D0003', 'NEUROLOGIST'),
(4, 'Olivia', 'Davis', '444444444', 'olivia.davis@example.com', 'D0004', 'PEDIATRICS'),
(5, 'Michael', 'Martinez', '555555555', 'michael.martinez@example.com', 'D0005', 'OCULIST'),
(6, 'Isabella', 'Garcia', '666666666', 'isabella.garcia@example.com', 'D0006', 'RADIOLOGIST'),
(7, 'Liam', 'Rodriguez', '777777777', 'liam.rodriguez@example.com', 'D0007', 'ORTHOPEDICS'),
(8, 'Noah', 'Wilson', '888888888', 'noah.wilson@example.com', 'D0008', 'PSYCHIATRY'),
(9, 'Emma', 'Taylor', '999999999', 'emma.taylor@example.com', 'D0009', 'GENERAL_MEDICINE'),
(10, 'Ava', 'Anderson', '000000000', 'ava.anderson@example.com', 'D0010', 'SURGEON');

-- Visit data
INSERT INTO visit (id, description, time, patient_id, doctor_id) VALUES
(1, 'Routine check-up', '2024-12-01T10:00:00', 1, 1),
(2, 'Follow-up for surgery', '2024-12-02T11:00:00', 2, 2),
(3, 'Dermatology consultation', '2024-12-03T09:30:00', 3, 3),
(4, 'Neurology examination', '2024-12-04T14:00:00', 4, 4),
(5, 'Cardiology check-up', '2024-12-05T13:00:00', 5, 5),
(6, 'Pediatric consultation', '2024-12-06T15:00:00', 6, 6),
(7, 'Orthopedics appointment', '2024-12-07T08:30:00', 7, 7),
(8, 'Oncology follow-up', '2024-12-08T10:30:00', 8, 8),
(9, 'Psychiatry session', '2024-12-09T12:00:00', 9, 9),
(10, 'General consultation', '2024-12-10T16:00:00', 10, 10);

-- Medical Treatment data
INSERT INTO medical_treatment (id, description, type) VALUES
(1, 'Physical Therapy', 'PHYSICAL'),
(2, 'Chemotherapy', 'CHEMICAL'),
(3, 'Psychological Therapy', 'PSYCHOLOGICAL'),
(4, 'Surgery', 'SURGICAL'),
(5, 'Vaccination', 'PREVENTIVE'),
(6, 'Radiation Therapy', 'RADIATION'),
(7, 'Occupational Therapy', 'REHABILITATION'),
(8, 'Cardiac Rehabilitation', 'CARDIOLOGICAL'),
(9, 'Pain Management', 'PAIN_RELIEF'),
(10, 'Nutritional Counseling', 'DIETARY');
