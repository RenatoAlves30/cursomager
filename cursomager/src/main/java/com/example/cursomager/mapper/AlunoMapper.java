package com.example.cursomager.mapper;

import com.example.cursomager.dto.AlunoDTO;
import com.example.cursomager.dto.CreateAlunoDTO;
import com.example.cursomager.model.Aluno;
import com.example.cursomager.model.Curso;

public class AlunoMapper {

    public static Aluno toEntity(CreateAlunoDTO dto, Curso curso) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setIdade(dto.idade());
        aluno.setMatricula(dto.matricula());
        aluno.setCurso(curso);
        aluno.setSituacao("ATIVO");
        return aluno;
    }

    public static AlunoDTO toDTO(Aluno aluno) {
        return new AlunoDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getIdade(),
                aluno.getMatricula(),
                aluno.getCurso() != null ? aluno.getCurso().getNome() : null
        );
    }
}