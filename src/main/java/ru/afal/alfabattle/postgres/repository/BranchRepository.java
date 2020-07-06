package ru.afal.alfabattle.postgres.repository;

import com.sun.istack.NotNull;
import ru.afal.alfabattle.postgres.api.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchRepository {
  @NotNull
  Optional<Branch> findByID(long id);

  @NotNull
  List<Branch> getAll();
}
