package com.kotlin.delivery_api.advice

import com.kotlin.delivery_api.exception.MenuNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {

    @ExceptionHandler(value = [
        NullPointerException::class,
        IllegalArgumentException::class,
        MenuNotFoundException::class,
    ])
    fun handleApiRequestException(ex: Exception): ResponseEntity<Any?>? {

        return ResponseEntity<Any?>("에러", HttpStatus.BAD_REQUEST)
    }
}