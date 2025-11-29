package com.example.cursomager.controller;

import com.example.cursomager.dto.MatriculaRequestDTO;
import com.example.cursomager.model.Aluno;
import com.example.cursomager.model.Curso;
import com.example.cursomager.model.Matricula;
import com.example.cursomager.repository.AlunoRepository;
import com.example.cursomager.repository.CursoRepository;
import com.example.cursomager.repository.MatriculaRepository;
import com.example.cursomager.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {


    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaController(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public Matricula adicionarMatricula(@RequestBody MatriculaRequestDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Matricula matricula = new Matricula(aluno, curso);

        return matriculaRepository.save(matricula);
    }
    @GetMapping
    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

}
