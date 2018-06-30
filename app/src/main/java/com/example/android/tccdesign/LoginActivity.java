package com.example.android.tccdesign;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity {

    private RequestQueue mQueue;
    Aluno aluno = new Aluno();
    Button btn_Logar;
    EditText txt_RM;
    public static final String PREFS_NAME = "MyPrefsFile";
    Intent intent;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mQueue = Volley.newRequestQueue(this);

        intent = new Intent(getApplicationContext(), MainActivity.class);

        btn_Logar = (Button)findViewById(R.id.buttonLogin);
        txt_RM = (EditText) findViewById(R.id.editText_RM);

        btn_Logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logar(txt_RM.getText().toString());
            }
        });
    }

    public void Logar(final String RM)
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logando...");
        progressDialog.show();

        String url = "https://etelg-pass.000webhostapp.com/API-NOTAS/API-ETE/resultado.php?rm=" + RM;

        if(isOnline(getApplicationContext()) == false)
        {

        }

        else
        {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>(){
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONObject inicio = response.getJSONObject("0");
                                JSONObject jsonObject = inicio.getJSONObject("Aluno");

                                String Nome = jsonObject.getString("Nome");
                                String Sala = jsonObject.getString("Sala");
                                String Curso = jsonObject.getString("Curso");
                                String Validade = jsonObject.getString("Ano");
                                String Número = jsonObject.getString("Número");


                                JSONArray jsonArray = response.getJSONArray("Notas");

                                for(i = 0; i < jsonArray.length(); i++)
                                {
                                    JSONObject Notas = jsonArray.getJSONObject(i);

                                    Disciplina[i] = Notas.getString("disciplina");
                                    Professor[i] = Notas.getString("professor");
                                    Conceito1[i] = Notas.getString("conceito1");
                                    Conceito2[i] = Notas.getString("conceito2");
                                    Conceito3[i] = Notas.getString("conceito3");
                                    Conceito4[i] = Notas.getString("conceito4");
                                    ConceitoFinal[i] = Notas.getString("conceito_final");
                                    PorcentagemFaltas[i] = Notas.getString("porcentagem");
                                }


                                if(Nome != "")
                                {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("RM", RM);
                                    bundle.putString("Nome", Nome);
                                    bundle.putString("Sala", Sala);
                                    bundle.putString("Curso", Curso);
                                    bundle.putString("Validade", Validade);
                                    bundle.putString("Número", Número);
                                    bundle.putInt("Contador", i);
                                    bundle.putStringArray("Disciplina", Disciplina);
                                    bundle.putStringArray("Professor", Professor);
                                    bundle.putStringArray("Conceito1", Conceito1);
                                    bundle.putStringArray("Conceito2", Conceito2);
                                    bundle.putStringArray("Conceito3", Conceito3);
                                    bundle.putStringArray("Conceito4", Conceito4);
                                    bundle.putStringArray("ConceitoFinal", ConceitoFinal);
                                    bundle.putStringArray("PorcentagemFaltas", PorcentagemFaltas);
                                    intent.putExtras(bundle);
                                    progressDialog.dismiss();
                                    startActivity(intent);
                                }

                                else
                                {
                                    progressDialog.setMessage("RM Inválido");
                                    Toast.makeText(getApplicationContext(), "RM Inválido", Toast.LENGTH_LONG).show();
                                    txt_RM.setText("");
                                    progressDialog.dismiss();
                                }

                            } catch (JSONException e) {
                                progressDialog.setMessage(e.getMessage());
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                                txt_RM.setText("");
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    progressDialog.setMessage(error.getMessage());
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    txt_RM.setText("");
                    progressDialog.dismiss();
                }
            });

            mQueue.add(request);
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected())
            return true;
        else
            return false;
    }

}
