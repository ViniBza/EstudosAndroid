package com.example.listadetarefas.Model;

import java.io.Serializable;

//Serializable para realizar uma a transferencia da tarefa para outra tela
public class Tarefa implements Serializable {

    private long id;
    private String nomeTarefa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }
}
