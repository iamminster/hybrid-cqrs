package jp.co.hybrid.write.data.service;

import jp.co.hybrid.common.swagger.CommonSwaggerConfiguration;
import jp.co.hybrid.write.data.service.backend.messaging.KafkaProducerConfig;
import jp.co.hybrid.write.data.service.backend.messaging.KafkaTopicConfig;
import jp.co.hybrid.write.data.service.web.WriteDataWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        WriteDataWebConfiguration.class,
        CommonSwaggerConfiguration.class,
        KafkaTopicConfig.class,
        KafkaProducerConfig.class
})
@EnableAutoConfiguration
@ComponentScan()
public class WriteDataServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(WriteDataServiceMain.class, args);
    }
}
