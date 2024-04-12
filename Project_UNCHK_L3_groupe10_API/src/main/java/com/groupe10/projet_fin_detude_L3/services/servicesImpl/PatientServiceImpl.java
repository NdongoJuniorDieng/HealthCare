package com.groupe10.projet_fin_detude_L3.services.servicesImpl;

import com.groupe10.projet_fin_detude_L3.dao.PatientRepository;
import com.groupe10.projet_fin_detude_L3.dao.UsersRepository;
import com.groupe10.projet_fin_detude_L3.models.Patient;
import com.groupe10.projet_fin_detude_L3.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> allPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getOnePatient(int idPatient) {
        return patientRepository.findById(idPatient).get();
    }

    @Override
    public Patient updatePatient(int idPatient, Patient patient) {
        Patient patientToUpdate = patientRepository.findById(idPatient).get();
        patientToUpdate.setPrenom(patient.getPrenom());
        patientToUpdate.setNom(patient.getNom());
        patientToUpdate.setEmail(patient.getEmail());
        patientToUpdate.setPassword(patient.getPassword());
        patientToUpdate.setTelephone(patient.getTelephone());
        patientToUpdate.setAdresse(patient.getAdresse());
        patientToUpdate.setMaladie(patient.getMaladie());
        patientToUpdate.setRole(patient.getRole());
        patientToUpdate.setEnabled(patient.isEnabled());

        return patientRepository.save(patientToUpdate);
    }

    @Override
    public void deletePatient(int idPatient) {
        patientRepository.deleteById(idPatient);
    }

    @Override
    public long nombreTotalDePatient() {
        return patientRepository.findAll().stream().count();
    }
}
