INSERT INTO user (id,username,password,firstname,lastname,role,on_duty)
 VALUES (1,'dr_tica','tica123','Tihomir','Papic','DOCTOR',true);

INSERT INTO user (id,username,password,firstname,lastname,role,on_duty)
 VALUES (2,'dr_misa','misa123','Misa','Radovic','DOCTOR',false);

INSERT INTO user (id,username,password,firstname,lastname,role,on_duty)
 VALUES (3,'david','david123','David','Vuletas','ADMINISTRATOR',false);

INSERT INTO disease (id,disaese_category,name) VALUES (1,'FIRST', 'Prehlada');
INSERT INTO disease (id,disaese_category,name) VALUES (2,'FIRST', 'Groznica');
INSERT INTO disease (id,disaese_category,name) VALUES (3,'FIRST', 'Upala krajnika');
INSERT INTO disease (id,disaese_category,name) VALUES (4,'FIRST', 'Sinusna infekcija');

INSERT INTO disease (id,disaese_category,name) VALUES (5,'SECOND', 'Hipertenzija');
INSERT INTO disease (id,disaese_category,name) VALUES (6,'SECOND', 'Dijabetes');
INSERT INTO disease (id,disaese_category,name) VALUES (7,'THIRD', 'Hronična bubrežna bolest');
INSERT INTO disease (id,disaese_category,name) VALUES (8,'THIRD', 'Akutna bubrežna povreda');
INSERT INTO disease (id,disaese_category,name) VALUES (9,'SECOND', 'Visok pritisak');

INSERT INTO symptom(id,description) VALUES  (1, 'Curenje iz nosa');
INSERT INTO symptom(id,description) VALUES (2, 'Bol u grlu');
INSERT INTO symptom(id,description) VALUES (3, 'Glavobolja');
INSERT INTO symptom(id,description) VALUES (4, 'Kijanje');
INSERT INTO symptom(id,description) VALUES (5, 'Kašalj');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,1);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,2);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,3);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,4);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,5);

INSERT INTO symptom(id,description) VALUES (6, 'Temperatura veca od 38⁰C');
INSERT INTO symptom(id,description) VALUES (7, 'Drhtavica');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,4);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,2);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,5);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,6);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,1);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,3);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,7);

INSERT INTO symptom(id,description) VALUES (8, 'Bol koji se širi do ušiju');
INSERT INTO symptom(id,description) VALUES (9, 'Temperatura od 40⁰C do 41⁰C');
INSERT INTO symptom(id,description) VALUES (10, 'Gubitak apetita');
INSERT INTO symptom(id,description) VALUES (11, 'Umor');
INSERT INTO symptom(id,description) VALUES (12, 'Žuti sekret iz nosa');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,2);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,8);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,3);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,9);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,7);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,10);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,11);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,12);

INSERT INTO symptom(id,description) VALUES (13, 'Oticanje oko očiju');
INSERT INTO symptom(id,description) VALUES (14,'Pacijent bolovao od prehlade ili groznice u poslednjih 60 dana'); --ovo proveriti

INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,13);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,3);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,12);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,2);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,6);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,5);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,4,14); -- i ovo proverit


INSERT INTO symptom(id,description) VALUES (15,'U poslednjih 6 meseci zabeleženo barem 10 slučajeva u kojem je pacijent imao visok pritisak'); --ovo proveriti
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,5,15); -- ovo isto


INSERT INTO symptom(id,description) VALUES (16,'Često uriniranje');
INSERT INTO symptom(id,description) VALUES (17,'Gubitak telesne težine');
INSERT INTO symptom(id,description) VALUES (18,'Zamor');
INSERT INTO symptom(id,description) VALUES (19,'Mučnina i povraćanje');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,6,16);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,6,17);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,6,18);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,6,19);



INSERT INTO symptom(id,description) VALUES (20,'Nocturia');
INSERT INTO symptom(id,description) VALUES (21,'Otoci nogu i zglobova');
INSERT INTO symptom(id,description) VALUES (22,'Gušenje');
INSERT INTO symptom(id,description) VALUES (23,'Bol u grudima');
INSERT INTO symptom(id,description) VALUES (24,'Pacijent boluje od hipertenzije više od 6 meseci');
INSERT INTO symptom(id,description) VALUES (25,'Pacijent boluje od dijabetesa');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,18);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,20);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,21);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,22);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,23);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,7,24);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,7,25);

INSERT INTO symptom(id,description) VALUES (26,'Oporavlja se od operacije');
INSERT INTO symptom(id,description) VALUES (27,'Dijareja');
INSERT INTO symptom(id,description) VALUES (28,'U poslednjih 14 dana dijagnostikovana bolest koja kao simptom ima povišenu telesnu temperaturu');
INSERT INTO symptom(id,description) VALUES (29,'U poslednjih 21 dana dijagnostikovana bolest za koju je primao antibiotike');
INSERT INTO symptom(id,description) VALUES (30,'Visok pritisak');

INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,8,26);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,8,18);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,8,22);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,8,21);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,8,27);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,8,28);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,8,29);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,9,30);

INSERT INTO patient(id,firstname,lastname,health_card_number) VALUES (1,'Pera', 'Peric','123456789');
INSERT INTO patient(id,firstname,lastname,health_card_number) VALUES (2,'Jova', 'Jovic','234567891');
INSERT INTO patient(id,firstname,lastname,health_card_number) VALUES (3,'Marko', 'Markovic','345678912');
INSERT INTO patient(id,firstname,lastname,health_card_number) VALUES (4,'Mira', 'Gvozdenac','456789123');
INSERT INTO patient(id,firstname,lastname,health_card_number) VALUES (5,'Mika', 'Mikic','567891234');
INSERT INTO patient(id,firstname,lastname,health_card_number) VALUES (6,'Darko', 'Darkovic','678912345');

INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (1,'2017-10-11 13:00',1,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (2,'2018-4-10 08:30',2,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (3,'2018-2-8 07:50',3,2);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (4,'2018-6-3 09:55',2,1);

INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (5,'2018-6-3 09:55',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (6,'2018-5-3 18:10',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (7,'2018-4-3 17:35',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (8,'2018-3-3 19:32',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (9,'2018-2-3 10:55',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (10,'2018-6-1 13:25',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (11,'2018-5-2 14:30',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (12,'2018-4-5 18:55',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (13,'2018-3-9 17:00',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (14,'2018-2-7 11:55',9,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (15,'2017-5-7 14:51',6,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (16,'2016-10-12 08:30',5,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (17,'2018-06-12 17:30',2,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (18,'2018-06-12 17:30',7,1);


INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (1,1);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (1,2);

INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (2,3);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (3,4);


INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,5);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,6);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,7);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,8);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,9);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,10);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,11);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,12);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,13);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (4,14);

INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (5,15);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (2,16);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (6,17);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (1,18);

INSERT INTO medical(id,category, name) VALUES (1,'ANTIBIOTIC','Dovicin');
INSERT INTO medical(id,category, name) VALUES (2,'ANTIBIOTIC','Palitrex');
INSERT INTO medical(id,category, name) VALUES (3,'ANTIBIOTIC','Sinacilin');

INSERT INTO medical(id,category, name) VALUES (4,'ANALGESIC','Andol');
INSERT INTO medical(id,category, name) VALUES (5,'ANALGESIC','Analgin');
INSERT INTO medical(id,category, name) VALUES (6,'ANALGESIC','Aspirin');
INSERT INTO medical(id,category, name) VALUES (7,'ANALGESIC','Febricet');
INSERT INTO medical_ingredients(medical_id, ingredients) VALUES (7,'Paracetamol');
INSERT INTO medical_ingredients(medical_id, ingredients) VALUES (7,'Celuloza');
INSERT INTO medical_ingredients(medical_id, ingredients) VALUES (7,'Zelatin');


INSERT INTO medical(id,category, name) VALUES (8,'OTHER','Gluformin');
INSERT INTO medical(id,category, name) VALUES (9,'OTHER','Bio-kult');
INSERT INTO medical(id,category, name) VALUES (10,'OTHER','Manozin');
INSERT INTO medical(id,category, name) VALUES (11,'OTHER','C vitamin');

INSERT INTO patient_allergens(patient_id, allergens) values (1,'Penicilin');
INSERT INTO patient_allergens(patient_id, allergens) values (1,'Paracetamol');

INSERT INTO examination_medicals(examination_id, medicals_id) VALUES (17,1);
INSERT INTO examination_medicals(examination_id, medicals_id) VALUES (17,11);