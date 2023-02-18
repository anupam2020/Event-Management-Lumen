package com.sbdev.eventmanagemntlumen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginPage extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private TextInputEditText email,pass;
    private AppCompatButton login;

    private DatabaseReference dRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        firebaseAuth=FirebaseAuth.getInstance();
        email=findViewById(R.id.loginEmail);
        pass=findViewById(R.id.loginPassword);

        login=findViewById(R.id.loginBtn);

        dRef= FirebaseDatabase.getInstance().getReference("Users");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e=email.getText().toString();
                String p=pass.getText().toString();

                if(e.isEmpty() || p.isEmpty())
                {
                    Toast.makeText(LoginPage.this, "Invalid Input!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loginToHome(e,p);
                }

            }
        });

    }

    private void loginToHome(String e, String p)
    {

        firebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(LoginPage.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginPage.this,HomePage.class));
                    finishAffinity();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}