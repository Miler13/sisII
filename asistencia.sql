CREATE TABLE Departamento (
  idDepartamento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  departamento VARCHAR NOT NULL,
  PRIMARY KEY(idDepartamento)
);

CREATE TABLE EstadoAsistencia (
  idEstadoAsistencia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  estado VARCHAR NOT NULL,
  PRIMARY KEY(idEstadoAsistencia)
);

CREATE TABLE Cargo (
  idCargo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  cargo VARCHAR NOT NULL,
  PRIMARY KEY(idCargo)
);

CREATE TABLE Empleado (
  ciEmpleado INTEGER UNSIGNED NOT NULL,
  Departamento_idDepartamento INTEGER UNSIGNED NOT NULL,
  nombre VARCHAR NOT NULL,
  PRIMARY KEY(ciEmpleado),
  FOREIGN KEY(Departamento_idDepartamento)
    REFERENCES Departamento(idDepartamento)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Asistencia (
  fecha DATE NOT NULL,
  Empleado_ciEmpleado INTEGER UNSIGNED NOT NULL,
  EstadoAsistencia_idEstadoAsistencia INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(fecha, Empleado_ciEmpleado, EstadoAsistencia_idEstadoAsistencia),
  FOREIGN KEY(Empleado_ciEmpleado)
    REFERENCES Empleado(ciEmpleado)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(EstadoAsistencia_idEstadoAsistencia)
    REFERENCES EstadoAsistencia(idEstadoAsistencia)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE EmpleadoCargo (
  idEmpleadoCargo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Empleado_ciEmpleado INTEGER UNSIGNED NOT NULL,
  Cargo_idCargo INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idEmpleadoCargo, Empleado_ciEmpleado, Cargo_idCargo),
  FOREIGN KEY(Empleado_ciEmpleado)
    REFERENCES Empleado(ciEmpleado)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Cargo_idCargo)
    REFERENCES Cargo(idCargo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


