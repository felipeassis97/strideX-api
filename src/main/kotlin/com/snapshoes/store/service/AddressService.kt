package com.snapshoes.store.service

import org.springframework.stereotype.Service
import com.snapshoes.store.presentation.dtos.request.SaveAddressDto
import com.snapshoes.store.persistense.repositories.AddressRepository
import com.snapshoes.store.presentation.dtos.response.common.AddressDto
import com.snapshoes.store.presentation.dtos.mappers.common.address.AddressMapperToDto
import com.snapshoes.store.presentation.dtos.mappers.common.address.AddressMapperToEntity

@Service
class AddressService(
    private val addressRepository: AddressRepository,
    private val addressMapperToDto: AddressMapperToDto,
    private val saveAddressDtoToEntity: AddressMapperToEntity,
) {
    fun saveAddress(address: SaveAddressDto): AddressDto {
        val addressSaved = addressRepository.save(saveAddressDtoToEntity.map(address))
        return addressMapperToDto.map(addressSaved)
    }
}