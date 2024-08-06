package com.snapshoes.store.service
import com.snapshoes.store.presentation.dtos.BrandDto
import com.snapshoes.store.presentation.mappers.BrandMapper
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.persistense.repositories.BrandRepository

import org.springframework.stereotype.Service

@Service
class BrandService(
    private val brandRepository: BrandRepository,
    private val brandMapper: BrandMapper,

) {
    fun getBrands() : List<BrandDto> {
        val brands = brandRepository.findAll()
        return brands.map { e ->  brandMapper.map(e)}
    }

    fun getBrandById(id: Long): BrandDto {
        val brand = brandRepository.findById(id)
            .orElseThrow{NotFoundException("Brand NOT FOUND")}
        return brandMapper.map(brand)
    }
}