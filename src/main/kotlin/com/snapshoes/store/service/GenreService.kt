package com.snapshoes.store.service

import org.springframework.stereotype.Service
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.CacheEvict
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.presentation.dtos.mappers.GenreMapper
import com.snapshoes.store.persistence.repositories.GenreRepository
import com.snapshoes.store.presentation.dtos.response.common.GenreDto
import com.snapshoes.store.persistence.repositories.ProductGenreRepository
import com.snapshoes.store.presentation.dtos.request.common.CreateGenreDto

@Service
class GenreService(
    private val genreMapper: GenreMapper,
    private val genreRepository: GenreRepository,
    private val productGenreRepository: ProductGenreRepository,
) {
    @Cacheable(cacheNames = ["Genres"], key = "#root.method.name")
    fun getGenres(): List<GenreDto> {
        val genres = genreRepository.findAll()
        return genres.map { e -> genreMapper.toDto(e) }
    }

    @Cacheable(cacheNames = ["Genres"], key = "#root.method.name")
    fun getGenreById(id: Long): GenreDto {
        val genre = genreRepository.findById(id)
            .orElseThrow {
                NotFoundException("Genre not found with ID: $id")
            }
        return genreMapper.toDto(genre)
    }

    @CacheEvict(cacheNames = ["Genres"], allEntries = true)
    fun createGenre(form: CreateGenreDto): GenreDto {
        val toSaveGenre= genreMapper.createGenreToEntity(null, form)
        val genre = genreRepository.save(toSaveGenre)
        return genreMapper.toDto(genre)
    }

    @CacheEvict(cacheNames = ["Genres"], allEntries = true)
    fun updateGenreById(id: Long, form: CreateGenreDto): GenreDto {
        val toSaveGenre= genreMapper.createGenreToEntity(id, form)
        val genre = genreRepository.save(toSaveGenre)
        return genreMapper.toDto(genre)
    }

    @CacheEvict(cacheNames = ["Genres"], allEntries = true)
    fun deleteGenreById(id: Long) {
        val genre = genreRepository.findById(id).orElseThrow {
            NotFoundException("Genre not found with ID: $id")
        }
        genreRepository.delete(genre)
        productGenreRepository.deleteByGenreId(id)
    }
}