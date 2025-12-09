package com.example.cursomager.dto;

public record CursoDTO(
        Long id,
        String nome,
        int cargaHoraria,
        int vagas
) {}
