package com.snapshoes.store.service

import org.springframework.stereotype.Service
import com.snapshoes.store.presentation.dtos.mappers.AddressMapper
import com.snapshoes.store.persistense.repositories.AddressRepository
import com.snapshoes.store.presentation.dtos.response.common.AddressDto
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto


@Service
class AddressService(
    private val addressRepository: AddressRepository,
    private val addressMapper: AddressMapper,
) {
    fun saveAddress(address: SaveAddressDto): AddressDto {
        val addressSaved = addressRepository.save(addressMapper.updateFormToEntity(address))
        return addressMapper.toDto(addressSaved)
    }
}