package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Categorie;
import com.senbusiness.ventematos.entities.sales.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @Query("select max(p.id) from Produit p")
    Optional<Integer> getMaxId();

    Optional<List<Produit>> findAllByArchiveFalseAndCategorie(Categorie categorie);

    Optional<List<Produit>> findAllByArchive(boolean archive);
}
