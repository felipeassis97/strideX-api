package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.service.BrandService
import org.springframework.web.bind.annotation.*
import com.snapshoes.store.presentation.dtos.BrandDto

@RestController
@RequestMapping("/brands")
class Brands(
    private val service: BrandService
) {
    @GetMapping
    fun fetchAll(): List<BrandDto> {
        return service.getBrands()
    }

    @GetMapping("/{id}")
    fun fetchById(@PathVariable id: Long) = service.getBrandById(id)

}