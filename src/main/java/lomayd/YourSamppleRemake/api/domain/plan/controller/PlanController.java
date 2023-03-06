package lomayd.YourSamppleRemake.api.domain.plan.controller;

import lomayd.YourSamppleRemake.api.domain.plan.dto.PlanResponseDto;
import lomayd.YourSamppleRemake.api.domain.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping("/plan")
    public ResponseEntity<List<PlanResponseDto.PlanInfo>> getPlan(){
        return ResponseEntity.ok(planService.getPlan());
    }
}