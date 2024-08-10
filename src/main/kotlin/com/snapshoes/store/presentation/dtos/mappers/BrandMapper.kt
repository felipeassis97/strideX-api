package com.snapshoes.store.presentation.dtos.mappers

import com.snapshoes.store.config.interfaces.Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Brand
import com.snapshoes.store.presentation.dtos.response.common.BrandDto

@Component
class BrandMapper : Mapper<Brand, BrandDto> {
    override fun toDto(entity: Brand): BrandDto {
        return BrandDto(
            id = entity.id,
            name = entity.name,
        )
    }

    override fun toEntity(dto: BrandDto): Brand {
        return Brand(
            id = dto.id,
            name = dto.name,
            createdAt = null,
            updatedAt = null
        )
    }
}
