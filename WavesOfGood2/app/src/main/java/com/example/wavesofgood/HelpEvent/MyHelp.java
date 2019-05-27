package com.example.wavesofgood.HelpEvent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.wavesofgood.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MyHelp extends AppCompatActivity {
    public List<Person> persons;

    private void initializeData() throws IOException, JSONException {


        AtomicReference<String> response = new AtomicReference<String>(null);
        Runnable runnable = () -> {
            String localResponse = null;
//            try {
//                localResponse = new Java().run("https://ways-of-good.herokuapp.com/api/tickets");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            response.set(localResponse);
        };
        Thread thread = new Thread(runnable);
        thread.start();

        JSONArray jsonArray = new JSONArray(response.get());
        for(int i=0;i<10;i++){
           // JSONObject jsonObject = jsonArray.getJSONObject(0);
           // String title = jsonArray.getJSONObject(0).getString("title");
//            persons = new ArrayList<>();
//            persons.add(new Person(jsonObject.getString("title"), jsonObject.getString("description"), R.drawable.addevent));
//            persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.addevent));
//            persons.add(new Person("Lillie Watts", "35 years old", R.drawable.addevent));
        }

    }

    RecyclerView recyclerViewEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu_event_vol);
        recyclerViewEvent = (RecyclerView)findViewById(R.id.recyclerViewEvent);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerViewEvent.setLayoutManager(llm);
        try {
            initializeData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RvAdapterEvent adapter = new RvAdapterEvent(persons);
        recyclerViewEvent.setAdapter(adapter);
    }

    public void AddEventVol(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateEventVol.class);
        startActivity(intent);
    }

}
