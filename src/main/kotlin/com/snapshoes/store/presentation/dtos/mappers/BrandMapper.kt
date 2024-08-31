package com.snapshoes.store.presentation.dtos.mappers

import org.springframework.stereotype.Component
import com.snapshoes.store.config.interfaces.Mapper
import com.snapshoes.store.persistence.entities.Brand
import com.snapshoes.store.presentation.dtos.response.common.BrandDto
import com.snapshoes.store.presentation.dtos.request.common.CreateBrandDto

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

    fun createBrandToEntity(id: Long?, form: CreateBrandDto): Brand {
        return Brand(
            id = id,
            name = form.name,
            createdAt = null,
            updatedAt = null
        )
    }
}

