package com.gerenciar.gerenciamentodepessoas.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {


    @Bean
    public OpenAPI springBlogPessoalOpenAPI() {

        return new OpenAPI().info(new Info().title("Avaliação desenvolvedor backend").description("Resposta").version("v0.0.1")
                .license(new License().name("Rebeca").url("https://www.linkedin.com/in/rebeca-silva-821607231/"))
                .contact(new Contact().name("Rebeca Silva").url("https://github.com/RebecaSSilva").email("rebeca-99a@hotmail.com"))).externalDocs(new ExternalDocumentation().description("Meu LinkedIn").url("https://www.linkedin.com/in/rebeca-silva-821607231/"));
    }
    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();

                apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                apiResponses.addApiResponse("201", createApiResponse("Objeto persistido!"));
                apiResponses.addApiResponse("204", createApiResponse("Objeto excluído!"));
                apiResponses.addApiResponse("400", createApiResponse("Erro na requisição!"));
                apiResponses.addApiResponse("401", createApiResponse("Acesso negado!"));
                apiResponses.addApiResponse("404", createApiResponse("Objeto não encontrado!"));
                apiResponses.addApiResponse("500", createApiResponse("Erro na aplicação!"));
            }));
        };
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}

