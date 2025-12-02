package com.example.cursomager.dto;

import jakarta.validation.constraints.*;

public class CreateAlunoDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotNull(message = "A idade é obrigatória")
    @Min(value = 16, message = "A idade mínima é 16 anos")
    private Integer idade;

    @NotBlank(message = "A matrícula é obrigatória")
    private String matricula;

    @NotNull(message = "O ID do curso é obrigatório")
    private Long cursoId;

    public CreateAlunoDTO() {

    }

    public CreateAlunoDTO(String nome, String email, Integer idade, String matricula, Long cursoId) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.matricula = matricula;
        this.cursoId = cursoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
