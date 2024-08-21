package com.snapshoes.store.presentation.controllers

import jakarta.validation.Valid
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import com.snapshoes.store.service.GenreService
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import com.snapshoes.store.presentation.dtos.response.common.GenreDto
import com.snapshoes.store.presentation.dtos.request.common.CreateGenreDto

@RestController
@RequestMapping("/genres")
class Genres(
    private val service: GenreService
) {
    @GetMapping
    fun fetchAllGenres(): ResponseEntity<List<GenreDto>> {
        val genres = service.getGenres()
        return ResponseEntity.ok(genres)
    }

    @GetMapping("/{id}")
    fun fetchGenreById(@PathVariable id: Long): ResponseEntity<GenreDto> {
        val genre = service.getGenreById(id)
        return ResponseEntity.ok(genre)
    }

    @Transactional
    @PutMapping("/{id}")
    fun updateGenreById(
        @PathVariable id: Long, @RequestBody @Valid form: CreateGenreDto, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<GenreDto> {
        val genre = service.updateGenreById(id, form)
        val uri = uriBuilder.path("/genres/${genre.id}").build().toUri()
        return ResponseEntity.created(uri).body(genre)
    }

    @Transactional
    @PostMapping
    fun createGenre(
        @RequestBody @Valid form: CreateGenreDto, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<GenreDto> {
        val genre = service.createGenre(form)
        val uri = uriBuilder.path("/genres/${genre.id}").build().toUri()
        return ResponseEntity.created(uri).body(genre)
    }

    @DeleteMapping("/{id}")
    fun deleteGenreById(@PathVariable id: Long): ResponseEntity<Void> {
        service.deleteGenreById(id)
        return ResponseEntity.noContent().build()
    }
}