package com.example.cursomager.mapper;

import com.example.cursomager.dto.AlunoDTO;
import com.example.cursomager.model.Aluno;

public class AlunoMapper {

    public static AlunoDTO toDTO(Aluno aluno) {
        return new AlunoDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula()
        );
    }
}
