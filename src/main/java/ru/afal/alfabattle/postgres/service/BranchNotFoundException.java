package ru.afal.alfabattle.postgres.service;

import java.util.Optional;

public class BranchNotFoundException extends RuntimeException {

  public BranchNotFoundException() {
  }

  public BranchNotFoundException(String message) {
    super(message);
  }

  public Optional<String> getOptionalMessage() {
    return Optional.ofNullable(getMessage());
  }
}
