package com.kayque.financemanager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI financeManagerOpenAPI() {

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()

                .info(
                        new Info()
                                .title("Finance Manager API")
                                .description("REST API for personal finance management")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Kayque Miguel")
                                                .email("seu-email@exemplo.com")
                                )
                )

                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(securitySchemeName)
                )

                .schemaRequirement(
                        securitySchemeName,
                        new SecurityScheme()

                                .name(securitySchemeName)

                                .type(SecurityScheme.Type.HTTP)

                                .scheme("bearer")

                                .bearerFormat("JWT")
                );
    }
}