package com.example.listaprofessor.model;

public class Presencas {
    private int dia;
    private String mes;
    private int ano;
    private Justificativa just = null;
    private int hora;
    private int minutos;
    private boolean ehMarcado = false;

    public Presencas(boolean ehMarcado, int dia, String mes, int ano, int hora,
                     int minutos, Justificativa just) {
        this.ehMarcado = ehMarcado;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minutos = minutos;
        this.just = just;
    }

    public int getAno() {
        return ano;
    }

    public int getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public Justificativa getJust() {
        return just;
    }

    public String getMes() {
        return mes;
    }

    public boolean ehMarcado(){
        return ehMarcado;
    }

    public void desmarca(){
        this.ehMarcado = false;
    }

    public void marca(int dia, String mes, int ano, int hora, int minutos) {
        this.ehMarcado = true;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minutos = minutos;
    }

    public void justifica(Justificativa nova) {
        this.just = nova;
    }
}
