package ru.afal.alfabattle.postgres.service;

import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;
import ru.afal.alfabattle.postgres.api.BranchWithDistance;
import ru.afal.alfabattle.postgres.api.Request;
import ru.afal.alfabattle.postgres.api.Branch;

import java.util.Optional;

public interface BranchService {
  Branch method(Request request);

  @NotNull
  Optional<Branch> findByID(long branchID);

  @NotNull
  Optional<BranchWithDistance> findNearest(double latitude, double longitude);
}
