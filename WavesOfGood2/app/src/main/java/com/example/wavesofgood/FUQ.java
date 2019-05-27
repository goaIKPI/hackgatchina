package com.example.wavesofgood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FUQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuq);
    }

    public void Final(View view) {
        finish();
    }
}
