package com.example.listaprofessor.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Aluno {
    private final String nome;
    private final String projeto;
    public Aluno(String umNome, String umProjeto) {
        this.nome = umNome;
        this.projeto = umProjeto;
    }

    protected Aluno(Parcel in) {
        nome = in.readString();
        projeto = in.readString();
    }

    public String getNome() {
        return nome;
    }

    public String getProjeto() {
        return projeto;
    }

    public List<Object> getJustificativas() {
        return null;
    }

    public List<Object> getPresencas() {
        return null;
    }
}
