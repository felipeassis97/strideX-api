package com.snapshoes.store.presentation.mappers

import Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.ProductImage
import com.snapshoes.store.presentation.dtos.ProductImageDto

@Component
class ProductImageMapper : Mapper<ProductImage, ProductImageDto> {
    override fun map(t: ProductImage): ProductImageDto {
        return ProductImageDto(
            id = t.id,
            url = t.url
        )
    }
}