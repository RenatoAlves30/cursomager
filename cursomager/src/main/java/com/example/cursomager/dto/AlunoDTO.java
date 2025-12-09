package com.example.cursomager.dto;

public record AlunoDTO(
        Long id,
        String nome,
        String email,
        Integer idade,
        String matriculas,
        String curso
) {}
