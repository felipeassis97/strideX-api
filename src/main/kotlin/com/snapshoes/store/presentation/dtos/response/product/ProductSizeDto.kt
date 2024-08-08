package com.snapshoes.store.presentation.dtos.response.product

import com.snapshoes.store.presentation.dtos.response.common.SizeDto

data class ProductSizeDto(
    val productId: Long?,
    val size: SizeDto
)

