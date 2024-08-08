package com.snapshoes.store.service
import com.snapshoes.store.presentation.dtos.response.store.StoreDto
import com.snapshoes.store.presentation.dtos.mappers.store.StoreMapper
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.persistense.repositories.AddressRepository
import com.snapshoes.store.persistense.repositories.StoreRepository
import com.snapshoes.store.presentation.dtos.mappers.common.address.SaveAddressDtoToEntity
import com.snapshoes.store.presentation.dtos.request.SaveAddressDto

import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable


@Service
class StoreService(
    private val storeRepository: StoreRepository,
    private val addressRepository: AddressRepository,
    private val storeMapper: StoreMapper,
    private val saveAddressDtoToEntity: SaveAddressDtoToEntity,

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

    fun updateAddress(storeId: Long, form: SaveAddressDto): StoreDto {
        val store = storeRepository.findById(storeId)
            .orElseThrow { NotFoundException("Store NOT FOUND") }

        val address = saveAddressDtoToEntity.map(form)
        addressRepository.save(address)

        val updatedStore = store.copy(address = address)
        storeRepository.save(updatedStore)

        return storeMapper.map(updatedStore)
    }
}