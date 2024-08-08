package com.snapshoes.store.presentation.dtos.response.store

import com.snapshoes.store.presentation.dtos.response.common.AddressDto

data class StoreDto(
    val id: Long? = null,
    val name: String,
    val description: String,
    val logo: String?,
    val address: AddressDto?,
)






