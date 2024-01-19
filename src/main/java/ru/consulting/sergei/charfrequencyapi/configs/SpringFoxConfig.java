package ru.consulting.sergei.charfrequencyapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration class for setting up Swagger documentation generation.
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    /**
     * Creates a Docket bean for configuring Swagger API documentation.
     *
     * @return The Docket instance.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.soigo.count.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
}