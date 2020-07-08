package com.senbusiness.ventematos.entities.sales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.senbusiness.ventematos.entities.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"telephone"})
)
public class Client extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    @Column(unique = true)
    private String matricule;
    private String nom;
    private String prenom;
    @Column(name = "telephone")
    private String telephone;
    private String adresse;
    private boolean archive;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Commande> commandes;

    @JsonProperty("nomComplet")
    public String getClient() {
        return prenom + " " + nom;
    }
}
