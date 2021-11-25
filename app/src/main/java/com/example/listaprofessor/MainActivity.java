package com.example.listaprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.listaprofessor.controller.ListaAlunosAdapter;
import com.example.listaprofessor.model.Aluno;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Aluno> alunos = new LinkedList<>();
    public static Aluno alunoEscolhido = null;
    private ListView umaListaAlunos = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Constroi lista de alunos
        umaListaAlunos = findViewById(R.id.listaDeAlunos);

        for (int i = 0; i < 10; i++) {

            alunos.add(new Aluno("Fulano " + i, "Projeto IHC " + i * 42));
        }

        ehListaVazia(alunos);
        umaListaAlunos.setAdapter(new ListaAlunosAdapter(alunos, this));
        umaListaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MudaPagina(position, view);
            }
        });

        // Search View
        SearchView buscador = findViewById(R.id.fieldBuscar);

        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String pal) {
                List<Aluno> filtrado = new LinkedList<>();

                for (Aluno umAluno: alunos) {
                    if (umAluno.getNome().toLowerCase().contains(pal.toLowerCase())) {
                        filtrado.add(umAluno);
                    }
                }
                umaListaAlunos.setAdapter(new ListaAlunosAdapter(filtrado, getApplicationContext()));
                ehListaVazia(filtrado);
                return false;
            }
        });
    }

    protected void MudaPagina(int posicao, View view) {
        Intent nextPage = new Intent(view.getContext(), PerfilAluno.class);
        MainActivity.alunoEscolhido = alunos.get(posicao);
        startActivity(nextPage);
    }

    private void ehListaVazia(List<Aluno> lista) {
        if (lista == null || lista.isEmpty()) {
            findViewById(R.id.alunosNaoEncontados).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.alunosNaoEncontados).setVisibility(View.INVISIBLE);
        }
    }
}