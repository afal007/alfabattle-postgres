package ru.afal.alfabattle.postgres.api;

import lombok.Value;

@Value(staticConstructor = "withStatus")
public class Error {
  String status;
}
