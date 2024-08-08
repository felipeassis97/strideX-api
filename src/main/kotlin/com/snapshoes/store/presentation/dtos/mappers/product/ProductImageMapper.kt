package com.snapshoes.store.presentation.dtos.mappers.product

import com.snapshoes.store.persistense.entities.ProductImage
import com.snapshoes.store.presentation.dtos.mappers.common.Mapper
import com.snapshoes.store.presentation.dtos.response.product.ProductImageDto
import org.springframework.stereotype.Component

@Component
class ProductImageMapper : Mapper<ProductImage, ProductImageDto> {
    override fun map(t: ProductImage): ProductImageDto {
        return ProductImageDto(
            id = t.id,
            url = t.url,
        )
    }
}
