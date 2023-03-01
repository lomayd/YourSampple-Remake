package lomayd.YourSamppleRemake.api.global.batch;

import lomayd.YourSamppleRemake.api.domain.plan.Plan;
import lomayd.YourSamppleRemake.api.domain.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class PlanCsvToDbWriter implements ItemWriter<Plan> {

    private final PlanRepository planRepository;
    @Override
    public void write(List<? extends Plan> items) throws Exception {
        planRepository.saveAll(new ArrayList<Plan>(items));
    }
}