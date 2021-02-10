package com.example.listadetarefas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadetarefas.Model.Tarefa;
import com.example.listadetarefas.R;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.myViewHolder> {

private List <Tarefa> listaTarefas;

    public TarefaAdapter(List<Tarefa> lista) {
        this.listaTarefas = lista;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_tarefa_adapter, parent, false);
        return new myViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Tarefa tarefa = listaTarefas.get(position);
        holder.Tarefa.setText(tarefa.getNomeTarefa());
    }

    //Definindo a quantidade de itens a ser exibido.
    @Override
    public int getItemCount() {
        return this.listaTarefas.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView Tarefa;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Tarefa = itemView.findViewById(R.id.textTarefa);
        }
    }

}
