package com.example.cursomager.service;

import com.example.cursomager.dto.CreateCursoDTO;
import com.example.cursomager.dto.CursoDTO;

import java.util.List;

public interface CursoService {
    CursoDTO criar(CreateCursoDTO dto);

    List<CursoDTO> listar();

    CursoDTO buscarPorId(Long id);
}
