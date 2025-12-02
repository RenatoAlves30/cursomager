package com.example.cursomager.controller;

import com.example.cursomager.dto.CursoQuantidadeDTO;
import com.example.cursomager.repository.CursoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final CursoRepository cursoRepository;

    public RelatorioController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/cursosComMaisAlunos")
    public List<CursoQuantidadeDTO> cursosComMaisalunos() {
        return cursoRepository.listarCursosComMaisAlunos();
    }

}
