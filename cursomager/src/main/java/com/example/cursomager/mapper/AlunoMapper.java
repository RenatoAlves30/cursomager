package com.example.cursomager.mapper;

import com.example.cursomager.dto.AlunoDTO;
import com.example.cursomager.dto.CreateAlunoDTO;
import com.example.cursomager.model.Aluno;
import com.example.cursomager.model.Curso;

public class AlunoMapper {

    public static AlunoDTO toDTO(Aluno aluno) {

        String nomeCurso = aluno.getCurso() != null ? aluno.getCurso().getNome() : "Sem curso";

        return new AlunoDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                nomeCurso
        );
    }

    public static Aluno toEntity(CreateAlunoDTO dto, Curso curso) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setIdade(dto.getIdade());
        aluno.setMatricula(dto.getMatricula());
        aluno.setCurso(curso);
        return aluno;
    }
}
