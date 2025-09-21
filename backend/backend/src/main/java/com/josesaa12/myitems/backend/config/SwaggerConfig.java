package com.josesaa12.myitems.backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myItemsOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("📦 MyItems API")
                        .description("Documentación generada automáticamente con Swagger para el proyecto MyItems.")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio en GitHub")
                        .url("https://github.com/JoseSaa12/myitems"));
    }

    // 📌 Aquí están los links para que puedas ver mi Swagger:
    // Swagger UI: http://localhost:8080/swagger-ui/index.html
    // OpenAPI JSON: http://localhost:8080/v3/api-docs
}
