package com.farmacia.farmacia.controller;

import com.farmacia.farmacia.model.Articulo;
import com.farmacia.farmacia.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (útil para pruebas)
public class ArticuloController {

    @Autowired
    private ArticuloRepository articuloRepository;

    // Obtener todos los artículos
    @GetMapping
    public List<Articulo> obtenerTodos() {
        return articuloRepository.findAll();
    }

    // Obtener un artículo por su código
    @GetMapping("/{codigo}")
    public Articulo obtenerPorCodigo(@PathVariable String codigo) {
        return articuloRepository.findByArtCod(codigo);
    }

    // Guardar un nuevo artículo
    @PostMapping
    public Articulo guardarArticulo(@RequestBody Articulo articulo) {
        if (articulo == null || articulo.getArtCod() == null || articulo.getArtNom() == null) {
            throw new IllegalArgumentException("Datos del artículo incompletos");
        }
        return articuloRepository.save(articulo);
    }
}
