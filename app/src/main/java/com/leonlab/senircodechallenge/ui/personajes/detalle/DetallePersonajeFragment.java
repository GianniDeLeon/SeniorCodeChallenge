package com.leonlab.senircodechallenge.ui.personajes.detalle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.leonlab.senircodechallenge.R;
import com.leonlab.senircodechallenge.model.Personaje;
import com.squareup.picasso.Picasso;

public class DetallePersonajeFragment extends Fragment {

    public DetallePersonajeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_personaje, container, false);
        ImageView imageViewFavorito = view.findViewById(R.id.imageViewFavorito);
        ImageView imageViewFoto = view.findViewById(R.id.imageViewFoto);
        TextView textViewNombre = view.findViewById(R.id.textViewNombre);
        TextView textViewOccupation = view.findViewById(R.id.textViewOccupation);
        TextView textViewStatus = view.findViewById(R.id.textViewStatus);
        TextView textViewPortrayed = view.findViewById(R.id.textViewPortrayed);
        Personaje personaje = DetallePersonajeFragmentArgs.fromBundle(getArguments()).getPersonaje();



        Picasso.get().load(personaje.getImg()).into(imageViewFoto);
        int resFavorito = (personaje.isFavorito())?R.drawable.ic_baseline_favorite:R.drawable.ic_baseline_favorite_border;
        imageViewFavorito.setImageResource(resFavorito);
        textViewNombre.setText(personaje.getNickname());
        textViewOccupation.setText(getOccupation(personaje.getOccupation()));
        textViewStatus.setText(personaje.getStatus());
        textViewPortrayed.setText(personaje.getPortrayed());
        return view;
    }

    private String getOccupation(String[] occupationArray){
        String occupation = occupationArray[0];
        for (int i=1; i < occupationArray.length; i++){
            occupation += ", "+occupationArray[i];
        }
        return occupation;
    }
}