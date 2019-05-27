package com.example.wavesofgood.Place;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wavesofgood.HelpEvent.RvAdapterEvent;
import com.example.wavesofgood.R;

import java.util.List;

public class RvAdapterPlace extends  RecyclerView.Adapter<RvAdapterPlace.PersonViewHolder>{

    private List<Place> persons;

    RvAdapterPlace(List<Place> persons) {
            this.persons = persons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_place_vol, viewGroup, false);
            PersonViewHolder pvh = new PersonViewHolder(v);
            return pvh;
            }

    @Override
    public int getItemCount() {
            return persons.size();
            }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int i) {
            personViewHolder.personName.setText(persons.get(i).name);
            personViewHolder.personPlace.setText(persons.get(i).place);
            personViewHolder.image.setImageResource(persons.get(i).image);
           // personViewHolder.personDescription.setImageResource(persons.get(i).description);
            }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personPlace;
        ImageView image;
       // TextView personDescription;
        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardViewEvent);
            personName = (TextView)itemView.findViewById(R.id.TextPlaceName);
            personPlace = (TextView)itemView.findViewById(R.id.TextPlacePlace);
            image = (ImageView)itemView.findViewById(R.id.imageCardPlace);
            //personPhoto = (ImageView)itemView.findViewById(R.id.cardViewImage);
        }
    }
}
