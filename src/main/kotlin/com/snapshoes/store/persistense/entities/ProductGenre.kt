package com.snapshoes.store.persistense.entities
import jakarta.persistence.*

@Entity
data class ProductGenre(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product,

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    val genre: Genre
) {
    constructor() : this(
        id = null,
        product = Product(),
        genre = Genre()
    )
}