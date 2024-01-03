package com.kotlin.delivery_api.controller.cart

import com.kotlin.delivery_api.controller.cart.dto.CartQueryRequest
import com.kotlin.delivery_api.service.cart.CartService
import io.github.oshai.kotlinlogging.KotlinLogging
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(origins = ["http://localhost:8080"], maxAge = 3600)
@Tag(name = "CartController" , description = "장바구니 컨트롤러")
@RestController
class CartController(
        val cartService: CartService
) {
    companion object {
        private val logger = KotlinLogging.logger(this::class.java.name)
    }

    @GetMapping("/apis/carts/items")
    fun list(cartQueryRequest : CartQueryRequest):ResponseEntity<CartQueryRequest> {

        logger.info { ">>> 장바구니 조회 요청" }
        val cart = cartService.findByCustomerId(cartQueryRequest.customerId)


        return ResponseEntity<CartQueryRequest>(HttpStatus.OK)
    }

}