CREATE DATABASE almacen;

-- drop table usuarios;
-- drop table softwares;
-- drop table hardwares;
-- drop table prestamo_softwares;
-- drop table prestamo_hardwares;



CREATE TABLE IF NOT EXISTS usuarios (
                                        usuario_id serial primary key,
                                        username varchar(50)
    );


CREATE TABLE IF NOT EXISTS hardwares (
                                         hardware_id serial primary key ,
                                         nombre_articulo varchar(50),
    estado int,
    is_loaned bool,
    marca varchar(50),
    modelo varchar(50),
    version int
    );

CREATE TABLE IF NOT EXISTS softwares (
                                         software_id serial primary key ,
                                         nombre_articulo varchar(50),
    estado int,
    is_loaned bool,
    marca varchar(50),
    modelo varchar(50),
    version int,
    tipo_licencia varchar(50)
    );


CREATE TABLE IF NOT EXISTS  prestamo_hardwares(
                                                  prestamo_id SERIAL PRIMARY KEY,
                                                  hardware_id int,
                                                  usuario_id int,
                                                  FOREIGN KEY (hardware_id) REFERENCES hardwares(hardware_id),
    FOREIGN KEY (usuario_id) REFERENCES  usuarios(usuario_id)
    );

CREATE TABLE IF NOT EXISTS  prestamo_softwares(
                                                  prestamo_id SERIAL PRIMARY KEY,
                                                  software_id int,
                                                  usuario_id int,
                                                  FOREIGN KEY (software_id) REFERENCES softwares(software_id),
    FOREIGN KEY (usuario_id) REFERENCES  usuarios(usuario_id)
    );

INSERT INTO usuarios (username) VALUES ('pbunworth0');
INSERT INTO usuarios (username) VALUES ('crobard1');
INSERT INTO usuarios (username) VALUES ('stoupe2');
INSERT INTO usuarios (username) VALUES ('pmarsh3');
INSERT INTO usuarios (username) VALUES ('hnancarrow4');
INSERT INTO usuarios (username) VALUES ('poxenbury5');
INSERT INTO usuarios (username) VALUES ('mgleaves6');
INSERT INTO usuarios (username) VALUES ('mmartensen7');
INSERT INTO usuarios (username) VALUES ('asoans8');
INSERT INTO usuarios (username) VALUES ('sandrus9');

SELECT * FROM usuarios;

INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca,modelo,version) VALUES ('Laptop',1,false,'Hp','1300',2022);
INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES ('Laptop',1,false,'Asus','Zaphyrus',2023);
INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES ('Laptop',1,false,'Asus','ROG',2020);
INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES ('Laptop',1,false,'Lenovo','Legion',2023);
INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES ('Laptop',1,false,'Lenovo','Thinkpad',2020);
INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES ('Laptop',1,false,'Acer','Nitro',2020);
INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES ('Laptop',1,false,'Hp','Omen',2023);
INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES ('Laptop',1,false,'Asus','Zenbook',2020);
INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES ('Laptop',1,false,'Asus','Vivobook',2021);
INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES ('Laptop',1,false,'Hp','compass',2015);
SELECT * FROM hardwares;


INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Word',1,false,'Microsoft', 'Office',365,'Digital');
INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Excel',1,false,'Microsoft','Office',365,'Digital');
INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Power Point',1,false,'Microsoft','Office',365,'Digital');
INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Autocad',1,false,'Autodesk','Windows',2023,'Fisica');
INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Photoshop',1,false,'Adobe','Cloud',2023,'Digital');
INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Illustrator',1,false,'Adobe','Cloud',2023,'Digital');
INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Antivirus',1,false,'Kaspesky','Cloud',2023,'Digital');
INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Google Chrome',1,false,'Google','Chrome',2023,'Digital');
INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Spotify',1,false,'Spotify','Spotify',2023,'Digital');
INSERT INTO softwares(nombre_articulo, estado, is_loaned,marca, modelo, version, tipo_licencia) VALUES ('Postgresql',1,false,'Postgresql','Postgresql',1,'Digital');


SELECT * from softwares;

INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (1,3);
INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (3,4);
INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (10,4);
INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (9,7);
INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (7,5);
INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (2,3);
INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (6,10);
INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (2,7);
INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (2,7);
INSERT INTO prestamo_hardwares(hardware_id, usuario_id) VALUES (3,6);

INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (1,3);
INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (3,4);
INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (10,4);
INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (9,7);
INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (7,5);
INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (2,3);
INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (6,10);
INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (2,7);
INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (2,7);
INSERT INTO prestamo_softwares(software_id, usuario_id) VALUES (3,6);



SELECT * FROM prestamo_hardwares
                  INNER JOIN usuarios u on prestamo_hardwares.usuario_id = u.usuario_id;

SELECT * FROM prestamo_softwares
                  INNER JOIN usuarios u on prestamo_softwares.usuario_id = u.usuario_id;