package com.farmacia.farmacia.repository;

import com.farmacia.farmacia.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    Articulo findByArtCod(String artCod);
}
