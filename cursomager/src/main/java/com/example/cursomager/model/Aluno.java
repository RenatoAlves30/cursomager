package com.example.cursomager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno extends Pessoa{


    private String matricula;
    private double media;

    private String situacao;

    public Aluno() {
    }

    public Aluno(Long id, String nome, String email, int idade, String matricula, double media, String situacao) {
        super(id, nome, email, idade);
        this.matricula = matricula;
        this.media = media;
        this.situacao = situacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public  String apresentar() {
        return "Aluno: " + getNome() + "\n"
                + "Média: " + getMedia() + " - Matrícula: "
                + matricula + "\n";
    }

//    @Override
//    public String toString() {
//        return "=== Aluno === \n" +
//                "Id: " + id + "\n" +
//                "Nome: " + nome + "\n" +
//                "Email: " + email + "\n" +
//                "Idade: " + idade + "\n";
//    }
//
//    public void exibirResumo() {
//        System.out.printf("Aluno: %s (%d anos) - Email: %s %n", nome, idade, email);
//    }
}
