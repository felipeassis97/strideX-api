package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.service.GenreService
import org.springframework.web.bind.annotation.*
import com.snapshoes.store.presentation.dtos.response.common.GenreDto

@RestController
@RequestMapping("/genres")
class Genres(
    private val service: GenreService
) {
    @GetMapping
    fun fetchAllGenres(): List<GenreDto> {
        return service.getGenres()
    }

    @GetMapping("/{id}")
    fun fetchGenreById(@PathVariable id: Long) = service.getGenreById(id)
}