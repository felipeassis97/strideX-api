package com.snapshoes.store.presentation.dtos.mappers.common.address
import com.snapshoes.store.persistense.entities.Address
import com.snapshoes.store.presentation.dtos.mappers.common.Mapper
import com.snapshoes.store.presentation.dtos.request.SaveAddressDto
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class AddressMapperToEntity: Mapper<SaveAddressDto, Address> {
    override fun map(t: SaveAddressDto): Address {
        return Address(
            street = t.street,
            neighborhood = t.neighborhood,
            city = t.city,
            state = t.state,
            country = t.country,
            zipcode = t.zipcode,
            lat = t.lat,
            lng = t.lng,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
    }
}