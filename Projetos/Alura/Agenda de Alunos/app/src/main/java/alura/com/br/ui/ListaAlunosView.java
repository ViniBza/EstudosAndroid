package alura.com.br.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;

import alura.com.br.Adapter.ListaAlunosAdapter;
import alura.com.br.Dao.AlunoDao;
import alura.com.br.model.Aluno;

public class ListaAlunosView {
    private final ListaAlunosAdapter adapter;
    private final Context context;
    private final AlunoDao dao;

    public ListaAlunosView(Context context){
        this.context = context;
        this.adapter = new ListaAlunosAdapter(context);
        this.dao = new AlunoDao();
    }


    public void exibeAlertaDeRemocao(final MenuItem item) {
        new AlertDialog.Builder(context)
                .setTitle("Removendo Aluno")
                .setMessage("Deseja realmente remover o aluno?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno alunoEscolhido = (Aluno) adapter.getItem(menuInfo.position);
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removerAluno(alunoEscolhido);
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    private void removerAluno(Aluno alunoSelecionado) {
        dao.remover(alunoSelecionado);
        adapter.remove(alunoSelecionado);
    }

    public void configuraAdapter(ListView listaAlunos) {
       listaAlunos.setAdapter(adapter);
    }

    public void atualizaAlunos(){
        adapter.atualiza(dao.exibirAlunos());
    }
}
