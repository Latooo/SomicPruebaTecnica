package com.farmacia.farmacia.controller;

import com.farmacia.farmacia.model.Nit;
import com.farmacia.farmacia.repository.NitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nits")
@CrossOrigin(origins = "*") 
public class NitController {

    @Autowired
    private NitRepository nitRepository;

    @GetMapping
    public List<Nit> obtenerTodos() {
        return nitRepository.findAll();
    }

    
    @GetMapping("/{nitDoc}")
    public Nit obtenerPorDocumento(@PathVariable String nitDoc) {
        return nitRepository.findByNitDoc(nitDoc);
    }

    
    @PostMapping
    public Nit guardarNit(@RequestBody Nit nit) {
        if (nit == null || nit.getNitDoc() == null || nit.getNitNom() == null) {
            throw new IllegalArgumentException("Datos de NIT incompletos");
        }
        return nitRepository.save(nit);
    }
}
