package ru.afal.alfabattle.postgres.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BranchWithDistance extends Branch {
  private Long distance;
}
