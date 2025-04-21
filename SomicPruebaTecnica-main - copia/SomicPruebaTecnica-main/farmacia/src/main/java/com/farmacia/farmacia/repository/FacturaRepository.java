package com.farmacia.farmacia.repository;

import com.farmacia.farmacia.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    Factura findByFacNum(String facNum);
}
