package com.snapshoes.store.persistense.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class ProductSize(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    val size: Size,

    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
) {
    constructor() : this(
        product = Product(),
        size = Size(),
        createdAt = null,
        updatedAt = null
    )
}