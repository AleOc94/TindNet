package com.example.tindnet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginCliente extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private static final String TAG="LoginClient";

    private EditText mEmailRegisterEditText, mPaswordEditText;

    private Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_cliente);

        mAuth = FirebaseAuth.getInstance();

        mEmailRegisterEditText = findViewById(R.id.editTextTextEmailAddress);

        mPaswordEditText = findViewById(R.id.editContrasenaCliente);

        mRegisterButton = findViewById(R.id.buttonContinuar);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mEmailRegisterEditText.getText().toString();
                String password=mPaswordEditText.getText().toString();
                if(!email.isEmpty() && !password.isEmpty()) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(LoginCliente.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        updateUI(null);

                                    }
                                }
                            });
                };
            }

        });


    }

    private void updateUI(FirebaseUser user) {
// Aquí puedes actualizar la interfaz de usuario según el estado de autenticación
// Por ejemplo, puedes redirigir al usuario a otra actividad después de que haya iniciado sesión correctamente
        if (user != null) {
            Intent intent = new Intent(LoginCliente.this, MainActivity.class); //Cambiarlo por la página siguiente
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            currentUser.reload();
        }
    }


        }

