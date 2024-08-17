package com.snapshoes.store.presentation.dtos.mappers

import com.snapshoes.store.config.interfaces.Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.*
import com.snapshoes.store.presentation.dtos.request.store.CreateStoreDto
import com.snapshoes.store.presentation.dtos.response.store.StoreDto

@Component
class StoreMapper(
    private val addressMapper: AddressMapper,
) : Mapper<Store, StoreDto> {

    override fun toDto(entity: Store): StoreDto {
        return StoreDto(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            logo = entity.logo,
            address = entity.address?.let { addressMapper.toDto(it) }
        )
    }

    override fun toEntity(dto: StoreDto): Store {
        return Store(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            logo = dto.logo,
            address = dto.address?.let { addressMapper.toEntity(it) }
        )
    }

     fun createFormToEntity(dto: CreateStoreDto): Store {
        return Store(
            name = dto.name,
            description = dto.description,
            logo = dto.logo,
            address = dto.address?.let { addressMapper.updateFormToEntity(it) }
        )
    }


}

