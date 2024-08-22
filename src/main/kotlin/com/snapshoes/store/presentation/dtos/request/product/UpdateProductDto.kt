package com.snapshoes.store.presentation.dtos.request.product

import jakarta.validation.constraints.Null
import jakarta.validation.constraints.Size
import jakarta.validation.constraints.NotEmpty
import com.snapshoes.store.presentation.dtos.request.common.CreateBrandDto
import com.snapshoes.store.presentation.dtos.request.common.CreateGenreDto
import com.snapshoes.store.presentation.dtos.request.common.CreateSizeDto

data class UpdateProductDto(
    @field:Size(min = 3, max = 100, message = "Title must be between 5 and 100 characters long")
    val title: String?,

    @field:Size(min = 3, max = 240, message = "Description must be between 5 and 240 characters long")
    val description: String?,

    @field:NotEmpty
    val price: Double?,

    @field:NotEmpty
    val quantity: Long?,

    @field:NotEmpty
    val brand: CreateBrandDto?,

    @field:NotEmpty
    val images: List<CreateProductImageDto>?,

    @field:Null
    val sizes: List<CreateSizeDto>?,

    @field:Null
    val genres: List<CreateGenreDto>?,
)
