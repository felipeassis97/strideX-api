package com.snapshoes.store.presentation.controllers
import com.snapshoes.store.presentation.dtos.request.product.CreateProductDto
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto
import com.snapshoes.store.service.ProductService
import com.snapshoes.store.presentation.dtos.response.product.ProductDto
import jakarta.validation.Valid

import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class Products(
    private val service: ProductService
) {
    @GetMapping
    fun fetchAllProducts(
        @RequestParam(required = false) storeId: Long?,
        @RequestParam(required = false) brandId: Long?,
        @RequestParam(required = false) name: String?,
        @PageableDefault(size = 10) pageable: Pageable
    ): ResponseEntity<Page<ProductDto>> {
        val products = service.getAll(storeId, brandId, name, pageable)
        return ResponseEntity.ok(products)
    }

    @PostMapping
    fun createProduct(@RequestBody @Valid form: CreateProductDto): ResponseEntity<ProductDto> {
        val productId = service.createProduct(form)
        val productCreated = service.findProductWithImagesAndGenres(productId)
        return ResponseEntity.ok(productCreated)
    }
}