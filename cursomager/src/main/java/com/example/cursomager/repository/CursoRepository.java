package com.example.cursomager.repository;

import com.example.cursomager.dto.CursoQuantidadeDTO;
import com.example.cursomager.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("""
            SELECT new com.example.cursomager.dto.CursoQuantidadeDTO(
                m.curso.nome,
                COUNT (m.aluno)
            )
            FROM Matricula m
            GROUP BY m.curso.nome
            ORDER BY COUNT(m.aluno) DESC
            """)
    List<CursoQuantidadeDTO> listarCursosComMaisAlunos();
}
