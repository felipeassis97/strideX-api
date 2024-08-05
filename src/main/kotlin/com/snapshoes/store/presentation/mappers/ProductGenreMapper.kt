package com.snapshoes.store.presentation.mappers

import Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.ProductGenre
import com.snapshoes.store.presentation.dtos.ProductGenreDto


@Component
class ProductGenreMapper : Mapper<ProductGenre, ProductGenreDto> {
    override fun map(t: ProductGenre): ProductGenreDto {
        return ProductGenreDto(
            id = t.id,
            name = t.genre.name
        )
    }
}