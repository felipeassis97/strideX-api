package com.snapshoes.store.persistense.entities

import jakarta.persistence.*

@Entity
data class Size(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val size: String
) {
    constructor() : this(
        id = null,
        size = ""
    )
}