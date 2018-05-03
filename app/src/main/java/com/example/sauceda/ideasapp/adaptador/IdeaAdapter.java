package com.example.sauceda.ideasapp.adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sauceda.ideasapp.R;
import com.example.sauceda.ideasapp.modelo.Idea;

import java.util.List;

/**
 * Created by sauceda on 10/02/18.
 */

public class IdeaAdapter extends RecyclerView.Adapter<IdeaAdapter.IdeaViewHolder> {

    public interface IdeaAdapterItemCallBack{
        void onIdeaItemSelected(int id);
    }

    List<Idea> ideaList;
    Context context;
    IdeaAdapterItemCallBack ideaAdapterItemCallBack;

    public IdeaAdapter(List<Idea> ideaList, Context context) {
        this.ideaList = ideaList;
        this.context = context;
        this.ideaAdapterItemCallBack = (IdeaAdapterItemCallBack) context;
    }

    @Override
    public IdeaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_idea,parent,false);
        return new IdeaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IdeaViewHolder holder, final int position) {

        holder.nombreIdea.setText(ideaList.get(position).getNombre());
        holder.descripcionIdea.setText(ideaList.get(position).getDescripcion());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ideaAdapterItemCallBack.onIdeaItemSelected(ideaList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return ideaList.size();

    }

    public class IdeaViewHolder extends RecyclerView.ViewHolder {

        TextView nombreIdea,descripcionIdea;
        View view;

        public IdeaViewHolder(View itemView) {
            super(itemView);

            nombreIdea=itemView.findViewById(R.id.txtNombre);
            descripcionIdea= itemView.findViewById(R.id.txtDescripcion);
            view=itemView.findViewById(R.id.view_idea);

        }
    }
}
