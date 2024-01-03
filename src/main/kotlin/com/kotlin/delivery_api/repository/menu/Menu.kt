package com.kotlin.delivery_api.repository.menu

import com.kotlin.delivery_api.domain.catalog.menu.MenuStatus
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.OffsetDateTime

@Entity
@Table(name = "menus", catalog = "food_delivery")
class Menu(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "menuId", nullable = false)
        val menuId: Long = -1,

        @Column(name = "storeId", nullable = false)
        val storeId: Long,

        @Column(name = "menuName", nullable = false)
        val menuName: String,

        @Column(name = "menuMainImage", nullable = false)
        val menuMainImageUrl: String,

        @Column(name = "price", nullable = false)
        val price: BigDecimal,

        @Enumerated(value = EnumType.STRING)
        @Column(name = "status", nullable = false)
        val menuStatus: MenuStatus = MenuStatus.READY,

        @Column(name = "description", nullable = false)
        val description: String,

        @Column(name = "isDeleted", nullable = false)
        val isDeleted: Boolean = false,

        @Column(name = "createdAt", nullable = false)
        val createdAt: OffsetDateTime = OffsetDateTime.now(),

        @Column(name = "updatedAt", nullable = false)
        val updatedAt: OffsetDateTime = OffsetDateTime.now(),

        @Column(name = "createdBy", nullable = false)
        val createdBy: String,

        @Column(name = "updatedBy", nullable = false)
        val updatedBy: String,
)