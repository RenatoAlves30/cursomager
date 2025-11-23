package com.example.cursomager.dao;

import com.example.cursomager.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlunoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int salvarAluno(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, email, idade, matricula, media) VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getIdade(),
                aluno.getMatricula(),
                aluno.getMedia());
    }

    public List<Aluno> listarTodosAlunos() {
        String sql = "SELECT * FROM alunos";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Aluno.class));
    }

    public Optional<Aluno> buscarPorId(Long id) {
        String sql = "SELECT * FROM alunos WHERE id = ?";
        List<Aluno> alunos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Aluno.class), id);
        return alunos.stream().findFirst();
    }

    public int atualizarAluno(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, email = ?, idade = ?, matricula = ?, media = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getIdade(),
                aluno.getMatricula(),
                aluno.getMedia(),
                aluno.getId());
    }

    public int deletarAluno(Long id) {
        String sql = "DELETE FROM alunos WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public List<Aluno> buscarAlunoPorIdadeEMedia(int idadeMinima, double mediaMinima) {
        String sql = "SELECT * FROM alunos WHERE idade > ? AND media > ?";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Aluno.class),
                idadeMinima,
                mediaMinima
        );
    }

    public List<Aluno> listarPaginado(int page, int size) {

        int offset = page * size;

        String sql = "SELECT * FROM alunos ORDER BY nome LIMIT ? OFFSET ?";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Aluno.class),
                size, offset
        );
    }

}
