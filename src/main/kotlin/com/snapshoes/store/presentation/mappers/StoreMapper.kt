package com.snapshoes.store.presentation.mappers
import com.snapshoes.store.persistense.entities.*
import com.snapshoes.store.presentation.dtos.*
import Mapper

import org.springframework.stereotype.Component

@Component
class StoreMapper(
    private val addressMapper: AddressMapper,
) : Mapper<Store, StoreDto> {
    override fun map(t: Store): StoreDto {
        return StoreDto(
            id = t.id,
            name = t.name,
            description = t.description,
            logo = t.logo,
            address = addressMapper.map(t.address),
        )
    }
}

