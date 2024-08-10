package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.service.StoreService
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto
import com.snapshoes.store.presentation.dtos.response.store.StoreDto
import jakarta.validation.Valid
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import org.springframework.data.web.PageableDefault
import org.springframework.transaction.annotation.Transactional

@RestController
@RequestMapping("/stores")
class Stores(
    private val service: StoreService
) {
    @GetMapping
    fun fetchAllStores(
        @RequestParam(required = false) name: String?,
        @PageableDefault(size = 5, direction = Sort.Direction.DESC)
        pageable: Pageable
    ): Page<StoreDto> {
        return service.getAllStores(name, pageable)
    }

    @GetMapping("/{id}")
    fun fetchStoreById(@PathVariable id: Long) = service.getStoreById(id)

    @PutMapping("/update-address/{id}")
    @Transactional
    fun updateStoreAddressById(
        @PathVariable id: Long,
        @RequestBody @Valid form: SaveAddressDto
    ): ResponseEntity<StoreDto> {
        val store = service.updateAddress(id, form)
        return ResponseEntity.ok(store)
    }
}