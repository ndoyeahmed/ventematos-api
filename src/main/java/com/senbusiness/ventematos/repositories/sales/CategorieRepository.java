package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    @Query("select c from Categorie c where upper(c.libelle) like upper(:libelle) ")
    Optional<Categorie> findByLibelle(@Param("libelle") String libelle);
}
