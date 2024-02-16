DROP DATABASE tarjetacreditodb;
CREATE DATABASE tarjetacreditodb;
\c tarjetacreditodb;

CREATE TABLE tarjetacredito(
    numeroTarjeta varchar(17) NOT NULL,
    nif varchar(9) NOT NULL,
    titular varchar(80) NOT NULL,
    pin varchar NOT NULL,
    limite integer NOT NULL,
    mesCaducidad integer,
    anoCaducidad integer,
    cvv varchar NOT NULL, 
    PRIMARY KEY(numeroTarjeta)
);

CREATE TABLE movimientos(
    movimiento_id SERIAL PRIMARY KEY,
    numeroTarjeta varchar(16) NOT NULL,
    concepto varchar NOT NULL,
    cantidad decimal NOT NULL,
    fecha date NOT NULL,
    CONSTRAINT fk_movimientos_numeroTarjeta 
    FOREIGN KEY (numeroTarjeta) 
    REFERENCES tarjetacredito(numeroTarjeta)
);

--Hay 4 tarjetas, de las cuales las dos primeras tienen movimientos total (10), las otras dos estan vacias para hacer hacer movimientos desde 0

INSERT INTO tarjetacredito (numeroTarjeta, nif, titular, pin, limite, mesCaducidad, anoCaducidad, cvv) VALUES('4017113418220814','28731849L','Naoual Weber Fernandez','12345',2500,10,2027,394);
INSERT INTO tarjetacredito (numeroTarjeta, nif, titular, pin, limite, mesCaducidad, anoCaducidad, cvv) VALUES('4014491966396860','99832033G','Jura Hkkinen Gonzalez','98745',1500,10,2027,734);
INSERT INTO tarjetacredito (numeroTarjeta, nif, titular, pin, limite, mesCaducidad, anoCaducidad, cvv) VALUES('4000662659371693','50678191Z','Monika Knotten Muñoz','19375',4500,10,2027,964);
INSERT INTO tarjetacredito (numeroTarjeta, nif, titular, pin, limite, mesCaducidad, anoCaducidad, cvv) VALUES('4011201202929421','60418475M','Mucahit Aziz Moreno','82465',5000,10,2027,345);
    

INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4017113418220814', 'Bizum coca cola', 100, '21-05-2023');
INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4017113418220814', 'Bizum profesor programacion', 500, '22-05-2023');
INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4017113418220814', 'Bizum cartulina worbu', 400, '19-05-2023');
INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4017113418220814', 'Bizum palomitas cine', 200, '25-05-2023');


INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4014491966396860', 'Bizum de gasolina', 200, '15-04-2023');   
INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4014491966396860', 'Bizum para el jamon', 550, '15-04-2023'); 
INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4014491966396860', 'Bizum profesor programacion', 320, '15-04-2023'); 
INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4014491966396860', 'Bizum viaje a malaga', 100, '15-04-2023'); 
INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4014491966396860', 'Bizum concierto Quevedo', 50, '15-04-2023'); 
INSERT INTO movimientos(numeroTarjeta, concepto, cantidad, fecha) VALUES('4014491966396860', 'Bizum pa pipas', 20, '15-04-2023'); 

