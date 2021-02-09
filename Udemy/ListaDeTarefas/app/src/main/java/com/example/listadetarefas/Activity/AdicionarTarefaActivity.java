package com.example.listadetarefas.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.listadetarefas.Model.Tarefa;
import com.example.listadetarefas.R;
import com.example.listadetarefas.helper.TarefaDao;
import com.google.android.material.textfield.TextInputEditText;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.editTarefa);
    }

    //Metodo de criação do menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }


    // Metodo das opções do menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemSalvar:

                TarefaDao tarefaDao = new TarefaDao(getApplicationContext());

                String nomeTarefa = editTarefa.getText().toString();

                if ( !nomeTarefa.isEmpty() ){
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa( nomeTarefa );
                    tarefaDao.salvar( tarefa );
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}