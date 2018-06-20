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

INSERT INTO symptom(id,description) VALUES  (1, 'Curenje iz nosa');
INSERT INTO symptom(id,description) VALUES (2, 'Bol u grlu ');
INSERT INTO symptom(id,description) VALUES (3, 'Glavobolja');
INSERT INTO symptom(id,description) VALUES (4, 'Kijanje');
INSERT INTO symptom(id,description) VALUES (5, 'Kašalj');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,1);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,2);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,3);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,4);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,1,5);

INSERT INTO symptom(id,description) VALUES (9, 'Temperatura veca od 38⁰ C');
INSERT INTO symptom(id,description) VALUES (12, 'Drhtavica');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,4);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,2);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,5);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,1);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,10);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,3);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,2,12);

INSERT INTO symptom(id,description) VALUES (14, 'Bol koji se širi do ušiju');
INSERT INTO symptom(id,description) VALUES (16, 'Temperatura od 40⁰C do 41⁰C');
INSERT INTO symptom(id,description) VALUES (18, 'Gubitak apetita');
INSERT INTO symptom(id,description) VALUES (19, 'Umor');
INSERT INTO symptom(id,description) VALUES (20, 'Žuti sekret iz nosa');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,2);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,14);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,3);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,16);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,12);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,18);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,19);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,3,20);

INSERT INTO symptom(id,description) VALUES (21, 'Oticanje oko očiju');
INSERT INTO symptom(id,description) VALUES (27,'Pacijent bolovao od prehlade ili
groznice u poslednjih 60 dana'); --ovo proveriti

INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,21);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,3);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,23);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,9);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,2);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,4,5);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,4,27); -- i ovo proverit


INSERT INTO symptom(id,description) VALUES (28,'U poslednjih 6 meseci zabeleženo barem 10 slučajeva u kojem je pacijent imao visok pritisak'); --ovo proveriti
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,5,28); -- ovo isto


INSERT INTO symptom(id,description) VALUES (29,'Često uriniranje');
INSERT INTO symptom(id,description) VALUES (30,'Gubitak telesne težine');
INSERT INTO symptom(id,description) VALUES (31,'Zamor');
INSERT INTO symptom(id,description) VALUES (32,'Mučnina i povraćanje');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,6,29);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,6,30);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,6,31);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,6,32);



INSERT INTO symptom(id,description) VALUES (33,'Nocturia');
INSERT INTO symptom(id,description) VALUES (34,'Otoci nogu i zglobova');
INSERT INTO symptom(id,description) VALUES (36,'Gušenje');
INSERT INTO symptom(id,description) VALUES (37,'Bol u grudima');
INSERT INTO symptom(id,description) VALUES (38,'Pacijent boluje od hipertenzije više od 6 meseci');
INSERT INTO symptom(id,description) VALUES (39,'Pacijent boluje od dijabetesa');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,33);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,34);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,31);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,36);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,7,37);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,7,38);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,7,39);



INSERT INTO symptom(id,description) VALUES (40,'Oporavlja se od operacije');
INSERT INTO symptom(id,description) VALUES (42,'Gušenje');
INSERT INTO symptom(id,description) VALUES (43,'Otoci nogu i zglobova');
INSERT INTO symptom(id,description) VALUES (44,'Dijareja');
INSERT INTO symptom(id,description) VALUES (45,'U poslednjih 14 dana dijagnostikovana bolest koja kao simptom ima povišenu telesnu
temperaturu');
INSERT INTO symptom(id,description) VALUES (46,'U poslednjih 21 dana dijagnostikovana bolest za koju je primao antibiotike');
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,8,40);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,8,31);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,8,42);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,8,34);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (false,8,44);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,8,45);
INSERT INTO disease_symptom (general, disease_id, symptom_id) VALUES (true,8,46);

INSERT INTO patient(id,firstname,lastname,health_card_number) VALUES (1,'Pera', 'Peric','123456789');
INSERT INTO patient(id,firstname,lastname,health_card_number) VALUES (2,'Jova', 'Jovic','234567891');
INSERT INTO patient(id,firstname,lastname,health_card_number) VALUES (3,'Marko', 'Markovic','345678912');

INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (1,'2017-10-11 13:00',1,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (2,'2018-6-10 08:30',2,1);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (3,'2018-2-8 07:50',2,2);
INSERT INTO examination(id,date, disease_id, doctor_id) VALUES (4,'2018-6-3 09:55',3,1);

INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (1,1);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (1,2);

INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (2,3);
INSERT INTO patient_examinations(patient_id, examinations_id) VALUES (3,4);



