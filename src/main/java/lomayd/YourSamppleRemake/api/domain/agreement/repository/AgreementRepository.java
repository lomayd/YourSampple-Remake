package lomayd.YourSamppleRemake.api.domain.agreement.repository;

import lomayd.YourSamppleRemake.api.domain.agreement.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, String> {
}
