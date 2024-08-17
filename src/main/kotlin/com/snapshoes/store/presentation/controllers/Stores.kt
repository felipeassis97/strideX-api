package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.presentation.dtos.request.store.CreateStoreDto
import jakarta.validation.Valid
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.data.domain.Pageable
import com.snapshoes.store.service.StoreService
import org.springframework.web.bind.annotation.*
import org.springframework.data.web.PageableDefault
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.transaction.annotation.Transactional
import com.snapshoes.store.presentation.dtos.response.store.StoreDto
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto

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
    ): ResponseEntity<Page<StoreDto>> {
        val stores =  service.getAllStores(name, pageable)
        return ResponseEntity.ok(stores)
    }

    @GetMapping("/{id}")
    fun fetchStoreById(@PathVariable id: Long): ResponseEntity<StoreDto> {
        val store = service.getStoreById(id)
        return ResponseEntity.ok(store)
    }

    @Transactional
    @PostMapping
    fun createStore(
        @RequestBody @Valid form: CreateStoreDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<StoreDto> {
        val store = service.createStore(form)
        val uri = uriBuilder.path("/stores/${store.id}").build().toUri()
        return ResponseEntity.created(uri).body(store)
    }

    @Transactional
    @PutMapping("/update-address/{id}")
    fun updateStoreAddressById(
        @PathVariable id: Long,
        @RequestBody @Valid form: SaveAddressDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<StoreDto> {
        val store = service.updateAddress(id, form)

        val uri = uriBuilder.path("/stores/${store.id}").build().toUri()
        return ResponseEntity.created(uri).body(store)
    }
}