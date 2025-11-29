package com.example.cursomager.controller;

import com.example.cursomager.model.Aluno;
import com.example.cursomager.model.Curso;
import com.example.cursomager.repository.CursoRepository;
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

    private final CursoRepository cursoRepository;
    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    //GET
    @GetMapping
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}/alunos")
    public List<Aluno> listarAlunosDoCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        return curso.getAlunos();
    }

    @PostMapping
    public Curso adicionarCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    //GET BY ID
    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
    }

    //DELETE

    @DeleteMapping("/{id}")
    public void removerCurso(@PathVariable Long id) {
        cursoRepository.deleteById(id);
    }

}
