package com.groupe10.projet_fin_detude_L3.services;

import com.groupe10.projet_fin_detude_L3.models.Agenda;

import java.util.List;

public interface AgendaService {

    public Agenda createAgenda(int idAgenda,Agenda agenda);
    public List<Agenda> allAgenda(int idDocteur);
    public Agenda getOneAgenda(int idAgenda);
    public Agenda updateAgenda(int idAgenda, Agenda agenda);
    public void deleteAgenda(int idAgenda);

}
