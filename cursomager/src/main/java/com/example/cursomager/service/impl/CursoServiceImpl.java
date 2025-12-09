package com.example.cursomager.service.impl;

import com.example.cursomager.dto.CreateCursoDTO;
import com.example.cursomager.dto.CursoDTO;
import com.example.cursomager.mapper.CursoMapper;
import com.example.cursomager.model.Curso;
import com.example.cursomager.repository.CursoRepository;
import com.example.cursomager.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public CursoDTO criar(CreateCursoDTO dto) {
        Curso curso = CursoMapper.toEntity(dto);
        curso = cursoRepository.save(curso);
        return CursoMapper.toDTO(curso);
    }


    public List<CursoDTO> listar() {
        return cursoRepository.findAll()
                .stream()
                .map(CursoMapper::toDTO)
                .toList();
    }

    public CursoDTO buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .map(CursoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }
}
