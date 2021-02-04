package com.example.listadetarefas.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.listadetarefas.Adapter.TarefaAdapter;
import com.example.listadetarefas.Model.Tarefa;
import com.example.listadetarefas.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;

    //Criando um list de objetos Tarefas
    private List<Tarefa> listaTaferas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // Exibe lista de tarefas no RecycleView

        //Configurar um adapter
        tarefaAdapter = new TarefaAdapter(listaTaferas);

        //Configurar Recycler
        recyclerView = findViewById(R.id.RecyclerListaTarefas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

       recyclerView.setAdapter(tarefaAdapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void carregarListaTarefas(){
        // Listar Tarefas
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setNomeTarefa("Ir ao mercado.");
        listaTaferas.add(tarefa1);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setNomeTarefa("Ir a academia.");
        listaTaferas.add(tarefa2);

        Tarefa tarefa3 = new Tarefa();
        tarefa3.setNomeTarefa("Ir ao cinema.");
        listaTaferas.add(tarefa3);
    }

    //Sempre o metodo onStart é chamado ele vai atualizar a lista de tarefas
    @Override
    protected void onStart() {
        super.onStart();
        carregarListaTarefas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}