package com.example.cursomager.dao;

import com.example.cursomager.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.jdbc.core.JdbcOperationsExtensionsKt.query;

@Repository
public class CursoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int adicionarCurso(Curso curso) {
        String sql = "INSERT INTO cursos (nome, carga_horaria, vagas) VALUES (?, ?, ?)";

        return jdbcTemplate.update(sql,
                curso.getNome(),
                curso.getCarga_horaria(),
                curso.getVagas());
    }

    public List<Curso> listarCursos() {
        String sql = "SELECT * FROM cursos";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Curso.class));
    }

    public Optional<Curso> buscarCursoPorId(Long id) {
        String sql = "SELECT * FROM cursos WHERE id = ?";
        List<Curso> cursos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Curso.class), id);
        return cursos.stream().findFirst();

    }

    public int atualizarCurso(Curso curso) {
        String sql = "UPDATE cursos SET nome = ?, carga_horaria = ?, vagas = ? WHERE id = ?";

        return jdbcTemplate.update(sql,
                curso.getNome(),
                curso.getCarga_horaria(),
                curso.getVagas(),
                curso.getId());
    }

    public int deletarCurso(Long id) {
        String sql = "DELETE FROM cursos WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }


}
