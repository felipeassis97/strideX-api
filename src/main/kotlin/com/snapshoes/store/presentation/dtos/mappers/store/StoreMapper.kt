package com.snapshoes.store.presentation.dtos.mappers.store
import com.snapshoes.store.persistense.entities.*
import com.snapshoes.store.presentation.dtos.mappers.common.Mapper
import com.snapshoes.store.presentation.dtos.mappers.common.address.AddressMapperToDto
import com.snapshoes.store.presentation.dtos.response.store.StoreDto

import org.springframework.stereotype.Component

@Component
class StoreMapper(
    private val addressMapperToDto: AddressMapperToDto,
) : Mapper<Store, StoreDto> {
    override fun map(t: Store): StoreDto {
        return StoreDto(
            id = t.id,
            name = t.name,
            description = t.description,
            logo = t.logo,
            address = t.address?.let { addressMapperToDto.map(it)}
        )
    }
}

