package com.example.cursomager.controller;

import com.example.cursomager.model.Curso;
import com.example.cursomager.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")

public class CursoController {

    @Autowired
    private CursoService cursoService;

    //GET
    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarTodos();
    }

    @PostMapping
    public String adicionarCurso(@RequestBody Curso curso) {
        return cursoService.adicionarCurso(curso);
    }

    //GET BY ID
    @GetMapping("/{id}")
    public Optional<Curso> buscarPorId(@PathVariable Long id) {
        return cursoService.buscarCursoPorId(id);
    }

    //DELETE

    @DeleteMapping("/{id}")
    public String removerCurso(@PathVariable Long id) {
        return cursoService.removerCurso(id);
    }

}
