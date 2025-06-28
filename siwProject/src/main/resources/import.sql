--=======================================================================================================
-- =========================== User
--=======================================================================================================
INSERT INTO users (name, surname, date_of_birth, email) VALUES ('Francesco', 'Di Gianvincenzo', '2002-07-28', 'fra.digianvincenzo@stud.uniroma3.it');
INSERT INTO users (name, surname, date_of_birth, email) VALUES ('Admin', 'Admin', '2000-01-01', 'admin@gmail.com');

INSERT INTO users (name, surname, date_of_birth, email) VALUES('Mario', 'Rossi', '1990-05-15', 'mario.rossi@example.com');
INSERT INTO users (name, surname, date_of_birth, email) VALUES('Laura', 'Bianchi', '1985-08-22', 'laura.bianchi@example.com');
INSERT INTO users (name, surname, date_of_birth, email) VALUES('Luca', 'Verdi', '1978-11-30', 'luca.verdi@example.com');
INSERT INTO users (name, surname, date_of_birth, email) VALUES('Giulia', 'Russo', '1995-02-10', 'giulia.russo@example.com');
INSERT INTO users (name, surname, date_of_birth, email) VALUES('Paolo', 'Ferrari', '1982-07-18', 'paolo.ferrari@example.com');

--=======================================================================================================
-- =========================== Credentials
--=======================================================================================================
INSERT INTO credentials (username, password, role, user_id) VALUES ('digia', '$2a$10$XVwcSEnz6Kupbnx2U.Di9OjVK.Or0xFeZnx/sS0heSCvE3OSUrUp2', 'DEFAULT', 1);
INSERT INTO credentials (username, password, role, user_id) VALUES ('admin', '$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'ADMIN', 2);

INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'mario_rossi',3);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'laura_bianchi',4);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'luca_verdi',5);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'giulia_russo',6);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'paolo_ferrari',7);

--=======================================================================================================
-- =========================== Ingredients
--=======================================================================================================
INSERT INTO ingredient (name) VALUES('Farina');
INSERT INTO ingredient (name) VALUES('Uova');
INSERT INTO ingredient (name) VALUES('Pomodoro');
INSERT INTO ingredient (name) VALUES('Mozzarella');
INSERT INTO ingredient (name) VALUES('Basilico');
INSERT INTO ingredient (name) VALUES('Zucchero');
INSERT INTO ingredient (name) VALUES('Sale');
INSERT INTO ingredient (name) VALUES('Olio d''oliva');
INSERT INTO ingredient (name) VALUES('Pepe');
INSERT INTO ingredient (name) VALUES('Latte');
INSERT INTO ingredient (name) VALUES('Burro');
INSERT INTO ingredient (name) VALUES('Formaggio');

--=======================================================================================================
-- =========================== RecipeCategory 
--=======================================================================================================
INSERT INTO recipe_category (name) VALUES('Antipasti');
INSERT INTO recipe_category (name) VALUES('Primi Piatti');
INSERT INTO recipe_category (name) VALUES('Secondi Piatti');
INSERT INTO recipe_category (name) VALUES('Dolci');
INSERT INTO recipe_category (name) VALUES('Contorni');

--=======================================================================================================
-- =========================== Recipe
--=======================================================================================================
INSERT INTO recipe (name, creator_id) VALUES('Pizza Margherita', 1);
INSERT INTO recipe (name, creator_id) VALUES('Tiramisù Classico', 2);
INSERT INTO recipe (name, creator_id) VALUES('Spaghetti al Pomodoro', 3);
INSERT INTO recipe (name, creator_id) VALUES('Lasagna alla Bolognese', 4);
INSERT INTO recipe (name, creator_id) VALUES('Bruschette al Pomodoro', 5);

--=======================================================================================================
-- =========================== RecipeIngredient
--=======================================================================================================
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(300, 'g', 1, 1);
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(2, 'unità',1, 2);
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(100, 'ml',1, 8);
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(250, 'g', 1, 4);
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(1, 'cucchiaio', 1, 5);
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(500, 'g', 2, 6);
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(3, 'foglie', 2, 5);
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(200, 'ml', 2, 10);
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(1, 'pizzico', 2, 7);
INSERT INTO recipe_ingredient (quantity, unit,  recipe_id, ingredient_id) VALUES(150, 'g', 3, 3);



--=======================================================================================================
-- =========================== ProcedureStep 
--=======================================================================================================
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Impastare gli ingredienti', 1, 'Far riposare 30 minuti', 1);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuocere in forno preriscaldato', 2, 'A 180 gradi', 1);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Montare a neve', 1, 'Utilizzare zucchero a velo', 2);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Tagliare a cubetti', 3, 'Dimensioni regolari', 2);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Mescolare delicatamente', 2, NULL, 3);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Sbucciare e tagliare', 1, 'A dadini', 4);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Friggere in olio bollente', 3, '2 minuti per lato', 4);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Decorare con erbe fresche', 4, 'Servire immediatamente', 5);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Setacciare la farina', 1, 'Per evitare grumi', 5);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Infornare per 40 minuti', 3, 'Controllare la cottura', 5);

--=======================================================================================================
-- =========================== Saved Recipes
--=======================================================================================================
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (1, 2);  -- User 1 saved Recipe 2
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (1, 3);  -- User 1 saved Recipe 3
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (2, 1);  -- User 2 saved Recipe 1
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (3, 4);  -- User 3 saved Recipe 4
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (4, 5);  -- User 4 saved Recipe 5
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (5, 1);  -- User 5 saved Recipe 1

--=======================================================================================================
-- =========================== Recipe Categories (Many-to-Many Relationship)
--=======================================================================================================
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 1);  -- Primi Piatti -> Pizza
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (4, 2);  -- Dolci -> Tiramisù
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 3);  -- Primi Piatti -> Spaghetti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 4);  -- Primi Piatti -> Lasagna
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (1, 5);  -- Antipasti -> Bruschette

--=======================================================================================================
-- =========================== Grading
--=======================================================================================================
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 1, 1);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 1, 3);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 2, 2);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (3, 3, 4);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 4, 5);

--=======================================================================================================
-- =========================== ingredient_recipes 
--=======================================================================================================
-- Ingredienti per Pizza Margherita (recipe_id = 1)
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (1, 1); -- Farina
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (2, 1); -- Uova
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (8, 1); -- Olio d'oliva
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (4, 1); -- Mozzarella
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (5, 1); -- Basilico

-- Ingredienti per Tiramisù Classico (recipe_id = 2)
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (6, 2); -- Zucchero
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (5, 2); -- Basilico
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (10, 2); -- Latte
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (7, 2); -- Sale

-- Ingredienti per Spaghetti al Pomodoro (recipe_id = 3)
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (3, 3); -- Pomodoro