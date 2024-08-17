package com.snapshoes.store.presentation.dtos.response.product

import com.snapshoes.store.presentation.dtos.response.common.GenreDto

data class ProductGenreDto(
    val productId: Long?,
    val genre: GenreDto,
)

