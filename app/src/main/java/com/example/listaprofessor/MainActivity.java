package com.example.listaprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.listaprofessor.controller.ListaAlunosAdapter;
import com.example.listaprofessor.model.Aluno;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Constroi lista de alunos
        ListView umaListaAlunos = findViewById(R.id.listaDeAlunos);

        List<Aluno> alunos = new LinkedList<>();

        for (int i = 0; i < 10; i++) {

            alunos.add(new Aluno("Fulano " + i, "Projeto IHC " + i * 42));
        }

        umaListaAlunos.setAdapter(new ListaAlunosAdapter(alunos, this));
    }
}