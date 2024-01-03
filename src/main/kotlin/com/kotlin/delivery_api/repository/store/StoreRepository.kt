package com.kotlin.delivery_api.repository.store

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository: JpaRepository<Store,Long> {

    /*
    @Query(
            value = """
           SELECT CategoryStore(
                csm.categoryId, s.storeId, s.storeName, s.storeMainImageUrl, s.deliveryTime, s.deliveryFee, s.reviewGrade)
           FROM Store s
           JOIN CategoryStoreMapping csm ON csm.storeId = s.storeId AND csm.categoryId = :categoryId
       """
    )
    fun findAllByCategoryId(@Param("categoryId") categoryId: Long): List<CategoryStore>

    @Query(
            value = """
           SELECT CategoryStore(
                csm.categoryId, s.storeId, s.storeName, s.storeMainImageUrl, s.deliveryTime, s.deliveryFee, s.reviewGrade)
           FROM Store s
           JOIN CategoryStoreMapping csm ON csm.storeId = s.storeId AND csm.categoryId = :categoryId
           WHERE s.reviewGrade >= :reviewGrade
       """
    )
    fun findAllByCategoryIdAndReviewGrade(@Param("categoryId") categoryId: Long, @Param("reviewGrade") reviewGrade: Int): List<CategoryStore>

    fun findAllByStoreNameContains(keyword: String): List<Store>

    fun findAllByStoreNameContainsAndReviewGradeIsGreaterThanEqual(keyword: String, reviewGrade: Int): List<Store>

     */

}