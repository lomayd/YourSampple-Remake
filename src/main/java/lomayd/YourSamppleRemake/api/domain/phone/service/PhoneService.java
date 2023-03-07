package lomayd.YourSamppleRemake.api.domain.phone.service;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import lomayd.YourSamppleRemake.api.domain.phone.dto.PhoneResponseDto;
import lomayd.YourSamppleRemake.api.domain.phone.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public List<PhoneResponseDto.PhoneInfo> getPhone() {
        List<Phone> phoneList = phoneRepository.findAll();

        return PhoneResponseDto.PhoneInfo.of(phoneList);
    }
}
