package ru.afal.alfabattle.postgres.controller.tmp.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.afal.alfabattle.postgres.api.Branch;
import ru.afal.alfabattle.postgres.api.BranchWithDistance;
import ru.afal.alfabattle.postgres.api.Tmp;
import ru.afal.alfabattle.postgres.service.BranchService;

@RestController("/")
@RequiredArgsConstructor
public class BranchController {

  private final BranchService branchService;

  @GetMapping("/branches/{id}")
  public ResponseEntity<Object> findByID(@PathVariable("id") Long branchID) {
    ResponseEntity atmLocationResponseEntity = branchService.findByID(branchID)
      .map(ResponseEntity::ok)
      .orElse(null);

    if (atmLocationResponseEntity == null) {
      atmLocationResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(Tmp.builder().status("branch not found").build());
    }

    return atmLocationResponseEntity;
  }

  @GetMapping("/branches")
  public ResponseEntity<BranchWithDistance> findNearest(@RequestParam("lat") Double latitude, @RequestParam("lon") Double longitude) {
    return ResponseEntity.of(branchService.findNearest(latitude, longitude));
  }
}
