CREATE DATABASE almacen;



CREATE TABLE IF NOT EXISTS usuarios (
                                        usuario_id serial primary key,
                                        username varchar(50)
    );


CREATE TABLE IF NOT EXISTS instrumentos (
                                            instrumento_id serial primary key ,
                                            nombre_articulo varchar(50),
    estado int,
    is_loaned bool,
    desDuenio varchar(150)
    );

CREATE TABLE IF NOT EXISTS partituras (
                                          partitura_id serial primary key ,
                                          nombre_articulo varchar(50),
    estado int,
    is_loaned bool,
    autor varchar(150),
    duracion int
    );


CREATE TABLE IF NOT EXISTS  prestamo_instrumentos(
                                                     prestamo_id SERIAL PRIMARY KEY,
                                                     instrumento_id int,
                                                     usuario_id int,
                                                     FOREIGN KEY (instrumento_id) REFERENCES instrumentos(instrumento_id),
    FOREIGN KEY (usuario_id) REFERENCES  usuarios(usuario_id)
    );

CREATE TABLE IF NOT EXISTS  prestamo_partituras(
                                                   prestamo_id SERIAL PRIMARY KEY,
                                                   partitura_id int,
                                                   usuario_id int,
                                                   FOREIGN KEY (partitura_id) REFERENCES partituras(partitura_id),
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

INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Guitarra',1,false,'Jorge');
INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Trompeta',1,false,'Ximena');
INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Violín',1,false,'Juan');
INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Cajón',1,false,'Estaban');
INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Guitarra Eléctrica',1,false,'Cesar');
INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Batería',1,false,'José');
INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Flauta Dulce',1,false,'Cesar A.');
INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Clarinete',1,false,'Alonso');
INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Tambor',1,false,'Lalo');
INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES ('Trombón',1,false,'Felipe');
SELECT * FROM instrumentos;


INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Guitarra',1,false,'Gabriel',5);
INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Star Wars Flauta',1,false,'Gabriel',3);
INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Motor y motivo Trompeta',1,false,'Cesar',4);
INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Yo soy tu amigo fiel - Toy Story - Flauta',1,false,'Miguel',2);
INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Himno Nacional del Perú - Trompeta',1,false,'Pablo',3);
INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Himno Nacional de Argentina - Flauta',1,false,'Hector',2);
INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Himno Nacional de Chile - Tambor',1,false,'Brenda',3);
INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Himno Nacional de Colombia - Trombón',1,false,'Felipe',2);
INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Musica Ligera - Guitarra Electrica',1,false,'Gabriel',4);
INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor, duracion) VALUES ('Muralla Verde',1,false,'Carlos',3);


SELECT * from partituras;

INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (1,3);
INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (3,4);
INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (10,4);
INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (9,7);
INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (7,5);
INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (2,3);
INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (6,10);
INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (2,7);
INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (2,7);
INSERT INTO prestamo_instrumentos(instrumento_id, usuario_id) VALUES (3,6);

INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (1,3);
INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (3,4);
INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (10,4);
INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (9,7);
INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (7,5);
INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (2,3);
INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (6,10);
INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (2,7);
INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (2,7);
INSERT INTO prestamo_partituras(partitura_id, usuario_id) VALUES (3,6);



SELECT * FROM prestamo_instrumentos
                  INNER JOIN usuarios u on prestamo_instrumentos.usuario_id = u.usuario_id;

SELECT * FROM prestamo_partituras
                  INNER JOIN usuarios u on prestamo_partituras.usuario_id = u.usuario_id;