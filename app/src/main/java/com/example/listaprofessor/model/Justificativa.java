package com.example.listaprofessor.model;

public class Justificativa {
    private boolean ehAceito = false;
    private String texto = null;

    public Justificativa (String texto, boolean ehAceito) {
        this.texto = texto;
        this.ehAceito = ehAceito;
    }

    public String getTexto() {
        return this.texto;
    }

    public boolean ehAceito() {
        return this.ehAceito;
    }

    public void aceita() { this.ehAceito = true; }
}
