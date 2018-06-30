package com.example.android.tccdesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotasFragment extends Fragment {

    Aluno aluno = new Aluno();
    public String[] Disciplina = new String[20];
    public String[] Professor = new String[20];
    public String[] Conceito1 = new String[20];
    public String[] Conceito2 = new String[20];
    public String[] Conceito3 = new String[20];
    public String[] Conceito4 = new String[20];
    public String[] ConceitoFinal = new String[20];
    public String[] PorcentagemFaltas = new String[20];
    int i;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notas, container, false);

        Disciplina = getArguments().getStringArray("Disciplina");
        Professor = getArguments().getStringArray("Professor");
        Conceito1 = getArguments().getStringArray("Conceito1");
        Conceito2 = getArguments().getStringArray("Conceito2");
        Conceito3 = getArguments().getStringArray("Conceito3");
        Conceito4 = getArguments().getStringArray("Conceito4");
        ConceitoFinal = getArguments().getStringArray("ConceitoFinal");
        PorcentagemFaltas = getArguments().getStringArray("PorcentagemFaltas");
        i = getArguments().getInt("Contador");

        final ArrayList<Word> words = new ArrayList<Word>();
        for(int j = 0; j < i; j++)
        {
            words.add(new Word(Disciplina[j], Conceito1[j], Conceito2[j], Conceito3[j], Conceito4[j]));
        }
        /*
        words.add(new Word("Matemática", "R", "MB", "B", "B"));
        words.add(new Word("Português", "R", "I", "B", "B"));
        words.add(new Word("Geografia", "R", "B", "B", "B"));
        words.add(new Word("Física", "R", "R", "B", "B"));
        words.add(new Word("Sociologia", "R", "MB", "B", "R"));
        words.add(new Word("Filosofia", "I", "MB", "B", "B"));
        words.add(new Word("História", "R", "MB", "B", "B"));
        words.add(new Word("Química", "R", "MB", "B", "B"));
        */

        WordAdapter adapter = new WordAdapter(getActivity(), words);
        ListView nota = (ListView) rootView.findViewById(R.id.notas);
        nota.setAdapter(adapter);
        return rootView;
    }

}
