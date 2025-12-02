package com.example.cursomager.dto;

public class CursoDTO {

    private Long id;
    private String nome;
    private int cargaHoraria;

    public CursoDTO(Long id, String nome, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

}
