package lomayd.YourSamppleRemake.api.domain.agreement.repository;

import lomayd.YourSamppleRemake.api.domain.agreement.Agreement;
import lomayd.YourSamppleRemake.api.domain.agreement.AgreementCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, AgreementCategory> {
}
