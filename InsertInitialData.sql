Use ApiDist;


INSERT INTO Sucursal 
VALUES (1, "Avenida Siempre Viva 123", "Siempre Viva");

INSERT INTO Sucursal 
VALUES (2, "Calle Falsa 123", "Calle Falsa");

INSERT INTO Sucursal 
VALUES (3, "Rivendel 758", "Rivendel");

INSERT INTO Sucursal 
VALUES (4, "Tatooine 523", "Tatooine");



INSERT into Cliente
VALUES(1, 50, '20-17254359-7', 'Av.San Juan 123', 'Av.Independencia 100', 'credito', 100, 'Juan Perez','password', 'empresa 1', '4321-6543','cliente', 1);

INSERT into Cliente
VALUES(2, 60, '20-17254358-7', 'Av.San Juan 143', 'Av.Independencia 500', 'credito', 200, 'Sebastian Perez','password', 'empresa 2', '4321-6542', 'cliente1', 2);

INSERT into Cliente
VALUES(3, 100, '20-17254357-7', 'Av.San Juan 1444', 'Av.Independencia 1000', 'credito', 300, 'Martin Perez', 'password', 'empresa 3', '4321-6541', 'cliente2',3);

INSERT into Cliente
VALUES(4, 200, '20-17254356-7', 'Av.San Juan 432', 'Av.Independencia 444', 'credito', 400, 'Carlos Perez', 'password','empresa 4', '4321-6549', 'cliente3',4);




INSERT into Empleado 
VALUES(1, 'Av. garay 123', 'Juan Perez', 'password','Empleado', 'ALMACEN', '4312-1234', 'almacen',1);

INSERT into Empleado 
VALUES(2, 'Av. Independencia 123', 'Sebastian Rodriguez', 'password','Empleado', 'ALMACEN', '4301-1237','almacen1', 1);

INSERT into Empleado 
VALUES(3, 'Av. San Juan 123', 'Julian Gomez', 'password','Gerente', 'ADMIN','4307-1234', 'admin',1);

INSERT into Empleado 
VALUES(4, 'Av. garay 122', 'Juan Rodriguez', 'password','Empleado', 'ALMACEN','4312-1232','almacen2', 2);

INSERT into Empleado 
VALUES(5, 'Av. Independencia 3000', 'Sebastian Diaz', 'password','Empleado', 'ALMACEN','4301-1233','almacen3', 2);

INSERT into Empleado 
VALUES(6, 'Av. San Juan 696', 'Oscar Fernandez', 'password','Gerente', 'ADMIN','4307-1231','admin1', 2);

INSERT into Empleado 
VALUES(7, 'Av. garay 122', 'Ramon Rodriguez', 'password','Empleado', 'ALMACEN', '4312-1235','almacen4', 3);

INSERT into Empleado 
VALUES(8, 'Av. Independencia 532', 'Javier Diaz', 'password','Empleado','ALMACEN', '4301-6378','almacen5', 3);

INSERT into Empleado 
VALUES(9, 'Av. San Juan 3242', 'Carlos Fernandez', 'password','Gerente', 'ADMIN','4307-4904','admin2', 3);

INSERT into Empleado 
VALUES(10, 'Av. garay 2345', 'Ramon Gomez', 'password','Empleado', 'DESPACHO', '4312-1235','despacho', 4);

INSERT into Empleado 
VALUES(11, 'Av. Independencia 665', 'Javier Fernandez', 'password','Empleado','DESPACHO', '4301-6378','despacho1', 4);

INSERT into Empleado 
VALUES(12, 'Av. San Juan 900', 'Carlos Diaz', 'password','Gerente', 'ADMIN','4307-4904','admin3', 4);



INSERT INTO AreaProduccion
VALUES (1, "Area produccion 1");

INSERT INTO AreaProduccion
VALUES (2, "Area produccion 2");

INSERT INTO AreaProduccion
VALUES (3, "Area produccion 3");

INSERT INTO AreaProduccion
VALUES (4, "Area produccion 4");


INSERT into LineaProduccion
VALUES(1, 'Libre', 0, '', 1);

INSERT into LineaProduccion
VALUES(2, 'Libre', 0, '', 1);

INSERT into LineaProduccion
VALUES(3, 'Libre', 0, '', 1);

INSERT into LineaProduccion
VALUES(4, 'Libre', 0, '', 2);

INSERT into LineaProduccion
VALUES(5, 'Libre', 0, '', 2);

INSERT into LineaProduccion
VALUES(6, 'Libre', 0, '', 2);

INSERT into LineaProduccion
VALUES(7, 'Libre', 0, '', 3);

INSERT into LineaProduccion
VALUES(8, 'Libre', 0, '', 3);

INSERT into LineaProduccion
VALUES(9, 'Libre', 0, '', 3);

INSERT into LineaProduccion
VALUES(10, 'Libre', 0, '', 4);

INSERT into LineaProduccion
VALUES(11, 'Libre', 0, '', 4);

INSERT into LineaProduccion
VALUES(12, 'Libre', 0, '', 4);


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


INSERT into StockMateriaPrima
VALUES(1, 1000, NOW(), 2, 'H010101', 1);

INSERT into StockMateriaPrima
VALUES(2, 1000, NOW(), 3, 'H010102', 2);

INSERT into StockMateriaPrima
VALUES(3, 1000, NOW(), 5, 'H010103', 3);

INSERT into StockMateriaPrima
VALUES(4, 1000, NOW(), 1, 'H010104', 4);

INSERT into StockMateriaPrima
VALUES(5, 1000, NOW(), 10, 'H010105', 5);



INSERT into Proveedor 
VALUES(1, 'cbu', 'cuit', 'Av. siempre viva 1234', 'Proveedor 1', '4309-8767' );

INSERT into Proveedor 
VALUES(2, 'cbu', 'cuit', 'Av. Garay 134', 'Proveedor 2', '4324-9634' );

INSERT into Proveedor 
VALUES(3, 'cbu', 'cuit', 'Av. San Juan 1004', 'Proveedor 3', '4301-4825' );

INSERT into Proveedor 
VALUES(4, 'cbu', 'cuit', 'Av. Independencia 576', 'Proveedor 4', '4307-4725' );

INSERT into Proveedor 
VALUES(5, 'cbu', 'cuit', 'Avellaneda 500', 'Proveedor 5', '4302-6581' );


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
VALUES (1, 'Tela necesaria',1 , 3.5, 1, 1); -- confeccion(id, detalle, estado , tiempoProd, areaProd_codigo, prenda_id)


INSERT INTO Insumo
VALUES (1, 10, 0.5, 2, 1); -- Insumo (id, cantidad, desperdicio, codigo materia prima, confeccion_id)




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
VALUES (2, 'Algodon necesario',1, 5.5, 2, 2); -- confeccion(id, detalle, estado ,tiempoProd, areaProd_codigo, prenda_id)


INSERT INTO Insumo
VALUES (2, 5, 0, 5, 2); -- Insumo (id, cantidad, desperdicio, codigo materia prima, confeccion_id)



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
VALUES (3, 'Botones necesarios', 1, 5, 3, 3); -- confeccion(id, detalle, estado ,tiempoProd, areaProd_codigo, prenda_id)


INSERT INTO Insumo
VALUES (3, 5, 0, 1, 3); -- Insumo (id, cantidad, desperdicio, codigo materia prima, confeccion_id)

