package com.snapshoes.store.presentation.dtos.request.store

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class SaveAddressDto(

    @field:NotNull
    @field:Size(min = 3, max = 100, message = "Title must be between 5 and 100 characters long")
    val street: String,

    @field:NotNull
    @field:Size(min = 3, max = 100, message = "Neighborhood must be between 5 and 100 characters long")
    val neighborhood: String,

    @field:NotNull
    @field:Size(min = 3, max = 100, message = "City must be between 5 and 100 characters long")
    val city: String,

    @field:NotNull
    @field:Size(min = 3, max = 100, message = "State must be between 5 and 50 characters long")
    val state: String,

    @field:NotNull
    @field:Size(min = 3, max = 100, message = "Country must be between 5 and 50 characters long")
    val country: String,

    @field:NotEmpty()
    @field:Size(min = 3, max = 20, message = "Zipcode must be between 5 and 50 characters long")
    val zipcode: String,

    @field:NotNull
    val lat: Double,

    @field:NotNull
    val lng: Double
)