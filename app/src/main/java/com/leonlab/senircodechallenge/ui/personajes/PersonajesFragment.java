package com.leonlab.senircodechallenge.ui.personajes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leonlab.senircodechallenge.R;

public class PersonajesFragment extends Fragment {

    public PersonajesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personajes, container, false);
        return view;
    }
}