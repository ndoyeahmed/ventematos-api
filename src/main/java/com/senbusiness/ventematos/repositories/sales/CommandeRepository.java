package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,  Long> {
}
