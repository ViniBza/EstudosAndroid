package alura.com.br.ui;

import static alura.com.br.ui.ConstantsActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import alura.com.agendadealunos.R;
import alura.com.br.model.Aluno;

public class ActivityListaAlunos extends AppCompatActivity {
    public static final String APPBAR_TITLE = "Lista de Alunos";
    private final ListaAlunosView listaAlunosView = new ListaAlunosView(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(APPBAR_TITLE);
        configurarFabNovoAluno();
        configuraLista();

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater()
                .inflate(R.menu.activity_lista_alunos_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_alunos_menu_rm){
                listaAlunosView.exibeAlertaDeRemocao(item);
        }
        return super.onContextItemSelected(item);
    }


    private void configurarFabNovoAluno() {
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
        listaAlunosView.atualizaAlunos();
    }

    private void configuraLista() {
        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_listview);
       listaAlunosView.configuraAdapter(listaAlunos);
        configuraClickSimplesEditarAluno(listaAlunos);

/* registerForContextMenu Indica ao android que em nossa listView ao ter um clickLong
 ele disparará um menu de contexto que será montado no onCreatContextMenu
 */
        registerForContextMenu(listaAlunos);
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

}