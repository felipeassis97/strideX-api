package com.snapshoes.store.persistense.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,
    val description: String,
    val price: Double,
    val quantity: Long,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    val store: Store,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    val brand: Brand,

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val images: List<ProductImage> = emptyList(),

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val productSizes: List<ProductSize> = emptyList(),

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val productGenres: List<ProductGenre> = emptyList()
) {
    constructor() : this(
        id = null,
        title = "",
        description = "",
        price = 0.0,
        quantity = 0,
        createdAt = null,
        updatedAt = null,
        store = Store(),
        brand = Brand()
    )
}