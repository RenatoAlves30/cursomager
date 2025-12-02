package com.example.cursomager.mapper;

import com.example.cursomager.dto.CursoDTO;
import com.example.cursomager.model.Curso;

public class CursoMapper {

    public static CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getNome(),
                curso.getCarga_horaria()
        );
    }
}
