package com.snapshoes.store.presentation.dtos.request.common

import jakarta.validation.constraints.Null
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class CreateBrandDto(
    @field:Null
    val id: Long?,

    @field:NotNull
    @field:NotEmpty
    val name: String
)

