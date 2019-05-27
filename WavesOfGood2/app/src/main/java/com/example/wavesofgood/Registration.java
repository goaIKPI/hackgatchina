package com.example.wavesofgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }

    public void RegistrationButton(View view) {
        Intent intent = new Intent(this, EditHelp.class);
        startActivity(intent);
        finish();
    }
}
