package com.example.patients;

public class Patient {
    private String nom;
    private String prenom;
    private float taille;
    private int poids;
    private int numChambre;

    public Patient(String nom, String prenom, float taille, int poids, int numChambre) {
        this.nom = nom;
        this.prenom = prenom;
        this.taille = taille;
        this.poids = poids;
        this.numChambre = numChambre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(int numChambre) {
        this.numChambre = numChambre;
    }
    public float calculerImc(){
        float inc=0;
        if(taille>0 && poids>0){
            inc= Math.round(poids/(taille*taille));
        }
        return inc;
    }
    public String IndicateurImc (){
        String body;
        if (calculerImc() < 18.5){
            body= " Vous etes maigres";
        }
        else if(calculerImc() >= 18.25 && calculerImc()<25){
            body= " Vous êtes normales";
        }
        else if(calculerImc() >= 25 && calculerImc()<30){
            body= " Vous êtes en surpoids";
        }
        else if(calculerImc() >= 30 && calculerImc()<35){
            body= " Obesité modérée";
        }
        else if(calculerImc() >= 35 && calculerImc()<40){
            body= " Obesité sévère";
        }
        else{
            body= " Obesité massive";
        }
        return body;
    }
    public String toString(){
        return nom +" "+ prenom + " votre IMC est :" + calculerImc();

    }
    public String afficherPatient(){
        return nom +" " + prenom +" :" + taille +"m, chambre n° "+ numChambre +", "+ poids +"kg, IMC: "+ calculerImc() +" " + IndicateurImc();
    }
}

