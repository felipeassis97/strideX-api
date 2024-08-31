package com.snapshoes.store.presentation.dtos.mappers

import com.snapshoes.store.config.interfaces.Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistence.entities.Size
import com.snapshoes.store.presentation.dtos.request.common.CreateSizeDto
import com.snapshoes.store.presentation.dtos.response.common.SizeDto

@Component
class SizeMapper : Mapper<Size, SizeDto> {
    override fun toDto(entity: Size): SizeDto {
        return SizeDto(
            id = entity.id,
            usSize = entity.usSize,
            euSize = entity.euSize,
            brSize = entity.brSize,
            cmSize = entity.cmSize
        )
    }

    override fun toEntity(dto: SizeDto): Size {
        return Size(
            id = dto.id,
            usSize = dto.usSize,
            euSize = dto.euSize,
            brSize = dto.brSize,
            cmSize = dto.cmSize,
            createdAt = null,
            updatedAt = null
        )
    }

    fun createSizeDtoToEntity(dto: CreateSizeDto): Size {
        return Size(
            id = dto.id,
            usSize = dto.usSize,
            euSize = dto.euSize,
            brSize = dto.brSize,
            cmSize = dto.cmSize,
            createdAt = null,
            updatedAt = null
        )
    }
}
