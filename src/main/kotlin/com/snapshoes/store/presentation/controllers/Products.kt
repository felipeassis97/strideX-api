package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.presentation.dtos.ProductDto
import com.snapshoes.store.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class Products(
    private val service: ProductService
) {
    @GetMapping
    fun fetchAll(): ResponseEntity<List<ProductDto>> {
        val products =  service.getAll()
        return ResponseEntity.ok(products)
    }
}