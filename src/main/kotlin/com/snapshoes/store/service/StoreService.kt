package com.snapshoes.store.service

import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.persistense.repositories.StoreRepository
import com.snapshoes.store.presentation.dtos.StoreDto
import com.snapshoes.store.presentation.mappers.StoreMapper
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page

@Service
class StoreService(
    private val storeRepository: StoreRepository,
    private val storeMapper: StoreMapper,
) {
    fun getAllStores(name: String?, pageable: Pageable): Page<StoreDto> {
        val stores = name?.let { storeRepository.findByName(name, pageable) }
            ?: storeRepository.findAll(pageable)
        return stores.map { e -> storeMapper.map(e) }
    }

    fun getStoreById(id: Long): StoreDto {
        val store = storeRepository.findById(id)
            .orElseThrow { NotFoundException("Store NOT FOUND") }
        return storeMapper.map(store)
    }
}