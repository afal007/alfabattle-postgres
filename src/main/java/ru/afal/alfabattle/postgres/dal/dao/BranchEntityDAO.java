package ru.afal.alfabattle.postgres.dal.dao;

import org.springframework.data.repository.CrudRepository;
import ru.afal.alfabattle.postgres.dal.model.BranchEntity;

public interface BranchEntityDAO extends CrudRepository<BranchEntity, Long> {
}
