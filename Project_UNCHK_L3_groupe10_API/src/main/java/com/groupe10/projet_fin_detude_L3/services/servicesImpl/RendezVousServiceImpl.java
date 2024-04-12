package com.groupe10.projet_fin_detude_L3.services.servicesImpl;

import com.groupe10.projet_fin_detude_L3.dao.PatientRepository;
import com.groupe10.projet_fin_detude_L3.dao.RendezVousRepository;
import com.groupe10.projet_fin_detude_L3.models.Patient;
import com.groupe10.projet_fin_detude_L3.models.RendezVous;
import com.groupe10.projet_fin_detude_L3.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RendezVousServiceImpl implements RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public RendezVous createRendezVous(int idPatient,RendezVous rendezVous) {
        Patient patient = patientRepository.findById(idPatient).get();
        RendezVous rendezVous1 = new RendezVous();
        rendezVous1.setDate_du_rv(rendezVous.getDate_du_rv());
        rendezVous1.setHeure_de_debut(rendezVous.getHeure_de_debut());
        rendezVous1.setTelephone(rendezVous.getTelephone());
        rendezVous1.setStatus(rendezVous.isStatus());
        RendezVous rendezVous2 = rendezVousRepository.save(rendezVous);
        List<RendezVous> rendezVousList = new ArrayList<>();
        rendezVousList.add(rendezVous2);
        patient.setRendezVousList(rendezVousList);
        patientRepository.save(patient);
        return rendezVous2;
    }

    @Override
    public List<RendezVous> allRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous getOneRendezVous(int idRendezVous) {
        return rendezVousRepository.findById(idRendezVous).get();
    }

    @Override
    public RendezVous updateRendezVous(int idRendezVous, RendezVous rendezVous) {
        RendezVous rendezVousToUpdate = rendezVousRepository.findById(idRendezVous).get();
        rendezVousToUpdate.setDate_du_rv(rendezVous.getDate_du_rv());
        rendezVousToUpdate.setHeure_de_debut(rendezVous.getHeure_de_debut());
        rendezVousToUpdate.setStatus(rendezVous.isStatus());
        rendezVousToUpdate.setTelephone(rendezVous.getTelephone());

        return rendezVousRepository.save(rendezVousToUpdate);
    }

    @Override
    public void deleteRendezVous(int idRendezVous,String telephone) {
        Patient patient = patientRepository.findAll().stream().filter(p -> p.getTelephone() == telephone).findFirst().get();
        List<RendezVous> rendezVousList = patient.getRendezVousList();
        RendezVous rendezVous = rendezVousRepository.findById(idRendezVous).get();
        for(RendezVous rv: rendezVousList){
            if(rv.getIdRendezVous() == idRendezVous){
                rendezVousList.remove(rendezVous);
            }
        }
        patient.setRendezVousList(rendezVousList);
        patientRepository.save(patient);
        rendezVousRepository.deleteById(idRendezVous);
    }

    @Override
    public long nombreTotalDeRendezVous() {
        return rendezVousRepository.findAll().stream().count();
    }


}
