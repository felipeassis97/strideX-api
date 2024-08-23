package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.service.SizeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.snapshoes.store.presentation.dtos.response.common.SizeDto

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
}