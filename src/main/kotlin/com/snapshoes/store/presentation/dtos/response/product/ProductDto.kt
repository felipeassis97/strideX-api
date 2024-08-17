package com.snapshoes.store.presentation.dtos.response.product

import com.snapshoes.store.presentation.dtos.response.common.BrandDto
import com.snapshoes.store.presentation.dtos.response.common.GenreDto
import com.snapshoes.store.presentation.dtos.response.common.SizeDto

data class ProductDto(
    val id: Long? = null,
    val title: String,
    val description: String,
    val price: Double,
    val quantity: Long,
    val storeId: Long?,
    val brand: BrandDto,
    val images: List<ProductImageDto> = emptyList(),
    val sizes: List<SizeDto> = emptyList(),
    val genres: List<GenreDto> = emptyList()
)
