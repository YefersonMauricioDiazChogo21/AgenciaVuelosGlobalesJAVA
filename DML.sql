use railway;

-- Estados
INSERT INTO Estado(id, nombre) VALUES (1, "En espera");
INSERT INTO Estado(id, nombre) VALUES (2, "Despegando");
INSERT INTO Estado(id, nombre) VALUES (3, "En vuelo");
INSERT INTO Estado(id, nombre) VALUES (4, "Aterrizando");
INSERT INTO Estado(id, nombre) VALUES (5, "En mantenimiento");
INSERT INTO Estado(id, nombre) VALUES (6, "Listo para vuelo");
INSERT INTO Estado(id, nombre) VALUES (7, "Retrasado");
INSERT INTO Estado(id, nombre) VALUES (8, "Cancelado");
INSERT INTO Estado(id, nombre) VALUES (9, "Desviando");



-- Inserciones para la tabla Fabricante
INSERT INTO Fabricante (id, nombre) VALUES (1, 'Boeing');
INSERT INTO Fabricante (id, nombre) VALUES (2, 'Airbus');
INSERT INTO Fabricante (id, nombre) VALUES (3, 'Embraer');
INSERT INTO Fabricante (id, nombre) VALUES (4, 'Bombardier');
INSERT INTO Fabricante (id, nombre) VALUES (5, 'Cessna');


-- Inserciones para la tabla Modelo
INSERT INTO Modelo (id, nombre, Fabricante_id) VALUES (1, '747', 1); -- Boeing 747
INSERT INTO Modelo (id, nombre, Fabricante_id) VALUES (2, 'A380', 2); -- Airbus A380
INSERT INTO Modelo (id, nombre, Fabricante_id) VALUES (3, 'E190', 3); -- Embraer E190
INSERT INTO Modelo (id, nombre, Fabricante_id) VALUES (4, 'CRJ900', 4); -- Bombardier CRJ900
INSERT INTO Modelo (id, nombre, Fabricante_id) VALUES (5, 'Citation X', 5); -- Cessna Citation X

-- Pais
INSERT INTO Pais (id, nombre) VALUES
(1, 'Colombia'),
(2, 'Venezuela'),
(3, 'Mexico'),
(4, 'Peru'),
(5, 'Paraguay'),
(6, 'Uruguay'),
(7, 'Bolivia'),
(8, 'Costa Rica'),
(9, 'Argentina'),
(10, 'Trinidad y Tobago'),
(11, 'Salvador'),
(12, 'España'),
(13, 'Estados Unidos'),
(14, 'Ecuador'),
(15, 'Puerto Rico'),
(16, 'Alemania'),
(17, 'Holanda'),
(18, 'Japon');

--ciudades

INSERT INTO Ciudad (id, nombre, Pais_id) VALUES
(1, 'Bogotá', 1),
(2, 'Medellín', 1),
(3, 'Caracas', 2),
(4, 'Maracaibo', 2),
(5, 'Ciudad de México', 3),
(6, 'Guadalajara', 3),
(7, 'Lima', 4),
(8, 'Cusco', 4),
(9, 'Asunción', 5),
(10, 'Ciudad del Este', 5),
(11, 'Montevideo', 6),
(12, 'Salto', 6),
(13, 'La Paz', 7),
(14, 'Santa Cruz', 7),
(15, 'San José', 8),
(16, 'Limón', 8),
(17, 'Buenos Aires', 9),
(18, 'Córdoba', 9),
(19, 'Puerto España', 10),
(20, 'San Fernando', 10),
(21, 'San Salvador', 11),
(22, 'Santa Ana', 11),
(23, 'Madrid', 12),
(24, 'Barcelona', 12),
(25, 'Nueva York', 13),
(26, 'Los Ángeles', 13),
(27, 'Quito', 14),
(28, 'Guayaquil', 14),
(29, 'San Juan', 15),
(30, 'Ponce', 15),
(31, 'Berlín', 16),
(32, 'Múnich', 16),
(33, 'Ámsterdam', 17),
(34, 'Rotterdam', 17),
(35, 'Tokio', 18),
(36, 'Osaka', 18);

