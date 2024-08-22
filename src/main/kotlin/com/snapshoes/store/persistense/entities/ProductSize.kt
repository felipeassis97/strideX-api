package com.snapshoes.store.persistense.entities

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime

@Entity
@IdClass(ProductSizeId::class)
data class ProductSize(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    var size: Size,

    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
)

{
    constructor() : this(
        product = Product(),
        size = Size(),
        createdAt = null,
        updatedAt = null
    )
}

@Embeddable
class ProductSizeId(
    val product: Long = 0L,
    val size: Long = 0L
) : Serializable