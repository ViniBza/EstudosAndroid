package alura.com.br.ui;

import static alura.com.br.ui.ConstantsActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import alura.com.agendadealunos.R;
import alura.com.br.Dao.AlunoDao;
import alura.com.br.model.Aluno;

public class ActivityListaAlunos extends AppCompatActivity {
    public static final String APPBAR_TITLE = "Lista de Alunos";
    private final AlunoDao dao = new AlunoDao();
    private ArrayAdapter<Aluno> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(APPBAR_TITLE);
        iniciarBtn();
        configuraAdapterLista();

    }


    private void iniciarBtn() {
        FloatingActionButton btn_add_aluno = findViewById(R.id.lista_alunos_fab_add_aluno);
        btn_add_aluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFormularioActivity();
            }
        });
    }


    private void abrirFormularioActivity() {
        startActivity(new Intent(ActivityListaAlunos.this, ActivityFormularioAluno.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        adapter.addAll(dao.exibirAlunos());
    }

    private void configuraAdapterLista() {
        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_listview);
        configuraAdapter(listaAlunos);
        configuraClickSimplesEditarAluno(listaAlunos);
        configurarClickLongRemoverAluno(listaAlunos);
    }

    private void configurarClickLongRemoverAluno(ListView listaAlunos) {
        listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Aluno alunoSelecionado = (Aluno) adapterView.getItemAtPosition(position);
                dao.remover(alunoSelecionado);
                adapter.remove(alunoSelecionado);
                return true;
            }
        });
    }


    private void configuraClickSimplesEditarAluno(ListView listaAlunos) {
        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Aluno alunoSelecionado = (Aluno) adapterView.getItemAtPosition(position);
                vaiParaFormularioActivity(alunoSelecionado);
            }
        });
    }

    private void vaiParaFormularioActivity(Aluno alunoSelecionado) {
        Intent intentFormulario = new Intent(ActivityListaAlunos.this, ActivityFormularioAluno.class);
        intentFormulario.putExtra(CHAVE_ALUNO, alunoSelecionado);
        startActivity(intentFormulario);
    }



    private void configuraAdapter(ListView listaAlunos) {
        adapter = (new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line
        ));
        listaAlunos.setAdapter(adapter);
    }
}