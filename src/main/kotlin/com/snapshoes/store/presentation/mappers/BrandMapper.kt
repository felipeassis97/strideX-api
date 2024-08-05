package com.snapshoes.store.presentation.mappers

import Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Brand
import com.snapshoes.store.presentation.dtos.BrandDto

@Component
class BrandMapper : Mapper<Brand, BrandDto> {
    override fun map(t: Brand): BrandDto {
        return BrandDto(
            id = t.id,
            name = t.name,
        )
    }
}
