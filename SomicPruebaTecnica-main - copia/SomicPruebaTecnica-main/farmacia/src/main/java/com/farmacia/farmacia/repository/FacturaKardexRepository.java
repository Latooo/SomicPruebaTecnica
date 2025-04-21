package com.farmacia.farmacia.repository;

import com.farmacia.farmacia.model.FacturaKardex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaKardexRepository extends JpaRepository<FacturaKardex, Long> {
    // Puedes agregar más métodos si lo necesitas luego
}
