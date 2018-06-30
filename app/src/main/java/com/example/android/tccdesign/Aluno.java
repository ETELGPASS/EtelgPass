package com.example.android.tccdesign;

public class Aluno {
    private String RM;
    private String Nome;
    private String Curso;
    private String Validade;
    private String Sala;
    private String Numero;
    public int i;

    public String[] Disciplina = new String[20];
    public String[] Professor = new String[20];
    public String[] Conceito1 = new String[20];
    public String[] Conceito2 = new String[20];
    public String[] Conceito3 = new String[20];
    public String[] Conceito4 = new String[20];
    public String[] ConceitoFinal = new String[20];
    public String[] PorcentagemFaltas = new String[20];

    public String getRM() {
        return RM;
    }

    public void setRM(String RM) {
        this.RM = RM;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public String getValidade() {
        return Validade;
    }

    public void setValidade(String validade) {
        Validade = validade;
    }

    public String getSala() {
        return Sala;
    }

    public void setSala(String sala) {
        Sala = sala;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

}
