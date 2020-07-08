package com.senbusiness.ventematos.entities.sales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senbusiness.ventematos.entities.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Categorie extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String libelle;

    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
    private List<Produit> produits;
}
