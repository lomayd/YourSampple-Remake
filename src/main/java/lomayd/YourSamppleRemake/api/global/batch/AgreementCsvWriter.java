package lomayd.YourSamppleRemake.api.global.batch;

import lomayd.YourSamppleRemake.api.domain.agreement.Agreement;
import lomayd.YourSamppleRemake.api.domain.agreement.repository.AgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class AgreementCsvWriter implements ItemWriter<Agreement> {

    private final AgreementRepository agreementRepository;
    @Override
    public void write(List<? extends Agreement> items) throws Exception {
        agreementRepository.saveAll(new ArrayList<Agreement>(items));
    }
}