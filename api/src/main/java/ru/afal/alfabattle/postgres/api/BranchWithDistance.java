package ru.afal.alfabattle.postgres.api;

import lombok.Data;

@Data
public class BranchWithDistance {
  private Long distance;
  private Branch branch;
}
