package com.example.cursomager.dao;

import com.example.cursomager.model.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MatriculaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public int novaMatricula(Matricula matricula) {
//
//        String sql = "INSERT INTO matriculas (aluno_id, curso_id, prioridade, status) VALUES (?, ?, ?, ?)";
//
//        return jdbcTemplate.update(sql,
//                matricula.getAluno_id(),
//                matricula.getCurso_id(),
//                matricula.getPrioridade(),
//                matricula.getStatus());
//    }



    public List<Matricula> listarTodasMatriculas() {
        String sql = "SELECT * FROM matriculas";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Matricula.class));
    }

    public Optional<Matricula> buscarPorAlunoECurso(Long alunoId, Long cursoId) {
        String sql = "SELECT * FROM matriculas WHERE aluno_id = ? AND curso_id = ?";
        List<Matricula> resultado = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Matricula.class), alunoId, cursoId);
        return resultado.stream().findFirst();
    }

    public List<Map<String, Object>> buscarAlunosPorCurso(Long cursoId) {
        String sql = """
                SELECT a.id AS aluno_id, a.nome AS aluno_nome,
                       c.id AS curso_id, c.nome AS curso_nome,
                       c.carga_horaria
                FROM matriculas m
                JOIN alunos a ON m.aluno_id = a.id
                JOIN cursos c ON m.curso_id = c.id
                WHERE c.id = ?
                """;

        return jdbcTemplate.queryForList(sql, cursoId);
    }
}
