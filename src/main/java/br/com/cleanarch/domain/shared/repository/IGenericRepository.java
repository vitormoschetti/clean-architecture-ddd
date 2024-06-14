package br.com.cleanarch.domain.shared.repository;

import br.com.cleanarch.domain.shared.entity.IAggregateRoot;

import java.util.List;

public interface IGenericRepository<T extends IAggregateRoot, I> {

    void create(final T entity);

    void update(final T entity);

    T findById(final I id);

    List<T> findAll();

}
