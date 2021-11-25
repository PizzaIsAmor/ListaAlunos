package com.example.listaprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.listaprofessor.model.Aluno;

public class PerfilAluno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_aluno);

        Intent intent = getIntent();
        Aluno aluno = MainActivity.alunoEscolhido;

        ((TextView) findViewById(R.id.perfilAluno_nome)).setText(aluno.getNome());

        // Botão voltar
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}