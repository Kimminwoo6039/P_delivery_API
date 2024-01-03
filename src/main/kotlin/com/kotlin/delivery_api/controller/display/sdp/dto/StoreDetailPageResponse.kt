package com.kotlin.delivery_api.controller.display.sdp.dto

import com.kotlin.delivery_api.controller.catalog.menu.dto.MenuDTO
import java.math.BigDecimal

/// TODO : data class getter , setter , toStirng 을 지원 해줌
data class StoreDetailPageResponse (
    val storeId : Long, // 상점 아이디
    val storeName : String , // 상점 이름
        val phone:String, // 연락처
        val address:String , // 주소
        val deliveryFee:BigDecimal, //배송비 (?)
        val deliveryTime: String , // 배송시간
        val minimumOrderPrice:BigDecimal, // 최조 주문 금액
        val reviewGrade: Int , // 리뷰 평점
        val storeMainImageUrl : String , // 상점 메인 이미지
        val description: String, // 상점 내용
        val menus: List<MenuDTO> // 상점 메뉴 목록
)