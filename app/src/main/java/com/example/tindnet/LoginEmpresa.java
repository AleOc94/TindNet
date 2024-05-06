package com.example.tindnet;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginEmpresa extends AppCompatActivity {

    private EditText editRepetirContrasena;

    private EditText editContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_empresa);

        editContrasena = findViewById(R.id.editContrasena);

        // Establecer longitud mínima de la contraseña
        int minLength = 8; // Cambia esto al valor mínimo deseado
        editContrasena.setFilters(new InputFilter[]{new InputFilter.LengthFilter(minLength)});

        editRepetirContrasena.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        editRepetirContrasena = findViewById(R.id.editRepetirContrasena);

        editRepetirContrasena.setFilters(new InputFilter[]{new InputFilter.LengthFilter(minLength)});

        editRepetirContrasena.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);


    }
}