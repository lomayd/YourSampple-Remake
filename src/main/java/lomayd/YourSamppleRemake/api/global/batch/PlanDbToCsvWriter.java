package lomayd.YourSamppleRemake.api.global.batch;

import lomayd.YourSamppleRemake.api.domain.plan.Plan;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@RequiredArgsConstructor
public class PlanDbToCsvWriter {

    public FlatFileItemWriter<Plan> flatFileItemWriter() throws Exception {
        BeanWrapperFieldExtractor<Plan> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[]{"id","carrier","cost"}); //필드명

        DelimitedLineAggregator<Plan> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");
        lineAggregator.setFieldExtractor(fieldExtractor);

        FlatFileItemWriter<Plan> flatFileItemWriter = new FlatFileItemWriterBuilder<Plan>()
                .name("planDbToCsvWriter")
                .encoding("UTF-8")
                .resource(new FileSystemResource("src/main/resources/csv/export/plan.csv")) //파일 생성하기 위함
                .lineAggregator(lineAggregator)
                .headerCallback(writer -> writer.write("id,carrier,cost"))
                .build();

        flatFileItemWriter.afterPropertiesSet();

        return flatFileItemWriter;
    }
}
