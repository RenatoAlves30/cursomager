package com.example.cursomager.controller;

import com.example.cursomager.model.Professor;
import com.example.cursomager.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public Collection<Professor> listarTodosProfessores() {
        return professorService.listarProfessores();
    }

    @PostMapping
    public Professor adicionarProfessor(@RequestBody Professor professor) {
        return professorService.adicionarProfessor(professor);
    }

    @GetMapping("/{id}")
    public Optional<Professor> buscarProfessorPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletarProfessor(@PathVariable Long id) {

        boolean removido = professorService.deletarProfessor(id);
        if (removido) {
            return "Professor removido com sucesso!";
        } else {
            return "Professor não removido!";
        }

    }
}
