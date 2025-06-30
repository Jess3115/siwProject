--=======================================================================================================
-- =========================== User
--=======================================================================================================
-- =========================== User
--=======================================================================================================
INSERT INTO users (name, surname, email) VALUES ('Francesco', 'Di Gianvincenzo', 'fra.digianvincenzo@stud.uniroma3.it');
INSERT INTO users (name, surname, email) VALUES ('Admin', 'Admin', 'admin@gmail.com');

INSERT INTO users (name, surname, email) VALUES('Mario', 'Rossi', 'mario.rossi@example.com');
INSERT INTO users (name, surname, email) VALUES('Laura', 'Bianchi', 'laura.bianchi@example.com');
INSERT INTO users (name, surname, email) VALUES('Luca', 'Verdi', 'luca.verdi@example.com');
INSERT INTO users (name, surname, email) VALUES('Giulia', 'Russo', 'giulia.russo@example.com');
INSERT INTO users (name, surname, email) VALUES('Paolo', 'Ferrari', 'paolo.ferrari@example.com');

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
INSERT INTO ingredient (name) VALUES('Pancetta');
INSERT INTO ingredient (name) VALUES('Panna');
INSERT INTO ingredient (name) VALUES('Cioccolato Fondente');
INSERT INTO ingredient (name) VALUES('Mandorle');
INSERT INTO ingredient (name) VALUES('Funghi Champignon');


--=======================================================================================================
-- =========================== RecipeCategory 
--=======================================================================================================
INSERT INTO recipe_category (name) VALUES('Antipasti');
INSERT INTO recipe_category (name) VALUES('Primi Piatti');
INSERT INTO recipe_category (name) VALUES('Secondi Piatti');
INSERT INTO recipe_category (name) VALUES('Dolci');
INSERT INTO recipe_category (name) VALUES('Contorni');
INSERT INTO recipe_category (name) VALUES('Zuppe e Minestre');
INSERT INTO recipe_category (name) VALUES('Piatti Vegetariani');
INSERT INTO recipe_category (name) VALUES('Street Food');
INSERT INTO recipe_category (name) VALUES('Piatti Internazionali');
INSERT INTO recipe_category (name) VALUES('Piatti da Forno');
INSERT INTO recipe_category (name) VALUES('Insalate e Piatti Freddi');


--=======================================================================================================
-- =========================== Recipe
--=======================================================================================================
INSERT INTO recipe (name, creator_id) VALUES('Pizza Margherita', 1);
INSERT INTO recipe (name, creator_id) VALUES('Tiramisù Classico', 2);
INSERT INTO recipe (name, creator_id) VALUES('Spaghetti al Pomodoro', 3);
INSERT INTO recipe (name, creator_id) VALUES('Lasagna alla Bolognese', 4);
INSERT INTO recipe (name, creator_id) VALUES('Bruschette al Pomodoro', 5);
INSERT INTO recipe (name, creator_id) VALUES('Carbonara Classica', 1);
INSERT INTO recipe (name, creator_id) VALUES('Risotto ai Funghi', 2);
INSERT INTO recipe (name, creator_id) VALUES('Torta al Cioccolato', 3);


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
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(200, 'g', 6, 1); -- Farina
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(2, 'uova', 6, 2);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(100, 'g', 6, 13); -- Pancetta
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(50, 'ml', 6, 14); -- Panna
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(250, 'g', 7, 15); -- Funghi
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'l', 7, 10); -- Latte
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(30, 'g', 7, 12); -- Formaggio
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(200, 'g', 8, 11); -- Burro
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(100, 'g', 8, 6); -- Zucchero
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(150, 'g', 8, 16); -- Cioccolato
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(2, 'unità', 8, 2); -- Uova
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(50, 'g', 8, 17); -- Mandorle

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
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuocere la pancetta', 1, 'Fino a doratura', 6);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Mescolare uova e panna', 2, NULL, 6);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Aggiungere il tutto alla pasta', 3, 'A fuoco spento', 6);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Soffriggere i funghi', 1, 'Con burro e cipolla', 7);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuocere il riso nel latte', 2, NULL, 7);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Aggiungere il formaggio a fine cottura', 3, 'Mantecare bene', 7);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Sciogliere il cioccolato e burro', 1, 'A bagnomaria', 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Unire uova, zucchero e farina', 2, NULL, 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Infornare a 180°', 3, 'Per 35 minuti', 8);


--=======================================================================================================
-- =========================== Saved Recipes
--=======================================================================================================
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (1, 2);  -- User 1 saved Recipe 2
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (1, 3);  -- User 1 saved Recipe 3
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (2, 1);  -- User 2 saved Recipe 1
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (3, 4);  -- User 3 saved Recipe 4
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (4, 5);  -- User 4 saved Recipe 5
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (5, 1);  -- User 5 saved Recipe 1
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (2, 6);  -- Admin salva Carbonara
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (5, 7);  -- Paolo salva Risotto
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (3, 8);  -- Luca salva Torta


--=======================================================================================================
-- =========================== Recipe Categories (Many-to-Many Relationship)
--=======================================================================================================
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 1);  -- Primi Piatti -> Pizza
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (4, 2);  -- Dolci -> Tiramisù
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 3);  -- Primi Piatti -> Spaghetti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 4);  -- Primi Piatti -> Lasagna
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (1, 5);  -- Antipasti -> Bruschette
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 6); -- Carbonara -> Primi Piatti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 7); -- Risotto -> Primi Piatti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (4, 8); -- Torta al Cioccolato -> Dolci
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (7, 3); -- Spaghetti al Pomodoro
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (7, 5); -- Bruschette al Pomodoro
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (8, 5); -- Bruschette al Pomodoro
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (8, 6); -- Carbonara Classica (può essere reinventata in versione street con pasta in cestini)
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (9, 2); -- Tiramisù Classico
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (10, 1); -- Pizza Margherita
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (10, 4); -- Lasagna alla Bolognese
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (10, 8); -- Torta al Cioccolato

--=======================================================================================================
-- =========================== Grading
--=======================================================================================================
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 1, 1);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 1, 3);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 2, 2);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (3, 3, 4);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 4, 5);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 6, 4);  -- Carbonara
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 7, 2);  -- Risotto
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 8, 1);  -- Torta al Cioccolato


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

-- Carbonara
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (1, 6); -- Farina
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (2, 6); -- Uova
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (13, 6); -- Pancetta
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (14, 6); -- Panna

-- Risotto ai Funghi
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (15, 7); -- Funghi Champignon
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (10, 7); -- Latte
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (12, 7); -- Formaggio

-- Torta al Cioccolato
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (11, 8); -- Burro
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (6, 8);  -- Zucchero
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (16, 8); -- Cioccolato Fondente
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (2, 8);  -- Uova
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (17, 8); -- Mandorle
