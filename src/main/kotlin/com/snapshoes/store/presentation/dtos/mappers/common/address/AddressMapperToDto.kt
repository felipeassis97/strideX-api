package com.snapshoes.store.presentation.dtos.mappers.common.address
import com.snapshoes.store.persistense.entities.Address
import com.snapshoes.store.presentation.dtos.mappers.common.Mapper
import com.snapshoes.store.presentation.dtos.response.common.AddressDto

import org.springframework.stereotype.Component

@Component
class AddressMapperToDto: Mapper<Address, AddressDto> {
    override fun map(t: Address): AddressDto {
        return AddressDto(
            id = t.id,
            street = t.street,
            neighborhood = t.neighborhood,
            city = t.city,
            state = t.state,
            country = t.country,
            zipcode = t.zipcode,
            lat = t.lat,
            lng = t.lng,
        )
    }
}