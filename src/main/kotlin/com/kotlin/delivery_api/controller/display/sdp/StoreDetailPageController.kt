package com.kotlin.delivery_api.controller.display.sdp

import com.kotlin.delivery_api.controller.catalog.menu.dto.MenuDTO
import com.kotlin.delivery_api.controller.display.sdp.dto.StoreDetailPageResponse
import com.kotlin.delivery_api.exception.NotFoundStoreException
import com.kotlin.delivery_api.service.menu.MenuService
import com.kotlin.delivery_api.service.store.StoreService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "StroeDetailPageController" , description = "상점 상세 페이지 컨트롤러")
@RestController
class StoreDetailPageController(
        val storeService: StoreService,
        val menuService: MenuService,
) {


    @GetMapping("/apis/display/stores/{storeId}")
    fun list(@PathVariable storeId: Long): StoreDetailPageResponse {
        val storeOptional = storeService.findByStoreId(storeId);
        if (storeOptional.isEmpty) {
            throw NotFoundStoreException("상점 정보를 찾을수 없습니다. $storeId");
        }

        val store = storeOptional.get()

        val menus = menuService.findByStoreId(storeId)
        val menuDTOs = menus.map { MenuDTO.from(it) }

        return StoreDetailPageResponse(
                storeId = storeId,
                storeName = store.storeName,
                phone = store.storePhone,
                address = store.address,
                storeMainImageUrl = store.storeMainImageUrl,
                description = store.description,
                deliveryFee = store.deliveryFee,
                deliveryTime = store.deliveryTime,
                reviewGrade = store.reviewGrade,
                minimumOrderPrice = store.minimumOrderPrice,
                menus = menuDTOs,
        )

    }
}