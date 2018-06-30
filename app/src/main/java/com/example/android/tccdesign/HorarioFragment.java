package com.example.android.tccdesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HorarioFragment extends Fragment {


    public HorarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_horario, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Segunda","PRC", "LCS", "265.3", "PRC", "LCS", "265.3","PRC", "LCS", "265.3","LPC", "TBV", "359", "EF","ARL","-" ,"GE","ADL","552","ICP","CSM","455","ICP","CSM","455","-","-","-"));
        words.add(new Word("Terça","PRC", "LCS", "265.3", "PRC", "LCS", "265.3","PRC", "LCS", "265.3","LPC", "TBV", "359", "EF","ARL","-" ,"GE","ADL","552","ICP","CSM","455","ICP","CSM","455","-","-","-"));
        words.add(new Word("Quarta","PRC", "LCS", "265.3", "PRC", "LCS", "265.3","PRC", "LCS", "265.3","LPC", "TBV", "359", "EF","ARL","-" ,"GE","ADL","552","ICP","CSM","455","ICP","CSM","455","-","-","-"));
        words.add(new Word("Quinta","PRC", "LCS", "265.3", "PRC", "LCS", "265.3","PRC", "LCS", "265.3","LPC", "TBV", "359", "EF","ARL","-" ,"GE","ADL","552","ICP","CSM","455","ICP","CSM","455","-","-","-"));
        words.add(new Word("Sexta","PRC", "LCS", "265.3", "PRC", "LCS", "265.3","PRC", "LCS", "265.3","LPC", "TBV", "359", "EF","ARL","-" ,"GE","ADL","552","ICP","CSM","455","ICP","CSM","455","-","-","-"));

        WordAdapter adapter = new WordAdapter(getActivity(), words);
        ListView horario = (ListView) rootView.findViewById(R.id.horario);
        horario.setAdapter(adapter);
        return rootView;
    }

}
