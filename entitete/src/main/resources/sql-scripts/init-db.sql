INSERT INTO uporabnik (ime, priimek, uporabnisko_ime, email) VALUES ('Petra', 'Kos', 'petrakos', 'petra.kos@hotmail.com');
INSERT INTO uporabnik (ime, priimek, uporabnisko_ime, email) VALUES ('Miha', 'Novak', 'mihanovak', 'miha.novak@gmail.com');
INSERT INTO kategorija (ime, opis) VALUES ('Pisala', 'Kemični svinčniki in nalivna peresa.');
INSERT INTO izdelek (ime, opis, teza_v_gramih, kategorija_id) VALUES ('Nalivno pero', 'Kakovostno nalivno pero zelene barve.', 10, 1);
INSERT INTO izdelek (ime, opis, teza_v_gramih, kategorija_id) VALUES ('Črnilo', 'Nalivno črnilo modre barve.', 5, 1);
INSERT INTO trgovina (ime, kraj, spletna_stran) VALUES ('Hofer', 'Ljubljana', 'www.hofer.si')
INSERT INTO trgovina (ime, kraj) VALUES ('Spar', 'Novo mesto')

INSERT INTO izdelekvtrgovini (izdelek_id, trgovina_id, cena, zaloga) VALUES (1, 1, 2.64, 3)
INSERT INTO izdelekvtrgovini (izdelek_id, trgovina_id, cena, zaloga) VALUES (1, 2, 1.64, 5)


