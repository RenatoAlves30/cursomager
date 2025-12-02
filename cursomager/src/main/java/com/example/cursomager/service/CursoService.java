package com.example.cursomager.service;

import com.example.cursomager.dto.CreateCursoDTO;
import com.example.cursomager.dto.CursoDTO;
import com.example.cursomager.mapper.CursoMapper;
import com.example.cursomager.model.Curso;
import com.example.cursomager.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
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

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }
}
