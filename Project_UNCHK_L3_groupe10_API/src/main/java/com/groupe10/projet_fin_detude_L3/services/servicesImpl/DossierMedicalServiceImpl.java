package com.groupe10.projet_fin_detude_L3.services.servicesImpl;

import com.groupe10.projet_fin_detude_L3.dao.DossierMedicalRepository;
import com.groupe10.projet_fin_detude_L3.dao.PatientRepository;
import com.groupe10.projet_fin_detude_L3.models.DossierMedical;
import com.groupe10.projet_fin_detude_L3.models.Patient;
import com.groupe10.projet_fin_detude_L3.services.DossierMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierMedicalServiceImpl implements DossierMedicalService {

    @Autowired
    private DossierMedicalRepository dossierMedicalRepository;
    @Autowired
    private PatientRepository patientRepository;


    @Override
    public DossierMedical createDossierMedical(int idPatient,DossierMedical dossierMedical) {
        Patient patient = patientRepository.findById(idPatient).get();
        DossierMedical dossier = new DossierMedical();
        dossier.setAntecedant_medicaux(dossierMedical.getAntecedant_medicaux());
        dossier.setObservation(dossierMedical.getObservation());
        dossier.setActions_a_faire(dossierMedical.getActions_a_faire());
        dossier.setTemperature(dossierMedical.getTemperature());
        dossier.setTension(dossierMedical.getTension());
        dossier.setGlycemie(dossierMedical.getGlycemie());
        dossier.setPrescription(dossierMedical.getPrescription());
        dossier.setNaissance(dossierMedical.getNaissance());
        dossier.setNumero_de_lit(dossierMedical.getNumero_de_lit());
        dossier.setSituationMatrimoniale(dossierMedical.getSituationMatrimoniale());
        dossier.setDate_dexpiration(dossierMedical.getDate_dexpiration());
        DossierMedical dossierMedical1 = dossierMedicalRepository.save(dossier);
        patient.setDossierMedical(dossierMedical1);
        patientRepository.save(patient);

        return dossierMedical1;
    }

    @Override
    public List<DossierMedical> allDossierMedical() {
        return dossierMedicalRepository.findAll();
    }

    @Override
    public DossierMedical getOneDossierMedical(int idDossier) {
        return dossierMedicalRepository.findById(idDossier).get();
    }

    @Override
    public DossierMedical updateDossierMedical(int idDossier, DossierMedical dossierMedical) {
        DossierMedical dossierMedicalToUpdate = dossierMedicalRepository.findById(idDossier).get();
        dossierMedicalToUpdate.setAntecedant_medicaux(dossierMedical.getAntecedant_medicaux());
        dossierMedicalToUpdate.setObservation(dossierMedical.getObservation());
        dossierMedicalToUpdate.setActions_a_faire(dossierMedical.getActions_a_faire());
        dossierMedicalToUpdate.setTemperature(dossierMedical.getTemperature());
        dossierMedicalToUpdate.setTension(dossierMedical.getTension());
        dossierMedicalToUpdate.setGlycemie(dossierMedical.getGlycemie());
        dossierMedicalToUpdate.setPrescription(dossierMedical.getGlycemie());
        dossierMedicalToUpdate.setPrescription(dossierMedical.getPrescription());
        dossierMedicalToUpdate.setNaissance(dossierMedical.getNaissance());
        dossierMedicalToUpdate.setNumero_de_lit(dossierMedical.getNumero_de_lit());
        dossierMedicalToUpdate.setSituationMatrimoniale(dossierMedical.getSituationMatrimoniale());
        dossierMedicalToUpdate.setDate_dexpiration(dossierMedical.getDate_dexpiration());

        return dossierMedicalRepository.save(dossierMedicalToUpdate);
    }

    @Override
    public void deleteDossierMedical(int idDossier) {
        dossierMedicalRepository.deleteById(idDossier);
    }

    @Override
    public long nombreTotalDeDossierMedical() {
        return dossierMedicalRepository.findAll().stream().count();
    }
}
