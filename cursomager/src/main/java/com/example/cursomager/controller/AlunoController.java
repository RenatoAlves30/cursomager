package com.example.cursomager.controller;


import com.example.cursomager.dto.AlunoDTO;
import com.example.cursomager.dto.CreateAlunoDTO;
import com.example.cursomager.service.impl.AlunoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoServiceImpl alunoService;

    public AlunoController(AlunoServiceImpl alunoService) {
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
