package com.example.tindnet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SingUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sing_up);
    }

    public void abrirSingUpClient(View view) {
        // Crear un Intent para abrir la actividad de la página de login
        Intent intent = new Intent(this, SingUpClient.class);
        startActivity(intent); // Iniciar la actividad
    }

    public void abrirSingUpCompany(View view) {
        // Crear un Intent para abrir la actividad de la página de login
        Intent intent = new Intent(this, SingUpCompany.class);
        startActivity(intent); // Iniciar la actividad
    }



}