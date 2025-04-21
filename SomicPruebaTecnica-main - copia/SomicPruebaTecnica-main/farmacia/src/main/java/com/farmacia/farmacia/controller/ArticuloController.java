package com.farmacia.farmacia.controller;

import com.farmacia.farmacia.model.Articulo;
import com.farmacia.farmacia.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
@CrossOrigin(origins = "*") 
public class ArticuloController {

    @Autowired
    private ArticuloRepository articuloRepository;

    
    @GetMapping
    public List<Articulo> obtenerTodos() {
        return articuloRepository.findAll();
    }


    @GetMapping("/{codigo}")
    public Articulo obtenerPorCodigo(@PathVariable String codigo) {
        return articuloRepository.findByArtCod(codigo);
    }

    
    @PostMapping
    public Articulo guardarArticulo(@RequestBody Articulo articulo) {
        if (articulo == null || articulo.getArtCod() == null || articulo.getArtNom() == null) {
            throw new IllegalArgumentException("Datos del artículo incompletos");
        }
        return articuloRepository.save(articulo);
    }
}
