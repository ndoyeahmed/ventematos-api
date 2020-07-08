package com.senbusiness.ventematos.entities.sales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senbusiness.ventematos.entities.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Facture extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    @Column(unique = true)
    private String numero;
    private Integer montantAPayer;
    private Integer montantRestant;
    private int statut;
    private boolean archive;

    @ManyToOne
    @JoinColumn(name = "commande", referencedColumnName = "id")
    private Commande commande;

    @OneToMany(mappedBy = "facture")
    @JsonIgnore
    private List<Paiement> paiements;
}
