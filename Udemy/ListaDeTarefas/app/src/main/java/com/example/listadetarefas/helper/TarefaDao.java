package com.example.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.listadetarefas.Model.Tarefa;

import java.util.List;

public class TarefaDao implements ITarefaDao {

    private SQLiteDatabase salvarDados;
    private SQLiteDatabase lerDados;

    public TarefaDao(Context context) {
        DbHelper db = new DbHelper( context );
        salvarDados = db.getWritableDatabase();
        lerDados = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try {
            salvarDados.insert(DbHelper.TABELA_TAFERAS, null, cv);
            Log.i("INFO OPERAÇÃO", "Tarefa salva com sucesso.");
        }catch (Exception e){
            Log.i("INFO OPERAÇÃO", "Error ao salvar dados. " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        return null;
    }
}
