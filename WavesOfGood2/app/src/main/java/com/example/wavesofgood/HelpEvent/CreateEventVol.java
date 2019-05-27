package com.example.wavesofgood.HelpEvent;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.wavesofgood.R;

public class CreateEventVol extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_vol);
    }


    public void By(View view) {

        Intent intent= new Intent(this,createwind.class);
        startActivity(intent);

    }
}
