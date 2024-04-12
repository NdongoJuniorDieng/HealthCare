package com.groupe10.projet_fin_detude_L3.services.servicesImpl;

import com.groupe10.projet_fin_detude_L3.dao.AgendaRepository;
import com.groupe10.projet_fin_detude_L3.dao.DocteurRepository;
import com.groupe10.projet_fin_detude_L3.models.Agenda;
import com.groupe10.projet_fin_detude_L3.models.Docteur;
import com.groupe10.projet_fin_detude_L3.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private DocteurRepository docteurRepository;

    @Override
    public Agenda createAgenda(int idDocteur,Agenda agenda) {
        Docteur docteur = docteurRepository.findById(idDocteur).get();
        Agenda agenda1 = new Agenda();
        agenda1.setJour_disponible(agenda.getJour_disponible());
        agenda1.setHeure_de_disponiblite(agenda.getHeure_de_disponiblite());
        agenda1.setHeure_de_fin(agenda.getHeure_de_fin());
        Agenda agenda2 = agendaRepository.save(agenda1);
        List<Agenda> agendaList = new ArrayList<>();
        agendaList.add(agenda2);
        docteur.setAgenda(agendaList);
        docteurRepository.save(docteur);
        return agenda2;
    }

    @Override
    public List<Agenda> allAgenda(int idDocteur) {
        Docteur docteur = docteurRepository.findById(idDocteur).get();
        return docteur.getAgenda();
    }

    @Override
    public Agenda getOneAgenda(int idAgenda) {
        return agendaRepository.findById(idAgenda).get();
    }

    @Override
    public Agenda updateAgenda(int idAgenda, Agenda agenda) {
        Agenda agendaToUpdate = agendaRepository.findById(idAgenda).get();
        agendaToUpdate.setJour_disponible(agenda.getJour_disponible());
        agendaToUpdate.setHeure_de_disponiblite(agenda.getHeure_de_disponiblite());
        agendaToUpdate.setHeure_de_fin(agenda.getHeure_de_fin());

        return agendaRepository.save(agendaToUpdate);
    }

    @Override
    public void deleteAgenda(int idAgenda) {
        agendaRepository.deleteById(idAgenda);
    }
}
