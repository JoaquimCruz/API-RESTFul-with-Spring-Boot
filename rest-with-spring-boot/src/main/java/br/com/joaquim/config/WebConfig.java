package br.com.joaquim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // via Extension http://localhost:8080/person/V1/1.xml deprecated on spring boot 2.6
    // Via query parameter http://localhost:8080/person/V1/1?mediaType=xml usual porém com uma url grande
    // e complexa de gerenciar.
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//            // query parameter
//            configurer.favorParameter(true)
//                    .parameterName("mediaType")
//                    .ignoreAcceptHeader(true)
//                    .useRegisteredExtensionsOnly(false)
//                    .defaultContentType(MediaType.APPLICATION_JSON)
//                    .mediaType("json", MediaType.APPLICATION_JSON)
//                    .mediaType("xml", MediaType.APPLICATION_XML);
//
//    }

    // Via headers http://localhost:8080/person/V1/1
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
