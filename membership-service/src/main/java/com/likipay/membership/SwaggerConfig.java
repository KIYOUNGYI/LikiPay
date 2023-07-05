package com.likipay.membership;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket restAPI() {

    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(new ApiInfo(
            "Title",
            "Description",
            "1.0",
            "Term of service URL",
            new Contact("Contact name", "Contact URL", "Contact email"),
            "License",
            "License URL",
            Collections.emptyList()
        ));
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().build();
  }
}
