package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
}
