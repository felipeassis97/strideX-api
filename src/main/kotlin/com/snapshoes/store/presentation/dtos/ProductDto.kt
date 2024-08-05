package com.snapshoes.store.presentation.dtos

data class ProductDto(
    val id: Long?,
    val title: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val storeId: Long,
    val brand: BrandDto,
    val images: List<ProductImageDto> = emptyList(),
    val productSizes: List<ProductSizeDto> = emptyList(),
    val productGenres: List<ProductGenreDto> = emptyList()
)
