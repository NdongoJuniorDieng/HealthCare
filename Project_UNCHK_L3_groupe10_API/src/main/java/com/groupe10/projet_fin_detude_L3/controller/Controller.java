package com.groupe10.projet_fin_detude_L3.controller;

import com.groupe10.projet_fin_detude_L3.models.*;
import com.groupe10.projet_fin_detude_L3.services.PatientService;
import com.groupe10.projet_fin_detude_L3.services.servicesImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping(path = "/controller")
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {

    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private DocteurServiceImpl docteurService;
    @Autowired
    private ReceptionnisteServiceImpl receptionnisteService;
    @Autowired
    private PatientServiceImpl patientService;
    @Autowired
    private DossierMedicalServiceImpl dossierMedicalService;
    @Autowired
    private RendezVousServiceImpl rendezVousService;
    @Autowired
    private AgendaServiceImpl agendaService;

    //-----------------------------------

    @PostMapping(path = "/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        return ResponseEntity.ok(adminService.addAdmin(admin));
    }

    @GetMapping(path = "/getOneAdmin/{idPatient}")
    public ResponseEntity<Admin> getOneAdmin(@PathVariable int idAdmin){
        return ResponseEntity.ok(adminService.getOneAdmin(idAdmin));
    }

    @PutMapping(path = "/updateAdmin/{idAdmin}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int idAdmin, @RequestBody Admin admin){
        return ResponseEntity.ok(adminService.updateAdmin(idAdmin, admin));
    }

    //-----------------------------------

    @PostMapping(path = "/addDocteur")
    public ResponseEntity<Docteur> addDocteur(@RequestBody Docteur docteur){
        return ResponseEntity.ok(docteurService.addDocteur(docteur));
    }

    @GetMapping(path = "/findAllDocteur")
    public ResponseEntity<List<Docteur>> retrieveAllDocteur(){
        return ResponseEntity.ok(docteurService.allDocteur());
    }

    @GetMapping(path = "/getOneDocteur/{idDocteur}")
    public ResponseEntity<Docteur> getOneDocteur(@PathVariable int idDocteur){
        return ResponseEntity.ok(docteurService.getOneDocteur(idDocteur));
    }

    @PutMapping(path = "/updateDocteur/{idDocteur}")
    public ResponseEntity<Docteur> updateDocteur(@PathVariable int idDocteur, @RequestBody Docteur docteur){
        return ResponseEntity.ok(docteurService.updateDocteur(idDocteur, docteur));
    }

    @DeleteMapping(path = "/deleteDocteur/{idDocteur}")
    public void deleteDocteur(@PathVariable int idDocteur){
        docteurService.deleteDocteur(idDocteur);
    }

    @GetMapping(path = "/getAvailableDocteur")
    public long docteurDisponible(){
        return docteurService.nombreDeDocteurDisponible();
    }

    @GetMapping(path = "/totalNumberOfDocteur")
    public long nombreTotalDeDocteur(){
        return docteurService.nombreTotalDeDocteur();
    }

    //--------------------------------------------------

    @PostMapping(path = "/addReceptionniste")
    public ResponseEntity<Receptionniste> addReceptionniste(@RequestBody Receptionniste receptionniste){
        return ResponseEntity.ok(receptionnisteService.addReceptionniste(receptionniste));
    }

    @GetMapping(path = "/getAllReceptionniste")
    public ResponseEntity<List<Receptionniste>> retrieveAllReceptionniste(){
        return ResponseEntity.ok(receptionnisteService.allReceptionniste());
    }

    @GetMapping(path = "/getOneReceptionniste/{idReceptionniste}")
    public ResponseEntity<Receptionniste> getOneReceptionniste(@PathVariable int idReceptionniste){
        return ResponseEntity.ok(receptionnisteService.getOneReceptionniste(idReceptionniste));
    }

    @PutMapping(path = "/updateReceptionniste/{idReceptionniste}")
    public ResponseEntity<Receptionniste> updateReceptionniste(@PathVariable int idReceptionniste, @RequestBody Receptionniste receptionniste){
        return ResponseEntity.ok(receptionnisteService.updateReceptionniste(idReceptionniste, receptionniste));
    }

    @DeleteMapping(path = "/deleteReceptionniste/{idReceptionniste}")
    public void deleteReceptionniste(@PathVariable int idReceptionniste){
        receptionnisteService.deleteReceptionniste(idReceptionniste);
    }

    @GetMapping(path = "/totalNumberOfReceptionniste")
    public long nombreTotalDeReceptionniste(){
        return receptionnisteService.nombreTotalDeReceptionniste();
    }

    //-----------------------------------------------

    @PostMapping(path = "/addPatient")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    @GetMapping(path = "/getAllPatient")
    public ResponseEntity<List<Patient>> retrieveAllPatient(){
        return ResponseEntity.ok(patientService.allPatient());
    }

    @GetMapping(path = "/getOnePatient/{idPatient}")
    public ResponseEntity<Patient> getOnePatient(@PathVariable int idPatient){
        return ResponseEntity.ok(patientService.getOnePatient(idPatient));
    }

    @PutMapping(path = "/updatePatient/{idPatient}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int idPatient,@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.updatePatient(idPatient, patient));
    }

    @DeleteMapping(path = "/deletePatient/{idPatient}")
    public void deletePatient(@PathVariable int idPatient){
        patientService.deletePatient(idPatient);
    }

    @GetMapping(path = "/totalNumberOfPatient")
    public long nombreTotalDePatient(){
        return patientService.nombreTotalDePatient();
    }

    //--------------------------------------------------

    @PostMapping(path = "/createDossierMedical/{idPatient}")
    public ResponseEntity<DossierMedical> createDossier(@PathVariable int idPatient,@RequestBody DossierMedical dossierMedical){
        return ResponseEntity.ok(dossierMedicalService.createDossierMedical(idPatient,dossierMedical));
    }

    @GetMapping(path = "/getAllDossierMedical")
    public ResponseEntity<List<DossierMedical>> retrieveAllDossierMedical(){
        return ResponseEntity.ok(dossierMedicalService.allDossierMedical());
    }

    @GetMapping(path = "/getOneDossierMedical/{idDossier}")
    public ResponseEntity<DossierMedical> getOneDossier(@PathVariable int idDossier){
        return ResponseEntity.ok(dossierMedicalService.getOneDossierMedical(idDossier));
    }

    @PutMapping(path = "/updateDossierMedical/{idDossier}")
    public ResponseEntity<DossierMedical> updateDossier(@PathVariable int idDossier, @RequestBody DossierMedical dossierMedical){
        return ResponseEntity.ok(dossierMedicalService.updateDossierMedical(idDossier, dossierMedical));
    }

    @DeleteMapping(path = "/deleteDossierMedical/{idDossier}")
    public void deleteDossierMedical(@PathVariable int idDossier){
        dossierMedicalService.deleteDossierMedical(idDossier);
    }

    @GetMapping(path = "/totalNumberOfDossierMedical")
    public long nombreTotalDeDossierMedical(){
        return dossierMedicalService.nombreTotalDeDossierMedical();
    }

    //----------------------------------------------------

    @PostMapping(path = "/createRendezVous/{idPatient}")
    public ResponseEntity<RendezVous> createRendezVous(@PathVariable int idPatient,@RequestBody RendezVous rendezVous){
        return ResponseEntity.ok(rendezVousService.createRendezVous(idPatient,rendezVous));
    }

    @GetMapping(path = "/getAllRendezVous")
    public ResponseEntity<List<RendezVous>> retrieveAllRendezVous(){
        return ResponseEntity.ok(rendezVousService.allRendezVous());
    }

    @GetMapping(path = "/getOneRendezVous/{idRendezVous}")
    public ResponseEntity<RendezVous> getOneRendezVous(@PathVariable int idRendezVous){
        return ResponseEntity.ok(rendezVousService.getOneRendezVous(idRendezVous));
    }

    @PutMapping(path = "/updateRendezVous/{idRendezVous}")
    public ResponseEntity<RendezVous> updateRendezVous(@PathVariable int idRendezVous, @RequestBody RendezVous rendezVous){
        return ResponseEntity.ok(rendezVousService.updateRendezVous(idRendezVous, rendezVous));
    }

    @DeleteMapping(path = "/deleteRendezVous/{idRendezVous}/{telephone}")
    public void deleteRendezVous(@PathVariable int idRendezVous, @PathVariable String telephone){
        rendezVousService.deleteRendezVous(idRendezVous,telephone);
    }

    @GetMapping(path = "/totalNumberOfRendezVous")
    public long nombreTotalDeRendezVous(){
        return rendezVousService.nombreTotalDeRendezVous();
    }

    //----------------------------------------------------

    @PostMapping(path = "/createAgenda/{idDocteur}")
    public ResponseEntity<Agenda> createAgenda(@PathVariable int idDocteur,@RequestBody Agenda agenda){
        return ResponseEntity.ok(agendaService.createAgenda(idDocteur,agenda));
    }

    @GetMapping(path = "/getAllAgenda/{idDocteur}")
    public ResponseEntity<List<Agenda>> retrieveAllAgenda(@PathVariable int idDocteur){
        return ResponseEntity.ok(agendaService.allAgenda(idDocteur));
    }

    @GetMapping(path = "/getOneAgenda/{idAgenda}")
    public ResponseEntity<Agenda> getOneAgenda(@PathVariable int idAgenda){
        return ResponseEntity.ok(agendaService.getOneAgenda(idAgenda));
    }

    @PutMapping(path = "/updateAgenda/{idAgenda}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable int idAgenda, @RequestBody Agenda agenda){
        return ResponseEntity.ok(agendaService.updateAgenda(idAgenda, agenda));
    }

    @DeleteMapping(path = "/deleteAgenda/{idAgenda}")
    public void deleteAgenda(@PathVariable int idAgenda){
        agendaService.deleteAgenda(idAgenda);
    }



}
