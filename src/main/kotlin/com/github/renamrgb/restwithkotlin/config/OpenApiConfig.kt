package com.github.renamrgb.restwithkotlin.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig  {

    @Bean
    fun customOperApi() : OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Person api by kotlin")
                    .version("V1")
                    .description("Api in kotlin by person")
                    .termsOfService("https://github.com/renamrgb")
                    .license(
                        License().name("Apache 2.0").url("https://github.com/renamrgb")
                    )
            )
    }
}