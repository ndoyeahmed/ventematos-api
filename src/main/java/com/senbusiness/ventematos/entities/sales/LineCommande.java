package com.senbusiness.ventematos.entities.sales;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LineCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private Integer prixVenteUnitaire;
    private Integer prixTotal;
    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "produit", referencedColumnName = "id")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "commande", referencedColumnName = "id")
    private Commande commande;
}
