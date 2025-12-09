package com.example.cursomager.service.impl;

import com.example.cursomager.dto.AlunoDTO;
import com.example.cursomager.dto.CreateAlunoDTO;
import com.example.cursomager.mapper.AlunoMapper;
import com.example.cursomager.model.Aluno;
import com.example.cursomager.model.Curso;
import com.example.cursomager.repository.AlunoRepository;
import com.example.cursomager.repository.CursoRepository;
import com.example.cursomager.service.AlunoService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public AlunoDTO criar(CreateAlunoDTO dto) {

        Curso curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        Aluno aluno = AlunoMapper.toEntity(dto, curso);

        aluno = alunoRepository.save(aluno);

        return AlunoMapper.toDTO(aluno);
    }


    @Override
    public List<AlunoDTO> listar() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoMapper::toDTO)
                .toList();
    }

    @Override
    public AlunoDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return AlunoMapper.toDTO(aluno);
    }

    @Override
    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }
}
