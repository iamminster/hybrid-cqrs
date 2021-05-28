package jp.co.hybrid.write.data.service.web;

import io.iamminster.restaurant.commonweb.WebConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan()
@Import({WebConfiguration.class})
public class WriteDataWebConfiguration {
}
