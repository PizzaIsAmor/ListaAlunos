package com.example.listaprofessor.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.LinkedList;
import java.util.List;

public class Aluno {
    private final String nome;
    private final String projeto;
    private List<Presencas> listPresenca= new LinkedList();
    private boolean faltou = false;
    private boolean jaJustificou = false;
    private boolean aceito = false;

    public Aluno(String umNome, String umProjeto) {
        this.nome = umNome;
        this.projeto = umProjeto;
    }

    public Aluno(String umNome, String umProjeto, boolean jaJustificou,
                 List<Presencas> listPrenca, boolean faltou) {
        this.nome = umNome;
        this.projeto = umProjeto;
        this.listPresenca = listPrenca;
        this.faltou = faltou;
        this.jaJustificou = jaJustificou;
    }

    public String getNome() {
        return nome;
    }

    public String getProjeto() {
        return projeto;
    }

    public boolean getJustificativas() {
        return this.jaJustificou;
    }

    public void setJustificativas(boolean jaJustificou) {
        this.jaJustificou = jaJustificou;
    }

    public List<Presencas> getPresencas() {
        return this.listPresenca;
    }

    public boolean jaFaltou() {
        return this.faltou;
    }

    public void aceitaJust() {
        this.aceito = true;
    }

    public boolean getAceita() {
        return this.aceito;
    }
}
