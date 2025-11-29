package com.example.cursomager.service;

import com.example.cursomager.dao.MatriculaDAO;
import com.example.cursomager.dto.AlunoResumoDTO;
import com.example.cursomager.dto.RelatorioAlunosPorCursoDTO;
import com.example.cursomager.exception.MatriculaException;
import com.example.cursomager.model.Matricula;
import com.example.cursomager.repositoryOld.MatriculaRepositoryOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatriculaService {
//    private final Queue<Matricula> filaMatriculas = new PriorityQueue<>(
//            (m1, m2) -> Integer.compare(m1.getPrioridade(), m2.getPrioridade())
//
//    );

    @Autowired
    private MatriculaDAO matriculaDAO;

//   public String realizarMatricula(Matricula matricula) {
//       boolean jaExiste = matriculaDAO.buscarPorAlunoECurso(
//               matricula.getAluno_id(),
//               matricula.getCurso_id()
//       ).isPresent();
//
//       if (jaExiste) {
//           throw new MatriculaException("O aluno já está matriculado nesse curso");
//       }
//
//       if (matricula.getPrioridade() < 1 || matricula.getPrioridade() > 5) {
//           throw new MatriculaException("A prioridade deve estar entre 1 e 5");
//       }
//       int linhasAfetadas = matriculaDAO.novaMatricula(matricula);
//       return  linhasAfetadas > 0 ? "Matrícula realizada com sucesso!" : "Falha ao realizar matrícula";
//   }

   public List<Matricula> listarMatriculas() {
       return matriculaDAO.listarTodasMatriculas();
   }

}
