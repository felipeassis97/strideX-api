package com.snapshoes.store.persistense.entities

import jakarta.persistence.*

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val storeId: Long,

    @ManyToOne
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
        title = "", description = "",
        price = 0.0, quantity = 0,
        storeId = 0L, brand = Brand(),
        images = emptyList(),
        productSizes = emptyList(),
        productGenres = emptyList()
    )
}
