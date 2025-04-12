package com.farmacia.farmacia.controller;

import com.farmacia.farmacia.model.Factura;
import com.farmacia.farmacia.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    // Obtener todas las facturas
    @GetMapping
    public List<Factura> obtenerTodas() {
        return facturaRepository.findAll();
    }

    // Obtener una factura por su número
    @GetMapping("/{numero}")
    public Factura obtenerPorNumero(@PathVariable String numero) {
        return facturaRepository.findByFacNum(numero);
    }

    // Guardar una nueva factura
    @PostMapping
    public Factura guardarFactura(@RequestBody Factura factura) {
        if (factura == null || factura.getFacNum() == null || factura.getFacFec() == null) {
            throw new IllegalArgumentException("Datos de la factura incompletos");
        }
        return facturaRepository.save(factura);
    }
}
