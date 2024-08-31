package com.snapshoes.store.config.exceptions

import java.time.LocalDateTime

data class RestExceptionResponse(
    val status: String,
    val message: String,
    val timestamp: LocalDateTime? = LocalDateTime.now(),
)
