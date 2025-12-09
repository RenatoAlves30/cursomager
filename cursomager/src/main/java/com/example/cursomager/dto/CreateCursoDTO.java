package com.example.cursomager.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateCursoDTO(
        @NotBlank String nome,
        @Min(1) int cargaHoraria,
        @Min(1) int vagas
) {}
