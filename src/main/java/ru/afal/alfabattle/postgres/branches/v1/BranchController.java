package ru.afal.alfabattle.postgres.branches.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.afal.alfabattle.postgres.api.Branch;
import ru.afal.alfabattle.postgres.api.BranchWithDistance;
import ru.afal.alfabattle.postgres.service.BranchService;

@RestController
@RequestMapping("/branches/v1")
@RequiredArgsConstructor
public class BranchController {

  private final BranchService branchService;

  @GetMapping("/{id}")
  public Branch findByID(@PathVariable("id") Long branchID) {
    return branchService.findByID(branchID);
  }

  @GetMapping("/")
  public ResponseEntity<BranchWithDistance> findNearest(@RequestParam("lat") Double latitude, @RequestParam("lon") Double longitude) {
    return ResponseEntity.of(branchService.findNearest(latitude, longitude));
  }
}
