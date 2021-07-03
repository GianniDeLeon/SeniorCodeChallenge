package com.leonlab.senircodechallenge.ui.acercade;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leonlab.senircodechallenge.R;

public class AcercaDeFragment extends Fragment {

    public AcercaDeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acerca_de, container, false);
        return view;
    }
}