package com.example.cursomager.service;

import com.example.cursomager.dto.AlunoDTO;
import com.example.cursomager.dto.CreateAlunoDTO;

import java.util.List;

public interface AlunoService {
    AlunoDTO criar(CreateAlunoDTO dto);

    List<AlunoDTO> listar();

    AlunoDTO buscarPorId(Long id);

    void deletar(Long id);
}
