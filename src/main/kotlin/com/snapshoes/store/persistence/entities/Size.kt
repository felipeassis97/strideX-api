package com.snapshoes.store.persistence.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Size(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val usSize: Double,
    val euSize: Double,
    val brSize: Double,
    val cmSize: Double,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
) {
    // Default constructor
    constructor() : this(
        id = null,
        usSize = 0.0,
        euSize = 0.0,
        brSize = 0.0,
        cmSize = 0.0,
        createdAt = null,
        updatedAt = null
    )
}