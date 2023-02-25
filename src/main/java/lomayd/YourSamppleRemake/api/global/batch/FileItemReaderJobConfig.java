package lomayd.YourSamppleRemake.api.global.batch;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import lomayd.YourSamppleRemake.api.domain.phone.repository.PhoneRepository;
import lomayd.YourSamppleRemake.api.domain.plan.Plan;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FileItemReaderJobConfig {
    private final PhoneRepository phoneRepository;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvReader csvReader;
    private final PhoneCsvWriter phoneCsvWriter;
    private final PlanCsvWriter planCsvWriter;

    private final PhoneCsvWriter2 phoneCsvWriter2;

    private static final int chunkSize = 1000;

    private final PhoneCsvReader2 phoneCsvReader2;

    @Bean
    public Job phoneCsvFileItemReaderJob() {
        return jobBuilderFactory.get("phoneCsvFileItemReaderJob")
                .start(phoneCsvFileItemReaderStep())
                .build();
    }

    @Bean
    public Job phoneCsvFileItemReaderJob2() throws Exception {
        return jobBuilderFactory.get("phoneCsvFileItemReaderJob2")
                .start(phoneCsvFileItemReaderStep2())
                .build();
    }


    @Bean
    public Job planCsvFileItemReaderJob() {
        return jobBuilderFactory.get("planCsvFileItemReaderJob")
                .start(planCsvFileItemReaderStep())
                .build();
    }

    @Bean
    public Step phoneCsvFileItemReaderStep() {
        return stepBuilderFactory.get("phoneCsvFileItemReaderStep")
                .<Phone, Phone>chunk(chunkSize)
                .reader(csvReader.phoneCsvFileItemReader())
                .writer(phoneCsvWriter)
                .build();
    }

    @Bean
    public Step phoneCsvFileItemReaderStep2() throws Exception {
        return stepBuilderFactory.get("phoneCsvFileItemReaderStep2")
                .<Phone, Phone>chunk(chunkSize)
                .reader((ItemReader<? extends Phone>) phoneCsvReader2.read())
                .writer(phoneCsvWriter2.flatFileItemWriter())
                .build();
    }

    @Bean
    public Step planCsvFileItemReaderStep() {
        return stepBuilderFactory.get("planCsvFileItemReaderStep")
                .<Plan, Plan>chunk(chunkSize)
                .reader(csvReader.planCsvFileItemReader())
                .writer(planCsvWriter)
                .build();
    }


}