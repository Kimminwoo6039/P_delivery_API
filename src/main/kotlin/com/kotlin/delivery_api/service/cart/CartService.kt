package com.kotlin.delivery_api.service.cart

import com.kotlin.delivery_api.exception.NotFoundException
import com.kotlin.delivery_api.repository.cart.Cart
import com.kotlin.delivery_api.repository.cart.CartRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CartService(
        val cartRepository: CartRepository
) {
    private var serverRoleName: String = "role"

    companion object {
        private const val INIT_QUANTITY = 1
    }

    fun findByCustomerId(customerId: Long): Cart {
        val cartOptional = cartRepository.findAllByCustomerIdAndIsDeleted(customerId, false)
        if (cartOptional.isEmpty) {
            throw NotFoundException("고객님의 장바구니 정보를 찾을 수 없습니다.")
        }
        return cartOptional.get()
    }
}