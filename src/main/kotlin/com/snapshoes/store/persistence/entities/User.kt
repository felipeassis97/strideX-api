package com.snapshoes.store.persistence.entities

import jakarta.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val username: String,
    val password: String,
    val role: String
) {
    constructor() : this(
        id = null,
        username = "",
        password = "",
        role = ""
    )
}



