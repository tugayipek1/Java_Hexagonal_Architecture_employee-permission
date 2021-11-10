package com.phexum.wf.domain.common;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, ID> {
  Optional<T> findById(ID id);

  List<T> findAll();

  T create(T entity);

  T update(T entity);

  void delete(T entity);

  void deleteById(ID id);
}
