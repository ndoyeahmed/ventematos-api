package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,  Long> {
    @Query("select max(c.id) from Commande c")
    Optional<Integer> getMaxId();

    Optional<List<Commande>> findAllByArchiveAndStatut(boolean archive, int statut);
}
