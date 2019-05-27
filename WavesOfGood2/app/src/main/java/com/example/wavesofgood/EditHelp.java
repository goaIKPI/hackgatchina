package com.example.wavesofgood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.wavesofgood.HelpEvent.MyHelp;

public class EditHelp extends AppCompatActivity {
    EditText text;
    int count;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_help);
        text = findViewById(R.id.editTextKol);
    }

    public void CheckPlus(View view) {
        count = Integer.parseInt(text.getText().toString());
        count++;
        text.setText(String.valueOf(count));
    }
    public void CheckMinus(View view) {
        count = Integer.parseInt(text.getText().toString());
        count--;
        text.setText(String.valueOf(count));
    }


    public void EditEvent(View view) {
        finish();
    }
}
