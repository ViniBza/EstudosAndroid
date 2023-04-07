package alura.com.br.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alura.com.agendadealunos.R;
import alura.com.br.model.Aluno;
import alura.com.br.ui.ListaAlunosView;


public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> listaAlunos = new ArrayList<>();
    private Context contex;

    public ListaAlunosAdapter(Context contex){
        this.contex = contex;
    }


    @Override
    public int getCount() {
        return listaAlunos.size();
    }

    @Override
    public Object getItem(int posicao) {
        return listaAlunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return listaAlunos.get(posicao).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View viewCriada = criaView(viewGroup);
        Aluno alunoDevolvido = listaAlunos.get(position);
        vinculaDados(viewCriada, alunoDevolvido);
        return viewCriada;
    }

    private void vinculaDados(View view, Aluno alunoView) {
        TextView nome = view.findViewById(R.id.aluno_item_txtNome);
        nome.setText(alunoView.getNome());
        TextView telefone = view.findViewById(R.id.aluno_item_txtTelefone);
        telefone.setText(alunoView.getTelefone());
    }


    private View criaView(ViewGroup viewGroup) {
        return LayoutInflater.from(contex).inflate(R.layout.aluno_item, viewGroup, false);
    }

    public void atualiza(List<Aluno> alunos){
        this.listaAlunos.clear();
        this.listaAlunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno){
        listaAlunos.remove(aluno);
        notifyDataSetChanged();
    }

}
