package com.groupe10.projet_fin_detude_L3.services.servicesImpl;

import com.groupe10.projet_fin_detude_L3.dao.ReceptionnisteRepository;
import com.groupe10.projet_fin_detude_L3.dao.UsersRepository;
import com.groupe10.projet_fin_detude_L3.models.Receptionniste;
import com.groupe10.projet_fin_detude_L3.services.ReceptionnisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionnisteServiceImpl implements ReceptionnisteService {

    @Autowired
    private ReceptionnisteRepository receptionnisteRepository;

    @Override
    public Receptionniste addReceptionniste(Receptionniste receptionniste) {
        Receptionniste receptionniste1 = new Receptionniste();
        receptionniste1.setPrenom(receptionniste.getPrenom());
        receptionniste1.setNom(receptionniste.getNom());
        receptionniste1.setEmail(receptionniste.getEmail());
        receptionniste1.setPassword(receptionniste.getPassword());
        receptionniste1.setTelephone(receptionniste.getTelephone());
        receptionniste1.setAdresse(receptionniste.getAdresse());
        receptionniste1.setRole(receptionniste.getRole());
        return receptionnisteRepository.save(receptionniste1);
    }

    @Override
    public List<Receptionniste> allReceptionniste() {
        return receptionnisteRepository.findAll();
    }

    @Override
    public Receptionniste getOneReceptionniste(int idReceptionniste) {
        return receptionnisteRepository.findById(idReceptionniste).get();
    }

    @Override
    public Receptionniste updateReceptionniste(int idReceptionniste, Receptionniste receptionniste) {
        Receptionniste receptionnisteToUpdate = receptionnisteRepository.findById(idReceptionniste).get();
        receptionnisteToUpdate.setPrenom(receptionniste.getPrenom());
        receptionnisteToUpdate.setNom(receptionniste.getNom());
        receptionnisteToUpdate.setEmail(receptionniste.getEmail());
        receptionnisteToUpdate.setPassword(receptionniste.getPassword());
        receptionnisteToUpdate.setTelephone(receptionniste.getTelephone());
        receptionnisteToUpdate.setAdresse(receptionniste.getAdresse());
        receptionnisteToUpdate.setRole(receptionniste.getRole());
        receptionnisteToUpdate.setEnabled(receptionniste.isEnabled());

        return receptionnisteRepository.save(receptionnisteToUpdate);
    }

    @Override
    public void deleteReceptionniste(int idReceptionniste) {
        receptionnisteRepository.deleteById(idReceptionniste);
    }

    @Override
    public long nombreTotalDeReceptionniste() {
        return receptionnisteRepository.findAll().stream().count();
    }
}
