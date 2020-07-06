package ru.afal.alfabattle.postgres.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.afal.alfabattle.postgres.api.BranchWithDistance;
import ru.afal.alfabattle.postgres.api.Request;
import ru.afal.alfabattle.postgres.api.Branch;
import ru.afal.alfabattle.postgres.model.Model;
import ru.afal.alfabattle.postgres.repository.BranchRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

  private final BranchRepository branchRepository;

  @Override
  public Branch method(Request request) {
    return new Branch();
  }

  @Override
  public Optional<Branch> findByID(long branchID) {
    return branchRepository.findByID(branchID);
  }

  @Override
  public Optional<BranchWithDistance> findNearest(double latitude, double longitude) {
    List<Branch> branchList = branchRepository.getAll();
    Branch nearest = null;
    double nearestDistance = Double.MAX_VALUE;
    for (Branch branch : branchList) {
      double distance = distance(latitude, branch.getLat(), longitude, branch.getLon(), 0., 0.);
      if (distance < nearestDistance) {
        nearestDistance = distance;
        nearest = branch;
      }
    }

    BranchWithDistance branchWithDistance = null;
    if (nearest != null) {
      branchWithDistance = new BranchWithDistance();
      branchWithDistance.setDistance((long) nearestDistance);
      branchWithDistance.setId(nearest.getId());
      branchWithDistance.setLon(nearest.getLon());
      branchWithDistance.setLat(nearest.getLat());
      branchWithDistance.setTitle(nearest.getTitle());
      branchWithDistance.setAddress(nearest.getAddress());
    }

    return Optional.ofNullable(branchWithDistance);
  }

  public double distance(double lat1, double lat2, double lon1,
                                double lon2, double el1, double el2) {

    final int R = 6371; // Radius of the earth

    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
      + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
      * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c * 1000; // convert to meters

    double height = el1 - el2;

    distance = Math.pow(distance, 2) + Math.pow(height, 2);

    return Math.sqrt(distance);
  }
}
