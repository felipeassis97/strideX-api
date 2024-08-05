package com.snapshoes.store.persistense.entities

import jakarta.persistence.*

@Entity
data class Store(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String,
    val logo: String,

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    val address: Address,

    @OneToMany(mappedBy = "storeId", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val products: List<Product> = emptyList()
) {
    constructor() : this(
        id = null,
        name = "", description = "",
        logo = "", address = Address(),
        products = emptyList()
    )
}
