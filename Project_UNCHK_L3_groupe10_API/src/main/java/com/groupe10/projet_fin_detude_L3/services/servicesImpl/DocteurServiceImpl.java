package com.groupe10.projet_fin_detude_L3.services.servicesImpl;

import com.groupe10.projet_fin_detude_L3.dao.DocteurRepository;
import com.groupe10.projet_fin_detude_L3.dao.UsersRepository;
import com.groupe10.projet_fin_detude_L3.models.Docteur;
import com.groupe10.projet_fin_detude_L3.services.DocteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocteurServiceImpl implements DocteurService {

   @Autowired
   private DocteurRepository docteurRepository;


    @Override
    public Docteur addDocteur(Docteur docteur) {
        return docteurRepository.save(docteur);
    }

    @Override
    public List<Docteur> allDocteur() {
        return docteurRepository.findAll();
    }

    @Override
    public Docteur getOneDocteur(int idDocteur) {
        return docteurRepository.findById(idDocteur).get();
    }

    @Override
    public Docteur updateDocteur(int idDocteur, Docteur docteur) {
        Docteur docteurToUpdate = docteurRepository.findById(idDocteur).get();
        docteurToUpdate.setPrenom(docteur.getPrenom());
        docteurToUpdate.setNom(docteur.getNom());
        docteurToUpdate.setEmail(docteur.getEmail());
        docteurToUpdate.setPassword((docteur.getPassword()));
        docteurToUpdate.setTelephone(docteur.getTelephone());
        docteurToUpdate.setAdresse(docteur.getAdresse());
        docteurToUpdate.setDisponibilite(docteur.isDisponibilite());
        docteur.setProfession(docteur.getProfession());
        docteurToUpdate.setRole(docteur.getRole());
        docteurToUpdate.setEnabled(docteur.isEnabled());

        return null;
    }

    @Override
    public void deleteDocteur(int idDocteur) {
        docteurRepository.deleteById(idDocteur);
    }

    @Override
    public long nombreTotalDeDocteur() {
        return docteurRepository.findAll().stream().count();
    }

    @Override
    public long nombreDeDocteurDisponible() {
        return docteurRepository.findAll().stream().filter(d -> d.isDisponibilite() == true).count();
    }
}
