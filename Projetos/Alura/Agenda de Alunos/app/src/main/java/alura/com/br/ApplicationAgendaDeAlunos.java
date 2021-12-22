package alura.com.br;

import android.app.Application;
import alura.com.br.Dao.AlunoDao;
import alura.com.br.model.Aluno;

public class ApplicationAgendaDeAlunos extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AlunoDao.salvar( new Aluno("Joao", "1111-2222","Joao@joao.com"));

    }
}
