package com.snapshoes.store.presentation.dtos.mappers

import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Product
import com.snapshoes.store.persistense.entities.ProductImage
import com.snapshoes.store.config.interfaces.Mapper
import com.snapshoes.store.presentation.dtos.response.product.ProductImageDto

@Component
class ProductImageMapper(
    private val entityManager: EntityManager
) : Mapper<ProductImage, ProductImageDto> {

    override fun toDto(entity: ProductImage): ProductImageDto {
        return ProductImageDto(
            id = entity.id,
            url = entity.url,
            productId = entity.product.id,
        )
    }

    override fun toEntity(dto: ProductImageDto): ProductImage {
        val productGenreRef = entityManager.getReference(Product::class.java, dto.productId)
        return ProductImage(
            id = dto.id,
            url = dto.url,
            product = productGenreRef,
            createdAt = null,
            updatedAt = null
        )
    }
}
