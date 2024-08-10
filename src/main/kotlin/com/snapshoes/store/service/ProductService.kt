package com.snapshoes.store.service

import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import com.snapshoes.store.persistense.repositories.ProductRepository
import com.snapshoes.store.presentation.dtos.response.product.ProductDto
import com.snapshoes.store.presentation.dtos.mappers.ProductMapper
import com.snapshoes.store.persistense.specifications.ProductSpecifications

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper,
) {
    fun getAll(storeId: Long?, brandId: Long?, name: String?, pageable: Pageable): Page<ProductDto> {
        val products = productRepository.findAll(
            Specification.where(
                storeId?.let { ProductSpecifications.hasStoreId(it) })
                .and(brandId?.let { ProductSpecifications.hasBrandId(it) })
                .and(name?.let { ProductSpecifications.hasName(it) }),
            pageable
        )
        return products.map { productMapper.toDto(it) }
    }
}