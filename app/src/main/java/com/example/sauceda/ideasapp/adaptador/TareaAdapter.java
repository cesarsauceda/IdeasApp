package com.example.sauceda.ideasapp.adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sauceda.ideasapp.R;
import com.example.sauceda.ideasapp.modelo.Tarea;

import java.util.List;

/**
 * Created by sauceda on 12/02/18.
 */

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaViewHolder> {
    public interface TareaAdapterItemCallBack{
        void onTareaItemSelected(int id);
    }
    List<Tarea> tareaList;
    Context context;
    TareaAdapterItemCallBack tareaAdapterItemCallBack;


    public TareaAdapter(List<Tarea> tareaList, Context context) {
        this.tareaList = tareaList;
        this.context = context;
        this.tareaAdapterItemCallBack = (TareaAdapterItemCallBack) context;

    }

    @Override
    public TareaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea,parent,false);
        return new TareaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TareaViewHolder holder, final int position) {

        holder.nombreTarea.setText(tareaList.get(position).getNombre());
        holder.descripcionTarea.setText(tareaList.get(position).getDescripcion());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tareaAdapterItemCallBack.onTareaItemSelected(tareaList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return tareaList.size();
    }


    public class TareaViewHolder extends RecyclerView.ViewHolder {

        TextView nombreTarea,descripcionTarea;
        View view;

        public TareaViewHolder(View itemView) {
            super(itemView);

            nombreTarea=itemView.findViewById(R.id.txtNombreTarea);
            descripcionTarea= itemView.findViewById(R.id.txtDescripcionTarea);
            view=itemView.findViewById(R.id.view_tarea);

        }
    }
}
