package com.snapshoes.store.service

import org.springframework.stereotype.Service
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.CacheEvict
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.presentation.dtos.mappers.BrandMapper
import com.snapshoes.store.persistence.repositories.BrandRepository
import com.snapshoes.store.persistence.repositories.ProductRepository
import com.snapshoes.store.presentation.dtos.response.common.BrandDto
import com.snapshoes.store.presentation.dtos.request.common.CreateBrandDto

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
            .orElseThrow {
                NotFoundException("Brand not found with ID: $id")
            }
        return brandMapper.toDto(brand)
    }

    @CacheEvict(cacheNames = ["Brands"], allEntries = true)
    fun deleteBrandAndProducts(id: Long) {
        val products = productRepository.findByBrandId(id)
        if (products.isNotEmpty()) {
            productRepository.deleteAll(products)
        }
        brandRepository.deleteById(id)
    }

    @CacheEvict(cacheNames = ["Brands"], allEntries = true)
    fun updateBrandById(id: Long, form: CreateBrandDto): BrandDto {
        val updatedBrand = brandMapper.createBrandToEntity(id, form)
        val brand = brandRepository.save(updatedBrand)
        return brandMapper.toDto(brand)
    }

    @CacheEvict(cacheNames = ["Brands"], allEntries = true)
    fun createBrand(form: CreateBrandDto): BrandDto {
        val toSaveBrand = brandMapper.createBrandToEntity(null, form)
        val brand = brandRepository.save(toSaveBrand)
        return brandMapper.toDto(brand)
    }
}
