package com.example.cursomager.handler;

import com.example.cursomager.exception.AlunoException;
import com.example.cursomager.exception.CursoException;
import com.example.cursomager.exception.MatriculaException;
import com.example.cursomager.exception.ProfessorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlunoException.class)
    public ResponseEntity<Map<String, Object>> handleAlunoException(AlunoException exception) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("Erro", exception.getMessage());
        erro.put("Status", HttpStatus.BAD_REQUEST.value());
        erro.put("Timestamp", LocalDateTime.now());
        erro.put("Tipo", "AlunoException");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(ProfessorException.class)
    public ResponseEntity<Map<String, Object>> handleProfessorException(ProfessorException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("Erro", ex.getMessage());
        erro.put("Status", HttpStatus.BAD_REQUEST.value());
        erro.put("Timestamp", LocalDateTime.now());
        erro.put("Tipo", "ProfessorException");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(CursoException.class)
    public ResponseEntity<Map<String, Object>> handleCursoException(CursoException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("Erro", ex.getMessage());
        erro.put("Status", HttpStatus.BAD_REQUEST.value());
        erro.put("Timestamp", LocalDateTime.now());
        erro.put("Tipo", "CursoException");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(MatriculaException.class)
    public ResponseEntity<Map<String, Object>> handleMatriculaException(MatriculaException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("Erro", ex.getMessage());
        erro.put("Status", HttpStatus.BAD_REQUEST.value());
        erro.put("Timestamp", LocalDateTime.now());
        erro.put("Tipo", "MatriculaException");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("Erro", ex.getMessage());
        erro.put("Status", HttpStatus.BAD_REQUEST.value());
        erro.put("Timestamp", LocalDateTime.now());
        erro.put("Tipo", "Exception");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
