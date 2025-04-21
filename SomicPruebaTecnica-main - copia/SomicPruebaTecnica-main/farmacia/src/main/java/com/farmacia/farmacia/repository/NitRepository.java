package com.farmacia.farmacia.repository;

import com.farmacia.farmacia.model.Nit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NitRepository extends JpaRepository<Nit, Long> {
    Nit findByNitDoc(String nitDoc);
}
