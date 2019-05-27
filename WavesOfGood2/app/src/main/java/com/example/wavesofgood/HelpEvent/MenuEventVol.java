package com.example.wavesofgood.HelpEvent;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wavesofgood.AboutProgram;
import com.example.wavesofgood.FUQ;
import com.example.wavesofgood.Map;
import com.example.wavesofgood.MapsActivity;
import com.example.wavesofgood.Place.MyPlaceVol;
import com.example.wavesofgood.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import kotlin.collections.MapAccessorsKt;
import okhttp3.internal.http.HttpMethod;

public class MenuEventVol extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<Person> persons;
    RvAdapterEvent adapter;
    RecyclerView recyclerViewEvent;



    private void initializeData() throws IOException, JSONException {

      // AtomicReference<String> response = new AtomicReference<String>(null);



        Runnable runnable = () -> {
            persons = new ArrayList<Person>();
            //String localResponse = null;
            String type = "";
            JSONParser jsonParser = new JSONParser();
            String  payloadData = null;
            try {
                payloadData = jsonParser.post("https://ways-of-good.herokuapp.com/api/usertickets/11", "");
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONArray payload = null;
            try {
                payload = new JSONArray(payloadData);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            for(int j = 0 ;j<payload.length();j++) {
                try {
                    if (j==0){
                        type = "Еда";
                    }
                    if( j==1){
                        type = "Ночлег";
                    }
                    if( j==2){
                        type = "Медицина";
                    }
                    if( j==3){
                        type = "Обогрев";
                    }
                    if( j==4){
                        type = "Чистка";
                    }
                    if( j==5){
                        type = "Работа";
                    }

                    persons.add(new Person(payload.getJSONObject(j).getString("title"), payload.getJSONObject(j).getString("description"), R.drawable.main_man, type));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            runOnUiThread(() -> {
                adapter = new RvAdapterEvent(persons);
                recyclerViewEvent.setAdapter(adapter);
            });
           // response.set(localResponse);
        };
        Thread thread = new Thread(runnable);
        thread.start();



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_event_vol);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.main_man)
                        .setContentTitle("На ваше место пришел");

        Notification notification = builder.build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);


        recyclerViewEvent = (RecyclerView) findViewById(R.id.recyclerViewEvent);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerViewEvent.setLayoutManager(llm);
        try {
            initializeData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

//

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) { //Переход в моих событиях в меню на мои места
            Intent intent = new Intent(this, MyPlaceVol.class);
            startActivity(intent);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }
        else if (id == R.id.FUQ) {
            Intent intent = new Intent(this, FUQ.class);
            startActivity(intent);
        }
        else if (id == R.id.aboutProgram) {
            Intent intent = new Intent(this, AboutProgram.class);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.maps) {
            Intent intent = new Intent(this, MapsActivity .class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void OpenPush(View view) {

    }

    public void AddEventVol(View view) {
        Intent intent = new Intent(this,CreateEventVol.class);
        startActivity(intent);
    }
    public void DelitEvent(View view){
        RecyclerView recyclerViewEvent = (RecyclerView) findViewById(R.id.recyclerViewEvent);
        persons.remove(0);
        RvAdapterEvent adapter = new RvAdapterEvent(persons);
        recyclerViewEvent.setAdapter(adapter);
    }
    public void CreateEvent(View view) {
        Intent intent = new Intent(this, createwind.class);
        startActivity(intent);
        // СОЗДАНИЕ НОВОГО МЕСТА
    }
}
