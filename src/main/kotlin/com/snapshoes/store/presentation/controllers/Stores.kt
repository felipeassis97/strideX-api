package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.presentation.dtos.StoreDto
import com.snapshoes.store.service.StoreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stores")
class Stores(
    private val service: StoreService
) {
    @GetMapping
    fun fetchAll(): List<StoreDto> {
        return service.getAllStores()
    }

    @GetMapping("/{id}")
    fun fetchById(@PathVariable id: Long) = service.getStoreById(id)
}