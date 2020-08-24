package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Commande;
import com.senbusiness.ventematos.entities.sales.LineCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LineCommandeRepository extends JpaRepository<LineCommande, Long> {

    Optional<List<LineCommande>> findAllByCommande(Commande commande);
}
