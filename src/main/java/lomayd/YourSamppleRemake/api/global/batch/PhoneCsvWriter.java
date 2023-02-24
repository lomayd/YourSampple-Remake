package lomayd.YourSamppleRemake.api.global.batch;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import lomayd.YourSamppleRemake.api.domain.phone.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class PhoneCsvWriter implements ItemWriter<Phone> {

    private final PhoneRepository phoneRepository;

    @Override
    public void write(List<? extends Phone> items) throws Exception {
        phoneRepository.saveAll(new ArrayList<Phone>(items));
    }
}