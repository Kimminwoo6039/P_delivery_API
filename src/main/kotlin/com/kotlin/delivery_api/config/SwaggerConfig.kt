package com.kotlin.delivery_api.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
        info = Info(
                title = "배달 서비스 API",
                description = "배달 서비스 API 목록",
                version = "2024-01-02"
        )
)


class SwaggerConfig