package com.example.cursomager.mapper;

import com.example.cursomager.dto.CursoDTO;
import com.example.cursomager.dto.CreateCursoDTO;
import com.example.cursomager.model.Curso;

public class CursoMapper {

    public static Curso toEntity(CreateCursoDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.nome());
        curso.setCarga_horaria(dto.cargaHoraria());
        curso.setVagas(dto.vagas());
        return curso;
    }

    public static CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getNome(),
                curso.getCarga_horaria(),
                curso.getVagas()
        );
    }
}
