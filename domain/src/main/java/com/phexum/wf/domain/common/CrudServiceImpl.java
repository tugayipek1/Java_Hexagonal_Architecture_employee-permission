package com.phexum.wf.domain.common;

import java.util.List;
import java.util.Optional;


public class CrudServiceImpl<R extends BaseRepository<T, ID>, T, ID> implements Crud<T, ID> {
  protected final R repository;

  public CrudServiceImpl(R repo) {
    this.repository = repo;
  }

  @Override
  public Optional<T> findById(ID id) {
    return repository.findById(id);
  }

  @Override
  public List<T> findAll() {
    return repository.findAll();
  }

  @Override
  public T create(T entity) {
    return repository.create(entity);
  }

  @Override
  public T update(T entity) {
    return repository.update(entity);
  }

  @Override
  public void delete(T entity) {
    repository.delete(entity);
  }

  @Override
  public void deleteById(ID id) {
    repository.deleteById(id);
  }


}
