package com.groupe10.projet_fin_detude_L3.dao;

import com.groupe10.projet_fin_detude_L3.models.Receptionniste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionnisteRepository extends JpaRepository<Receptionniste,Integer> {
}
