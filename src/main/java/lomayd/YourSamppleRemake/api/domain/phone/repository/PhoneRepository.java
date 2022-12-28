package lomayd.YourSamppleRemake.api.domain.phone.repository;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String> {
}
