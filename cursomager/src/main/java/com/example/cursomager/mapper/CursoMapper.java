package com.example.cursomager.mapper;

import com.example.cursomager.dto.CreateCursoDTO;
import com.example.cursomager.dto.CursoDTO;
import com.example.cursomager.model.Curso;

public class CursoMapper {

    public static CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getNome(),
                curso.getCarga_horaria(),
                curso.getVagas()
        );
    }

    public static Curso toEntity(CreateCursoDTO dto) {
        Curso curso = new Curso();

        curso.setNome(dto.getNome());
        curso.setCarga_horaria(dto.getCarga_horaria());
        curso.setVagas(dto.getVagas());

        return curso;
    }
}
