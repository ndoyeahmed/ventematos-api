package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
