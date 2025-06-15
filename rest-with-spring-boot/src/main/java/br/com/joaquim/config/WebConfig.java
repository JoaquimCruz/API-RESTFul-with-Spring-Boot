package br.com.joaquim.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.origin.patterns:}")
    private String corsOriginPatterns = "http://localhost:8080, http://localhost:3000";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
       var allowedOrigins = corsOriginPatterns.split(",");
       //aplicando cors em toda as rotas da aplicação
       registry.addMapping("/**")
               .allowedOrigins(allowedOrigins)
               .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
               .allowCredentials(true);
    }
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
       // essa passagem via header é a mais comum. Ela não é passada na url e sim no header.
        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("yaml", MediaType.APPLICATION_YAML); // para o yaml

    }




}
