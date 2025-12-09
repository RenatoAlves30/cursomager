package com.example.cursomager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAlunoDTO(
        @NotBlank String nome,
        @Email @NotBlank String email,
        @NotNull @Min(16) Integer idade,
        @NotBlank String matricula,
        @NotNull Long cursoId
) {
}
