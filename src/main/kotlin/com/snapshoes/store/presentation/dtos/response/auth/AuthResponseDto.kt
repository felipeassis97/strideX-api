package com.snapshoes.store.presentation.dtos.response.auth

data class AuthResponseDto(
    val accessToken: String,
    val refreshToken: String
)
