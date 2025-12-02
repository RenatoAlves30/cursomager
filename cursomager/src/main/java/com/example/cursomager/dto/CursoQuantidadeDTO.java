package com.example.cursomager.dto;

public class CursoQuantidadeDTO {

    private String nomeCurso;
    private Long totalAlunos;

    public CursoQuantidadeDTO(String nomeCurso, Long totalAlunos) {
        this.nomeCurso = nomeCurso;
        this.totalAlunos = totalAlunos;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public Long getTotalAlunos() {
        return totalAlunos;
    }
}
