package br.com.cleanarch.domain.shared.repository;

import br.com.cleanarch.domain.shared.entity.IAggregateRoot;

import java.util.List;

public interface IGenericRepository<T extends IAggregateRoot> {

    void create(final T entity);

    void update(final T entity);

    T findById(final String id);

    List<T> findAll();

}
