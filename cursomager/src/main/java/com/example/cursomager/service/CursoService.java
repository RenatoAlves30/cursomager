package com.example.cursomager.service;

import com.example.cursomager.dao.CursoDAO;
import com.example.cursomager.exception.CursoException;
import com.example.cursomager.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoDAO cursoDAO;

    public String adicionarCurso(Curso curso) {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new CursoException("O nome do curso é obrigatório!");
        }

        if (curso.getCarga_horaria() <= 0) {
            throw new CursoException("A carga horárioa deve ser maior que zero.");
        }

        if (curso.getVagas() <= 0) {
            throw new CursoException("O número de vagas deve ser maior que zero.");
        }

        List<Curso> cursos = cursoDAO.listarCursos();
        boolean cursoExistente = cursos.stream()
                .anyMatch(c -> c.getNome().equalsIgnoreCase(curso.getNome()));
        if (cursoExistente) {
            throw new CursoException("Já existe um curso cadastrado com o nome: " + curso.getNome());
        }

        int linhasAfetadas = cursoDAO.adicionarCurso(curso);
        return linhasAfetadas > 0 ? "Curso cadastrado com sucesso!" : "Falha ao cadastrar curso.";
    }

    public List<Curso> listarTodos() {
        return cursoDAO.listarCursos();
    }

    public Optional<Curso> buscarCursoPorId(Long id) {
        return cursoDAO.buscarCursoPorId(id);
    }

    public String atualizarCurso(Curso curso) {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new CursoException("O nome do curso é obrigatório!");
        }

        if (curso.getCarga_horaria() <= 0) {
            throw new CursoException("A carga horárioa deve ser maior que zero.");
        }

        if (curso.getVagas() <= 0) {
            throw new CursoException("O número de vagas deve ser maior que zero.");
        }

        List<Curso> cursos = cursoDAO.listarCursos();
        boolean cursoExistente = cursos.stream()
                .anyMatch(c -> c.getNome().equalsIgnoreCase(c.getNome().trim()));
        if (cursoExistente) {
            throw new CursoException("Já existe um curso cadastrado com o nome: " + curso.getNome());
        }
        int linhasAfetadas = cursoDAO.atualizarCurso(curso);
        return linhasAfetadas > 0 ? "Curso atualizado com sucesso!" : "Falha ao atualizar curso";
    }

    public String removerCurso(Long id) {
        int rowsAffected = cursoDAO.deletarCurso(id);
        return rowsAffected > 0 ? "Curso removido com sucesso!" : "Falha ao deletar curso!";
    }
}
