package com.example.cursomager.service;

import com.example.cursomager.dao.MatriculaDAO;
import com.example.cursomager.dto.AlunoResumoDTO;
import com.example.cursomager.dto.RelatorioAlunosPorCursoDTO;
import com.example.cursomager.exception.MatriculaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RelatorioService {
    @Autowired
    private MatriculaDAO matriculaDAO;
    public RelatorioAlunosPorCursoDTO gerarRelatorio(Long cursoId) {
        List<Map<String, Object>> linhas = matriculaDAO.buscarAlunosPorCurso(cursoId);

        if (linhas.isEmpty()) {
            throw new MatriculaException("Nenhuma matrícula encontrada para este curso.");
        }

        String nomeCurso = (String) linhas.get(0).get("curso_nome");
        int cargaHoraria = ((Number) linhas.get(0).get("carga_horaria")).intValue();

        List<AlunoResumoDTO> alunos = linhas.stream()
                .map(m -> new AlunoResumoDTO(
                        ((Number) m.get("aluno_id")).longValue(),
                        (String) m.get("aluno_nome")
                ))
                .toList();

        RelatorioAlunosPorCursoDTO dto = new RelatorioAlunosPorCursoDTO();
        dto.setCurso(nomeCurso);
        dto.setCarga_horaria(cargaHoraria);
        dto.setTotalAlunos(alunos.size());
        dto.setAlunos(alunos);

        return dto;
    }
}
