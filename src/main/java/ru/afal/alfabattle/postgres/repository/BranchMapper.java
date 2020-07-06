package ru.afal.alfabattle.postgres.repository;

import org.mapstruct.Mapper;
import ru.afal.alfabattle.postgres.api.Branch;
import ru.afal.alfabattle.postgres.dal.model.BranchEntity;

@Mapper(componentModel = "spring")
public interface BranchMapper {
  Branch map(BranchEntity branchEntity);
}
