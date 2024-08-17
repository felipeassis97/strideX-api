package com.snapshoes.store.service

import org.springframework.stereotype.Service
import org.springframework.cache.annotation.Cacheable
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.presentation.dtos.mappers.GenreMapper
import com.snapshoes.store.persistense.repositories.GenreRepository
import com.snapshoes.store.presentation.dtos.response.common.GenreDto

@Service
class GenreService(
    private val genreMapper: GenreMapper,
    private val genreRepository: GenreRepository
) {
    @Cacheable(cacheNames = ["Genres"], key = "#root.method.name")
    fun getGenres(): List<GenreDto> {
        val genres = genreRepository.findAll()
        return genres.map { e -> genreMapper.toDto(e) }
    }

    @Cacheable(cacheNames = ["Genres"], key = "#root.method.name")
    fun getGenreById(id: Long): GenreDto {
        val genre = genreRepository.findById(id)
            .orElseThrow { NotFoundException("Genre NOT FOUND") }
        return genreMapper.toDto(genre)
    }
}