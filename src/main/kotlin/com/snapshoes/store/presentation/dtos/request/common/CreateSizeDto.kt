package com.snapshoes.store.presentation.dtos.request.common

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null

data class CreateSizeDto(
    @field:Null
    val id: Long?,

    @field:NotNull
    @field:NotEmpty
    val usSize: Double,

    @field:NotEmpty
    val euSize: Double,

    @field:NotEmpty
    val brSize: Double,

    @field:NotEmpty
    val cmSize: Double,
)