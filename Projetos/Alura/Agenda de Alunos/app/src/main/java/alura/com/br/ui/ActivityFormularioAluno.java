package alura.com.br.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import alura.com.agendadealunos.R;
import alura.com.br.model.Aluno;
import alura.com.br.Dao.AlunoDao;

public class ActivityFormularioAluno extends AppCompatActivity {

    public static final String APPBAR_TITULO = "Formulario de Cadastro";
    private Aluno aluno;
    private EditText edt_nome;
    private EditText edt_telefone;
    private EditText edt_email;
    private Button btn_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(APPBAR_TITULO);

        final AlunoDao alunoDao = new AlunoDao();
        iniciarCampos();
        Intent dadosAluno = getIntent();

        if (dadosAluno.hasExtra("AlunoExtra")){
            aluno = (Aluno) dadosAluno.getSerializableExtra("AlunoExtra");
            edt_nome.setText(aluno.getNome());
            edt_telefone.setText(aluno.getTelefone());
            edt_email.setText(aluno.getEmail());
        }else {
            aluno = new Aluno();
        }



        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno =  criarAluno();
                salvar(aluno, alunoDao);
            }
        });
    }

    private void salvar(Aluno aluno, AlunoDao alunoDao) {
        alunoDao.salvar(aluno);
        finish();
    }


    private Aluno criarAluno() {
        String nome = edt_nome.getText().toString();
        String telefone = edt_telefone.getText().toString();
        String email = edt_email.getText().toString();
        Aluno aluno = new Aluno(nome, telefone, email);
        return aluno;
    }

    private void iniciarCampos() {
        edt_nome = findViewById(R.id.activity_formulario_edtNome);
        edt_telefone = findViewById(R.id.activity_formulario_edtTelefone);
        edt_email = findViewById(R.id.activity_formulario_edtEmail);
        btn_salvar = findViewById(R.id.activity_formulario_btnSalvar);
    }
}