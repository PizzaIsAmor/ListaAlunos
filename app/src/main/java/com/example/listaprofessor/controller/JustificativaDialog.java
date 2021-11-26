package com.example.listaprofessor.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.listaprofessor.PerfilAluno;
import com.example.listaprofessor.R;
import com.example.listaprofessor.model.Justificativa;

public class JustificativaDialog extends AppCompatDialogFragment {
    private String titulo;
    private Justificativa just;

    public JustificativaDialog (Justificativa umaJust, String titulo) {
        this.just = umaJust;
        this.titulo = titulo;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_justificativa_dialog, null);
        builder.setView(view)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setPositiveButton("Aceitar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                PerfilAluno.aceitaJustificativa();
            }
        });

        ((TextView) view.findViewById(R.id.dialogTitulo)).setText(this.titulo);
        ((TextView) view.findViewById(R.id.dialogText)).setText(this.just.getTexto());

        return builder.create();
    }
}
