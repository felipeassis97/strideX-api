package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.presentation.dtos.request.common.CreateSizeDto
import com.snapshoes.store.presentation.dtos.request.product.CreateProductDto
import com.snapshoes.store.service.SizeService
import org.springframework.http.ResponseEntity
import com.snapshoes.store.presentation.dtos.response.common.SizeDto
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/sizes")
class Sizes(
    private val service: SizeService
) {

    @GetMapping
    fun fetchAllSizes(): ResponseEntity<List<SizeDto>> {
        val sizes = service.fetchAllSizes()
        return ResponseEntity.ok(sizes)
    }

    @Transactional
    @PostMapping
    fun createSize(
        @RequestBody @Valid form: CreateSizeDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<SizeDto> {
        val size = service.createSize(form)
        val uri = uriBuilder.path("/sizes/${size.id}").build().toUri()
        return ResponseEntity.created(uri).body(size)
    }

    @DeleteMapping("/{id}")
    fun deleteSizeById(@PathVariable id: Long): ResponseEntity<SizeDto> {
        service.deleteSizeById(id)
        return ResponseEntity.noContent().build()
    }
}