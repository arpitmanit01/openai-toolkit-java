package com.java.toolkit.openaitoolkit;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Jake - Java", version = "1.0.0"),
		tags = {@Tag(name = "Toolkit", description = "Provides access to various OpenAI features")}
)

@SecurityScheme(name = "BearerJWT", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT",
		description = "Bearer token for the project.")

public class OpenaitoolkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenaitoolkitApplication.class, args);
	}

}
