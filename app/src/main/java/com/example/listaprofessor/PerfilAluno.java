package com.example.listaprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.listaprofessor.model.Aluno;

import java.util.List;

public class PerfilAluno extends AppCompatActivity {
    private boolean ehJustificativa = false;
    Aluno aluno = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_aluno);

        Intent intent = getIntent();
        aluno = MainActivity.alunoEscolhido;

        //Adiciona Nome
        setConfig();

        // Botão voltar
        criarBotaoVoltar();

        // seta Lista
        setConteudoLista();
        ehShowMensagemNaoEncontrado();

        // seta Troca de menu (Presen <-> Justificativa)
        ((TextView) findViewById(R.id.selecaoFrequencia)).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mudaSelecao(false);
                setConteudoLista();
                ehShowMensagemNaoEncontrado();
            }
        });

        ((TextView) findViewById(R.id.selecaoJustificativas)).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mudaSelecao(true);
                setConteudoLista();
                ehShowMensagemNaoEncontrado();
            }
        });
    }

    private void mudaSelecao(Boolean seleJustificativa) {
        TextView opcaoJust = (TextView) findViewById(R.id.selecaoJustificativas);
        TextView opcaoFreq = (TextView) findViewById(R.id.selecaoFrequencia);
        String primary_color = "#ff0099CC";
        String secondary_color = "#B38C8F8F";

        if (this.ehJustificativa && !seleJustificativa) { // Apaga justificativa
            opcaoJust.setTextColor(Color.parseColor(secondary_color)); // grey
            opcaoJust.setTypeface(opcaoJust.getTypeface(), Typeface.NORMAL);

            opcaoFreq.setTextColor(Color.parseColor(primary_color)); // grey
            opcaoFreq.setTypeface(opcaoFreq.getTypeface(), Typeface.BOLD);
            this.ehJustificativa = !this.ehJustificativa;
        } else if (!this.ehJustificativa && seleJustificativa) {                    // Acende Justificativa
            opcaoFreq.setTextColor(Color.parseColor(secondary_color)); // grey
            opcaoFreq.setTypeface(opcaoFreq.getTypeface(), Typeface.NORMAL);

            opcaoJust.setTextColor(Color.parseColor(primary_color)); // grey
            opcaoJust.setTypeface(opcaoJust.getTypeface(), Typeface.BOLD);
            this.ehJustificativa = !this.ehJustificativa;
        }
    }

    private void setConteudoLista() {

    }

    private void setConfig() {
        ((TextView) findViewById(R.id.perfilAluno_nome)).setText(aluno.getNome());
    }

    private void criarBotaoVoltar() {
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private boolean ehListaVazia(List<Object> lista) {
        if (lista == null || lista.isEmpty())
            return true;

        return false;
    }

    private void ehShowMensagemNaoEncontrado() {
        if (this.ehJustificativa && ehListaVazia(this.aluno.getJustificativas())) {
            ((TextView) findViewById(R.id.perfilAluno_erroExplicacao)).setText("O aluno ainda nao possui justificativas");
            findViewById(R.id.perfrilAluno_naoEncontrado).setVisibility(View.VISIBLE);
        } else if (!this.ehJustificativa && ehListaVazia(this.aluno.getPresencas())) {
            ((TextView) findViewById(R.id.perfilAluno_erroExplicacao)).setText("O aluno ainda nao possui presencas");
            findViewById(R.id.perfrilAluno_naoEncontrado).setVisibility(View.VISIBLE);
        } else
            findViewById(R.id.perfrilAluno_naoEncontrado).setVisibility(View.INVISIBLE);
    }
}