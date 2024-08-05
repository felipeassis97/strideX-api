package com.snapshoes.store.presentation.dtos

data class AddressDto(
    val street: String,
    val neighborhood: String,
    val city: String,
    val state: String,
    val country: String,
    val zipcode: String,
    val lat: Double,
    val lng: Double
)