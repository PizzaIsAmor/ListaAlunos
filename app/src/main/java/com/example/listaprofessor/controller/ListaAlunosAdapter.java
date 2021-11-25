package com.example.listaprofessor.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listaprofessor.R;
import com.example.listaprofessor.model.Aluno;

import java.util.List;

public class ListaAlunosAdapter extends BaseAdapter {
    private List<Aluno> alunos;
    private Context contexto;

    public ListaAlunosAdapter(List<Aluno> umaListaDeAlunos, Context umContexto) {
        this.alunos = umaListaDeAlunos;
        this.contexto = umContexto;
    }

    @Override
    public int getCount() {
        return this.alunos.size();
    }

    @Override
    public Aluno getItem(int i) {
        return this.alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(contexto).inflate(R.layout.item_aluno, parent, false);
        Aluno aluno = alunos.get(posicao);

        ((TextView) viewCriada.findViewById(R.id.nomeAluno)).setText(aluno.getNome());
        ((TextView) viewCriada.findViewById(R.id.nomeProjeto)).setText(aluno.getProjeto());

        return viewCriada;
    }
}
