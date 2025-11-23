package com.example.cursomager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseTestService {

    @Autowired
    private  JdbcTemplate jdbcTemplate;

    public String testarConexao() {
        try {
            jdbcTemplate.execute("Select 1");
            return "Conexão com banco de dados bem-sucedida!!";
        } catch (Exception e){
            return "Falha na conexão: " + e.getMessage();
        }
    }

    public Map<String, Object> getVersionBanco() {
        Map<String, Object> resposta = new HashMap<>();

        try {
            String versao = jdbcTemplate.queryForObject("SELECT VERSION()", String.class);
            resposta.put("Versão", versao);
            resposta.put("Status", "Conexão OK");
            resposta.put("Timestamp", LocalDateTime.now());
            resposta.put("Mensagem", "Versão obtida com sucesso!");
        } catch (Exception e) {
            resposta.put("Versão", "Indisponível");
            resposta.put("Status", "Erro");
            resposta.put("Timestamp", LocalDateTime.now());
            resposta.put("Mensagem", "Falha ao obter versão: " + e.getMessage());
        }

        return resposta;
    }

}
