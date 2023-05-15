package com.example.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.patients.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Patient unPatient;

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

                unPatient= new Patient(nom, prenom, taille, numChambre, poids);

                Toast.makeText(MainActivity.this, unPatient.afficherPatient() ,Toast.LENGTH_LONG).show();
            }
        });

    };
}