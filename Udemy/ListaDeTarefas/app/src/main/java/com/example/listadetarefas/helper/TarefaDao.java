package com.example.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.IDNA;
import android.util.Log;

import com.example.listadetarefas.Model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDao implements ITarefaDao {

    private SQLiteDatabase escreverDados;
    private SQLiteDatabase lerDados;

    public TarefaDao(Context context) {
        DbHelper db = new DbHelper( context );
        escreverDados = db.getWritableDatabase();
        lerDados = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try {
            escreverDados.insert(DbHelper.TABELA_TAFERAS, null, cv);
            Log.i("INFO SALVAR", "Tarefa salva com sucesso.");
        }catch (Exception e){
            Log.i("INFO SALVAR", "Error ao salvar tarefa: " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try {
            String[] args = {String.valueOf(tarefa.getId())};
            escreverDados.update(DbHelper.TABELA_TAFERAS, cv,"id =?", args );
            Log.i("INFO ATUALIZAR", "Tarefa atualizada com sucesso.");
        }catch (Exception e){
            Log.i("INFO ATUALIZAR", "Error ao atualizar tarefa: " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        try {
            String[] args = {String.valueOf(tarefa.getId())};
            escreverDados.delete(DbHelper.TABELA_TAFERAS,"id =?", args );
            Log.i("INFO DELETAR", "Tarefa removida com sucesso.");
        }catch (Exception e){
            Log.i("INFO DELETAR", "Error ao remover tarefa: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();
                String sql = "SELECT * FROM " + DbHelper.TABELA_TAFERAS + " ;";
                Cursor c = lerDados.rawQuery(sql , null);

                while ( c.moveToNext() ){
                    Tarefa tarefa = new Tarefa();

                    Long id = c.getLong( c.getColumnIndex("id") );
                    String nomeTarefa = c.getString( c.getColumnIndex("nome") );

                    tarefa.setId( id );
                    tarefa.setNomeTarefa( nomeTarefa );
                    tarefas.add( tarefa );
                }
                     return tarefas;
    }
}
