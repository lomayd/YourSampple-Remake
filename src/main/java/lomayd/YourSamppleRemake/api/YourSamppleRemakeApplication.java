package lomayd.YourSamppleRemake.api;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class YourSamppleRemakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourSamppleRemakeApplication.class, args);
	}

}
