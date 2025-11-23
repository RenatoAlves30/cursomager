package com.example.cursomager.repositoryOld;

import java.util.*;

public class RepositorioGenericoOld<T> {

    protected final Map<Long, T> dados = new HashMap<>();

    public Collection<T> findAll() {
        return dados.values();
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(dados.get(id));
    }

    public T save(Long id, T entidade) {
        dados.put(id, entidade);
        return entidade;
    }

    public boolean delete(Long id) {
        return dados.remove(id) != null;
    }

    public boolean existsById(Long id) {
        return dados.containsKey(id);
    }

    public Set<Long> getIds() {
        return dados.keySet();
    }

    public Map<Long, T> getMap() {
        return dados;
    }

}


