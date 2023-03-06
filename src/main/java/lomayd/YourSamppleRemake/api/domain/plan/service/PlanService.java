package lomayd.YourSamppleRemake.api.domain.plan.service;

import lomayd.YourSamppleRemake.api.domain.plan.Plan;
import lomayd.YourSamppleRemake.api.domain.plan.dto.PlanResponseDto;
import lomayd.YourSamppleRemake.api.domain.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;

    public List<PlanResponseDto.PlanInfo> getPlan() {
        List<Plan> planList = planRepository.findAll();

        return PlanResponseDto.PlanInfo.of(planList);
    }
}

