package com.sbdev.eventmanagemntlumen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    AppCompatButton singOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        singOut=findViewById(R.id.mainSignOut);

        firebaseAuth=FirebaseAuth.getInstance();

        singOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(HomePage.this,MainActivity.class));
                finishAffinity();
            }
        });

    }
}