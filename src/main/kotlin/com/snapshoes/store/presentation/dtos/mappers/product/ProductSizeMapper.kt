package com.snapshoes.store.presentation.dtos.mappers.product

import com.snapshoes.store.persistense.entities.ProductSize
import com.snapshoes.store.presentation.dtos.mappers.common.Mapper
import com.snapshoes.store.presentation.dtos.mappers.common.SizeMapper
import com.snapshoes.store.presentation.dtos.response.product.ProductSizeDto
import org.springframework.stereotype.Component

@Component
class ProductSizeMapper : Mapper<ProductSize, ProductSizeDto> {
    override fun map(t: ProductSize): ProductSizeDto {
        val sizeMapper = SizeMapper()
        return ProductSizeDto(
            productId = t.product.id,
            size = sizeMapper.map(t.size)
        )
    }
}