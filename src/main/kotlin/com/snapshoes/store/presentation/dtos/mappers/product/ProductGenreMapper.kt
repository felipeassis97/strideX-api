package com.snapshoes.store.presentation.dtos.mappers.product

import com.snapshoes.store.persistense.entities.ProductGenre
import com.snapshoes.store.presentation.dtos.mappers.common.GenreMapper
import com.snapshoes.store.presentation.dtos.mappers.common.Mapper
import com.snapshoes.store.presentation.dtos.response.product.ProductGenreDto
import org.springframework.stereotype.Component

@Component
class ProductGenreMapper : Mapper<ProductGenre, ProductGenreDto> {
    override fun map(t: ProductGenre): ProductGenreDto {
        return ProductGenreDto(
            productId = t.product.id,
            genre =   GenreMapper().map(t.genre),
        )
    }
}