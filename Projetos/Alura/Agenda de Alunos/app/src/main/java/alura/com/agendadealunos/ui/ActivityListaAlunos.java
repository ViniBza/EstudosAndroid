package alura.com.agendadealunos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import alura.com.agendadealunos.R;

public class ActivityListaAlunos extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Lista de Alunos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(APPBAR_TITLE);
        iniciarBtn();

    }

    @Override
    protected void onResume() {
        super.onResume();
        exibirListaAlunos();
    }

    private void exibirListaAlunos() {
        //Lista de teste
        List<String> alunos = new ArrayList<>(Arrays.asList("Vinicio", "João", "Giovane", "Leandro"));

        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_listview);
           listaAlunos.setAdapter(new ArrayAdapter<>(
                   this, android.R.layout.simple_dropdown_item_1line,alunos
           ));

    }

    private void iniciarBtn() {
        FloatingActionButton btn_add_aluno = findViewById(R.id.lista_alunos_fab_add_aluno);
        btn_add_aluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamarFormularioActivity();
            }
        });
    }

    private void chamarFormularioActivity() {
    }
}