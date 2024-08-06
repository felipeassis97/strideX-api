package com.snapshoes.store.presentation.mappers
import com.snapshoes.store.persistense.entities.Genre
import com.snapshoes.store.presentation.dtos.GenreDto
import Mapper

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