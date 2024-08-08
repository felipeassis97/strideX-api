package com.snapshoes.store.persistense.entities

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
data class Store(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String,
    val logo: String?,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    val address: Address? = null,

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val products: List<Product> = emptyList(),

    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
) {
    constructor() : this(
        id = null,
        name = "",
        description = "",
        logo = "",
        address = Address(),
        createdAt = null,
        updatedAt = null,
    )
}



