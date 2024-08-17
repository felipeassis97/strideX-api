package com.snapshoes.store.persistense.entities

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
data class Brand(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)

{
    // Default constructor
    constructor() : this(
        id = null,
        name = "",
        createdAt = null,
        updatedAt = null
    )
}
