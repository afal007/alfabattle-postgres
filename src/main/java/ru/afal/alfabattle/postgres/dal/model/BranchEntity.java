package ru.afal.alfabattle.postgres.dal.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "branches")
public class BranchEntity {
  @Id
  private long id;

  private Double lon;
  private Double lat;
  private String title;
  private String address;
}
