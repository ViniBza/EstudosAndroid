package alura.com.agendadealunos.Dao;

import java.util.ArrayList;
import java.util.List;

import alura.com.agendadealunos.model.Aluno;

public class AlunoDao {

    private static List<Aluno> alunos = new ArrayList();

    public static void salvar(Aluno aluno){ alunos.add(aluno);}


    public ArrayList<Aluno> exibirAlunos(){
        return new ArrayList<>(alunos);
    }
}
