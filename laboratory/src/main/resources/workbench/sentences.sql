select * from labs;
select * from technical_support;
select * from equipment;
select * from equipment_suport_history;
select * from resources_stock;
select * from administratives;
select * from researchs;
select * from scientists;
select * from assistants;
select * from test_subjects;

update equipment set working=0 where id=2;

SELECT l.*, r.name FROM labs l LEFT JOIN researchs r ON l.id=r.Labs_id;
SELECT l.*, r.name FROM labs l RIGHT JOIN researchs r ON l.id=r.Labs_id;
SELECT l.*, r.name FROM researchs r RIGHT OUTER JOIN labs l ON l.id=r.Labs_id;
SELECT l.*, r.name FROM labs l RIGHT OUTER JOIN researchs r ON l.id=r.Labs_id;

SELECT e.id, e.name, h.id FROM equipment e JOIN equipment_suport_history h ON e.id=h.Equipment_id;
SELECT e.id, e.name, h.id FROM equipment e RIGHT JOIN equipment_suport_history h ON e.id=h.Equipment_id;
SELECT e.id, e.name, h.id FROM equipment e LEFT JOIN equipment_suport_history h ON e.id=h.Equipment_id;
SELECT e.id, e.name FROM equipment e WHERE NOT EXISTS (SELECT 1 FROM equipment_suport_history h 
WHERE e.id=h.Equipment_id);

SELECT * FROM equipment WHERE id=3;