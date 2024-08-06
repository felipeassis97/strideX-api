package com.snapshoes.store

import com.snapshoes.store.presentation.dtos.GenreDto

data class ProductGenreDto(
    val productId: Long?,
    val genre: GenreDto,
)

