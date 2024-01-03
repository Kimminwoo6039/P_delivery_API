package com.kotlin.delivery_api.repository.cart

import com.kotlin.delivery_api.repository.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "carts" , catalog = "food_delivery")
class Cart (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    val cartId: Long = 0,

    @Column(name = "customer_id")
    val customerId: Long,

): BaseEntity()