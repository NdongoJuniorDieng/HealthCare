package com.groupe10.projet_fin_detude_L3.services;

import com.groupe10.projet_fin_detude_L3.models.Docteur;

import java.util.List;

public interface DocteurService {

    public Docteur addDocteur(Docteur docteur);
    public List<Docteur> allDocteur();
    public Docteur getOneDocteur(int idDocteur);
    public Docteur updateDocteur(int idDocteur, Docteur docteur);
    public void deleteDocteur(int idDocteur);
    public long nombreTotalDeDocteur();
    public long nombreDeDocteurDisponible();

}
