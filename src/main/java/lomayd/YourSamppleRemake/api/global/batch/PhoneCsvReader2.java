package lomayd.YourSamppleRemake.api.global.batch;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import lomayd.YourSamppleRemake.api.domain.phone.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PhoneCsvReader2 implements ItemReader<Phone> {

    private final PhoneRepository phoneRepository;

    @Override
    public Phone read() throws Exception {
        return phoneRepository.findById("SHW-M250S").get();
    }
}
