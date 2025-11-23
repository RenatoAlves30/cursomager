package com.example.cursomager.model;

public class Professor extends Pessoa{


    public Professor() {
    }

    public Professor(Long id, String nome, String email, int idade) {
        super(id, nome, email, idade);
    }

    public String apresentar() {
        return "Professor: " + getNome() + " Especialidade: " +"\n";
    }
}
