INSERT INTO pais(id_pais,nombre)
VALUES(1,'Argentina')
ON CONFLICT DO NOTHING;

INSERT INTO pais(id_pais,nombre)
VALUES(2,'Chile')
ON CONFLICT DO NOTHING;


INSERT INTO pais(id_pais,nombre)
VALUES(3,'Brasil')
ON CONFLICT DO NOTHING;


INSERT INTO pais(id_pais,nombre)
VALUES(4,'Urugay')
ON CONFLICT DO NOTHING;


INSERT INTO pais(id_pais,nombre)
VALUES(5,'Bolivia')
ON CONFLICT DO NOTHING;


INSERT INTO pais(id_pais,nombre)
VALUES(6,'Paraguay')
ON CONFLICT DO NOTHING;


INSERT INTO pais(id_pais,nombre)
VALUES(7,'Otros')
ON CONFLICT DO NOTHING;



INSERT INTO tipo_documento(id_tipo_documento,tipo_documento)
VALUES (1,'Documento Unico')
ON CONFLICT DO NOTHING;

INSERT INTO tipo_documento(id_tipo_documento,tipo_documento)
VALUES (2,'Célula Identidad')
ON CONFLICT DO NOTHING;

INSERT INTO tipo_documento(id_tipo_documento,tipo_documento)
VALUES (3,'Libreta Civica')
ON CONFLICT DO NOTHING;

INSERT INTO tipo_documento(id_tipo_documento,tipo_documento)
VALUES (4,'Pasaporte')
ON CONFLICT DO NOTHING;

INSERT INTO relacion(id_relacion,tipo_relacion)
VALUES(1,'PADRE')
ON CONFLICT DO NOTHING;

INSERT INTO relacion(id_relacion,tipo_relacion)
VALUES(2,'HERMAN@')
ON CONFLICT DO NOTHING;

INSERT INTO relacion(id_relacion,tipo_relacion)
VALUES(3,'TI@')
ON CONFLICT DO NOTHING;

INSERT INTO relacion(id_relacion,tipo_relacion)
VALUES(4,'PRIM@')
ON CONFLICT DO NOTHING;