package com.example.android.tccdesign;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Intent.getIntent;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarteirinhaFragment extends Fragment {

    TextView txt_RM;
    TextView txt_Nome;
    TextView txt_Sala;
    TextView txt_Curso;
    TextView txt_Validade;
    TextView txt_Numero;
    Aluno aluno = new Aluno();

    public CarteirinhaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carteirinha, container, false);

        txt_RM = (TextView)view.findViewById(R.id.txt_RM);
        txt_Nome = (TextView)view.findViewById(R.id.txt_Nome);
        txt_Sala = (TextView)view.findViewById(R.id.txt_Sala);
        txt_Curso = (TextView)view.findViewById(R.id.txt_Curso);
        txt_Numero = (TextView)view.findViewById(R.id.txt_Numero);
        txt_Validade = (TextView)view.findViewById(R.id.txt_Validade);

        txt_RM.setText(getArguments().getString("RM"));
        txt_Nome.setText(getArguments().getString("Nome"));
        txt_Sala.setText(getArguments().getString("Sala"));
        txt_Curso.setText(getArguments().getString("Curso"));
        txt_Numero.setText(getArguments().getString("Número"));
        txt_Validade.setText(getArguments().getString("Validade"));

        // Inflate the layout for this fragment
        return view;
    }
}
