package com.snapshoes.store.persistense.entities

import java.time.LocalDate
import jakarta.persistence.*


@Entity
data class Address(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val street: String,
    val neighborhood: String,
    val city: String,
    val state: String,
    val country: String,
    val zipcode: String,
    val lat: Double,
    val lng: Double,
    val createdAt: LocalDate?,
    val updatedAt: LocalDate?,
){
    constructor() : this(
        id = null,
        street = "", neighborhood = "",
        city = "", state = "",
        country = "", zipcode = "",
        lat = 0.0, lng = 0.0,
        createdAt = null, updatedAt = null
    )
}
