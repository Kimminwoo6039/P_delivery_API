package com.kotlin.delivery_api.service.store

import com.kotlin.delivery_api.repository.store.Store
import com.kotlin.delivery_api.repository.store.StoreRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
@Transactional
class StoreService(
        private val storeRepository: StoreRepository
) {

    fun findByStoreId(storeId : Long) : Optional<Store> {
       return storeRepository.findById(storeId);
    }

}