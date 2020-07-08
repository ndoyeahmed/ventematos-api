package com.senbusiness.ventematos.repositories.sales;

import com.senbusiness.ventematos.entities.sales.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
