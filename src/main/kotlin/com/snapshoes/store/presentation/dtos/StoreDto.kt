package com.snapshoes.store.presentation.dtos

data class StoreDto(
    val id: Long?,
    val name: String,
    val description: String,
    val logo: String,
    val address: AddressDto,
    var products: List<ProductDto>
)






