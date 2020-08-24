package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<List<Client>> findAllByArchive(boolean archive);
}
