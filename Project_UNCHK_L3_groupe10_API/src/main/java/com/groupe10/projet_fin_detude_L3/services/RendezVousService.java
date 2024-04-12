package com.groupe10.projet_fin_detude_L3.services;

import com.groupe10.projet_fin_detude_L3.models.RendezVous;

import java.util.List;

public interface RendezVousService {

    public RendezVous createRendezVous(int idPatient, RendezVous rendezVous);
    public List<RendezVous> allRendezVous();
    public RendezVous getOneRendezVous(int idRendezVous);
    public RendezVous updateRendezVous(int idRendezVous, RendezVous rendezVous);
    public void deleteRendezVous(int idRendezVous,String telephone);
    public long nombreTotalDeRendezVous();

}
