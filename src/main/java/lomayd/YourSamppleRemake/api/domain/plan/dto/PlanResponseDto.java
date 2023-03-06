package lomayd.YourSamppleRemake.api.domain.plan.dto;

import lomayd.YourSamppleRemake.api.domain.plan.Plan;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

public class PlanResponseDto {
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlanInfo {
        private String id;
        private String carrier;
        private Integer cost;

        public static PlanResponseDto.PlanInfo of(Plan plan) {
            return PlanInfo.builder()
                    .id(plan.getId())
                    .carrier(plan.getCarrier())
                    .cost(plan.getCost())
                    .build();
        }

        public static List<PlanResponseDto.PlanInfo> of(List<Plan> planList) {
            return planList.stream().map(PlanResponseDto.PlanInfo::of).collect(Collectors.toList());
        }
    }
}
