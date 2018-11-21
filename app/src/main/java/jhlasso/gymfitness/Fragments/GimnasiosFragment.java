package jhlasso.gymfitness.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageButton;


import jhlasso.gymfitness.Clases.Mapa;
import jhlasso.gymfitness.R;

public class GimnasiosFragment extends Fragment {

    ImageButton mapa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_gimnasios, container, false);

        ImageButton mapa = vista.findViewById(R.id.mapa);

        mapa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),Mapa.class);
                startActivity(in);
            }
        });

        return vista;
    }

}
