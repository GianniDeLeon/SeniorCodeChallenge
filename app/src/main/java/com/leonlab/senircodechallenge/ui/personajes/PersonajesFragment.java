package com.leonlab.senircodechallenge.ui.personajes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.leonlab.senircodechallenge.R;
import com.leonlab.senircodechallenge.adapter.PersonajeAdapter;
import com.leonlab.senircodechallenge.model.Personaje;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class PersonajesFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private PersonajeAdapter personajeAdapter;
    private ArrayList<Personaje> arrayList;
    public PersonajesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personajes, container, false);
        swipeRefreshLayout = view.findViewById(R.id.swiperefresh);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        swipeRefreshLayout.setOnRefreshListener(() -> getPersonajes());
        getPersonajes();
        return view;
    }


    private void getPersonajes(){
        String url = "https://www.breakingbadapi.com/api/characters";
        RequestQueue queue = Volley.newRequestQueue(getContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, (Response.Listener<org.json.JSONArray>) response -> {
            clearArrayList();
            setArrayListPersonaje(response);
            if(arrayList.size() > 0){
                personajeAdapter = new PersonajeAdapter(arrayList);
                recyclerView.setAdapter(personajeAdapter);
            }
        }, (Response.ErrorListener) error -> {
            Log.i("Error",error.toString());
        }
        );
        queue.add(jsonArrayRequest);

    }

    private void setArrayListPersonaje(JSONArray response){
        arrayList = new ArrayList<>();
        for (int i = 0; i < response.length(); i++){
            Gson gson = new Gson();
            try {
                Personaje personaje = gson.fromJson(response.get(i).toString(),Personaje.class);
                personaje.initFavorito(getContext());
                arrayList.add(personaje);
                swipeRefreshLayout.setRefreshing(false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void clearArrayList(){
        if (arrayList != null){
            if (arrayList.size() > 0){
                arrayList.clear();
            }
        }
    }



}