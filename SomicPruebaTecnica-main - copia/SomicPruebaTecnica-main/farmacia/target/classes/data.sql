-- Tabla: nits
INSERT INTO nits (nit_cup, nit_pla, nit_doc, nit_nom) VALUES (10000.0, 1, '123456789', 'Cliente A');
INSERT INTO nits (nit_cup, nit_pla, nit_doc, nit_nom) VALUES (15000.0, 2, '987654321', 'Cliente B');
INSERT INTO nits (nit_cup, nit_pla, nit_doc, nit_nom) VALUES (12000.0, 1, '456789123', 'Cliente C');
INSERT INTO nits (nit_cup, nit_pla, nit_doc, nit_nom) VALUES (20000.0, 3, '321654987', 'Cliente D');
INSERT INTO nits (nit_cup, nit_pla, nit_doc, nit_nom) VALUES (11000.0, 2, '159753468', 'Cliente E');

-- Tabla: articulos
INSERT INTO articulos (art_cos, art_pre, art_sal, art_cod, art_lab, art_nom) VALUES (100.0, 150.0, 50, 'A001', 'Lab Uno', 'Paracetamol');
INSERT INTO articulos (art_cos, art_pre, art_sal, art_cod, art_lab, art_nom) VALUES (200.0, 250.0, 30, 'A002', 'Lab Dos', 'Ibuprofeno');
INSERT INTO articulos (art_cos, art_pre, art_sal, art_cod, art_lab, art_nom) VALUES (80.0, 120.0, 70, 'A003', 'Lab Tres', 'Amoxicilina');
INSERT INTO articulos (art_cos, art_pre, art_sal, art_cod, art_lab, art_nom) VALUES (150.0, 200.0, 40, 'A004', 'Lab Cuatro', 'Omeprazol');
INSERT INTO articulos (art_cos, art_pre, art_sal, art_cod, art_lab, art_nom) VALUES (50.0, 90.0, 100, 'A005', 'Lab Cinco', 'Loratadina');

-- Tabla: factura
INSERT INTO factura (fac_nit, fac_fec, fac_ven, fac_num) VALUES (1, '2024-04-01 10:00:00', '2024-04-10 10:00:00', 'F001');
INSERT INTO factura (fac_nit, fac_fec, fac_ven, fac_num) VALUES (2, '2024-04-02 11:00:00', '2024-04-11 11:00:00', 'F002');
INSERT INTO factura (fac_nit, fac_fec, fac_ven, fac_num) VALUES (3, '2024-04-03 12:00:00', '2024-04-12 12:00:00', 'F003');
INSERT INTO factura (fac_nit, fac_fec, fac_ven, fac_num) VALUES (4, '2024-04-04 13:00:00', '2024-04-13 13:00:00', 'F004');
INSERT INTO factura (fac_nit, fac_fec, fac_ven, fac_num) VALUES (5, '2024-04-05 14:00:00', '2024-04-14 14:00:00', 'F005');

-- Tabla: facturakardex
INSERT INTO facturakardex (fak_art, fak_cos, fak_fac, fak_pre, fak_tot_cos, fak_tot_ven, fak_uni, fak_nat)
VALUES (1, 100.0, 1, 150.0, 1000.0, 1500.0, 10, '-');
INSERT INTO facturakardex (fak_art, fak_cos, fak_fac, fak_pre, fak_tot_cos, fak_tot_ven, fak_uni, fak_nat)
VALUES (2, 200.0, 2, 250.0, 800.0, 1000.0, 4, '-');
INSERT INTO facturakardex (fak_art, fak_cos, fak_fac, fak_pre, fak_tot_cos, fak_tot_ven, fak_uni, fak_nat)
VALUES (3, 80.0, 3, 120.0, 400.0, 600.0, 5, '-');
INSERT INTO facturakardex (fak_art, fak_cos, fak_fac, fak_pre, fak_tot_cos, fak_tot_ven, fak_uni, fak_nat)
VALUES (4, 150.0, 4, 200.0, 300.0, 400.0, 2, '-');
INSERT INTO facturakardex (fak_art, fak_cos, fak_fac, fak_pre, fak_tot_cos, fak_tot_ven, fak_uni, fak_nat)
VALUES (5, 50.0, 5, 90.0, 500.0, 900.0, 10, '-');
