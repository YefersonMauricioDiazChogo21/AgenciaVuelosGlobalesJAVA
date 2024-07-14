USE railway;

-- DROP DATABASE IF EXISTS railway;
-- CREATE DATABASE IF NOT EXISTS railway;

-- Creación de la tabla Fabricante
CREATE TABLE Fabricante (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40)
);

-- Creación de la tabla Modelo
CREATE TABLE Modelo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45),
    Fabricante_id INT,
    FOREIGN KEY (Fabricante_id) REFERENCES Fabricante(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Estado
CREATE TABLE Estado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30)
);

-- Creación de la tabla Avion
CREATE TABLE Avion (
    id INT PRIMARY KEY AUTO_INCREMENT,
    matricula VARCHAR(45),
    capacidad INT,
    fechaFabricacion DATE,
    Modelo_id INT,
    Estado_id INT,
    FOREIGN KEY (Modelo_id) REFERENCES Modelo(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Estado_id) REFERENCES Estado(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Rol
CREATE TABLE Rol (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45)
);

-- Creación de la tabla Pais
CREATE TABLE Pais (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45)
);

-- Creación de la tabla Aerolinea
CREATE TABLE Aerolinea (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45)
);

-- Creación de la tabla Ciudad
CREATE TABLE Ciudad (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45),
    Pais_id INT,
    FOREIGN KEY (Pais_id) REFERENCES Pais(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Aeropuerto
CREATE TABLE Aeropuerto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45),
    Ciudad_id INT,
    FOREIGN KEY (Ciudad_id) REFERENCES Ciudad(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Salida
CREATE TABLE Salida (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numeroSalida VARCHAR(5),
    Aeropuerto_id INT,
    FOREIGN KEY (Aeropuerto_id) REFERENCES Aeropuerto(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Empleado
CREATE TABLE Empleado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45),
    fechaIngreso INT,
    Rol_id INT,
    Aerolinea_id INT,
    FOREIGN KEY (Rol_id) REFERENCES Rol(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Aerolinea_id) REFERENCES Aerolinea(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Revision
CREATE TABLE Revision (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fechaRevision VARCHAR(45),
    Avion_id INT,
    FOREIGN KEY (Avion_id) REFERENCES Avion(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Revision_Empleado
CREATE TABLE Revision_Empleado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Revision_id INT,
    Empleado_id INT,
    descripcion VARCHAR(45),
    FOREIGN KEY (Empleado_id) REFERENCES Empleado(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Revision_id) REFERENCES Revision(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Viaje
CREATE TABLE Viaje (
    id INT PRIMARY KEY AUTO_INCREMENT,
    aeropuertoOrigen INT,
    aeropuertoDestino INT,
    fechaViaje DATETIME,
    precio DECIMAL NOT NULL,
    FOREIGN KEY (aeropuertoOrigen) REFERENCES Aeropuerto(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (aeropuertoDestino) REFERENCES Aeropuerto(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Escala
CREATE TABLE Escala (
    id INT PRIMARY KEY AUTO_INCREMENT,
    aeropuertoDestino INT,
    aeropuertoOrigen INT,
    Avion_id INT,
    Viaje_id INT,
    FOREIGN KEY (Avion_id) REFERENCES Avion(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Viaje_id) REFERENCES Viaje(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (aeropuertoOrigen) REFERENCES Aeropuerto(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (aeropuertoDestino) REFERENCES Aeropuerto(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Tripulante
CREATE TABLE Tripulante (
    Escala_id INT,
    Empleado_id INT,
    PRIMARY KEY (Escala_id, Empleado_id),
    FOREIGN KEY (Escala_id) REFERENCES Escala(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Empleado_id) REFERENCES Empleado(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Documento
CREATE TABLE Documento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45)
);

-- Creación de la tabla Cliente
CREATE TABLE Cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45),
    edad VARCHAR(45),
    Documento_id INT,
    FOREIGN KEY (Documento_id) REFERENCES Documento(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Tarifa
CREATE TABLE Tarifa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(45),
    detalle VARCHAR(45),
    valor VARCHAR(45)
);

-- Creación de la tabla detalleReserva
CREATE TABLE detalleReserva (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Tarifa_id INT,
    Cliente_id INT,
    FOREIGN KEY (Tarifa_id) REFERENCES Tarifa(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla ReservaViaje
CREATE TABLE ReservaViaje (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE,
    Viaje_id INT,
    detalleReserva_id INT,
    FOREIGN KEY (Viaje_id) REFERENCES Viaje(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (detalleReserva_id) REFERENCES detalleReserva(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Creación de la tabla Clase
CREATE TABLE Clase (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoClase VARCHAR(10)
);

-- Creación de la tabla Asiento
CREATE TABLE Asiento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idAvion INT,
    numeroAsiento VARCHAR(5),
    fila INT,
    columna INT,
    idClase INT,
    FOREIGN KEY (idAvion) REFERENCES Avion(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (idClase) REFERENCES Clase(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ReservaAsiento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idAsiento INT,
    idReserva INT,
    FOREIGN KEY (idAsiento) REFERENCES Asiento(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (idReserva) REFERENCES ReservaViaje(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE AutenticacionRol(
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) UNIQUE,
    contraseña VARCHAR(10),
    rolId INT,
    FOREIGN KEY (rolId) REFERENCES Rol(id) ON DELETE CASCADE ON UPDATE CASCADE
);
