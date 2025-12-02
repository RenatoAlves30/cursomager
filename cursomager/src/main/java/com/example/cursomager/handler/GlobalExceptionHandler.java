package com.example.cursomager.handler;

import com.example.cursomager.exception.AlunoException;
import com.example.cursomager.exception.CursoException;
import com.example.cursomager.exception.MatriculaException;
import com.example.cursomager.exception.ProfessorException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("Timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Erro interno do servidor");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("Timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Parâmetros inválidos");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err ->
                erros.put(err.getField(), err.getDefaultMessage())
        );
        body.put("Timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_GATEWAY.value());
        body.put("error", "Erro de validação");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return ResponseEntity.badRequest().body(body);
    }


//    @ExceptionHandler(AlunoException.class)
//    public ResponseEntity<Map<String, Object>> handleAlunoException(AlunoException exception) {
//        Map<String, Object> erro = new HashMap<>();
//        erro.put("Erro", exception.getMessage());
//        erro.put("Status", HttpStatus.BAD_REQUEST.value());
//        erro.put("Timestamp", LocalDateTime.now());
//        erro.put("Tipo", "AlunoException");
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
//    }
//
//    @ExceptionHandler(ProfessorException.class)
//    public ResponseEntity<Map<String, Object>> handleProfessorException(ProfessorException ex) {
//        Map<String, Object> erro = new HashMap<>();
//        erro.put("Erro", ex.getMessage());
//        erro.put("Status", HttpStatus.BAD_REQUEST.value());
//        erro.put("Timestamp", LocalDateTime.now());
//        erro.put("Tipo", "ProfessorException");
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
//    }
//
//    @ExceptionHandler(CursoException.class)
//    public ResponseEntity<Map<String, Object>> handleCursoException(CursoException ex) {
//        Map<String, Object> erro = new HashMap<>();
//        erro.put("Erro", ex.getMessage());
//        erro.put("Status", HttpStatus.BAD_REQUEST.value());
//        erro.put("Timestamp", LocalDateTime.now());
//        erro.put("Tipo", "CursoException");
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
//    }
//
//    @ExceptionHandler(MatriculaException.class)
//    public ResponseEntity<Map<String, Object>> handleMatriculaException(MatriculaException ex) {
//        Map<String, Object> erro = new HashMap<>();
//        erro.put("Erro", ex.getMessage());
//        erro.put("Status", HttpStatus.BAD_REQUEST.value());
//        erro.put("Timestamp", LocalDateTime.now());
//        erro.put("Tipo", "MatriculaException");
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
//        Map<String, Object> erro = new HashMap<>();
//        erro.put("Erro", ex.getMessage());
//        erro.put("Status", HttpStatus.BAD_REQUEST.value());
//        erro.put("Timestamp", LocalDateTime.now());
//        erro.put("Tipo", "Exception");
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
//    }
}
