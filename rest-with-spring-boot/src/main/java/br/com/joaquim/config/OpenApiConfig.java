package br.com.joaquim.config;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API with Spring Boot 3")
                        .version("v1")
                        .description("This is a sample RESTful API built with Spring Boot 3, demonstrating various features such as HATEOAS, Swagger documentation, and more.")
                        .termsOfService("https://example.com/terms")
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html")));

    }
}
