package ru.afal.alfabattle.postgres.branches.v1;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.afal.alfabattle.postgres.api.Error;
import ru.afal.alfabattle.postgres.service.BranchNotFoundException;

@ControllerAdvice("ru.afal.alfabattle.postgres.branches")
public class BranchControllerAdvice {

  private static final Error BRANCH_WAS_NOT_FOUND = Error.withStatus("branch not found");

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(BranchNotFoundException.class)
  public ResponseEntity<Error> handleAtmNotFoundException(@NotNull BranchNotFoundException e) {
    Error error = e.getOptionalMessage().map(Error::withStatus).orElse(BRANCH_WAS_NOT_FOUND);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }
}
