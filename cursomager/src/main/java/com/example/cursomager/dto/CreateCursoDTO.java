package com.example.cursomager.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateCursoDTO {
    @NotBlank(message = "O nome do curso é obrigatório.")
    private String nome;

    @Min(value = 1, message = "A carga horária deve ser maior que 0.")
    private int carga_horaria;

    @Min(value = 1, message = "O número de vagas deve ser maior que 0.")
    private int vagas;

    public CreateCursoDTO() {
    }

    public CreateCursoDTO(String nome, int carga_horaria, int vagas) {
        this.nome = nome;
        this.carga_horaria = carga_horaria;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }


}
