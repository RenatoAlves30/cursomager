package com.example.cursomager.repository;

import com.example.cursomager.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNomeContaining(String nome);

    List<Aluno> findByIdadeGreaterThan(int idade);

    List<Aluno> findByEmailStartingWith(String prefixo);

    List<Aluno> findByCursoNomeContaining(String nomeCurso);

}
