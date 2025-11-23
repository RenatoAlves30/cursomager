package com.example.cursomager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Olá, Spring Boot! Sua aplicação está funcionando!";
    }

    @GetMapping("/hello/{nome}")
    public String helloNome(@PathVariable String nome) {

        return "Olá, " + nome + "! Seja bem-vindo ao mundo do Spring Boot!";
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        Map<String, String> info = new HashMap<>();
        info.put("status", "online");
        info.put("app", "CursoManager");

        return info;
    }

}
