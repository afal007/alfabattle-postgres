package ru.afal.alfabattle.postgres.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.afal.alfabattle.postgres.api.Branch;
import ru.afal.alfabattle.postgres.dal.dao.BranchEntityDAO;
import ru.afal.alfabattle.postgres.dal.model.BranchEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AlfaBranchRepository implements BranchRepository {

  private final BranchMapper branchMapper;
  private final BranchEntityDAO branchEntityDAO;

  @Override
  public Optional<Branch> findByID(long id) {
    return branchEntityDAO.findById(id).map(branchMapper::map);
  }

  @Override
  public List<Branch> getAll() {
    List<Branch> resList = new ArrayList<>();
    Iterable<BranchEntity> branchEntities = branchEntityDAO.findAll();
    for (BranchEntity branchEntity : branchEntities) {
      resList.add(branchMapper.map(branchEntity));
    }

    return resList;
  }
}
