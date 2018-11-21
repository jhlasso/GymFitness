package jhlasso.gymfitness.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Toast;


import jhlasso.gymfitness.Clases.CodigoQR;
import jhlasso.gymfitness.R;


public class MenuFragment extends Fragment {

    private FragmentActivity myContext;
    ImageButton ejercicios;
    ImageButton mapa;
    View vista;

    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_menu, container, false);

        ImageButton qr = vista.findViewById(R.id.btnQr);

        qr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),CodigoQR.class);
                startActivity(in);
            }
        });

        ejercicios = vista.findViewById(R.id.btnEjercicios);
        mapa = vista.findViewById(R.id.btnMapa);

        ejercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment a = new EjerciciosFragment();
                FragmentManager fm = myContext.getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.contenedor,a).commit();            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment a = new GimnasiosFragment();
                FragmentManager fm = myContext.getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.contenedor,a).commit();            }
        });

        return vista;
    }



}
