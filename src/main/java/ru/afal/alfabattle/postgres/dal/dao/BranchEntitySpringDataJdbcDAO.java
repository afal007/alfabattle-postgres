package ru.afal.alfabattle.postgres.dal.dao;

import org.springframework.stereotype.Repository;
import ru.afal.alfabattle.postgres.dal.model.BranchEntity;

import java.util.Optional;

@Repository
public class BranchEntitySpringDataJdbcDAO implements BranchEntityDAO {

  @Override
  public <S extends BranchEntity> S save(S entity) {
    return null;
  }

  @Override
  public <S extends BranchEntity> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<BranchEntity> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Iterable<BranchEntity> findAll() {
    return null;
  }

  @Override
  public Iterable<BranchEntity> findAllById(Iterable<Long> longs) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long aLong) {

  }

  @Override
  public void delete(BranchEntity entity) {

  }

  @Override
  public void deleteAll(Iterable<? extends BranchEntity> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
