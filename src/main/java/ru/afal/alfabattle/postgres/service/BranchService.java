package ru.afal.alfabattle.postgres.service;

import com.sun.istack.NotNull;
import ru.afal.alfabattle.postgres.api.BranchWithDistance;
import ru.afal.alfabattle.postgres.api.Branch;

import java.util.Optional;

public interface BranchService {
  @NotNull
  Branch findByID(long branchID) throws BranchNotFoundException;

  @NotNull
  Optional<BranchWithDistance> findNearest(double latitude, double longitude);
}
