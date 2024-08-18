package com.snapshoes.store.service

import org.springframework.stereotype.Service
import org.springframework.cache.annotation.Cacheable
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.presentation.dtos.mappers.BrandMapper
import com.snapshoes.store.persistense.repositories.BrandRepository
import com.snapshoes.store.persistense.repositories.ProductRepository
import com.snapshoes.store.presentation.dtos.response.common.BrandDto

@Service
class BrandService(
    private val brandMapper: BrandMapper,
    private val brandRepository: BrandRepository,
    private val productRepository: ProductRepository,
) {
    @Cacheable(cacheNames = ["Brands"], key = "#root.method.name")
    fun getBrands(): List<BrandDto> {
        val brands = brandRepository.findAll()
        return brands.map { e -> brandMapper.toDto(e) }
    }

    @Cacheable(cacheNames = ["Brands"], key = "#root.method.name")
    fun getBrandById(id: Long): BrandDto {
        val brand = brandRepository.findById(id)
            .orElseThrow { NotFoundException("Brand NOT FOUND") }
        return brandMapper.toDto(brand)
    }


    fun deleteBrandById(id: Long) {
        // Fetch all products by brandId
        val products = productRepository.findByBrandId(id)

        // Delete everyone
        if (products.isNotEmpty()) {
            productRepository.deleteAll(products)
        }
        brandRepository.deleteById(id)
    }
}