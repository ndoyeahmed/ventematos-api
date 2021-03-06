package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
