package jhlasso.gymfitness.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import jhlasso.gymfitness.Clases.EjercicioVo;
import jhlasso.gymfitness.R;
import pl.droidsonroids.gif.GifImageView;

public class EjercicioAdapter extends RecyclerView.Adapter<EjercicioAdapter.ViewHolderEjercicios> implements View.OnClickListener{

    ArrayList<EjercicioVo> listaDatos;
    private View.OnClickListener listener;

    public EjercicioAdapter(ArrayList<EjercicioVo> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public ViewHolderEjercicios onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null,false);
        view.setOnClickListener(this);
        return new ViewHolderEjercicios(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderEjercicios holder, int position) {
        holder.nombre.setText(listaDatos.get(position).getNombre());
        holder.info.setText(listaDatos.get(position).getInfo());
        holder.foto.setImageResource(listaDatos.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {

        if(listener!=null)
        {
            listener.onClick(view);
        }
    }

    public class ViewHolderEjercicios extends RecyclerView.ViewHolder {
        TextView nombre,info;
        GifImageView foto;

        public ViewHolderEjercicios(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.idNombre);
            info=itemView.findViewById(R.id.idInfo);
            foto = itemView.findViewById(R.id.imgEjercicio);

        }
    }
}
