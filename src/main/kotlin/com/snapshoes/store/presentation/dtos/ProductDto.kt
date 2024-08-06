package com.snapshoes.store.presentation.dtos

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
