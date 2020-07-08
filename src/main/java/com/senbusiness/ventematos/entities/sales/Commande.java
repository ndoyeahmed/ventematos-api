package com.senbusiness.ventematos.entities.sales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senbusiness.ventematos.entities.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Commande extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    @Column(unique = true)
    private String code;
    private Timestamp dateCommande;
    private Timestamp dateLivraison;
    private int statut;
    private boolean archive;

    @OneToMany(mappedBy = "commande")
    @JsonIgnore
    private List<LineCommande> lineCommandes;

    @OneToMany(mappedBy = "commande")
    @JsonIgnore
    private List<Facture> factures;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;
}
