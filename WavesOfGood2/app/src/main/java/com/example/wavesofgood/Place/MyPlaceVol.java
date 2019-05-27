package com.example.wavesofgood.Place;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.wavesofgood.AboutProgram;
import com.example.wavesofgood.FUQ;
import com.example.wavesofgood.HelpEvent.MenuEventVol;
import com.example.wavesofgood.HelpEvent.RvAdapterEvent;
import com.example.wavesofgood.Map;
import com.example.wavesofgood.R;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MyPlaceVol extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private List<Place> persons;

    private void initializeData() throws IOException, JSONException {

 //      AtomicReference<String> response = new AtomicReference<String>(null);
//        Runnable runnable = () -> {
//            String localResponse = null;
//            try {
//                localResponse = new Java().run("https://ways-of-good.herokuapp.com/api/places");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            response.set(localResponse);
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();


        //JSONArray jsonArray = new JSONArray(response.get());

        //for(int i=0;i<10;i++){
        //JSONObject jsonObject = new JSONObject(response.get());
        //JSONObject jsonObject = jsonArray.getJSONObject(0);
        //String title = jsonArray.getJSONObject(0).getString("title");
        persons = new ArrayList<>();
        //persons.add(new Person(jsonObject.getString("title"), jsonObject.getString("description"), R.drawable.addevent));
        persons.add(new Place("Дом", "Ул. Октябрьская, дом 23",R.drawable.house));
        persons.add(new Place("Гараж", "Ул. Сибирская горка, дом 61", R.drawable.garage));
        // }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_place_vol);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        RecyclerView recyclerViewPlace = (RecyclerView) findViewById(R.id.recyclerViewPlace);
        LinearLayoutManager l = new LinearLayoutManager(getApplicationContext());
        recyclerViewPlace.setLayoutManager(l);
        try {
            initializeData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RvAdapterPlace adapter = new RvAdapterPlace(persons);
        recyclerViewPlace.setAdapter(adapter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_place);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_place);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this, MenuEventVol.class);
            startActivity(intent);
            finish();
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
            Intent intent = new Intent(this, Map.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_place);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
