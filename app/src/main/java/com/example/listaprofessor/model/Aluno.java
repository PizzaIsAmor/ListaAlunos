package com.example.listaprofessor.model;

public class Aluno {
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
}
