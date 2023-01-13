INSERT INTO Assistants (name, lastname, nationality, age, Scientists_id) VALUES ("Kim", "Lee", "korean", 24, 3);

INSERT INTO technical_support (name, lastname) VALUES ("Many", "King");
INSERT INTO technical_support (name, lastname) VALUES ("Manuel", "Herrera");
INSERT INTO technical_support (name, lastname) VALUES ("Miguel", "Hernandez");

INSERT INTO equipment (name, working) VALUES ("Laser", 1);
INSERT INTO equipment (name, working) VALUES ("Laser", 1);
INSERT INTO equipment (name, working) VALUES ("Laser", 1);

INSERT INTO equipment_suport_history (Equipment_id, TechnicalSupport_id, status, start) VALUES (2, 2, "inProgress", "2023-01-12");

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

INSERT INTO researchs (name, start, budget, complete, Labs_id) VALUES ("Heavy Water", "2022-12-01", 7000, 0, 4);
INSERT INTO researchs (name, start, budget, complete, Labs_id) VALUES ("Radioactivity", "2022-11-01", 7000, 0, 2);
INSERT INTO researchs (name, start, budget, complete, Labs_id) VALUES ("Ultra Violet", "2022-6-01", 7000, 0, 3);

INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 3, 1, 28, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 2, 0, 24, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 2, 0, 22, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 4, 0, 26, 1);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 4, 1, 34, 2);
INSERT INTO test_subjects (species, age, sex, weight, Researchs_id) VALUES ("Monkey", 3, 1, 35, 3);

select * from administratives;
select * from assistants;
select * from scientists;
select * from equipment;
select * from labs;
select * from test_subjects;
select * from technical_support;
select * from researchs;

SELECT l.*, r.name FROM labs l LEFT JOIN researchs r ON l.id=r.Labs_id;
SELECT l.*, r.name FROM labs l RIGHT JOIN researchs r ON l.id=r.Labs_id;
SELECT l.*, r.name FROM researchs r RIGHT OUTER JOIN labs l ON l.id=r.Labs_id;
SELECT l.*, r.name FROM labs l RIGHT OUTER JOIN researchs r ON l.id=r.Labs_id;

SELECT e.id, e.name, h.id FROM equipment e JOIN equipment_suport_history h ON e.id=h.Equipment_id;
SELECT e.id, e.name, h.id FROM equipment e RIGHT JOIN equipment_suport_history h ON e.id=h.Equipment_id;
SELECT e.id, e.name, h.id FROM equipment e LEFT JOIN equipment_suport_history h ON e.id=h.Equipment_id;
SELECT e.id, e.name FROM equipment e WHERE NOT EXISTS (SELECT 1 FROM equipment_suport_history h 
WHERE e.id=h.Equipment_id);