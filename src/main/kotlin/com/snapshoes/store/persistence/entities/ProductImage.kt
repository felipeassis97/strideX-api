package com.snapshoes.store.persistence.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class ProductImage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val url: String,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product
)

{
    constructor() : this(
        id = null,
        url = "",
        createdAt = null,
        updatedAt = null,
        product = Product()
    )
}
