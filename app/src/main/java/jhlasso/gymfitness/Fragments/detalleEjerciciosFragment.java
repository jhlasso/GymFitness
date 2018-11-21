package jhlasso.gymfitness.Fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.Fragment;


import jhlasso.gymfitness.Clases.EjercicioVo;
import jhlasso.gymfitness.R;


public class detalleEjerciciosFragment extends Fragment {

    TextView textoDescripcion;
    TextView consejo;
    ImageView imageView;

    Button atras;
    private FragmentActivity myContext;

    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_ejercicios, container, false);

        textoDescripcion = view.findViewById(R.id.descripcion);
        consejo = view.findViewById(R.id.consejo);
        imageView = view.findViewById(R.id.imagenDescripcion);


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedor, new EjerciciosFragment()).commit();
            }
        });



        Bundle objetoEjercicio = getArguments();
        EjercicioVo ejercicio = null;

        if (objetoEjercicio!=null)
        {
            ejercicio= (EjercicioVo) objetoEjercicio.getSerializable("objeto");
            imageView.setImageResource(ejercicio.getImagenDetaller());
            textoDescripcion.setText(ejercicio.getDescripcion());
            consejo.setText(ejercicio.getConsejo());
        }

        return view;
    }


}
