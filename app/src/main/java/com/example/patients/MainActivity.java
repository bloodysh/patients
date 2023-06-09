package com.example.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.patients.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Patient unPatient;
    Services monService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.boutonValider.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String nom= binding.SaisieNom.getText().toString();
                String prenom= binding.SaisiePrenom.getText().toString();
                float taille = Float.parseFloat(binding.SaisieTaille.getText().toString())/100;
                int numChambre = Integer.valueOf(binding.SaisieChambre.getText().toString());
                int poids = Integer.valueOf(binding.SaisiePoids.getText().toString());
                String genrePatient = "";
                if(binding.radioButton3.isChecked()){
                    genrePatient="Masculin";
                }
                else{
                    genrePatient="Feminin";
                }

                unPatient= new Patient(nom, prenom, taille, numChambre, poids);
                monService.ajouterPatient(unPatient);

                Toast.makeText(MainActivity.this, unPatient.afficherPatient() ,Toast.LENGTH_LONG).show();
            }
        });

        monService = new Services("Service test");

        ArrayAdapter<Patient> adapter = new ArrayAdapter<Patient>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, monService.getPatients());
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerAfficherPatient.setAdapter(adapter);



        binding.boutonAfficherPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, unPatient.afficherPatient() ,Toast.LENGTH_LONG).show();
            }

        });
    };
}