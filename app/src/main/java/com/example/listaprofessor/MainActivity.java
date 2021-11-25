package com.example.listaprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listaprofessor.controller.ListaAlunosAdapter;
import com.example.listaprofessor.model.Aluno;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Aluno> alunos = new LinkedList<>();
    public static Aluno alunoEscolhido = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Constroi lista de alunos
        ListView umaListaAlunos = findViewById(R.id.listaDeAlunos);

        for (int i = 0; i < 10; i++) {

            alunos.add(new Aluno("Fulano " + i, "Projeto IHC " + i * 42));
        }

        umaListaAlunos.setAdapter(new ListaAlunosAdapter(alunos, this));

        umaListaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MudaPagina(position, view);
            }
        });
    }

    protected void MudaPagina(int posicao, View view) {
        Intent nextPage = new Intent(view.getContext(), PerfilAluno.class);
        MainActivity.alunoEscolhido = alunos.get(posicao);
        startActivity(nextPage);
    }
}