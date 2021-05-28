package jp.co.hybrid.read.service;

import jp.co.hybrid.common.swagger.CommonSwaggerConfiguration;
import jp.co.hybrid.read.service.backend.messaging.KafkaConsumerConfig;
import jp.co.hybrid.read.service.web.ReadServiceWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({KafkaConsumerConfig.class,
        CommonSwaggerConfiguration.class,
        ReadServiceWebConfiguration.class})
@EnableAutoConfiguration
@ComponentScan()
public class ReadServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(ReadServiceMain.class, args);
    }
}
