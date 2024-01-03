package com.kotlin.delivery_api.controller.display.mdp

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.delivery_api.controller.display.sdp.StoreDetailPageController
import com.kotlin.delivery_api.domain.catalog.menu.MenuStatus
import com.kotlin.delivery_api.repository.menu.Menu
import com.kotlin.delivery_api.service.menu.MenuService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import java.math.BigDecimal
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class MenuDetailPageControllerTest {

    @Mock
    private lateinit var menuService: MenuService

    @InjectMocks
    private lateinit var menuDetailPageController: MenuDetailPageController


    @BeforeEach
    fun setUp(){}

    @AfterEach
    fun tearDown(){}


    @DisplayName("menuID 로 메뉴 상세 정보 조회를 할수 있다")
    @Test
    fun test_menu_detail_query() {
        //given
        val menuId = 1L
        val testMenu = createTestMenu(menuId)
        `when`(menuService.findByMenuId(menuId)).thenReturn(Optional.of(testMenu))

        //when
        val menuDetailPageResponse = this.menuDetailPageController.detail(menuId,1)
        //then

        Assertions.assertThat(menuDetailPageResponse).isNotNull
        Assertions.assertThat(menuDetailPageResponse.menuId).isEqualTo(menuId)
    }


    private fun createTestMenu(menuId:Long) : Menu {
        return Menu(
                menuId = menuId,
                storeId = 1L,
                menuName = "name",
                menuMainImageUrl = "image",
                price = BigDecimal(1_000),
                menuStatus = MenuStatus.SALE,
                description = "desc",
                createdBy = "tester",
                updatedBy = "tester",
        )
    }

}