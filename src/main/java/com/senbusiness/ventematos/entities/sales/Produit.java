package com.senbusiness.ventematos.entities.sales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senbusiness.ventematos.entities.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Produit extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    @Column(unique = true)
    private String code;
    private String libelle;
    private Integer quantiteStock;
    private String description;
    @Lob
    private String image;
    private Integer prixNormal;
    private Integer prixMinimal;
    private boolean archive;

    @ManyToOne
    @JoinColumn(name = "categorie", referencedColumnName = "id")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    @JsonIgnore
    private List<LineCommande> lineCommandes;
}
