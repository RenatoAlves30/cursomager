package com.example.cursomager.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int carga_horaria;
    private int vagas;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Aluno> alunos = new ArrayList<>();

    public Curso() {
    }

    public Curso(Long id, String nome, int carga_horaria, int vagas) {
        this.id = id;
        this.nome = nome;
        this.carga_horaria = carga_horaria;
        this.vagas = vagas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso curso)) return false;
        return getCarga_horaria() == curso.getCarga_horaria() && getVagas() == curso.getVagas() && Objects.equals(getId(), curso.getId()) && Objects.equals(getNome(), curso.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCarga_horaria(), getVagas());
    }

    @Override
    public String toString() {
        return "=== Curso ===: " + "\n" +
                "Id: " + id + "\n" +
                "NomeDoCurso: " + nome + "\n" +
                "CargaHoraria: " + carga_horaria + "\n";
    }

    public void exibirResumo() {
        System.out.printf("Curso: %s - Carga Horária: %dh %n", nome, carga_horaria);
    }

}
