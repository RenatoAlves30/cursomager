package com.example.cursomager.controller;

import com.example.cursomager.dto.RelatorioAlunosPorCursoDTO;
import com.example.cursomager.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/alunosPorCurso/{cursoId}")
    public RelatorioAlunosPorCursoDTO alunosPorCurso(@PathVariable Long cursoId) {
        return relatorioService.gerarRelatorio(cursoId);
    }
}
