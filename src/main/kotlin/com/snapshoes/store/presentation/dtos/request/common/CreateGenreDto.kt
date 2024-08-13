package com.snapshoes.store.presentation.dtos.request.common

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Null

data class CreateGenreDto(
    @field:Null
    val id: Long?,

    @field:NotEmpty
    val name: String,
)