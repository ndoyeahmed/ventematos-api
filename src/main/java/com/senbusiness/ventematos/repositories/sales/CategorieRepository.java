package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
