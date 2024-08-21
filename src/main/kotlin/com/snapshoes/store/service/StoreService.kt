package com.snapshoes.store.service

import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.CacheEvict
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.persistense.entities.Address
import com.snapshoes.store.persistense.repositories.*
import com.snapshoes.store.presentation.dtos.mappers.StoreMapper
import com.snapshoes.store.presentation.dtos.mappers.AddressMapper
import com.snapshoes.store.presentation.dtos.response.store.StoreDto
import com.snapshoes.store.presentation.dtos.request.store.CreateStoreDto
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto

@Service
class StoreService(
    private val storeMapper: StoreMapper,
    private val addressMapper: AddressMapper,
    private val productRepository: ProductRepository,
    private val storeRepository: StoreRepository,
    private val addressRepository: AddressRepository,
    private val productGenreRepository: ProductGenreRepository,
    private val productImageRepository: ProductImageRepository,
    private val productSizeRepository: ProductSizeRepository,
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
            .orElseThrow { NotFoundException("Store not found with ID: $id") }
        return storeMapper.toDto(store)
    }

    @CacheEvict(cacheNames = ["Stores"], allEntries = true)
    fun updateAddress(storeId: Long, form: SaveAddressDto): StoreDto {
        val store = storeRepository.findById(storeId)
            .orElseThrow { NotFoundException("Store not found with ID: $storeId") }

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

    @CacheEvict(cacheNames = ["Stores"], allEntries = true)
    fun deleteStoreById(id: Long) {
        val store = storeRepository.findById(id)
            .orElseThrow { NotFoundException("Store not found with ID: $id") }

        val products = productRepository.findByStoreId(id)
        products.map {
            it.id?.let { it1 -> productGenreRepository.deleteByProductId(it1) }
            it.id?.let { it1 -> productImageRepository.deleteByProductId(it1) }
            it.id?.let { it1 -> productSizeRepository.deleteByProductId(it1) }
        }

        storeRepository.delete(store)
    }
}