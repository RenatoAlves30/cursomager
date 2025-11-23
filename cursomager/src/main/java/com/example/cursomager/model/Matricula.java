package com.example.cursomager.model;

import java.time.LocalDateTime;

public class Matricula implements Comparable<Matricula>{

    private Long id;
    private Long aluno_id;
    private Long curso_id;
    private LocalDateTime data_matricula;
    private String status;
    private int prioridade;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(Long aluno_id) {
        this.aluno_id = aluno_id;
    }

    public Long getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Long curso_id) {
        this.curso_id = curso_id;
    }

    public LocalDateTime getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(LocalDateTime data_matricula) {
        this.data_matricula = data_matricula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int compareTo(Matricula outra) {
        return Integer.compare(this.prioridade, outra.prioridade);
    }
}
