package jhlasso.gymfitness.Fragments.Tabs;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.util.ArrayList;

import jhlasso.gymfitness.Adapters.EjercicioAdapter;
import jhlasso.gymfitness.Clases.EjercicioVo;
import jhlasso.gymfitness.IComunicaFragments;
import jhlasso.gymfitness.R;


public class TabHombroFragment extends Fragment {

    RecyclerView recyclerHombro;
    ArrayList<EjercicioVo> listaEjercicio;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_hombro, container, false);

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
        listaEjercicio.add(new EjercicioVo(getString(R.string.nombre_hombro1),getString(R.string.info_hombro1),getString(R.string.descripcion_hombro1),getString(R.string.consejo_hombro1),R.drawable.hombro1,R.drawable.hombro1));
        listaEjercicio.add(new EjercicioVo(getString(R.string.nombre_hombro2),getString(R.string.info_hombro1),getString(R.string.descripcion_hombro2),getString(R.string.consejo_hombro2),R.drawable.hombro2,R.drawable.hombro2));
        listaEjercicio.add(new EjercicioVo(getString(R.string.nombre_hombro3),getString(R.string.info_hombro1),getString(R.string.descripcion_hombro3),getString(R.string.consejo_hombro3),R.drawable.hombro3,R.drawable.hombro3));
        listaEjercicio.add(new EjercicioVo(getString(R.string.nombre_hombro4),getString(R.string.info_hombro1),getString(R.string.descripcion_hombro4),getString(R.string.consejo_hombro4),R.drawable.hombro4,R.drawable.hombro4));

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
