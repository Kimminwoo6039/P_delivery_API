package com.kotlin.delivery_api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Tag(name = "첫 프로젝트 생성 컨트롤러" , description = "컨트롤러 조회 컨트롤러")
    @Operation(summary = "할리", description = "갈리")
    @GetMapping("/hello")
    fun hello():String {
        return "안녕";
    }
}