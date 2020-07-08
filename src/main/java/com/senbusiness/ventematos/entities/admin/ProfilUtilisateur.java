package com.senbusiness.ventematos.entities.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senbusiness.ventematos.entities.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class ProfilUtilisateur  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private Timestamp date;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn
    private Profil profil;
}
