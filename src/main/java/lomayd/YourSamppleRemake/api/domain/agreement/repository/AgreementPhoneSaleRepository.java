package lomayd.YourSamppleRemake.api.domain.agreement.repository;

import lomayd.YourSamppleRemake.api.domain.agreement.AgreementPhoneSale;
import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgreementPhoneSaleRepository extends JpaRepository<AgreementPhoneSale, Integer> {

    Optional<AgreementPhoneSale> findByPhoneId(String phoneId);
}
