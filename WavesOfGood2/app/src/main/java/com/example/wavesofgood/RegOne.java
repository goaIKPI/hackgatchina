package com.example.wavesofgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class RegOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_one);
    }

    public void OrgButtonClick(View view) {
        Intent intent = new Intent(this, Registration2.class);
        startActivity(intent);
        finish();
    }

    public void VolButtonCLick(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
        finish();
    }
}