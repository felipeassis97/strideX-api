package com.snapshoes.store.presentation.dtos
import java.time.LocalDateTime

data class BrandDto(
    val id: Long?,
    val name: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)