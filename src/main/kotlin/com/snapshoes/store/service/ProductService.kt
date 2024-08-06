package com.snapshoes.store.service

import com.snapshoes.store.persistense.repositories.ProductRepository
import com.snapshoes.store.presentation.dtos.ProductDto
import com.snapshoes.store.presentation.mappers.ProductMapper
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper,
) {
    fun getAll(): List<ProductDto> {
       val products =  productRepository.findAll()
        return products.map { e->  productMapper.map(e)}
    }
}