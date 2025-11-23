package com.example.cursomager.controller;

import com.example.cursomager.model.Matricula;
import com.example.cursomager.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public String adicionarMatricula(@RequestBody Matricula matricula) {
        return matriculaService.realizarMatricula(matricula);
    }
    @GetMapping
    public List<Matricula> listarMatriculas() {
        return matriculaService.listarMatriculas();
    }

}
