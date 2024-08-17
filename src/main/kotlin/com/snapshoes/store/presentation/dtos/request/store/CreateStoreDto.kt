package com.snapshoes.store.presentation.dtos.request.store

import jakarta.validation.constraints.Null
import jakarta.validation.constraints.Size
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.NotEmpty

data class CreateStoreDto (
    @field:NotNull
    @field:NotEmpty()
    @field:Size(min = 3, max = 100, message = "Name must be between 5 and 100 characters long")
    val name: String,

    @field:NotNull
    @field:NotEmpty()
    @field:Size(min = 3, max = 240, message = "Description must be between 5 and 240 characters long")
    val description: String,

    @field:Null
    val logo: String?,

    @field:Null
    val address: SaveAddressDto?
)
