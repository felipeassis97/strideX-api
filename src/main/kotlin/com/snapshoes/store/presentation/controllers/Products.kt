package com.snapshoes.store.presentation.controllers
import com.snapshoes.store.service.ProductService
import com.snapshoes.store.presentation.dtos.ProductDto

import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class Products(
    private val service: ProductService
) {
    @GetMapping
    fun fetchAll(
        @RequestParam(required = false) storeId: Long?,
        @RequestParam(required = false) brandId: Long?,
        @RequestParam(required = false) name: String?,
        @PageableDefault(size = 10) pageable: Pageable
    ): ResponseEntity<Page<ProductDto>> {
        val products = service.getAll(storeId, brandId, name, pageable)
        return ResponseEntity.ok(products)
    }
}