package com.snapshoes.store.presentation.controllers

import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import com.snapshoes.store.service.ProductService
import org.springframework.data.web.PageableDefault
import org.springframework.web.util.UriComponentsBuilder
import com.snapshoes.store.presentation.dtos.response.product.ProductDto
import com.snapshoes.store.presentation.dtos.request.product.CreateProductDto
import com.snapshoes.store.presentation.dtos.request.product.UpdateProductDto

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
    fun createProduct(
        @RequestBody @Valid form: CreateProductDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ProductDto> {
        val productId = service.createProduct(form)
        val productCreated = service.findProductWithImagesAndGenres(productId)
        val uri = uriBuilder.path("/products/${productCreated.id}").build().toUri()
        return ResponseEntity.created(uri).body(productCreated)
    }

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable id: Long): ResponseEntity<Void> {
        service.deleteProductById(id)
        return ResponseEntity.noContent().build()
    }

    @PatchMapping("/{id}")
    fun patchProductById(
        @PathVariable id: Long,
        @RequestBody @Valid form: UpdateProductDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ProductDto> {
        service.patchProduct(id, form)
        val productUpdated = service.findProductWithImagesAndGenres(id)
        val uri = uriBuilder.path("/products/${productUpdated.id}").build().toUri()
        return ResponseEntity.created(uri).body(productUpdated)
    }
}