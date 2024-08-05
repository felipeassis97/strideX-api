package com.snapshoes.store.persistense.entities
import jakarta.persistence.*

@Entity
data class ProductImage(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val url: String,

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product
){
    constructor() : this(
        id = null,
        url = "", product = Product()
    )
}