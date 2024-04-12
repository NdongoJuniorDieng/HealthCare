package com.groupe10.projet_fin_detude_L3.dao;

import com.groupe10.projet_fin_detude_L3.models.Patient;
import com.groupe10.projet_fin_detude_L3.models.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Patient findByTelephone(String s);
}
