package com.kotlin.delivery_api.controller.display.mdp.dto

import com.kotlin.delivery_api.domain.catalog.menu.MenuStatus
import java.math.BigDecimal

data class MenuDetailPageResponse(
        val menuId: Long, // 메뉴 아이디
        val menuName: String, // 메뉴 이름
        val storeId: Long, // 상점아이디
        val description: String, // 메뉴 상세 내용
        val menuMainImageUrl: String, // 메뉴 메인 이미지
        val price: BigDecimal, // 메뉴 가격
        val menuStatue: MenuStatus, // 메뉴 상태
)
