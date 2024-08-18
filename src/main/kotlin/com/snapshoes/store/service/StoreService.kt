package com.snapshoes.store.service

import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.CacheEvict
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.presentation.dtos.mappers.StoreMapper
import com.snapshoes.store.presentation.dtos.mappers.AddressMapper
import com.snapshoes.store.persistense.repositories.StoreRepository
import com.snapshoes.store.presentation.dtos.response.store.StoreDto
import com.snapshoes.store.persistense.repositories.AddressRepository
import com.snapshoes.store.presentation.dtos.request.store.CreateStoreDto
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto

@Service
class StoreService(
    private val storeMapper: StoreMapper,
    private val addressMapper: AddressMapper,
    private val storeRepository: StoreRepository,
    private val addressRepository: AddressRepository
) {
    @Cacheable(cacheNames = ["Stores"], key = "#root.method.name")
    fun getAllStores(name: String?, pageable: Pageable): Page<StoreDto> {
        val stores = name?.let { storeRepository.findByName(name, pageable) }
            ?: storeRepository.findAll(pageable)
        return stores.map { e -> storeMapper.toDto(e) }
    }

    @Cacheable(cacheNames = ["Stores"], key = "#root.method.name")
    fun getStoreById(id: Long): StoreDto {
        val store = storeRepository.findById(id)
            .orElseThrow { NotFoundException("Store NOT FOUND") }
        return storeMapper.toDto(store)
    }

    @CacheEvict(cacheNames = ["Stores"], allEntries = true)
    fun updateAddress(storeId: Long, form: SaveAddressDto): StoreDto {
        val store = storeRepository.findById(storeId)
            .orElseThrow { NotFoundException("Store NOT FOUND") }

        val address = addressMapper.updateFormToEntity(form)
        addressRepository.save(address)

        val updatedStore = store.copy(address = address)
        storeRepository.save(updatedStore)

        return storeMapper.toDto(updatedStore)
    }


    @CacheEvict(cacheNames = ["Stores"], allEntries = true)
    fun createStore(form: CreateStoreDto): StoreDto {
       val formAddress = form.address?.let {
           val formAddress = addressMapper.updateFormToEntity(it)
           addressRepository.save(formAddress)
        }

        val formStore = storeMapper.createFormToEntity(form);
        formStore.address = formAddress;
        val store = storeRepository.save(formStore)

        return storeMapper.toDto(store)
    }
}