package com.snapshoes.store.presentation.dtos.request

import com.snapshoes.store.persistense.entities.UserRole

data class UserDto(
    val id: Long?,
    val username: String,
    val password: String,
    val role: UserRole?
)



