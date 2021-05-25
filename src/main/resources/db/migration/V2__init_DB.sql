insert into brand(id, brand_name)
    values (1, 'Audi'),
           (2, 'BMW'),
           (3, 'Chrysler'),
           (4, 'Daewoo'),
           (5, 'Honda'),
           (6, 'Jeep'),
           (7, 'Lada'),
           (8, 'KIA');

insert into model(id, model_name, brand_id)
    values (1, 'A4', 1),
           (2, 'A6', 1),
           (3, 'A8', 1),
           (4, 'X3', 2),
           (5, 'X5', 2),
           (6, 'X6', 2),
           (7, 'Neon', 3),
           (8, 'Matiz', 4),
           (9, 'CR-V', 5),
           (10, 'Wrangler', 6),
           (11, 'Vesta', 7),
           (12, 'Ceed', 8),
           (13, 'Rio', 8);

insert into category(id, category_name)
    values (1, 'body'),
           (2, 'engine'),
           (3, 'chassis'),
           (4, 'chassis'),
           (5, 'brake system'),
           (6, 'interior');

SELECT setval('hibernate_sequence', 13, true);