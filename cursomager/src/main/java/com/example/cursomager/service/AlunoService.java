package com.example.cursomager.service;

import com.example.cursomager.exception.AlunoException;
import com.example.cursomager.model.Aluno;
import com.example.cursomager.dao.AlunoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlunoService {

//Estava utilizando desta forma antes de implementar a classe RepositorioGenerico.
//    private final Map<Long, Aluno> alunos = new HashMap<>();
//
//    public AlunoService() {
//        alunos.put(1L, new Aluno(1L, "Renato Alves", "RenatoAlves@email.com", 25, "001", 8.5));
//        alunos.put(2L, new Aluno(2L, "Carlos Silva", "CarlosSilva@email.com", 22, "002", 6.7));
//        alunos.put(3L, new Aluno(3L, "Amanda Costa", "AmandaCosta@email.com", 28, "003", 9.2));
//    }


    @Autowired
    private AlunoDAO alunoDAO;

    public String adicionarAluno(Aluno aluno) {
        // Validação do nome do aluno
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new AlunoException("O nome do aluno é obrigatório!");
        }

        // Validação do e-mail do aluno.
        if (aluno.getEmail() == null || aluno.getEmail().isBlank()) {
            throw new AlunoException("O email do aluno é obrigatório!");
        }

        List<Aluno> alunos = alunoDAO.listarTodosAlunos();
        boolean emailDuplicado = alunos.stream()
                        .anyMatch(a -> a.getEmail().equalsIgnoreCase(aluno.getEmail().trim()));
        if (emailDuplicado) {
            throw new AlunoException("Já existe um aluno cadastrado com o e-mail: " + aluno.getEmail());
        }

        int linhasAfetadas = alunoDAO.salvarAluno(aluno);
        return linhasAfetadas > 0 ? "Aluno cadastrado com sucesso!" : "Falha ao cadastrar aluno.";
    }

    public List<Aluno> listarTodos() {
        return alunoDAO.listarTodosAlunos();
    }

    public Aluno buscarPorId(Long id) {
        return alunoDAO.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
    }

    public String atualizarAluno(Long id, Aluno aluno) {

        // Validação do nome do aluno
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new AlunoException("O nome do aluno é obrigatório!");
        }

        // Validação do e-mail do aluno.
        if (aluno.getEmail() == null || aluno.getEmail().isBlank()) {
            throw new AlunoException("O email do aluno é obrigatório!");
        }

        List<Aluno> alunos = alunoDAO.listarTodosAlunos();
        boolean emailDuplicado = alunos.stream()
                .anyMatch(a -> a.getEmail().equalsIgnoreCase(aluno.getEmail().trim()));
        if (emailDuplicado) {
            throw new AlunoException("Já existe um aluno cadastrado com o e-mail: " + aluno.getEmail());
        }

        int linhasAfetadas = alunoDAO.atualizarAluno(aluno);
        return linhasAfetadas > 0 ? "Aluno cadastrado com sucesso!" : "Falha ao cadastrar aluno.";
    }

    public String deletarAluno(Long id) {
        int linhasAfetadas = alunoDAO.deletarAluno(id);
        return linhasAfetadas > 0 ? "Aluno deletado com sucesso!" : "Aluno não encontrado.";
    }

    public List<Aluno> filtrarAlunos() {
        int idadeMinima = 18;
        double mediaMinima = 7.0;

        return alunoDAO.buscarAlunoPorIdadeEMedia(idadeMinima, mediaMinima);
    }

    public List<Aluno> listarAlunoPaginado(int page, int size) {
        return alunoDAO.listarPaginado(page, size);
    }
}
