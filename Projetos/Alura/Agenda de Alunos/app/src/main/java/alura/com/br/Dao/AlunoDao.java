package alura.com.br.Dao;

import java.util.ArrayList;
import java.util.List;

import alura.com.br.model.Aluno;

public class AlunoDao {
    private static List<Aluno> alunos = new ArrayList();
    private static int contadorIds = 1;


    public static void salvar(Aluno aluno){
        aluno.setId(contadorIds);
        alunos.add(aluno);
        contadorIds++;
    }

    public void editar(Aluno aluno) {
        Aluno alunoEscolhido = buscarAlunoPeloId(aluno);
        if (alunoEscolhido != null){
            int posicaoAluno = alunos.indexOf(alunoEscolhido);
            alunos.set(posicaoAluno, aluno);}
    }

    private Aluno buscarAlunoPeloId(Aluno aluno) {
        for (Aluno a: alunos) {
            if (a.getId() == aluno.getId()){
                return a;
            }
        }
        return null;
    }
    
    public ArrayList<Aluno> exibirAlunos(){
        return new ArrayList<>(alunos);
    }


}
