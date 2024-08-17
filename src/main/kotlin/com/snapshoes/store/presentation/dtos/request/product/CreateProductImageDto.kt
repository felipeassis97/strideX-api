package com.snapshoes.store.presentation.dtos.request.product

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null

data class CreateProductImageDto(
    @field:Null
    val id: Long?,

    @field:NotNull
    @field:NotEmpty
    val url: String
)