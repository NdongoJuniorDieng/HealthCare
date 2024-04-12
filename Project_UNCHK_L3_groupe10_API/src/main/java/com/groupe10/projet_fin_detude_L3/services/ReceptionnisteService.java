package com.groupe10.projet_fin_detude_L3.services;

import com.groupe10.projet_fin_detude_L3.models.Receptionniste;

import java.util.List;

public interface ReceptionnisteService {

    public Receptionniste addReceptionniste(Receptionniste receptionniste);
    public List<Receptionniste> allReceptionniste();
    public Receptionniste getOneReceptionniste(int idReceptionniste);
    public Receptionniste updateReceptionniste(int idReceptionniste, Receptionniste receptionniste);
    public void deleteReceptionniste(int idReceptionniste);
    public long nombreTotalDeReceptionniste();

}
