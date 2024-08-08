package com.snapshoes.store.presentation.dtos.mappers.product
import com.snapshoes.store.presentation.dtos.response.product.ProductDto
import com.snapshoes.store.presentation.dtos.mappers.common.Mapper
import com.snapshoes.store.persistense.entities.*
import com.snapshoes.store.presentation.dtos.mappers.common.BrandMapper
import com.snapshoes.store.presentation.dtos.mappers.common.GenreMapper
import com.snapshoes.store.presentation.dtos.mappers.common.SizeMapper

import org.springframework.stereotype.Component

@Component
class ProductMapper : Mapper<Product, ProductDto> {
    override fun map(t: Product): ProductDto {
        return ProductDto(
            id = t.id,
            storeId = t.store.id,
            title = t.title,
            description = t.description,
            price = t.price,
            quantity = t.quantity,
            brand = BrandMapper().map( t.brand),
            images = t.images.map { ProductImageMapper().map(it) },
            sizes = t.productSizes.map { SizeMapper().map(it.size) },
            genres = t.productGenres.map { GenreMapper().map(it.genre) }
        )
    }
}



