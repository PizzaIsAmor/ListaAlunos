package com.example.listaprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listaprofessor.controller.ListaAlunosAdapter;
import com.example.listaprofessor.model.Aluno;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Aluno> alunos = new LinkedList<>();

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
                Toast.makeText(view.getContext(), "Posicao " + position, Toast.LENGTH_SHORT).show();
                MudaPagina(position, view);
            }
        });
    }

    protected void MudaPagina(int posicao, View view) {
        System.out.println("Entrou Muda pagina");
        Intent nextPage = new Intent(view.getContext(), PerfilAluno.class);
        System.out.println("definiu intent");
//        nextPage.putExtra("product",lst_txt);
        startActivity(nextPage);
    }
}