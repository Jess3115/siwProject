-- =========================== Users
INSERT INTO users (name, surname, email) VALUES ('Francesco', 'Di Gianvincenzo', 'fra.digianvincenzo@stud.uniroma3.it');
INSERT INTO users (name, surname, email) VALUES ('Admin', 'Admin', 'admin@gmail.com');
INSERT INTO users (name, surname, email) VALUES('Mario', 'Rossi', 'mario.rossi@example.com');
INSERT INTO users (name, surname, email) VALUES('Laura', 'Bianchi', 'laura.bianchi@example.com');
INSERT INTO users (name, surname, email) VALUES('Luca', 'Verdi', 'luca.verdi@example.com');
INSERT INTO users (name, surname, email) VALUES('Giulia', 'Russo', 'giulia.russo@example.com');
INSERT INTO users (name, surname, email) VALUES('Paolo', 'Ferrari', 'paolo.ferrari@example.com');

-- =========================== Credentials
INSERT INTO credentials (username, password, role, user_id) VALUES ('digia', '$2a$10$XVwcSEnz6Kupbnx2U.Di9OjVK.Or0xFeZnx/sS0heSCvE3OSUrUp2', 'DEFAULT', 1);
INSERT INTO credentials (username, password, role, user_id) VALUES ('admin', '$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'ADMIN', 2);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'mario_rossi',3);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'laura_bianchi',4);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'luca_verdi',5);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'giulia_russo',6);
INSERT INTO credentials (password, role, username, user_id) VALUES('$2a$10$7P5cx4thx8/wWnGKfMyTOOSC3.g/gfzgF5SJ8PsXPb/jH17M..ixu', 'DEFAULT', 'paolo_ferrari',7);

-- =========================== Ingredients 
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
INSERT INTO ingredient (name) VALUES('Parmigiano');
INSERT INTO ingredient (name) VALUES('Pancetta');
INSERT INTO ingredient (name) VALUES('Pecorino');
INSERT INTO ingredient (name) VALUES('Funghi Champignon');
INSERT INTO ingredient (name) VALUES('Cioccolato Fondente');
INSERT INTO ingredient (name) VALUES('Caffè');
INSERT INTO ingredient (name) VALUES('Mascarpone');
INSERT INTO ingredient (name) VALUES('Savoiardi');
INSERT INTO ingredient (name) VALUES('Cacao');
INSERT INTO ingredient (name) VALUES('Spaghetti');
INSERT INTO ingredient (name) VALUES('Riso');
INSERT INTO ingredient (name) VALUES('Brodo vegetale');
INSERT INTO ingredient (name) VALUES('Guanciale');
INSERT INTO ingredient (name) VALUES('Spaghetti');
INSERT INTO ingredient (name) VALUES('Aglio');
INSERT INTO ingredient (name) VALUES('Pasta per lasagne');
INSERT INTO ingredient (name) VALUES('Carne macinata');
INSERT INTO ingredient (name) VALUES('Besciamella');
INSERT INTO ingredient (name) VALUES('Vino rosso');
INSERT INTO ingredient (name) VALUES('Pane casereccio');
INSERT INTO ingredient (name) VALUES('Pomodorini');
INSERT INTO ingredient (name) VALUES('Lievito per dolci');

-- =========================== RecipeCategory 
INSERT INTO recipe_category (name) VALUES('Antipasti');
INSERT INTO recipe_category (name) VALUES('Primi Piatti');
INSERT INTO recipe_category (name) VALUES('Secondi Piatti');
INSERT INTO recipe_category (name) VALUES('Dolci');
INSERT INTO recipe_category (name) VALUES('Contorni');
INSERT INTO recipe_category (name) VALUES('Piatti Unici');
INSERT INTO recipe_category (name) VALUES('Vegetariano');
INSERT INTO recipe_category (name) VALUES('Senza Glutine');

-- =========================== Recipe
INSERT INTO recipe (name, creator_id) VALUES('Pizza Margherita', 1);
INSERT INTO recipe (name, creator_id) VALUES('Tiramisù Classico', 1);
INSERT INTO recipe (name, creator_id) VALUES('Spaghetti al Pomodoro', 3);
INSERT INTO recipe (name, creator_id) VALUES('Lasagna alla Bolognese', 4);
INSERT INTO recipe (name, creator_id) VALUES('Bruschette al Pomodoro', 5);
INSERT INTO recipe (name, creator_id) VALUES('Carbonara Classica', 1);
INSERT INTO recipe (name, creator_id) VALUES('Risotto ai Funghi', 2);
INSERT INTO recipe (name, creator_id) VALUES('Torta al Cioccolato', 3);

-- =========================== RecipeIngredient
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

-- Spaghetti al Pomodoro
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(320, 'g', 3, 21);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(800, 'g', 3, 3);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(4, 'spicchi', 3, 8);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'pizzico', 3, 7);

-- Carbonara
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(320, 'g', 6, 21);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(3, 'unità', 6, 2);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(150, 'g', 6, 24);  -- Guanciale
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(50, 'g', 6, 14);  -- Pecorino
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'pizzico', 6, 9);

-- Risotto ai Funghi
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(320, 'g', 7, 22);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(300, 'g', 7, 15);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'l', 7, 23);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'bicchiere', 7, 11);

-- Torta al Cioccolato
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(200, 'g', 8, 16);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(200, 'g', 8, 11);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(3, 'unità', 8, 2);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(150, 'g', 8, 6);
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(100, 'g', 8, 1);

-- Spaghetti al pomodoro
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(400, 'g', 3, 21);  -- Spaghetti
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(800, 'g', 3, 3);   -- Pomodoro
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(3, 'spicchi', 3, 25); -- Aglio
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'mazzo', 3, 5);   -- Basilico
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(4, 'cucchiai', 3, 8); -- Olio

--Lasagna alla bolognese
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(250, 'g', 4, 26);  -- Pasta per lasagne
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(500, 'g', 4, 27);  -- Carne macinata
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'l', 4, 28);    -- Besciamella
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(200, 'g', 4, 12);  -- Parmigiano
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'bicchiere', 4, 29); -- Vino rosso

-- Bruschette al pomodoro
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(8, 'fette', 5, 30);  -- Pane casereccio
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(4, 'unità', 5, 31);  -- Pomodorini
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES(1, 'cucchiaio', 5, 7);       -- Sale

-- Torta al cioccolato
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(16, 'g', 8, 32);  -- Lievito
INSERT INTO recipe_ingredient (quantity, unit, recipe_id, ingredient_id) VALUES(1, 'pizzico', 8, 7); -- Sale

-- =========================== ProcedureStep
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

-- Spaghetti al pomodoro
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Soffriggere l''aglio nell''olio a fuoco basso', 1, 'Non deve bruciare', 3);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Aggiungere i pomodori schiacciati e il basilico', 2, 'Cuocere 20 minuti', 3);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuocere gli spaghetti al dente in acqua salata', 3, '8-10 minuti', 3);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Saltare la pasta nel sugo per 1 minuto', 4, 'Fuoco vivace', 3);

-- Lasagna alla bolognese
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Preparare il ragù: rosolare la carne con sedano, carota e cipolla', 1, '30 minuti', 4);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Sfumare con il vino rosso e aggiungere il pomodoro', 2, 'Cuocere 2 ore', 4);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Alternare strati di pasta, ragù, besciamella e parmigiano', 3, '5-6 strati', 4);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuocere in forno a 180°C per 40 minuti', 4, 'Ultimi 5 minuti a 200°C', 4);

-- Bruschette al pomodoro
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Tostare il pane sulla griglia o in forno', 1, '2 minuti per lato', 5);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Strofinare le fette con aglio fresco', 2, NULL, 5);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Condire con pomodori a cubetti, olio e sale', 3, 'Servire immediatamente', 5);

-- Torta al cioccolato
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Fondere cioccolato e burro a bagnomaria', 1, 'Mescolare fino a liscio', 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Montare uova e zucchero a nastro', 2, '10 minuti', 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Incorporare il cioccolato fuso al composto', 3, 'Mescolare dal basso', 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Aggiungere farina e lievito setacciati', 4, 'Non smontare l''impasto', 8);
INSERT INTO procedure_step (description, step, note, recipe_id) VALUES('Cuocere in forno a 170°C per 35 minuti', 5, 'Test stecchino pulito', 8);

-- =========================== Saved Recipes
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (1, 2);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (1, 3);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (2, 1);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (3, 4);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (4, 5);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (5, 1);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (2, 6);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (5, 7);
INSERT INTO users_saved_recipes (savers_id, saved_recipes_id) VALUES (3, 8);

-- =========================== Recipe Categories
-- Pizza
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (6, 1);  -- Piatto Unico
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (7, 1);  -- Vegetariano

-- Tiramisù
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (4, 2);  -- Dolci

-- Spaghetti
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 3);  -- Primi
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (7, 3);  -- Vegetariano

-- Carbonara
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 6);  -- Primi

-- Risotto
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (2, 7);  -- Primi
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (7, 7);  -- Vegetariano

-- Torta
INSERT INTO recipe_category_recipes (categories_id, recipes_id) VALUES (4, 8);  -- Dolci

-- =========================== Grading 
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 1, 1);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 1, 3);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 2, 2);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 3, 4);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 4, 5);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (4, 6, 4);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 7, 2);
INSERT INTO grading (value, recipe_id, voter_id) VALUES (5, 8, 1);

-- =========================== Ingredient-Recipes 
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

-- Spaghetti al Pomodoro (recipe_id=3)
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(21, 3);  -- Spaghetti
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(3, 3);   -- Pomodoro
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(25, 3);  -- Aglio
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(5, 3);   -- Basilico
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(8, 3);   -- Olio d'oliva
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(7, 3);   -- Sale

-- Lasagna alla Bolognese (recipe_id=4)
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(26, 4);  -- Pasta per lasagne
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(27, 4);  -- Carne macinata
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(28, 4);  -- Besciamella
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(12, 4);  -- Parmigiano
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(29, 4);  -- Vino rosso
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(3, 4);   -- Pomodoro
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(11, 4);  -- Burro
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(33, 4);  -- Cipolla
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(34, 4);  -- Sedano
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(35, 4);  -- Carota

-- Bruschette al Pomodoro (recipe_id=5)
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(30, 5);  -- Pane casereccio
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(31, 5);  -- Pomodorini
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(8, 5);   -- Olio d'oliva
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(7, 5);   -- Sale
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(25, 5);  -- Aglio
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(5, 5);   -- Basilico

-- Torta al Cioccolato (recipe_id=8)
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(16, 8);  -- Cioccolato fondente
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(11, 8);  -- Burro
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(2, 8);   -- Uova
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(6, 8);   -- Zucchero
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(1, 8);   -- Farina
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(32, 8);  -- Lievito per dolci
INSERT INTO ingredient_recipes (ingredients_id, recipes_id) VALUES(7, 8);   -- Sale