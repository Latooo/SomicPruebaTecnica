package com.farmacia.farmacia.controller;

import com.farmacia.farmacia.model.FacturaKardex;
import com.farmacia.farmacia.repository.FacturaKardexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturakardex")
@CrossOrigin(origins = "*")
public class FacturaKardexController {

    @Autowired
    private FacturaKardexRepository facturaKardexRepository;

    // Obtener todos los registros del kardex
    @GetMapping
    public List<FacturaKardex> obtenerTodos() {
        return facturaKardexRepository.findAll();
    }

    // Guardar un nuevo movimiento de factura en el kardex
    @PostMapping
public FacturaKardex guardarFacturaKardex(@RequestBody FacturaKardex facturaKardex) {
    if (facturaKardex == null || facturaKardex.getFactura() == null || facturaKardex.getArticulo() == null) {
        throw new IllegalArgumentException("Datos del kardex incompletos");
    }
    return facturaKardexRepository.save(facturaKardex);
}
}
