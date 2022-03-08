package com.lab.engenharia.apifrotas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI buildOpenAPI() {
    var info = getInfo();
    return new OpenAPI().info(info);
  }

  private Info getInfo() {
    var license = getLicense();
    return new Info()
        .title("API de Frotas")
        .description("API responsável pelos dados de frotas no sistema de controle.")
        .version("1.0.0-SNAPSHOT")
        .license(license);
  }

  private License getLicense() {
    return new License()
        .name("Apache License Version 2.0")
        .url("https://www.apache.org/licenses/LICENSE-2.0\"");
  }
}