package com.example.cursomager.service;

import com.example.cursomager.exception.ProfessorException;
import com.example.cursomager.model.Professor;
import com.example.cursomager.repositoryOld.ProfessorRepositoryOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepositoryOld professorRepository;


    public Collection<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Professor adicionarProfessor(Professor professor) {

        if (professor.getEmail().contains("@gmail.com")) {
            return professorRepository.save(professor.getId(), professor);
        } else {
            throw new ProfessorException("Este email não é válido para cadastro!");
        }

    }

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    public boolean deletarProfessor(Long id) {
        return professorRepository.delete(id);
    }


}
