package com.snapshoes.store.presentation.mappers

import Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.ProductSize
import com.snapshoes.store.presentation.dtos.ProductSizeDto


@Component
class ProductSizeMapper : Mapper<ProductSize, ProductSizeDto> {
    override fun map(t: ProductSize): ProductSizeDto {
        return ProductSizeDto(
            id = t.id,
            size = t.size.size
        )
    }
}
