package com.example.cursomager.controller;

import com.example.cursomager.dto.CreateCursoDTO;
import com.example.cursomager.dto.CursoDTO;
import com.example.cursomager.model.Curso;
import com.example.cursomager.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")

public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public CursoDTO criar(@RequestBody @Valid CreateCursoDTO dto) {
        return cursoService.criar(dto);
    }

    @GetMapping
    public List<CursoDTO> listar() {
        return cursoService.listar();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cursoService.deletar(id);
    }

}
