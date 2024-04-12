package com.groupe10.projet_fin_detude_L3.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRendezVous;
    @Column
    private LocalDate date_du_rv;
    @Column
    private LocalTime heure_de_debut;
    @Column
    private LocalDate creation = LocalDate.now();
    @Column
    private String telephone;
    @Column
    private boolean status;

}
