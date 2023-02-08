package com.twitter.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.any;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(any())
                .paths(PathSelectors.any())
                .build();
    }
}
