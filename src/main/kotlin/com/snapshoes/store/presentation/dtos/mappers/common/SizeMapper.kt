package com.snapshoes.store.presentation.dtos.mappers.common

import com.snapshoes.store.persistense.entities.Size
import com.snapshoes.store.presentation.dtos.response.common.SizeDto
import org.springframework.stereotype.Component

@Component
class SizeMapper : Mapper<Size, SizeDto> {
    override fun map(t: Size): SizeDto {
        return SizeDto(
            id = t.id,
            size = t.size,
        )
    }
}
