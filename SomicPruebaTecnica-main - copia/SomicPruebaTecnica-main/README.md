
# Formulario de Facturación con Java, MySQL y Frontend Web

Este proyecto es un prototipo para una prueba técnica. Se trata de un sistema de facturación desarrollado en Java con conexión a una base de datos MySQL, y un frontend en HTML, CSS y JavaScript. El objetivo es permitir el registro de facturas mediante un formulario que impacta directamente en la base de datos.

## 🧰 Tecnologías Utilizadas

- **Backend:** Java (Spring Boot)
- **Base de datos:** MySQL (Clever Cloud)
- **Frontend:** HTML, CSS, JavaScript
- **Conexión a BD:** JDBC

## 🗃️ Estructura de la Base de Datos

### Tabla: `Nits`
```sql
CREATE TABLE Nits (
    NitId INT AUTO_INCREMENT PRIMARY KEY,
    NitNom VARCHAR(100),
    NitDoc VARCHAR(50),
    NitCup DECIMAL(10, 2),
    NitPla INT
);
```

### Tabla: `Articulos`
```sql
CREATE TABLE Articulos (
    ArtId INT AUTO_INCREMENT PRIMARY KEY,
    ArtCod VARCHAR(50),
    ArtNom VARCHAR(100),
    ArtLab VARCHAR(100),
    ArtSal INT,
    ArtCos DECIMAL(10, 2),
    ArtPre DECIMAL(10, 2)
);
```

### Tabla: `Factura`
```sql
CREATE TABLE Factura (
    FacId INT AUTO_INCREMENT PRIMARY KEY,
    FacNum VARCHAR(20),
    FacFec DATE,
    FacVen DATE,
    FacNit INT,
    FOREIGN KEY (FacNit) REFERENCES Nits(NitId)
);
```

### Tabla: `Facturakardex`
```sql
CREATE TABLE Facturakardex (
    FakId INT AUTO_INCREMENT PRIMARY KEY,
    FakFac INT,
    FakArt INT,
    FakNat CHAR(1),
    FakUni INT,
    FakCos DECIMAL(10,2),
    FakPre DECIMAL(10,2),
    FakTotVen DECIMAL(10,2),
    FakTotCos DECIMAL(10,2),
    FOREIGN KEY (FakFac) REFERENCES Factura(FacId),
    FOREIGN KEY (FakArt) REFERENCES Articulos(ArtId)
);
```

### Datos de ejemplo

#### Tabla: `Nits`
```sql
INSERT INTO nits (nit_cup, nit_pla, nit_doc, nit_nom) VALUES
(10000.0, 1, '123456789', 'Cliente A'),
(15000.0, 2, '987654321', 'Cliente B'),
(12000.0, 1, '456789123', 'Cliente C'),
(20000.0, 3, '321654987', 'Cliente D'),
(11000.0, 2, '159753468', 'Cliente E');
```

#### Tabla: `Articulos`
```sql
INSERT INTO articulos (art_cos, art_pre, art_sal, art_cod, art_lab, art_nom) VALUES
(100.0, 150.0, 50, 'A001', 'Lab Uno', 'Paracetamol'),
(200.0, 250.0, 30, 'A002', 'Lab Dos', 'Ibuprofeno'),
(80.0, 120.0, 70, 'A003', 'Lab Tres', 'Amoxicilina'),
(150.0, 200.0, 40, 'A004', 'Lab Cuatro', 'Omeprazol'),
(50.0, 90.0, 100, 'A005', 'Lab Cinco', 'Loratadina');
```

## 🧾 Funcionalidades del Formulario

El formulario permite ingresar los siguientes datos:

- Número de factura
- Fecha de emisión y vencimiento
- Nit del cliente (con buscador)
- Nombre del cliente, cupo, plazo, cartera y disponible
- Código del artículo (con buscador)
- Nombre, laboratorio, saldo del artículo
- Naturaleza (positiva "+" o negativa "-")
- Unidades, costo, precio de venta (solo si naturaleza es "-")
- Total venta y total costo

### Botón "Agregar"

Al hacer clic en el botón:

- Se limpia el formulario.
- Se agrega la información a una rejilla visible.
- La rejilla muestra los totales y cada fila tiene una "X" para eliminarla.
- Se guarda la información directamente en la base de datos.

### Validaciones especiales

- Si la naturaleza es "-", el precio de venta debe ser **mayor o igual al costo del producto**.
- Si la naturaleza es "+", el precio de venta se oculta y se guarda como 0.

## 📂 Organización del Proyecto

```
/Proyecto
│
├── /controller
│   ├── ArticuloController.java
│   ├── FacturaController.java
│   ├── FacturaKardexController.java
│   └── NitController.java
│
├── /repository
│   ├── ArticuloRepository.java
│   ├── FacturaRepository.java
│   ├── FacturaKardexRepository.java
│   └── NitRepository.java
│
├── /model
│   ├── Articulo.java
│   ├── Factura.java
│   ├── FacturaKardex.java
│   ├── Nit.java
│   └── FormularioFactura.java
│
├── /Frontend
│   ├── index.html
│   ├── script.js
│   └── style.css
│
```

## 🧪 Notas adicionales

Este es un prototipo para fines académicos y pruebas técnicas. El objetivo es demostrar el manejo de formularios, validaciones y conexión entre frontend y backend con una base de datos relacional.
