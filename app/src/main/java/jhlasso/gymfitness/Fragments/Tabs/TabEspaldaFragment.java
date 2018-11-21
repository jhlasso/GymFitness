package jhlasso.gymfitness.Fragments.Tabs;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import jhlasso.gymfitness.Adapters.EjercicioAdapter;
import jhlasso.gymfitness.Clases.EjercicioVo;
import jhlasso.gymfitness.IComunicaFragments;
import jhlasso.gymfitness.R;


public class TabEspaldaFragment extends Fragment {

    RecyclerView recyclerHombro;
    ArrayList<EjercicioVo> listaEjercicio;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_espalda, container, false);

        listaEjercicio= new ArrayList<>();
        recyclerHombro=view.findViewById(R.id.recyclerId);
        recyclerHombro.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();

        EjercicioAdapter adapter = new EjercicioAdapter(listaEjercicio);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Selección: "+listaEjercicio.get
                        (recyclerHombro.getChildAdapterPosition(view))
                        .getNombre(),Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarEjercicio(listaEjercicio.get(recyclerHombro.getChildAdapterPosition(view)));
            }
        });

        recyclerHombro.setAdapter(adapter);

        return view;
    }

    private void llenarLista() {
        listaEjercicio.add(new EjercicioVo(getString(R.string.nombre_espalda1),getString(R.string.info_espalda1),getString(R.string.descripcion_espalda1),getString(R.string.consejo_espalda1),R.drawable.espalda1,R.drawable.espalda1));
        listaEjercicio.add(new EjercicioVo(getString(R.string.nombre_espalda2),getString(R.string.info_espalda1),getString(R.string.descripcion_espalda2),getString(R.string.consejo_espalda2),R.drawable.espalda2,R.drawable.espalda2));
        listaEjercicio.add(new EjercicioVo(getString(R.string.nombre_espalda3),getString(R.string.info_espalda1),getString(R.string.descripcion_espalda3),getString(R.string.consejo_espalda3),R.drawable.espalda3,R.drawable.espalda3));
        listaEjercicio.add(new EjercicioVo(getString(R.string.nombre_espalda4),getString(R.string.info_espalda1),getString(R.string.descripcion_espalda4),getString(R.string.consejo_espalda4),R.drawable.espalda4,R.drawable.espalda4));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity)
        {
            this.activity=(Activity) context;
            interfaceComunicaFragments=(IComunicaFragments) this.activity;
        }
    }
}
