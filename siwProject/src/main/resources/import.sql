-- =========================== Users (CORRECT)
INSERT INTO users (name, surname, email) VALUES ('Francesco', 'Di Gianvincenzo', 'fra.digianvincenzo@stud.uniroma3.it');
INSERT INTO users (name, surname, email) VALUES ('Admin', 'Admin', 'admin@gmail.com');
INSERT INTO users (name, surname, email) VALUES('Mario', 'Rossi', 'mario.rossi@example.com');
INSERT INTO users (name, surname, email) VALUES('Laura', 'Bianchi', 'laura.bianchi@example.com');
INSERT INTO users (name, surname, email) VALUES('Luca', 'Verdi', 'luca.verdi@example.com');
INSERT INTO users (name, surname, email) VALUES('Giulia', 'Russo', 'giulia.russo@example.com');
INSERT INTO users (name, surname, email) VALUES('Paolo', 'Ferrari', 'paolo.ferrari@example.com');

-- =========================== Credentials (CORRECT)
INSERT INTO credentials (username, password, role, user_id) VALUES ('digia', '$2a$10$XVwcSEnz6Kupbnx2U.Di9OjVK.Or0xFeZnx/sS0heSCvE3OSUrUp2', 'DEFAULT', 1);
INSERT INTO credentials (username, password, role, user_id) VALUES ('admin', '$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'ADMIN', 2);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'mario_rossi',3);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'laura_bianchi',4);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'luca_verdi',5);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'giulia_russo',6);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'paolo_ferrari',7);

-- =========================== Ingredients (FIXED duplicates + added missing)
-- Removed duplicate spaghetti (original ID25) and renumbered
INSERT INTO ingredient (name) VALUES('Farina');            -- 1
INSERT INTO ingredient (name) VALUES('Uova');              -- 2
INSERT INTO ingredient (name) VALUES('Pomodoro');          -- 3
INSERT INTO ingredient (name) VALUES('Mozzarella');        -- 4
INSERT INTO ingredient (name) VALUES('Basilico');          -- 5
INSERT INTO ingredient (name) VALUES('Zucchero');          -- 6
INSERT INTO ingredient (name) VALUES('Sale');              -- 7
INSERT INTO ingredient (name) VALUES('Olio d''oliva');     -- 8
INSERT INTO ingredient (name) VALUES('Pepe');              -- 9
INSERT INTO ingredient (name) VALUES('Latte');             -- 10
INSERT INTO ingredient (name) VALUES('Burro');             -- 11
INSERT INTO ingredient (name) VALUES('Parmigiano');        -- 12
INSERT INTO ingredient (name) VALUES('Pancetta');          -- 13
INSERT INTO ingredient (name) VALUES('Pecorino');          -- 14
INSERT INTO ingredient (name) VALUES('Funghi Champignon'); -- 15
INSERT INTO ingredient (name) VALUES('Cioccolato Fondente'); -- 16
INSERT INTO ingredient (name) VALUES('Caffè');             -- 17
INSERT INTO ingredient (name) VALUES('Mascarpone');        -- 18
INSERT INTO ingredient (name) VALUES('Savoiardi');         -- 19
INSERT INTO ingredient (name) VALUES('Cacao');             -- 20
INSERT INTO ingredient (name) VALUES('Spaghetti');         -- 21
INSERT INTO ingredient (name) VALUES('Riso');              -- 22
INSERT INTO ingredient (name) VALUES('Brodo vegetale');    -- 23
INSERT INTO ingredient (name) VALUES('Guanciale');         -- 24
-- Added missing ingredients with correct numbering:
INSERT INTO ingredient (name) VALUES('Aglio');             -- 25
INSERT INTO ingredient (name) VALUES('Pasta per lasagne'); -- 26
INSERT INTO ingredient (name) VALUES('Carne macinata');    -- 27
INSERT INTO ingredient (name) VALUES('Besciamella');       -- 28
INSERT INTO ingredient (name) VALUES('Vino rosso');        -- 29
INSERT INTO ingredient (name) VALUES('Pane casereccio');   -- 30
INSERT INTO ingredient (name) VALUES('Pomodorini');        -- 31
INSERT INTO ingredient (name) VALUES('Lievito per dolci'); -- 32
INSERT INTO ingredient (name) VALUES('Cipolla');           -- 33
INSERT INTO ingredient (name) VALUES('Sedano');            -- 34
INSERT INTO ingredient (name) VALUES('Carota');            -- 35

-- =========================== RecipeCategory (FIXED duplicates)
-- Removed duplicate gluten-free category
INSERT INTO recipe_category (name) VALUES('Antipasti');       -- 1
INSERT INTO recipe_category (name) VALUES('Primi Piatti');    -- 2
INSERT INTO recipe_category (name) VALUES('Secondi Piatti');  -- 3
INSERT INTO recipe_category (name) VALUES('Dolci');           -- 4
INSERT INTO recipe_category (name) VALUES('Contorni');        -- 5
INSERT INTO recipe_category (name) VALUES('Piatti Unici');    -- 6
INSERT INTO recipe_category (name) VALUES('Vegetariano');     -- 7
INSERT INTO recipe_category (name) VALUES('Senza Glutine');   -- 8 (consolidated gluten-free)
INSERT INTO recipe_category (name) VALUES('Ricette Veloci');  -- 9
INSERT INTO recipe_category (name) VALUES('Ricette Economiche'); -- 10
INSERT INTO recipe_category (name) VALUES('Ricette della Nonna'); -- 11
INSERT INTO recipe_category (name) VALUES('Cucina Regionale'); -- 12
INSERT INTO recipe_category (name) VALUES('Ricette per Bambini'); -- 13
INSERT INTO recipe_category (name) VALUES('Ricette Festive');  -- 14
INSERT INTO recipe_category (name) VALUES('Ricette Light');    -- 15
INSERT INTO recipe_category (name) VALUES('Ricette Proteiche');-- 16
INSERT INTO recipe_category (name) VALUES('Ricette Vegane');   -- 17

-- =========================== Recipe (CORRECT)
INSERT INTO recipe (name, creator_id) VALUES('Pizza Margherita', 1);
INSERT INTO recipe (name, creator_id) VALUES('Tiramisù Classico', 1);
INSERT INTO recipe (name, creator_id) VALUES('Spaghetti al Pomodoro', 3);
INSERT INTO recipe (name, creator_id) VALUES('Lasagna alla Bolognese', 4);
INSERT INTO recipe (name, creator_id) VALUES('Bruschette al Pomodoro', 5);
INSERT INTO recipe (name, creator_id) VALUES('Carbonara Classica', 1);
INSERT INTO recipe (name, creator_id) VALUES('Risotto ai Funghi', 2);
INSERT INTO recipe (name, creator_id) VALUES('Torta al Cioccolato', 3);

-- =========================== RecipeIngredient (FIXED syntax + duplicates)
-- Pizza Margherita
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(500, 'g', 1, 1);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(250, 'ml', 1, 10);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(7, 'g', 1, 7);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(400, 'g', 1, 3);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(300, 'g', 1, 4);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(10, 'foglie', 1, 5);

-- Tiramisù
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(500, 'g', 2, 18);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(4, 'unità', 2, 2);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(100, 'g', 2, 6);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(300, 'ml', 2, 17);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(200, 'g', 2, 19);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(30, 'g', 2, 20);

-- Spaghetti al Pomodoro (single set)
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(400, 'g', 3, 21);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(800, 'g', 3, 3);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(3, 'spicchi', 3, 25);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'mazzo', 3, 5);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(4, 'cucchiai', 3, 8);

-- Carbonara
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(320, 'g', 6, 21);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(3, 'unità', 6, 2);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(150, 'g', 6, 24);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(50, 'g', 6, 14);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'pizzico', 6, 9);

-- Risotto ai Funghi
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(320, 'g', 7, 22);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(300, 'g', 7, 15);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'l', 7, 23);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(50, 'g', 7, 11);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(50, 'g', 7, 12);

-- Torta al Cioccolato (single set)
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(200, 'g', 8, 16);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(200, 'g', 8, 11);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(3, 'unità', 8, 2);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(150, 'g', 8, 6);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(100, 'g', 8, 1);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(16, 'g', 8, 32);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'pizzico', 8, 7);

-- Lasagna alla Bolognese (single set)
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(250, 'g', 4, 26);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(500, 'g', 4, 27);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(500, 'ml', 4, 28);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(100, 'g', 4, 12);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(100, 'ml', 4, 29);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(400, 'g', 4, 3);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'unità', 4, 33);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'gambo', 4, 34);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'unità', 4, 35);

-- Bruschette al Pomodoro (FIXED syntax)
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(8, 'fette', 5, 30);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(300, 'g', 5, 31);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(3, 'cucchiai', 5, 8);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(2, 'spicchi', 5, 25);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'pizzico', 5, 7);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(10, 'foglie', 5, 5);

-- =========================== ProcedureStep (FIXED bruschette step)
-- Pizza Margherita
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Prepara l''impasto con farina, acqua e lievito', 1, 'Impastare per 10 minuti', 1);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Stendi la pasta e aggiungi pomodoro, mozzarella e basilico', 2, 'Spessore 0.5cm', 1);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuoci in forno a 250°C per 10-15 minuti', 3, 'Fino a croccantezza', 1);

-- Tiramisù
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Monta tuorli e zucchero, aggiungi mascarpone', 1, 'Consistenza cremosa', 2);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Inzuppa i savoiardi nel caffè freddo', 2, 'Rapido per non inzuppare troppo', 2);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Alterna strati di crema e savoiardi', 3, 'Finire con crema', 2);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Spolvera con cacao e refrigera per 4 ore', 4, NULL, 2);

-- Carbonara
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Soffriggi il guanciale a fuoco medio', 1, 'Senza bruciare', 6);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Scola la pasta e manteca con uova e pecorino', 2, 'Fuori dal fuoco', 6);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Aggiungi il guanciale e servi immediatamente', 3, NULL, 6);

-- Risotto
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Tostare il riso con burro e cipolla', 1, NULL, 7);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Aggiungere brodo caldo poco alla volta', 2, 'Mescolare costantemente', 7);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Unire i funghi a metà cottura', 3, 'Tritati grossolanamente', 7);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Mantecare con burro e parmigiano', 4, NULL, 7);

-- Spaghetti al Pomodoro
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Soffriggere l''aglio nell''olio a fuoco basso', 1, 'Non deve bruciare', 3);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Aggiungere i pomodori schiacciati e il basilico', 2, 'Cuocere 20 minuti', 3);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuocere gli spaghetti al dente in acqua salata', 3, '8-10 minuti', 3);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Saltare la pasta nel sugo per 1 minuto', 4, 'Fuoco vivace', 3);

-- Lasagna alla Bolognese
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Preparare il ragù: rosolare la carne con sedano, carota e cipolla', 1, '30 minuti', 4);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Sfumare con il vino rosso e aggiungere il pomodoro', 2, 'Cuocere 2 ore', 4);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Alternare strati di pasta, ragù, besciamella e parmigiano', 3, '5-6 strati', 4);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuocere in forno a 180°C per 40 minuti', 4, 'Ultimi 5 minuti a 200°C', 4);

-- Bruschette al Pomodoro (FIXED)
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Tostare il pane sulla griglia o in forno', 1, '2 minuti per lato', 5);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Strofinare le fette con aglio fresco', 2, NULL, 5);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Condire con pomodori a cubetti, olio e sale', 3, 'Servire immediatamente', 5);

-- Torta al Cioccolato
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Fondere cioccolato e burro a bagnomaria', 1, 'Mescolare fino a liscio', 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Montare uova e zucchero a nastro', 2, '10 minuti', 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Incorporare il cioccolato fuso al composto', 3, 'Mescolare dal basso', 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Aggiungere farina e lievito setacciati', 4, 'Non smontare l''impasto', 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuocere in forno a 170°C per 35 minuti', 5, 'Test stecchino pulito', 8);

-- =========================== Saved Recipes (CORRECT)
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (1, 2);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (1, 3);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (2, 1);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (3, 4);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (4, 5);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (5, 1);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (2, 6);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (5, 7);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (3, 8);

-- =========================== Recipe Categories (FIXED gluten-free)
-- Pizza Margherita
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(6, 1);  -- Piatti Unici
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(7, 1);  -- Vegetariano
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(9, 1);  -- Ricette Veloci
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(10, 1); -- Ricette Economiche
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(12, 1); -- Cucina Regionale

-- Tiramisù Classico
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(4, 2);  -- Dolci
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(11, 2); -- Ricette della Nonna
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(14, 2); -- Ricette Festive
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(13, 2); -- Ricette per Bambini

-- Spaghetti al Pomodoro
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(2, 3);  -- Primi Piatti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(7, 3);  -- Vegetariano
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(9, 3);  -- Ricette Veloci
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(10, 3); -- Ricette Economiche
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(15, 3); -- Ricette Light

-- Lasagna alla Bolognese
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(2, 4);  -- Primi Piatti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(11, 4); -- Ricette della Nonna
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(12, 4); -- Cucina Regionale
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(14, 4); -- Ricette Festive
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(16, 4); -- Ricette Proteiche

-- Bruschette al Pomodoro
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(1, 5);  -- Antipasti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(7, 5);  -- Vegetariano
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(9, 5);  -- Ricette Veloci
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(10, 5); -- Ricette Economiche
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(15, 5); -- Ricette Light
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(17, 5); -- Ricette Vegane

-- Carbonara Classica
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(2, 6);  -- Primi Piatti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(9, 6);  -- Ricette Veloci
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(12, 6); -- Cucina Regionale
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(16, 6); -- Ricette Proteiche

-- Risotto ai Funghi
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(2, 7);  -- Primi Piatti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(7, 7);  -- Vegetariano
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(8, 7);  -- Senza Glutine
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(15, 7); -- Ricette Light

-- Torta al Cioccolato
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(4, 8);  -- Dolci
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(13, 8); -- Ricette per Bambini
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES(14, 8); -- Ricette Festive

-- =========================== Grading (CORRECT)
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 1, 1);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 1, 3);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 2, 2);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 3, 4);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 4, 5);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 6, 4);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 7, 2);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 8, 1);

-- =========================== Ingredient-Recipes (FIXED references)
-- Pizza
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (1, 1);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (3, 1);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (4, 1);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (5, 1);

-- Tiramisù
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (18, 2);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (2, 2);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (6, 2);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (17, 2);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (19, 2);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (20, 2);

-- Carbonara
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (21, 6);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (24, 6);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (2, 6);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (14, 6);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES (9, 6);

-- Spaghetti al Pomodoro
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(21, 3);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(3, 3);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(25, 3);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(5, 3);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(8, 3);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(7, 3);

-- Lasagna alla Bolognese
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(26, 4);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(27, 4);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(28, 4);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(12, 4);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(29, 4);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(3, 4);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(33, 4);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(34, 4);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(35, 4);

-- Bruschette al Pomodoro
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(30, 5);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(31, 5);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(8, 5);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(7, 5);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(25, 5);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(5, 5);

-- Torta al Cioccolato
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(16, 8);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(11, 8);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(2, 8);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(6, 8);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(1, 8);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(32, 8);
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(7, 8);