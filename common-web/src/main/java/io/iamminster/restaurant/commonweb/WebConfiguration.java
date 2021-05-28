package io.iamminster.restaurant.commonweb;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    public ServletListenerRegistrationBean<RequestContextListener> httpRequestContextListener() {
        return new ServletListenerRegistrationBean<>(new RequestContextListener());
    }

}
