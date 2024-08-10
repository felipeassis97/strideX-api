package com.snapshoes.store.presentation.dtos.mappers

import com.snapshoes.store.config.interfaces.Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Genre
import com.snapshoes.store.presentation.dtos.response.common.GenreDto

@Component
class GenreMapper : Mapper<Genre, GenreDto> {
    override fun toDto(entity: Genre): GenreDto {
        return GenreDto(
            id = entity.id,
            name = entity.name
        )
    }

    override fun toEntity(dto: GenreDto): Genre {
        return Genre(
            id = dto.id,
            name = dto.name,
            createdAt = null,
            updatedAt = null
        )
    }


}