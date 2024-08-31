package com.snapshoes.store.presentation.dtos.mappers

import com.snapshoes.store.persistence.entities.Product
import com.snapshoes.store.config.interfaces.Mapper
import com.snapshoes.store.persistence.entities.ProductSize
import com.snapshoes.store.presentation.dtos.response.common.SizeDto
import com.snapshoes.store.presentation.dtos.response.product.ProductSizeDto
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component

@Component
class ProductSizeMapper(
    private val sizeMapper: SizeMapper,
    private val entityManager: EntityManager
) : Mapper<ProductSize, ProductSizeDto> {
    override fun toDto(entity: ProductSize): ProductSizeDto {
        return ProductSizeDto(
            productId = entity.product.id,
            size = sizeMapper.toDto(entity.size)
        )
    }

    override fun toEntity(dto: ProductSizeDto): ProductSize {
        val productGenreRef = entityManager.getReference(Product::class.java, dto.productId)

        return ProductSize(
            product = productGenreRef,
            size = sizeMapper.toEntity(dto.size)
        )
    }

    fun sizeDtoToEntity(dto: SizeDto, productId: Long?): ProductSize {
        val productGenreRef = entityManager.getReference(Product::class.java, productId)

        return ProductSize(
            product = productGenreRef,
            size = sizeMapper.toEntity(dto)
        )
    }
}