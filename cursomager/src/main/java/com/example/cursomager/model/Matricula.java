package com.example.cursomager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;


    private LocalDateTime data_matricula = LocalDateTime.now();
    private String status = "ATIVA";



    public Matricula() {

    }

    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDateTime getData_matricula() {
        return data_matricula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
