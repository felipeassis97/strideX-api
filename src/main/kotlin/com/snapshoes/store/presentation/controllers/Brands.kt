package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.presentation.dtos.request.common.CreateBrandDto
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import com.snapshoes.store.service.BrandService
import org.springframework.web.bind.annotation.*
import com.snapshoes.store.presentation.dtos.response.common.BrandDto
import com.snapshoes.store.presentation.dtos.response.store.StoreDto
import jakarta.validation.Valid
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/brands")
class Brands(
    private val service: BrandService
) {
    @GetMapping
    fun fetchAllBrands(): List<BrandDto> {
        return service.getBrands()
    }

    @GetMapping("/{id}")
    fun fetchBrandById(@PathVariable id: Long) = service.getBrandById(id)

    @Transactional
    @DeleteMapping("/{id}")
    fun deleteBrandById(@PathVariable id: Long): ResponseEntity<Void> {
        service.deleteBrandAndProducts(id)
        return ResponseEntity.noContent().build()
    }

    @Transactional
    @PutMapping("/{id}")
    fun updateBrandById(@PathVariable id: Long,
                        @RequestBody @Valid form: CreateBrandDto,
                        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<BrandDto> {
       val brand =  service.updateBrandById(id, form)
        val uri = uriBuilder.path("/stores/${brand.id}").build().toUri()
        return ResponseEntity.created(uri).body(brand)
    }


}