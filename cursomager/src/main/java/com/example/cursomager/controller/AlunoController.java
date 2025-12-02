package com.example.cursomager.controller;

import com.example.cursomager.dto.AlunoDTO;
import com.example.cursomager.mapper.AlunoMapper;
import com.example.cursomager.model.Aluno;
import com.example.cursomager.repository.AlunoRepository;
import com.example.cursomager.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    //POST
    @PostMapping
    public Aluno adicionarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    //GET
    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontradoo"));
    }

    @GetMapping("/buscarPorNome")
    public List<Aluno> buscarPorNome(@RequestParam String nome) {
        return alunoRepository.findByNomeContaining(nome);
    }

    @GetMapping("/maioresDe")
    public List<Aluno> buscarMaioresDe(@RequestParam int idade) {
        return alunoRepository.findByIdadeGreaterThan(idade);
    }

    @GetMapping("/buscarPorCurso")
    public List<Aluno> buscarPorCurso(@RequestParam String nomeCurso) {
        return alunoRepository.findByCursoNomeContaining(nomeCurso);
    }

    // Lista com Mapper
    @GetMapping("/mapped")
    public List<AlunoDTO> listarAlunosMapper() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoMapper::toDTO)
                .toList();
    }

    // DELETE BY ID
    @DeleteMapping("/{id}")
    public void removerAluno(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }

}
