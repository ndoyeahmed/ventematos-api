package com.senbusiness.ventematos.entities.sales;

import com.senbusiness.ventematos.entities.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Paiement extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private Timestamp datePaiement;
    private Integer montant;

    @ManyToOne
    @JoinColumn(name = "facture", referencedColumnName = "id")
    private Facture facture;
}
