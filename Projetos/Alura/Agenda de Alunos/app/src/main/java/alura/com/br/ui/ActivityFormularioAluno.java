package alura.com.br.ui;

import static alura.com.br.ui.ConstantsActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import alura.com.agendadealunos.R;
import alura.com.br.Dao.AlunoDao;
import alura.com.br.model.Aluno;

public class ActivityFormularioAluno extends AppCompatActivity {

    public static final String APPBAR_TITULO_CADASTRO = "Cadastrar Aluno";
    public static final String APPBAR_TITULO_EDITAR = "Editar Aluno";
    private Aluno aluno;
    private EditText edt_nome;
    private EditText edt_telefone;
    private EditText edt_email;
    private Button btn_salvar;
    private final AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        iniciarCampos();
        carregarCampos();
        definirAcaoBotao();
    }

    private void iniciarCampos() {
        edt_nome = findViewById(R.id.activity_formulario_edtNome);
        edt_telefone = findViewById(R.id.activity_formulario_edtTelefone);
        edt_email = findViewById(R.id.activity_formulario_edtEmail);
        btn_salvar = findViewById(R.id.activity_formulario_btnSalvar);
    }

    private void carregarCampos() {
        Intent dadosAluno = getIntent();
        if (dadosAluno.hasExtra(CHAVE_ALUNO)){
            aluno = (Aluno) dadosAluno.getSerializableExtra(CHAVE_ALUNO);
            edt_nome.setText(aluno.getNome());
            edt_telefone.setText(aluno.getTelefone());
            edt_email.setText(aluno.getEmail());
        }else {
            aluno = new Aluno();
        }
    }

    private void definirAcaoBotao() {
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setarCampos();
                definirCadastrOuEdicao(dao);
                finish();
            }
        });
    }

    private void setarCampos () {
        String nome = edt_nome.getText().toString();
        String telefone = edt_telefone.getText().toString();
        String email = edt_email.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }

    private void definirCadastrOuEdicao(AlunoDao dao) {
        if (aluno.verificarId()){
            setTitle(APPBAR_TITULO_EDITAR);
            dao.editar(aluno);
        }
        else {
            setTitle(APPBAR_TITULO_CADASTRO);
            dao.salvar(aluno);
        }
    }





}