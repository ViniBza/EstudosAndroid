package com.example.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.listadetarefas.Model.Tarefa;

import java.util.ArrayList;
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
        List<Tarefa>  tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAFERAS + " ;";
        Cursor c = lerDados.rawQuery(sql, null);

        while (c.moveToNext()){
            Tarefa tarefa = new Tarefa();
            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefa = c.getString(c.getColumnIndex("id"));

            tarefa.setId( id );
            tarefa.setNomeTarefa( nomeTarefa );
            tarefas.add( tarefa );
        }

        return tarefas;
    }
}
