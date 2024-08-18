package com.snapshoes.store.presentation.dtos.request.common

import jakarta.validation.constraints.Null
import jakarta.validation.constraints.NotEmpty

data class CreateBrandDto(
    @field:Null
    val id: Long?,

    @field:NotEmpty
    val name: String
)

