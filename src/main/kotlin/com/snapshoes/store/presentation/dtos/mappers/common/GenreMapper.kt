package com.snapshoes.store.presentation.dtos.mappers.common
import com.snapshoes.store.persistense.entities.Genre
import com.snapshoes.store.presentation.dtos.response.common.GenreDto

import org.springframework.stereotype.Component

@Component
class GenreMapper : Mapper<Genre, GenreDto> {
    override fun map(t: Genre): GenreDto {
        return GenreDto(
            id = t.id,
            name = t.name
        )
    }
}