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

import java.util.List;

import alura.com.agendadealunos.R;
import alura.com.br.Dao.AlunoDao;
import alura.com.br.model.Aluno;

public class ActivityListaAlunos extends AppCompatActivity {
    public static final String APPBAR_TITLE = "Lista de Alunos";

    private final AlunoDao dao = new AlunoDao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(APPBAR_TITLE);
        iniciarBtn();

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
        exibirListaAlunos();
    }

    private void exibirListaAlunos() {
        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_listview);
        List<Aluno> aluno = dao.exibirAlunos();
        configuraAdapter(listaAlunos, aluno);
        configuraAlunoSelecionado(listaAlunos, aluno);
    }


    private void configuraAlunoSelecionado(ListView listaAlunos, List<Aluno> aluno) {
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

    private void configuraAdapter(ListView listaAlunos, List<Aluno> alunos) {
        listaAlunos.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, alunos
        ));
    }
}