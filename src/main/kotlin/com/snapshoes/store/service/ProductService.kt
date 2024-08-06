package com.snapshoes.store.service

import com.snapshoes.store.persistense.predicates.ProductSpecification
import com.snapshoes.store.persistense.repositories.ProductRepository
import com.snapshoes.store.presentation.dtos.ProductDto
import com.snapshoes.store.presentation.mappers.ProductMapper
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper,
) {
    fun getAll(storeId: Long?, brandId: Long?, name: String?): List<ProductDto> {
        val products = productRepository.findAll(ProductSpecification(storeId, brandId, name))
        return products.map { productMapper.map(it) }
    }
}