package com.groupe10.projet_fin_detude_L3.models;

import com.groupe10.projet_fin_detude_L3.models.enums.SituationMatrimoniale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DossierMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDossier;
    @Column
    private String antecedant_medicaux;
    @Column
    private String observation;
    @Column
    private String actions_a_faire;
    @Column
    private String temperature;
    @Column
    private String tension;
    @Column
    private String glycemie;
    @Column
    private String prescription;
    @Column
    private LocalDate naissance;
    @Column
    private String matricule = ( Math.random() * 1000 ) + 10 +"DM"+LocalDate.now();
    @Column
    private String numero_de_lit;
    @Column
    private SituationMatrimoniale situationMatrimoniale;
    @Column
    private LocalDate date_dexpiration;
    @Column
    private LocalDate creation = LocalDate.now();

}
