package com.groupe10.projet_fin_detude_L3.services;

import com.groupe10.projet_fin_detude_L3.models.DossierMedical;

import java.util.List;

public interface DossierMedicalService {

    public DossierMedical createDossierMedical(int idPatient,DossierMedical dossierMedical);
    public List<DossierMedical> allDossierMedical();
    public DossierMedical getOneDossierMedical(int idDossier);
    public DossierMedical updateDossierMedical(int idDossier, DossierMedical dossierMedical);
    public void deleteDossierMedical(int idDossier);
    public long nombreTotalDeDossierMedical();

}
