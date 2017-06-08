Use ApiDist;

INSERT INTO Sucursal 
VALUES (1, "Avenida Siempre Viva 123", "Siempre Viva");

INSERT INTO Sucursal 
VALUES (2, "Calle Falsa 123", "Calle Falsa");

INSERT INTO Sucursal 
VALUES (3, "Rivendel 758", "Rivendel");

INSERT INTO Sucursal 
VALUES (4, "Tatooine 523", "Tatooine");



INSERT INTO AreaProduccion
VALUES (1, "Area produccion 1");

INSERT INTO AreaProduccion
VALUES (2, "Area produccion 2");

INSERT INTO AreaProduccion
VALUES (3, "Area produccion 3");

INSERT INTO AreaProduccion
VALUES (4, "Area produccion 4");

INSERT INTO AreaProduccion
VALUES (5, "Area produccion 5");



INSERT INTO MateriaPrima
VALUES (1, 10, "Botones");

INSERT INTO MateriaPrima
VALUES (2, 10, "Tela");

INSERT INTO MateriaPrima
VALUES (3, 10, "Cuero");

INSERT INTO MateriaPrima
VALUES (4, 10, "Hilo");

INSERT INTO MateriaPrima
VALUES (5, 10, "Algodon peruano");



-- PRENDA 1
INSERT INTO Prenda
VALUES (1, 100, "Remera cuello redondo", 0, "Remera", 10);


INSERT INTO PrendaEntity_coloresValidos
VALUES (1, 1); -- Remera Roja


INSERT INTO PrendaEntity_tallesValidos
VALUES (1, 's'); -- Talle s

INSERT INTO PrendaEntity_tallesValidos
VALUES (1, 'm'); -- Talle m

INSERT INTO PrendaEntity_tallesValidos
VALUES (1, 'l'); -- Talle l


INSERT INTO Confeccion
VALUES (1, 'Tela necesaria', 3.5, 1, 1); -- confeccion(id, detalle, tiempoProd, areaProd_codigo, prenda_id)


INSERT INTO Insumo
VALUES (1, 10, 0.5, 3, 2, 1); -- Insumo (id, cantidad, desperdicio, precio, codigo materia prima, confeccion_id)




-- PRENDA 2
INSERT INTO Prenda
VALUES (2, 100, "Remera cuello v", 1, "Remera", 10);


INSERT INTO PrendaEntity_coloresValidos
VALUES (2, 2); -- Remera Negro


INSERT INTO PrendaEntity_tallesValidos
VALUES (2, 'xs'); -- Talle xs

INSERT INTO PrendaEntity_tallesValidos
VALUES (2, 's'); -- Talle s

INSERT INTO PrendaEntity_tallesValidos
VALUES (2, 'm'); -- Talle m

INSERT INTO PrendaEntity_tallesValidos
VALUES (2, 'l'); -- Talle l

INSERT INTO PrendaEntity_tallesValidos
VALUES (2, 'xl'); -- Talle xl


INSERT INTO Confeccion
VALUES (2, 'Algodon necesario', 5.5, 2, 2); -- confeccion(id, detalle, tiempoProd, areaProd_codigo, prenda_id)


INSERT INTO Insumo
VALUES (2, 5, 0, 5, 5, 2); -- Insumo (id, cantidad, desperdicio, precio, codigo materia prima, confeccion_id)



-- PRENDA 3
INSERT INTO Prenda
VALUES (3, 100, "Pantalon jean", 1, "Pantalon", 10);

INSERT INTO PrendaEntity_coloresValidos
VALUES (3, 2); -- Pantalon Negro

INSERT INTO PrendaEntity_tallesValidos
VALUES (3, 's'); -- Talle s

INSERT INTO PrendaEntity_tallesValidos
VALUES (3, 'm'); -- Talle m


INSERT INTO Confeccion
VALUES (3, 'Botones necesarios', 1.5, 3, 3); -- confeccion(id, detalle, tiempoProd, areaProd_codigo, prenda_id)


INSERT INTO Insumo
VALUES (3, 5, 0, 5, 1, 3); -- Insumo (id, cantidad, desperdicio, precio, codigo materia prima, confeccion_id)



INSERT INTO StockPrenda
VALUES (3, 10, 1, 1.5, "", NOW(), "M", "AAA", null, 3, null); -- stock

INSERT INTO StockPrenda
VALUES (2, 0, 1, 1.5, "", NOW(), "M", "AAA", null, 2, null); -- stock

INSERT INTO StockPrenda
VALUES (1, 0, 1, 1.5, "", NOW(), "M", "AAA", null, 1, null); -- stock

