package com.senbusiness.ventematos.entities.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senbusiness.ventematos.entities.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Profil extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String libelle;
    private String description;

    @OneToMany(mappedBy = "profil")
    @JsonIgnore
    private List<ProfilUtilisateur> profilUtilisateurs;
}
