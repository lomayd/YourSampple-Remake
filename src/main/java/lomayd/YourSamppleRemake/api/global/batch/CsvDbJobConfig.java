package lomayd.YourSamppleRemake.api.global.batch;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import lomayd.YourSamppleRemake.api.domain.plan.Plan;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CsvDbJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvDbReader csvDbReader;
    private final PhoneCsvToDbWriter phoneCsvToDbWriter;
    private final PhoneDbToCsvWriter phoneDbToCsvWriter;
    private final PlanCsvToDbWriter planCsvToDbWriter;

    private final PlanDbToCsvWriter planDbToCsvWriter;

    private static final int chunkSize = 1000;


    // Phone Csv -> Table
    @Bean
    public Job phoneCsvToDbJob() {
        return jobBuilderFactory.get("phoneCsvToDbJob")
                .start(phoneCsvToDbStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }
    @Bean
    public Step phoneCsvToDbStep() {
        return stepBuilderFactory.get("phoneCsvToDbStep")
                .<Phone, Phone>chunk(chunkSize)
                .reader(csvDbReader.phoneCsvToDbReader())
                .writer(phoneCsvToDbWriter)
                .build();
    }

    // Phone Table -> Csv
    @Bean
    public Job phoneDbToCsvJob() throws Exception {
        return jobBuilderFactory.get("phoneDbToCsvJob")
                .start(phoneDbToCsvStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step phoneDbToCsvStep() throws Exception {
        return stepBuilderFactory.get("phoneDbToCsvStep")
                .<Phone, Phone>chunk(chunkSize)
                .reader(csvDbReader.phoneDbToCsvReader())
                .writer(phoneDbToCsvWriter.flatFileItemWriter())
                .build();
    }

    // Plan Csv -> Table
    @Bean
    public Job planCsvToDbJob() {
        return jobBuilderFactory.get("planCsvToDbJob")
                .start(planCsvToDbStep())
                .build();
    }

    @Bean
    public Step planCsvToDbStep() {
        return stepBuilderFactory.get("planCsvToDbStep")
                .<Plan, Plan>chunk(chunkSize)
                .reader(csvDbReader.planCsvToDbReader())
                .writer(planCsvToDbWriter)
                .build();
    }

    // Plan Table -> Csv
    @Bean
    public Job planDbToCsvJob() throws Exception {
        return jobBuilderFactory.get("planDbToCsvJob")
                .start(planDbToCsvStep())
                .build();
    }

    @Bean
    public Step planDbToCsvStep() throws Exception {
        return stepBuilderFactory.get("planDbToCsvStep")
                .<Plan, Plan>chunk(chunkSize)
                .reader(csvDbReader.planDbToCsvReader())
                .writer(planDbToCsvWriter.flatFileItemWriter())
                .build();
    }
}