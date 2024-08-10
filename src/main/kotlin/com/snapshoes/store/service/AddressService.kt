package com.snapshoes.store.service

import org.springframework.stereotype.Service
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto
import com.snapshoes.store.persistense.repositories.AddressRepository
import com.snapshoes.store.presentation.dtos.response.common.AddressDto
import com.snapshoes.store.presentation.dtos.mappers.AddressMapper

@Service
class AddressService(
    private val addressRepository: AddressRepository,
    private val addressMapper: AddressMapper,
) {
    fun saveAddress(address: SaveAddressDto): AddressDto {
        val addressSaved = addressRepository.save(addressMapper.saveAddressDtoToEntity(address))
        return addressMapper.toDto(addressSaved)
    }
}