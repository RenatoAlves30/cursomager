package com.example.cursomager.controller;

import com.example.cursomager.dto.AlunoDTO;
import com.example.cursomager.dto.CreateAlunoDTO;
import com.example.cursomager.mapper.AlunoMapper;
import com.example.cursomager.model.Aluno;
import com.example.cursomager.repository.AlunoRepository;
import com.example.cursomager.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoDTO criar(@RequestBody @Valid CreateAlunoDTO dto) {
        return alunoService.criar(dto);
    }

    @GetMapping
    public List<AlunoDTO> listar() {
        return alunoService.listar();
    }

    @GetMapping("/{id}")
    public AlunoDTO buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alunoService.deletar(id);
    }

}
