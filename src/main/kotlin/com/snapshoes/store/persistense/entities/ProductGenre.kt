package com.snapshoes.store.persistense.entities

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime

@Entity
@IdClass(ProductGenreId::class)
data class ProductGenre(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    val genre: Genre,

    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
) {
    constructor() : this(
        product = Product(), // Construtor padrão para Product
        genre = Genre(), // Construtor padrão para Genre
        createdAt = null,
        updatedAt = null
    )
}


@Embeddable
class ProductGenreId(
    val product: Long = 0L,
    val genre: Long = 0L
) : Serializable