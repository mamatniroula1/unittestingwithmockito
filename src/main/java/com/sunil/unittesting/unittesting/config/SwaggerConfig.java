package com.sunil.unittesting.unittesting.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    private static final Contact DEFAULT_CONTACT =  new Contact("Sunil Niroula", "http://testingwithMockito",
            "sunilniroula1@gmail.com");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Awesome Api Title", "Awesome Api Documentation", "1.0",
            "urn:tos", DEFAULT_CONTACT.toString(), "Apache 2.0",
            "http://www.apache.org/licences/license-2.0"
    );

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }

}
