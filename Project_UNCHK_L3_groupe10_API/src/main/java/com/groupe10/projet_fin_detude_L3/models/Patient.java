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
public class Patient extends Users{

    @Column
    private String maladie;
    @OneToOne(cascade = CascadeType.ALL)
    private DossierMedical dossierMedical;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RendezVous> rendezVousList;

}
