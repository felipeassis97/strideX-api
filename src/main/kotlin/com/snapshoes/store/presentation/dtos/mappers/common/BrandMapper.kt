package com.snapshoes.store.presentation.dtos.mappers.common
import com.snapshoes.store.persistense.entities.Brand
import com.snapshoes.store.presentation.dtos.response.common.BrandDto

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
