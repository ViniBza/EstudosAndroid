package com.example.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.IDNA;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 3;             //Definindo a versão do BD
    public static String DB_NAME = "DB_TAREFAS";    //Definindo o nome do BD
    public static String TABELA_TAFERAS = "tarefas";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    //OnCreate é executado apenas uma vez quando o usuário instala o app
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabela = " CREATE TABLE IF NOT EXISTS " + TABELA_TAFERAS
                   + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + " nome TEXT NOT NULL); ";

    //Recuperando informações de error caso ocorra ao criar a tabela
        try {
            db.execSQL(sqlTabela);
            Log.i("INFO DB", "Sucesso ao criar a tabela.");
            }
        catch (Exception e){
            Log.i("INFO DB", "Error ao criar a tabela" + e.getMessage());
            }
    }


// Caso lançamos uma nova versão do app e atualizamos o BD o método onUpgrade é executado
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_TAFERAS + " ;";

        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar a tabela.");
        } catch (Exception e){
            Log.i("INFO DB", "Error ao atualizar a tabela: " + e.getMessage());
        }

    }
}
