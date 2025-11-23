package com.example.cursomager.controller;

import com.example.cursomager.service.DatabaseTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DatabaseController {

    @Autowired
    private DatabaseTestService databaseTestService;

    @GetMapping("/testar-conexao")
    public String testarConexao() {
        return databaseTestService.testarConexao();
    }

    @GetMapping("/version")
    public Map<String, Object> getVersionBanco() {
        return databaseTestService.getVersionBanco();
    }
}
