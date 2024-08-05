package com.snapshoes.store.presentation.mappers

import Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Address
import com.snapshoes.store.presentation.dtos.AddressDto


@Component
class AddressMapper: Mapper<Address, AddressDto> {
    override fun map(t: Address): AddressDto {
        return AddressDto(
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