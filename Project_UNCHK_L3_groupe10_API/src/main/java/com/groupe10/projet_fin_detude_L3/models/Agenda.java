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
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgenda;
    @Column
    private LocalDate jour_disponible;
    @Column
    private LocalTime heure_de_disponiblite;
    @Column
    private LocalTime heure_de_fin;



}
