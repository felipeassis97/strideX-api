package com.snapshoes.store.presentation.dtos.request.product

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.NotEmpty
import com.snapshoes.store.presentation.dtos.request.common.CreateBrandDto
import com.snapshoes.store.presentation.dtos.request.common.CreateGenreDto
import com.snapshoes.store.presentation.dtos.request.common.CreateSizeDto

data class CreateProductDto(
    @field:NotEmpty
    val title: String,

    @field:NotEmpty
    val description: String,

    @field:NotNull
    val price: Double,

    @field:NotNull
    val quantity: Long,

    @field:NotNull
    val storeId: Long,

    @field:NotNull
    val brand: CreateBrandDto,

    @field:NotEmpty
    val images: List<CreateProductImageDto> = emptyList(),

    @field:NotEmpty
    val sizes: List<CreateSizeDto> = emptyList(),

    @field:NotEmpty
    val genres: List<CreateGenreDto> = emptyList()
)
