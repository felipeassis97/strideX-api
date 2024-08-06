package com.snapshoes.store.presentation.mappers
import com.snapshoes.store.persistense.entities.Brand
import com.snapshoes.store.presentation.dtos.BrandDto
import Mapper

import org.springframework.stereotype.Component

@Component
class BrandMapper : Mapper<Brand, BrandDto> {
    override fun map(t: Brand): BrandDto {
        return BrandDto(
            id = t.id,
            name = t.name,
        )
    }
}
