package com.farmacia.farmacia.controller;

import com.farmacia.farmacia.model.Nit;
import com.farmacia.farmacia.repository.NitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nits")
@CrossOrigin(origins = "*") // Permitir peticiones desde cualquier origen (ideal para desarrollo)
public class NitController {

    @Autowired
    private NitRepository nitRepository;

    // Obtener todos los NITs
    @GetMapping
    public List<Nit> obtenerTodos() {
        return nitRepository.findAll();
    }

    // Obtener un NIT por número de documento
    @GetMapping("/{nitDoc}")
    public Nit obtenerPorDocumento(@PathVariable String nitDoc) {
        return nitRepository.findByNitDoc(nitDoc);
    }

    // Guardar un nuevo NIT
    @PostMapping
    public Nit guardarNit(@RequestBody Nit nit) {
        if (nit == null || nit.getNitDoc() == null || nit.getNitNom() == null) {
            throw new IllegalArgumentException("Datos de NIT incompletos");
        }
        return nitRepository.save(nit);
    }
}
