package lomayd.YourSamppleRemake.api.global.batch;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import javax.batch.api.chunk.ItemWriter;

@Configuration
@RequiredArgsConstructor
public class PhoneCsvWriter2 {

    public FlatFileItemWriter<Phone> flatFileItemWriter() throws Exception {
        BeanWrapperFieldExtractor<Phone> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[]{"id","name","prize"}); //필드명

        DelimitedLineAggregator<Phone> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");
        lineAggregator.setFieldExtractor(fieldExtractor);

        FlatFileItemWriter<Phone> flatFileItemWriter = new FlatFileItemWriterBuilder<Phone>()
                .name("itemWriter")
                .encoding("UTF-8")
                .resource(new ClassPathResource("/csv/export/phone.csv")) //파일 생성하기 위함
                .lineAggregator(lineAggregator)
                .headerCallback(writer -> writer.write("id,name,prize"))
                .build();

        flatFileItemWriter.afterPropertiesSet();

        return flatFileItemWriter;
    }
}
