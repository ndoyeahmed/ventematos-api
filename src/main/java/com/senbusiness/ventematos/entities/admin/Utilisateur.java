package com.senbusiness.ventematos.entities.admin;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senbusiness.ventematos.entities.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonFilter("passwordFilter")
public class Utilisateur  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    @Lob
    private String photo;
    private boolean statut;
    private boolean archive;
    @Column(columnDefinition = "boolean default false")
    private boolean passwordChange;

    @OneToMany(mappedBy = "utilisateur")
    private List<ProfilUtilisateur> profilUtilisateurs;
}
