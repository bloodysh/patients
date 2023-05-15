package com.example.patients;
import java.util.ArrayList;

public class Services {
    private String nom;
    private ArrayList<Patient> patients;

    public Services(String nom){
        this.nom= nom;
        patients= new ArrayList<Patient>();
    }

    public void ajouterPatient(Patient patient) {patients.add(patient);}

    public ArrayList<Patient> getPatients() {return patients;}

}
