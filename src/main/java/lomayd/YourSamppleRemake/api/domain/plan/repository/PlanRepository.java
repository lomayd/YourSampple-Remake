package lomayd.YourSamppleRemake.api.domain.plan.repository;

import lomayd.YourSamppleRemake.api.domain.plan.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, String> {
}
