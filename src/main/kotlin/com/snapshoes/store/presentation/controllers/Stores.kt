package com.snapshoes.store.presentation.controllers
import com.snapshoes.store.presentation.dtos.StoreDto
import com.snapshoes.store.service.StoreService

import org.springframework.data.domain.Sort
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import org.springframework.data.web.PageableDefault

@RestController
@RequestMapping("/stores")
class Stores(
    private val service: StoreService
) {
    @GetMapping
    fun fetchAll(
        @RequestParam(required = false) name: String?,
        @PageableDefault(size = 5, direction = Sort.Direction.DESC)
        pageable: Pageable
    ): Page<StoreDto> {
        return service.getAllStores(name, pageable)
    }

    @GetMapping("/{id}")
    fun fetchById(@PathVariable id: Long) = service.getStoreById(id)
}