package com.snapshoes.store.presentation.dtos.mappers

import com.snapshoes.store.config.interfaces.Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Address
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto
import com.snapshoes.store.presentation.dtos.response.common.AddressDto

@Component
class AddressMapper : Mapper<Address, AddressDto> {
    override fun toDto(entity: Address): AddressDto {
        return AddressDto(
            id = entity.id,
            street = entity.street,
            neighborhood = entity.neighborhood,
            city = entity.city,
            state = entity.state,
            country = entity.country,
            zipcode = entity.zipcode,
            lat = entity.lat,
            lng = entity.lng,
        )
    }

    override fun toEntity(dto: AddressDto): Address {
        return Address(
            id = dto.id,
            street = dto.street,
            neighborhood = dto.neighborhood,
            city = dto.city,
            state = dto.state,
            country = dto.country,
            zipcode = dto.zipcode,
            lat = dto.lat,
            lng = dto.lng,
            createdAt = null,
            updatedAt = null,
        )
    }

    fun updateFormToEntity(t: SaveAddressDto): Address {
        return Address(
            street = t.street,
            neighborhood = t.neighborhood,
            city = t.city,
            state = t.state,
            country = t.country,
            zipcode = t.zipcode,
            lat = t.lat,
            lng = t.lng,
            createdAt = null,
            updatedAt = null,
        )
    }
}