package com.snapshoes.store.presentation.dtos.mappers

import com.snapshoes.store.config.interfaces.Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Size
import com.snapshoes.store.presentation.dtos.request.common.CreateSizeDto
import com.snapshoes.store.presentation.dtos.response.common.SizeDto

@Component
class SizeMapper : Mapper<Size, SizeDto> {
    override fun toDto(entity: Size): SizeDto {
        return SizeDto(
            id = entity.id,
            size = entity.size,
        )
    }

    override fun toEntity(dto: SizeDto): Size {
        return Size(
            id = dto.id,
            size = dto.size,
            createdAt = null,
            updatedAt = null
        )
    }

    fun createSizeDtoToEntity(dto: CreateSizeDto): Size {
        return Size(
            id = dto.id,
            size = dto.size,
            createdAt = null,
            updatedAt = null
        )
    }
}
