package com.snapshoes.store.persistense.entities

import jakarta.persistence.*

@Entity
data class ProductSize(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product,

    @ManyToOne
    @JoinColumn(name = "size_id", nullable = false)
    val size: Size
) {
    constructor() : this(
        id = null,
        product = Product(), size = Size()
    )
}