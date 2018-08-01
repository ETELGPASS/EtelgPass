package com.example.android.tccdesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
    TextView txt_Porcentagem;

    Classe classe = new Classe();

    public CarteirinhaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carteirinha, container, false);

        txt_RM = view.findViewById(R.id.txt_RM);
        txt_Nome = view.findViewById(R.id.txt_Nome);
        txt_Sala = view.findViewById(R.id.txt_Sala);
        txt_Curso = view.findViewById(R.id.txt_Curso);
        txt_Numero = view.findViewById(R.id.txt_Numero);
        txt_Validade = view.findViewById(R.id.txt_Validade);
        txt_Porcentagem = view.findViewById(R.id.txt_porcentagem);

        txt_RM.setText(classe.getRM());
        txt_Nome.setText(classe.getNome());
        txt_Sala.setText(classe.getSala());
        txt_Curso.setText(classe.getCurso());
        txt_Numero.setText(classe.getNumero());
        txt_Validade.setText(classe.getValidade());
        txt_Porcentagem.setText(Classe.getPorcentagemGeral() + "%");

        txt_RM.setAllCaps(true);
        // Inflate the layout for this fragment
        return view;
    }
}
