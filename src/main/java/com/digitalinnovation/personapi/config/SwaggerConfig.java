package com.digitalinnovation.personapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.digitalinnovation.personapi"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageForGet());
    }

    private List<ResponseMessage> responseMessageForGet() {
        List<ResponseMessage> configs = new ArrayList<>();
        /*configs.add(new ResponseMessageBuilder()
                .code(404)
                .message("Erro 500")
                .responseModel(new ModelRef("Error"))
        .build());*/
        configs.add(new ResponseMessageBuilder()
                .code(403)
                .message("Acesso não permitido!")
                .build());
        configs.add(new ResponseMessageBuilder()
                .code(404)
                .message("Pessoa não encontrada!")
                .build());
        return configs;
    }
}
