package com.example.wavesofgood.HelpEvent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.wavesofgood.R;

public class createwind extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modalewindow);
    }

    public void ByCreateWind(View view) {
        finish();
    }
}
