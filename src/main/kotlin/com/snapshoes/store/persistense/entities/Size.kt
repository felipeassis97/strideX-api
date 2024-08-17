package com.snapshoes.store.persistense.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Size(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val size: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
) {
    // Default constructor
    constructor() : this(
        id = null,
        size = "",
        createdAt = null,
        updatedAt = null
    )
}