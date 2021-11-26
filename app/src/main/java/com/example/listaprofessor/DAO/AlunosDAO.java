package com.example.listaprofessor.DAO;

import com.example.listaprofessor.model.Aluno;
import com.example.listaprofessor.model.Justificativa;
import com.example.listaprofessor.model.Presencas;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AlunosDAO {
    private static List<Aluno> alunos = new LinkedList<>();

    public static List<Aluno> createAlunos() {
        // Constroi as primeiras presencas
        List<Presencas> presencas = new LinkedList<>();
        for (int i = 25; i >= 10; i--) {
            presencas.add( new Presencas(true, i, "Novembro",
                    2021, 8, 0, null) );
        }

        // Aluno completo
        alunos.add( new Aluno("Isabel de Alcanvara",
                "Projeto de Inteligencia Artificial", false, presencas, false) );

        // Aluno nao justificado
        presencas = new LinkedList<>();
        for (int i = 25; i >= 10; i--) {
            presencas.add( new Presencas(true, i, "Novembro",
                    2021, 8, 0, null) );
        }

        alunos.add( new Aluno("Italo de Almeida","Projeto de Grafos", false,
                (List<Presencas>) ((LinkedList) presencas).clone(), true) );

        // Aluno justificado
        presencas = new LinkedList<>();
        for (int i = 25; i >= 10; i--) {
            presencas.add( new Presencas(true, i, "Novembro",
                    2021, 8, 0, null) );
        }
        presencas.get(0).justifica( new Justificativa("Nao pude ir no dia porque teve um temporal e nao deu pra ir",
                false));
        alunos.add( new Aluno("Rafael Silva","Projeto de Realidade virtual", true,
                (List<Presencas>) ((LinkedList) presencas).clone(), true) );

        // Aluno novo
        alunos.add( new Aluno("Gustavo Pereira",
                "Projeto de Computacao Grafica") );
        alunos.add( new Aluno("Muriel Antunes",
                "Projeto de Dados") );
        alunos.add( new Aluno("Igor Centeno",
                "Projeto de Biologia") );
        alunos.add( new Aluno("Helena Lunelli",
                "Projeto de Historia ") );

        // Ordena alunos
        Collections.sort(alunos, new Comparator<Aluno>() {
            @Override
            public int compare(Aluno o1, Aluno o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        return alunos;
    }
}
