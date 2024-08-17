package com.snapshoes.store.presentation.dtos.request.product

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.NotEmpty
import com.snapshoes.store.presentation.dtos.request.common.CreateBrandDto
import com.snapshoes.store.presentation.dtos.request.common.CreateGenreDto
import com.snapshoes.store.presentation.dtos.request.common.CreateSizeDto
import jakarta.validation.constraints.Size

data class CreateProductDto(
    @field:NotNull
    @field:Size(min = 3, max = 100, message = "Title must be between 5 and 100 characters long")
    val title: String,

    @field:NotNull
    @field:Size(min = 3, max = 240, message = "Description must be between 5 and 240 characters long")
    val description: String,

    @field:NotNull
    @field:NotEmpty
    val price: Double,

    @field:NotNull
    @field:NotEmpty
    val quantity: Long,

    @field:NotNull
    @field:NotEmpty
    val storeId: Long,

    @field:NotNull
    @field:NotEmpty
    val brand: CreateBrandDto,

    @field:NotNull
    @field:NotEmpty
    val images: List<CreateProductImageDto> = emptyList(),

    @field:NotEmpty
    val sizes: List<CreateSizeDto> = emptyList(),

    @field:NotEmpty
    val genres: List<CreateGenreDto> = emptyList()
)
