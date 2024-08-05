package com.snapshoes.store.presentation.mappers

import Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Genre
import com.snapshoes.store.presentation.dtos.GenreDto

@Component
class GenreMapper : Mapper<Genre, GenreDto> {
    override fun map(t: Genre): GenreDto {
        return GenreDto(
            id = t.id,
            name = t.name
        )
    }
}