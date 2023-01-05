package lomayd.YourSamppleRemake.api.domain.agreement.repository;

import lomayd.YourSamppleRemake.api.domain.agreement.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

    Optional<Agreement> findByPhoneId(String phoneId);
}
