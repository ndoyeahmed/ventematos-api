package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.LineCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineCommandeRepository extends JpaRepository<LineCommande, Long> {
}
