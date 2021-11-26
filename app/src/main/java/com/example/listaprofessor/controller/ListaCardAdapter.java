package com.example.listaprofessor.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.listaprofessor.R;
import com.example.listaprofessor.model.Justificativa;
import com.example.listaprofessor.model.Presencas;

import java.util.List;

public class ListaCardAdapter extends BaseAdapter {
    private List<Presencas> presenca;
    private List<Justificativa> just;
    private Context contexto;
    private boolean ehJust = false;

    public ListaCardAdapter(List<Presencas> presencas, Context umContexto) {
        this.presenca = presencas;
        this.contexto = umContexto;
        this.ehJust = false;
    }

    public ListaCardAdapter(List<Justificativa> justificativa, Context umContexto, List<Presencas> presenca) {
        this.just = justificativa;
        this.contexto = umContexto;
        this.presenca = presenca;
        this.ehJust = true;
    }

    @Override
    public int getCount() {
        if (this.presenca != null)
            return this.presenca.size();
        return 0;
    }

    @Override
    public Presencas getItem(int i) {
        if (this.presenca != null)
            return this.presenca.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(contexto).inflate(R.layout.item_card_presenca, parent, false);
        if (!this.ehJust) {
            viewCriada = listaPresenca(viewCriada, posicao);
        } else {
            viewCriada = listaJustificativa(viewCriada, posicao);
        }

        return viewCriada;
    }

    private View listaJustificativa(View viewCriada, int posicao) {
        Presencas umaPresenca = presenca.get(posicao);

        ((TextView) viewCriada.findViewById(R.id.item_cardData)).setText("" + umaPresenca.getDia() +
                " de " + umaPresenca.getMes() + " de " + umaPresenca.getAno());

        Justificativa umaJust = just.get(posicao);
        if(umaJust.ehAceito()) {
            ((ImageView) viewCriada.findViewById(R.id._item_cardFigura)).setImageResource(R.drawable.vec_done_card);
            ((ImageView) viewCriada.findViewById(R.id.item_cardBackgroud)).setImageResource(R.color.cor_done);
            ((TextView) viewCriada.findViewById(R.id.item_cardInfo)).setText("Justificativa respondida");
        } else {
            // Justificadas não vista
            ((TextView) viewCriada.findViewById(R.id.item_cardInfo)).setText("Pendente");
            ((ImageView) viewCriada.findViewById(R.id._item_cardFigura)).setImageResource(R.drawable.vec_atencao_card);
            ((ImageView) viewCriada.findViewById(R.id.item_cardBackgroud)).setImageResource(R.color.cor_atencao);
        }

        return viewCriada;
    }

    private View listaPresenca(View viewCriada, int posicao) {
        Presencas umaPresenca = presenca.get(posicao);

        ((TextView) viewCriada.findViewById(R.id.item_cardData)).setText("" + umaPresenca.getDia() +
                " de " + umaPresenca.getMes() + " de " + umaPresenca.getAno());

        if (umaPresenca.ehMarcado()) {  // Não tem faltas
            ((TextView) viewCriada.findViewById(R.id.item_cardInfo)).setText(
                    String.format("Marcado as %d:%02d", umaPresenca.getHora(), umaPresenca.getMinutos()));
            ((ImageView) viewCriada.findViewById(R.id._item_cardFigura)).setImageResource(R.drawable.vec_done_card);
            ((ImageView) viewCriada.findViewById(R.id.item_cardBackgroud)).setImageResource(R.color.cor_done);
        } else if (umaPresenca.getJust() == null) {  // Tem faltas não justificadas
            ((TextView) viewCriada.findViewById(R.id.item_cardInfo)).setText("No aguardo de justificativa");
            ((ImageView) viewCriada.findViewById(R.id._item_cardFigura)).setImageResource(R.drawable.vec_nao_completo_card);
            ((ImageView) viewCriada.findViewById(R.id.item_cardBackgroud)).setImageResource(R.color.cor_nao_completo);
        } else if (!umaPresenca.getJust().ehAceito()) {  // Tem faltas justificadas não aceitas
            ((TextView) viewCriada.findViewById(R.id.item_cardInfo)).setText("Justificativa pendente");
            ((ImageView) viewCriada.findViewById(R.id._item_cardFigura)).setImageResource(R.drawable.vec_atencao_card);
            ((ImageView) viewCriada.findViewById(R.id.item_cardBackgroud)).setImageResource(R.color.cor_atencao);
        } else {  // Tem faltas justificadas aceitas
            ((ImageView) viewCriada.findViewById(R.id._item_cardFigura)).setImageResource(R.drawable.vec_done_card);
            ((ImageView) viewCriada.findViewById(R.id.item_cardBackgroud)).setImageResource(R.color.cor_done);
            ((TextView) viewCriada.findViewById(R.id.item_cardInfo)).setText("Justificativa respondida");
        }

        return viewCriada;
    }
}
