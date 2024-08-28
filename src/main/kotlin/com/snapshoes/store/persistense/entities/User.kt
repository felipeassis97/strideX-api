package com.snapshoes.store.persistense.entities

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



