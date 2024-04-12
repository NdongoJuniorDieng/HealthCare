package com.groupe10.projet_fin_detude_L3.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Docteur extends Users{

    @Column
    private boolean disponibilite;
    @Column
    private String profession;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Agenda> agenda;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RendezVous> rendezVousList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Patient> patientList;

}
