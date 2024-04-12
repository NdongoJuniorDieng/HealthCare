package com.groupe10.projet_fin_detude_L3.services;

import com.groupe10.projet_fin_detude_L3.models.Patient;

import java.util.List;

public interface PatientService {

    public Patient addPatient(Patient patient);
    public List<Patient> allPatient();
    public Patient getOnePatient(int idPatient);
    public Patient updatePatient(int idPatient, Patient patient);
    public void deletePatient(int idPatient);
    public long nombreTotalDePatient();

}
