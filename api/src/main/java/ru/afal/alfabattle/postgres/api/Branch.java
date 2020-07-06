package ru.afal.alfabattle.postgres.api;

import lombok.Data;

@Data
public class Branch {
  private Long id;
  private Double lon;
  private Double lat;
  private String title;
  private String address;
}
