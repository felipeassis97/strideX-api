package com.snapshoes.store.presentation.dtos.response.common

data class AddressDto(
    val id: Long?,
    val street: String,
    val neighborhood: String,
    val city: String,
    val state: String,
    val country: String,
    val zipcode: String,
    val lat: Double,
    val lng: Double
)