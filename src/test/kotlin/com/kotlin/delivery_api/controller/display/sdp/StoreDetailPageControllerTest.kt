package com.kotlin.delivery_api.controller.display.sdp

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.delivery_api.controller.display.sdp.dto.StoreDetailPageResponse
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
@AutoConfigureMockMvc
class StoreDetailPageControllerTest {


    // Api 연결 호출
    @Autowired
    private lateinit var mockMvc : MockMvc

    // Json 형태 변경
    @Autowired
    private lateinit var objectMapper : ObjectMapper

    @Autowired
    private lateinit var context: WebApplicationContext

    @Autowired
    private lateinit var storeDetailPageController: StoreDetailPageController

    @BeforeEach
    fun setUp(){}

    @AfterEach
    fun tearDown(){}

    @DisplayName("상품 상세 여부와 메뉴를 조회할수 있다.")
    @Test
    fun text_store_detail_and_menus() {
        //given
        val storeId = 1L
        val url = "/apis/display/stores/${storeId}"

        //when
        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isOk)
                .andReturn()

        //then
        val storeDetailPageResponse = objectMapper.readValue(mvcResult.response.contentAsString, StoreDetailPageResponse::class.java)
        Assertions.assertThat(storeDetailPageResponse).isNotNull
        Assertions.assertThat(storeDetailPageResponse.storeId).isEqualTo(storeId)

    }

}