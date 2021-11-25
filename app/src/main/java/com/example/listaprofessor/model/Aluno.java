package com.example.listaprofessor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Aluno implements Parcelable {
    private final String nome;
    private final String projeto;
    public Aluno(String umNome, String umProjeto) {
        this.nome = umNome;
        this.projeto = umProjeto;
    }

    public String getNome() {
        return nome;
    }

    public String getProjeto() {
        return projeto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
