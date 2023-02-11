package lomayd.YourSamppleRemake.api.global.batch;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import lomayd.YourSamppleRemake.api.domain.phone.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.batch.api.chunk.ItemWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public abstract class CsvWriter implements ItemWriter<Phone> {

    private final PhoneRepository phoneRepository;

    @Override
    public void write(List<? extends Phone> list) throws Exception {
        phoneRepository.saveAll(new ArrayList<Phone>(list));
    }
}