INSERT INTO Labs (capacity, complexity) VALUES (6, 2);
INSERT INTO Scientists (name, lastname, nationality, age) VALUES ("Steve", "Moore", "canadian", 31);
INSERT INTO Scientists (name, lastname, nationality, age) VALUES ("Andres", "Rivas", "spainish", 30);
INSERT INTO Scientists (name, lastname, nationality, age) VALUES ("Mario", "Ferrari", "italian", 42);
INSERT INTO Scientists (name, lastname, nationality, age) VALUES ("Steve", "Moore", "canadian", 31);
INSERT INTO Assistants (name, lastname, nationality, age, Scientists_id) VALUES ("Brok", "Lee", "canadian", 24, 1);
INSERT INTO Assistants (name, lastname, nationality, age, Scientists_id) VALUES ("Chi", "Lee", "korean", 24, 5);
INSERT INTO Assistants (name, lastname, nationality, age, Scientists_id) VALUES ("Kim", "Lee", "korean", 24, 6);
INSERT INTO technical_support (name, lastname) VALUES ("Many", "King");
INSERT INTO technical_support (name, lastname) VALUES ("Manuel", "Herrera");
INSERT INTO technical_support (name, lastname) VALUES ("Miguel", "Hernandez");
INSERT INTO equipment (name, working) VALUES ("Laser", 1);
INSERT INTO equipment (name, working) VALUES ("Laser", 1);
INSERT INTO equipment (name, working) VALUES ("Laser", 1);
INSERT INTO equipment_suport_history (Equipment_id, TechnicalSupport_id) VALUES (19, 2);
INSERT INTO resources_stock (name, unit, quantity) VALUES ("Distilled Water", "liters", 400);
INSERT INTO resources_stock (name, unit, quantity) VALUES ("Gold", "grams", 300);
INSERT INTO resources_stock (name, unit, quantity) VALUES ("Copper", "grams", 900);
INSERT INTO resources_stock (name, unit, quantity) VALUES ("Alcohol", "liters", 400);
INSERT INTO resources_stock (name, unit, quantity) VALUES ("Benzene", "liters", 400);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Adam", "King", 1);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Adam", "Philips", 1);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Alexander", "Romanov", 1);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Augustus", "Maximus", 1);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Anne", "Sheeran", 1);
INSERT INTO administratives (name, lastname, Resources_Stock_id) VALUES ("Annie", "Sherman", 5);
INSERT INTO researchs (name, start, budget, complete, Labs_id) VALUES ("Heavy Water", "2022-12-01", 7000, 0, 1);
INSERT INTO researchs (name, start, budget, complete, Labs_id) VALUES ("Radioactivity", "2022-11-01", 7000, 0, 2);
INSERT INTO researchs (name, start, budget, complete, Labs_id) VALUES ("Ultra Violet", "2022-6-01", 7000, 0, 3);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id, Researchs_Labs_id) VALUES ("Monkey", 3, 1, 28, 1, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id, Researchs_Labs_id) VALUES ("Monkey", 2, 0, 24, 1, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id, Researchs_Labs_id) VALUES ("Monkey", 2, 0, 22, 2, 2);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id, Researchs_Labs_id) VALUES ("Monkey", 4, 0, 26, 2, 2);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id, Researchs_Labs_id) VALUES ("Monkey", 4, 1, 34, 2, 2);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id, Researchs_Labs_id) VALUES ("Monkey", 3, 1, 35, 3, 3);
INSERT INTO subjects_asigned_history (Researchs_id, Test_Subjects_id) VALUES (2, 2);

SELECT * FROM Labs;
SELECT * FROM Scientists;
SELECT * FROM Assistants;
SELECT * FROM technical_support;
SELECT * FROM equipment;
SELECT * FROM equipment_suport_history;
SELECT * FROM resources_stock;
SELECT * FROM administratives;
SELECT * FROM researchs;
SELECT * FROM test_subjects;
SELECT * FROM subjects_asigned_history;

UPDATE Labs SET capacity=12, complexity=3 WHERE id=3;
UPDATE Scientists SET age=32 WHERE id=1;
UPDATE Assistants SET age=25 WHERE id=2;
UPDATE technical_support SET name="Brat", lastname="Pitt" WHERE id=3;
UPDATE equipment SET working=0 WHERE id=2;
UPDATE equipment_suport_history SET TechnicalSupport_id=2 WHERE id=1;
UPDATE resources_stock SET quantity=410 WHERE id=4;
UPDATE administratives SET Resources_Stock_id=5 WHERE id=5;
UPDATE researchs SET budget=10000 WHERE id=2;
UPDATE test_subjects SET age=5, weight=30 WHERE id=4;

DELETE FROM Labs WHERE id>3;

DELETE FROM Scientists WHERE id>6;
DELETE FROM Assistants WHERE id>0 AND age>60;
DELETE FROM technical_support WHERE id=6 AND name="Peter";
DELETE FROM equipment WHERE id>0 AND name="Mercury thermometer";
DELETE FROM resources_stock WHERE id>0 AND name="Uranium";
DELETE FROM Administratives WHERE id=6;
DELETE FROM test_subjects WHERE id>2 AND id<5;
DELETE FROM subjects_asigned_history WHERE id>0 AND Researchs_id=1;
DELETE FROM resource_petition WHERE id>0 AND quantity<10;

SELECT l.*, r.name FROM labs l LEFT JOIN researchs r ON l.id=r.Labs_id;
SELECT l.*, r.name FROM labs l RIGHT JOIN researchs r ON l.id=r.Labs_id;
SELECT l.*, r.name FROM researchs r RIGHT OUTER JOIN labs l ON l.id=r.Labs_id;
SELECT l.*, r.name FROM labs l RIGHT OUTER JOIN researchs r ON l.id=r.Labs_id;

SELECT e.id, e.name, h.id FROM equipment e JOIN equipment_suport_history h ON e.id=h.Equipment_id;
SELECT e.id, e.name, h.id FROM equipment e RIGHT JOIN equipment_suport_history h ON e.id=h.Equipment_id;
SELECT e.id, e.name, h.id FROM equipment e LEFT JOIN equipment_suport_history h ON e.id=h.Equipment_id;
SELECT e.id, e.name FROM equipment e WHERE NOT EXISTS (SELECT 1 FROM equipment_suport_history h 
WHERE e.id=h.Equipment_id); 


 