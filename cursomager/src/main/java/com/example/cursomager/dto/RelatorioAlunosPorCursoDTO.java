package com.example.cursomager.dto;

import java.util.List;

public class RelatorioAlunosPorCursoDTO {

    private String curso;
    private int carga_horaria;
    private int totalAlunos;
    private List<AlunoResumoDTO> alunos;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    public List<AlunoResumoDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoResumoDTO> alunos) {
        this.alunos = alunos;
    }
}
