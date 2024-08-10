package com.snapshoes.store.presentation.dtos.request.store
import com.snapshoes.store.presentation.dtos.response.common.AddressDto

data class UpdateStoreAddressDto(
    val storeId: Long,
    val address: AddressDto
)